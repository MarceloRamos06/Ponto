package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.PontoEletronico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PontoEletronicoService {

    @Autowired
    FuncionarioService service;

    private List<PontoEletronico> pontoEletronico = new ArrayList<>();
    public List<PontoEletronico> getPontoEletronico() {
        return this.pontoEletronico;
    }


    public String registraPonto(Integer id) {
        Funcionario funcionario = this.service.mostraFun(id);
        PontoEletronico ponto = new PontoEletronico();
        boqueio(funcionario);
        if (funcionario.getBloqueado()) {
            return "Acesso Bloqueado, consulte o RH para o desbloqueio";
        } else {
            ponto.setFuncionario(funcionario);
            ponto.setData(LocalDate.now());
            ponto.setHorario(LocalTime.now());
           this.pontoEletronico.add(ponto);
        }

            return "Ponto Registrado";
        }

    public void boqueio(Funcionario funcionario) {
        if(funcionario.getAtrasos() >= 2) {
            funcionario.setBloqueado(true);
        }
    }

    public Object mostraPonto(Integer id) {
        Funcionario funcionario = this.service.mostraFun(id);
        if(funcionario.getRh()) {
            return this.pontoEletronico;
        } else {
            return "Acesso Negado";
        }
    }


}



        







