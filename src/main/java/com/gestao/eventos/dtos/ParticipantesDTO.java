package com.gestao.eventos.dtos;

import com.gestao.eventos.entities.Participantes;

public class ParticipantesDTO {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public ParticipantesDTO() {
    }

    public ParticipantesDTO(Long id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public ParticipantesDTO(Participantes participante) {
        this.id = participante.getId();
        this.nome = participante.getNome();
        this.email = participante.getEmail();
        this.telefone = participante.getTelefone();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
