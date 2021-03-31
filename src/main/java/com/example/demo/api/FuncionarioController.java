package com.example.demo.api;

import com.example.demo.model.Funcionario;
import com.example.demo.model.PontoEletronico;
import com.example.demo.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class FuncionarioController {

    @Autowired
    FuncionarioService service;

    @PostMapping("/funcionarios")
    public String cadastrarFuncionario(@RequestBody Map<String, Object> json){
        return this.service.cadastraFun(json);
    }

    @GetMapping("/funcionarios")
    public List<Funcionario> mostraFuncionario() {
        return this.service.getFuncionarios();
    }

    @GetMapping("/funcionarios/{id}")
    public List<PontoEletronico> buscaFuncionario(@PathVariable Integer id) {
        return (List<PontoEletronico>) this.service.mostraFun(id);
    }




}
