package com.example.demo.api;

import com.example.demo.model.PontoEletronico;
import com.example.demo.service.PontoEletronicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;


@RestController
public class PontoController {
    @Autowired
    PontoEletronicoService service;

    @PostMapping("/ponto/funcionarios")
    public String registraPonto(@RequestBody Map<String, String> json) throws ParseException {
        return this.service.registraPonto(json);

    }

    @GetMapping("/ponto/{id}")
    public Object mostraPonto(@PathVariable Integer id) {
        return this.service.mostraPonto(id);
    }

    @PostMapping("/ponto/desbloqueio")
    public String desbloqueia(@RequestBody Map<String, String> json) throws ParseException {
        return this.service.desbloqueia(json);
    }

}

