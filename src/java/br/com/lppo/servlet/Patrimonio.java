/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lppo.servlet;

/**
 *
 * @author tiago
 */
public class Patrimonio {
    private Long id;
    private String serie;
    private String local;
    private String descricao;
    private int estado;

    public Patrimonio() {
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getSerie() {
	return serie;
    }

    public void setSerie(String serie) {
	this.serie = serie;
    }

    public String getLocal() {
	return local;
    }

    public void setLocal(String local) {
	this.local = local;
    }

    public String getDescricao() {
	return descricao;
    }

    public void setDescricao(String descricao) {
	this.descricao = descricao;
    }

    public int getEstado() {
	return estado;
    }

    public void setEstado(int estado) {
	this.estado = estado;
    }
    
    
    
}
