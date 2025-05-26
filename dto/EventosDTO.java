package com.gestao.eventos.dto;

import java.sql.Date;

import com.gestao.eventos.entities.Eventos;

public class EventosDTO {
	private Long id;
	private String nome;
	private String descricao;
	private Date data;
	private String local;
	private int vagas;

	public EventosDTO() {
		
	}
	
	public EventosDTO(Long id, String nome, String descricao, Date data, String local, int vagas) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.local = local;
		this.vagas = vagas;
	}
	
	public EventosDTO(Eventos evento) {
		id = evento.getId();
		nome = evento.getNome();
		descricao = evento.getDescricao();
		local = evento.getLocal();
		vagas = evento.getVagas();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}
	
	
}
