package com.example.demo.service;

import com.example.demo.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class FuncionarioService {

    private List<Funcionario> funcionarios = new ArrayList<>();
    public List<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public String cadastraFun(Map<String, Object> json) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(seqFunc());
        funcionario.setNome((String) json.get("nome"));
        funcionario.setRh((Boolean) json.get("RH"));
        funcionario.setAtrasos(5);
        funcionario.setBloqueado(false);
        this.funcionarios.add(funcionario);
        return "Funcionario cadastrado";


    }


    Integer seqF = 0;
    private Integer seqFunc() {
        return seqF ++;
    }

    public Funcionario mostraFun(Integer id) {
        return this.funcionarios.get(id);
    }


}
