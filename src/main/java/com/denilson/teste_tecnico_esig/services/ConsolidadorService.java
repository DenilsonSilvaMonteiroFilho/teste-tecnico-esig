package com.denilson.teste_tecnico_esig.services;

import com.denilson.teste_tecnico_esig.entities.Cargo;
import com.denilson.teste_tecnico_esig.entities.CargoVencimento;
import com.denilson.teste_tecnico_esig.entities.Pessoa;
import com.denilson.teste_tecnico_esig.entities.PessoaSalarioConsolidado;
import com.denilson.teste_tecnico_esig.entities.Vencimento;
import com.denilson.teste_tecnico_esig.repositories.PessoaSalarioConsolidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsolidadorService {

    private final String credito = "CREDITO";
    private final String debito = "DEBITO";

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private CargoService cargoService;
    @Autowired
    private VencimentoService vencimentoService;
    @Autowired
    private CargoVencimentoService cargoVencimentoService;
    @Autowired
    private PessoaSalarioConsolidadoRepository pessoaSalarioConsolidadoRepository;


    //PODE SER IMPLMENTADO UM @TRASASIONAL PRA PREVINIR ERROS
    public List<PessoaSalarioConsolidado> consolidarCargoVencimento() {

        List<Pessoa> pessoas = pessoaService.findAll();

        //Pegar todos o vencimentos para diminuir a consulta no banco
        List<CargoVencimento> listTodosCargoVencimentos = cargoVencimentoService.findAll();

        List<PessoaSalarioConsolidado> pessoaSalarioConsolidadoList = new ArrayList<>();

        pessoaSalarioConsolidadoRepository.deleteAll();//remove todas as consolidacoes anteriores

        for (Pessoa pessoa : pessoas) {
            Cargo cargo = pessoa.getCargo();

            List<CargoVencimento> cargoVencimentos = cargoVencimentoService.
                    encontrarCargoVencimentosPorCargo(listTodosCargoVencimentos,cargo);

            BigDecimal salario = BigDecimal.ZERO;

            for (CargoVencimento cargoVencimento : cargoVencimentos) {
                Vencimento vencimento = cargoVencimento.getVencimento();
                if (credito.equalsIgnoreCase(vencimento.getTipoVencimento().toString())) {
                    salario = salario.add(vencimento.getValor());
                } else if (debito.equalsIgnoreCase(vencimento.getTipoVencimento().toString())) {
                    salario = salario.subtract(vencimento.getValor());
                }
            }
            PessoaSalarioConsolidado pessoaSalConsolidado = new PessoaSalarioConsolidado();

            pessoaSalConsolidado.setNomePessoa(pessoa.getNome());
            if(cargo!=null) {
                pessoaSalConsolidado.setNomeCargo(pessoa.getCargo().getNome());
            } else {
                pessoaSalConsolidado.setNomeCargo("-");
            }
            pessoaSalConsolidado.setSalario(salario);

            pessoaSalarioConsolidadoList.add(pessoaSalConsolidado);
        }
        pessoaSalarioConsolidadoRepository.saveAll(pessoaSalarioConsolidadoList);
        return pessoaSalarioConsolidadoList;
    }
}
