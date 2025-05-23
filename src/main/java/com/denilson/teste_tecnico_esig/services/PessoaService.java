package com.denilson.teste_tecnico_esig.services;

import com.denilson.teste_tecnico_esig.entities.Pessoa;
import com.denilson.teste_tecnico_esig.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com id: " + id));
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa update(Long id, Pessoa pessoaAtualizada) {
        Pessoa pessoaExistente = findById(id);

        pessoaExistente.setNome(pessoaAtualizada.getNome());
        pessoaExistente.setCidade(pessoaAtualizada.getCidade());
        pessoaExistente.setEmail(pessoaAtualizada.getEmail());
        pessoaExistente.setCep(pessoaAtualizada.getCep());
        pessoaExistente.setEndereco(pessoaAtualizada.getEndereco());
        pessoaExistente.setPais(pessoaAtualizada.getPais());
        pessoaExistente.setUsuario(pessoaAtualizada.getUsuario());
        pessoaExistente.setTelefone(pessoaAtualizada.getTelefone());
        pessoaExistente.setDataNascimento(pessoaAtualizada.getDataNascimento());
        pessoaExistente.setCargo(pessoaAtualizada.getCargo());

        return pessoaRepository.save(pessoaExistente);
    }

    public void delete(Long id) {
        pessoaRepository.deleteById(id);
    }
}
