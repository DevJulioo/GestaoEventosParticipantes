package com.gestao.eventos.dtos;

import java.sql.Date;

import com.gestao.eventos.entities.Eventos;

public class EventosDTO {
	private Long id;
	private String nome;
	private String descricao;
	private Date data;
	private String local;
	private int vagas;
	private int vagasDisponiveis;

	public EventosDTO() {
		
	}
	
	public EventosDTO(Long id, String nome, String descricao, Date data, String local, int vagas, int vagasDisponiveis) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.local = local;
		this.vagas = vagas;
		this.vagasDisponiveis = vagasDisponiveis;
	}
	
	public EventosDTO(Eventos evento) {
		id = evento.getId();
		nome = evento.getNome();
		descricao = evento.getDescricao();
		local = evento.getLocal();
		vagas = evento.getVagas();
		this.vagasDisponiveis = evento.getVagasDisponiveis();

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

	public int getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(int vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}



}
