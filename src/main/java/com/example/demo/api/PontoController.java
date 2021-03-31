package com.example.demo.api;

import com.example.demo.model.PontoEletronico;
import com.example.demo.service.PontoEletronicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PontoController {
    @Autowired
    PontoEletronicoService service;

    @PostMapping("/ponto/funcionarios/{id}")
    public String registraPonto(@PathVariable Integer id) {
        return this.service.registraPonto(id);

    }

    //@GetMapping("/ponto/funcionarios")
    //public List<PontoEletronico> mostraPonto() {
        //return this.service.getPontoEletronico();
   // }

    @GetMapping("/ponto/{id}")
    public Object mostraPonto(@PathVariable Integer id) {
        return this.service.mostraPonto(id);
    }

}
