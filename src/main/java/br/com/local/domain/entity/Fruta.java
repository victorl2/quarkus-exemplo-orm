package br.com.local.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Fruta {
	@Id
	private String nome;
	private Integer pesoKg;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPesoKg() {
		return pesoKg;
	}
	public void setPesoKg(Integer pesoKg) {
		this.pesoKg = pesoKg;
	}
}
