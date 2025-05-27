package com.denilson.teste_tecnico_esig.Beans;

import com.denilson.teste_tecnico_esig.entities.Cargo;
import com.denilson.teste_tecnico_esig.entities.Pessoa;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class PessoaBean implements Serializable {
    private boolean exibirDialog;
    private Pessoa pessoaSelecionada;
    private Pessoa pessoaAlterar;
    private List<Pessoa> pessoas;
    private Pessoa pessoa = new Pessoa();
    private final String URLBASE = "http://localhost:8080/api";
    private RestTemplate restTemplate = new RestTemplate();
    private List<Cargo> cargos;
    private Long idCargoSelecionado;

    @PostConstruct
    public void init() {
        carregarPessoas();
        carregarCargos();
    }

    public void carregarPessoas() {
        Pessoa[] response = restTemplate.getForObject(URLBASE + "/pessoas", Pessoa[].class);
        pessoas = Arrays.asList(response);
    }

    public void carregarCargos(){
        Cargo[] response = restTemplate.getForObject(URLBASE + "/cargos", Cargo[].class);
        cargos = Arrays.asList(response);
    }

    public void salvar2() {
        if (pessoa.getId() == null) {
            restTemplate.postForObject(URLBASE, pessoa, Pessoa.class);
        } else {
            restTemplate.put(URLBASE + "/pessoas/" + pessoa.getId(), pessoa);
        }
        pessoa = new Pessoa();
        carregarPessoas();
    }

    public void salvar() {
        if (idCargoSelecionado != null) {
            Cargo cargoSelecionado = cargos.stream()
                    .filter(c -> c.getId().equals(idCargoSelecionado))
                    .findFirst()
                    .orElse(null);
            pessoa.setCargo(cargoSelecionado);
        }

        if (pessoa.getId() == null) {
            restTemplate.postForObject(URLBASE + "/pessoas", pessoa, Pessoa.class);
        } else {
            restTemplate.put(URLBASE + "/pessoas/" + pessoa.getId(), pessoa);
        }

        pessoa = new Pessoa();
        carregarPessoas();
    }


    public void novo() {
        this.pessoa = new Pessoa();
        this.exibirDialog = true;
    }

    public void editar(Pessoa p) {
        this.pessoa = new Pessoa();  // evita efeitos colaterais
        this.pessoa.setId(p.getId());
        this.pessoa.setNome(p.getNome());
        this.pessoa.setEmail(p.getEmail());
        this.pessoa.setEndereco(p.getEndereco());
        this.pessoa.setCidade(p.getCidade());
        this.pessoa.setCep(p.getCep());
        this.pessoa.setPais(p.getPais());
        this.pessoa.setTelefone(p.getTelefone());
        this.pessoa.setDataNascimento(p.getDataNascimento());
        this.pessoa.setUsuario(p.getUsuario());
        this.pessoa.setCargo(p.getCargo());
        this.exibirDialog = true;
        carregarPessoas();
    }

    public void excluir(Long id) {
        restTemplate.delete(URLBASE + "/pessoas/" + id);
        carregarPessoas();
    }

    public boolean isExibirDialog() { return exibirDialog; }
    public void setExibirDialog(boolean exibirDialog) { this.exibirDialog = exibirDialog; }
    public Pessoa getPessoaSelecionada() { return pessoaSelecionada; }
    public void setPessoaSelecionada(Pessoa pessoaSelecionada) { this.pessoaSelecionada = pessoaSelecionada; }
    public List<Pessoa> getPessoas() { return pessoas; }
    public Pessoa getPessoa() { return pessoa; }
    public void setPessoa(Pessoa pessoa) { this.pessoa = pessoa; }
    public List<Cargo> getCargos() {
        return cargos;
    }

    public Long getIdCargoSelecionado() {
        return idCargoSelecionado;
    }
    public void setIdCargoSelecionado(Long idCargoSelecionado) {
        this.idCargoSelecionado = idCargoSelecionado;
    }
}

