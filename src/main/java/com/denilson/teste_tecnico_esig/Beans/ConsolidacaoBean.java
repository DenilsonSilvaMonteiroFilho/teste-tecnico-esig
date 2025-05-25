package com.denilson.teste_tecnico_esig.Beans;

import com.denilson.teste_tecnico_esig.entities.PessoaSalarioConsolidado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@ViewScoped
@Named
public class ConsolidacaoBean implements Serializable {

    private List<PessoaSalarioConsolidado> listaConsolidada;

    private final String URLBASE = "http://localhost:8080/api/consolidar";

    @PostConstruct
    public void init(){
    }

    public void consolidar() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URLBASE+"/salarios"))
                    .POST(HttpRequest.BodyPublishers.noBody())
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            listaConsolidada = Arrays.asList(mapper.readValue(response.body(), PessoaSalarioConsolidado[].class));

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<PessoaSalarioConsolidado> getListaConsolidada() {
        return listaConsolidada;
    }

    public boolean isExibirTabela() {
        return listaConsolidada != null && !listaConsolidada.isEmpty();
    }
}
