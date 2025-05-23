package com.denilson.teste_tecnico_esig.services;

import com.denilson.teste_tecnico_esig.entities.Vencimento;
import com.denilson.teste_tecnico_esig.repositories.VencimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VencimentoService {

    private final VencimentoRepository vencimentoRepository;

    public VencimentoService(VencimentoRepository vencimentoRepository) {
        this.vencimentoRepository = vencimentoRepository;
    }

    public List<Vencimento> findAll() {
        return vencimentoRepository.findAll();
    }

    public Vencimento findById(Long id) {
        return vencimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vencimento não encontrado com id: " + id));
    }

    public Vencimento save(Vencimento vencimento) {
        return vencimentoRepository.save(vencimento);
    }

    public Vencimento update(Long id, Vencimento vencimentoAtualizado) {
        Vencimento vencimentoExistente = findById(id);
        vencimentoExistente.setDescricao(vencimentoAtualizado.getDescricao());
        vencimentoExistente.setValor(vencimentoAtualizado.getValor());
        vencimentoExistente.setTipoVencimento(vencimentoAtualizado.getTipoVencimento());
        return vencimentoRepository.save(vencimentoExistente);
    }

    public void delete(Long id) {
        vencimentoRepository.deleteById(id);
    }
}
