package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.model.PontoEletronico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PontoEletronicoService {

    @Autowired
    FuncionarioService service;

    private List<PontoEletronico> pontoEletronico = new ArrayList<>();
    public List<PontoEletronico> getPontoEletronico() {
        return this.pontoEletronico;
    }

    public String registraPonto(Map<String, String> json) {
        Funcionario funcionario = this.service.mostraFun(Integer.parseInt(json.get("ponto")));
        PontoEletronico ponto = new PontoEletronico();
        bloqueio(funcionario);
        atraso(funcionario);
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

    public void bloqueio(Funcionario funcionario) {
        if(funcionario.getAtrasos() >= 2) {
            funcionario.setBloqueado(true);
        }
    }

    public Object mostraPonto(Integer id) {
        Funcionario funcionario = this.service.mostraFun(id);
        if(funcionario.getRh()) {
            return this.getPontoEletronico();
        } else {
            return "Acesso Negado";
        }
    }

    public void atraso(Funcionario funcionario){
        LocalTime entrada = LocalTime.of(8,0,5);
        LocalTime chegada = LocalTime.now();
        if(chegada.isAfter(entrada)) {
            funcionario.setAtrasos(funcionario.getAtrasos() + 1);
        }
    }

    public String desbloqueia(Map< String, String> json) {
        Funcionario funcionariorh = this.service.mostraFun(Integer.parseInt(json.get("RH")));
        Funcionario funcionario = this.service.mostraFun(Integer.parseInt(json.get("funcionario")));
        if(funcionariorh.getRh()) {
            if(funcionario.getBloqueado()){
                funcionario.setBloqueado(false);
                this.service.getFuncionarios().add(funcionario);
                return "Funcionario desbloqueado";
            } else {
                return"Funcionario não esta bloqueado";
            }
        } else {
            return "Você não tem permissao";
        }
    }


}








        







