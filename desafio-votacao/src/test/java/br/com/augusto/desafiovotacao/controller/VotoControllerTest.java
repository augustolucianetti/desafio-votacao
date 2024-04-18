package br.com.augusto.desafiovotacao.controller;

import br.com.augusto.desafiovotacao.dto.VotoDTO;
import br.com.augusto.desafiovotacao.exception.ApiException;
import br.com.augusto.desafiovotacao.model.Associado;
import br.com.augusto.desafiovotacao.model.Pauta;
import br.com.augusto.desafiovotacao.model.SessaoVotacao;
import br.com.augusto.desafiovotacao.model.Voto;
import br.com.augusto.desafiovotacao.service.VotoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(VotoController.class)
public class VotoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VotoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private Voto voto;

    private VotoDTO votoDTO;

    @BeforeEach
    public void setup() {
        voto = new Voto();
        voto.setVoto( true );
        Associado associado = new Associado();
        associado.setCpf( "12345678999" );
        associado.setId( UUID.randomUUID().toString() );
        associado.setNome( "Alex" );
        SessaoVotacao sessaoVotacao = new SessaoVotacao();
        sessaoVotacao.setEndDate( LocalDateTime.MAX );
        sessaoVotacao.setStartDate( LocalDateTime.MIN );
        sessaoVotacao.setId( UUID.randomUUID().toString() );
        Pauta pauta = new Pauta();
        pauta.setId( UUID.randomUUID().toString() );
        pauta.setDescription( "Test" );
        pauta.setName( "Teste" );
        sessaoVotacao.setPauta( pauta );
        voto.setSessaoVotacao( sessaoVotacao );
        voto.setAssociado( associado );

        votoDTO  = new VotoDTO();
        votoDTO.setVoto( true );
        votoDTO.setAssociadoId( "661d82049a52893287b43fd3" );
        votoDTO.setSessaoVotacaoId( "661c7ae3fac44a0f4247f683" );
    }

    @Test
    public void votarComSucessoTest() throws Exception {

        when(service.save( votoDTO )).thenReturn( voto );

        mockMvc.perform( post("/voto")
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( "{\n" +
                                "    \"voto\" : true,\n" +
                                "    \"associadoId\" : \"661d82049a52893287b43fd3\",\n" +
                                "    \"sessaoVotacaoId\" : \"661c7ae3fac44a0f4247f683\"\n" +
                                "}" ))
                .andExpect(status().isOk());
    }

    @Test
    public void votarSessaoNaoEncontradaExceptionTest() throws Exception {

        when(service.save( any() )).thenThrow( new ApiException( HttpStatus.NOT_FOUND, "Sess\u00E3o n\u00E3o encontrada" ) );

        mockMvc.perform( post("/voto")
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( "{\n" +
                                "    \"voto\" : true,\n" +
                                "    \"associadoId\" : \"661d82049a52893287b43fd3\",\n" +
                                "    \"sessaoVotacaoId\" : \"661c7ae3fac44a0f4247f683\"\n" +
                                "}" ))
                .andDo( MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect( result -> {
                    JsonNode jsonNode = objectMapper.readTree( result.getResponse().getContentAsString());
                    assertEquals("SessÃ£o nÃ£o encontrada" ,jsonNode.path( "message" ).asText());
                } );
    }

    @Test
    public void votarAssociadoNaoEncontradoExceptionTest() throws Exception {

        when(service.save( any() ))
                .thenThrow( new ApiException(HttpStatus.NOT_FOUND, "Associado n\u00E3o encontrado" ));

        mockMvc.perform( post("/voto")
                        .contentType( MediaType.APPLICATION_JSON )
                        .content( "{\n" +
                                "    \"voto\" : true,\n" +
                                "    \"associadoId\" : \"661d82049a52893287b43fd3\",\n" +
                                "    \"sessaoVotacaoId\" : \"661c7ae3fac44a0f4247f683\"\n" +
                                "}" ))
                .andDo( MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect( result -> {
                    JsonNode jsonNode = objectMapper.readTree( result.getResponse().getContentAsString());
                    assertEquals("Associado nÃ£o encontrado" ,jsonNode.path( "message" ).asText());
                } );
    }

}
