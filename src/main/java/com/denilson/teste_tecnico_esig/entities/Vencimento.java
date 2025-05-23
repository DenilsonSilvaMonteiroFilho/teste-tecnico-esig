package com.denilson.teste_tecnico_esig.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Vencimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoVencimento tipoVencimento;

    public Vencimento() {
    }

    public Long getId() {
        return id;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public TipoVencimento getTipoVencimento() {
        return tipoVencimento;
    }

    public void setTipoVencimento(TipoVencimento tipoVencimento) {
        this.tipoVencimento = tipoVencimento;
    }
}
