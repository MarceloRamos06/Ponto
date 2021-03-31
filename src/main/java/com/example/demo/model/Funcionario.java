package com.example.demo.model;

import java.util.ArrayList;

public class Funcionario {
    private int id;
    private String nome;
    private Integer atrasos;
    private Boolean bloqueado;
    private Boolean rh;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAtrasos() {
        return atrasos;
    }

    public void setAtrasos(Integer atrasos) {
        this.atrasos = atrasos;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public Boolean getRh() { return rh; }

    public void setRh(Boolean rh) { this.rh = rh; }



    }

