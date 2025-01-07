package com.batch.base_batch.dominio;

import io.micrometer.common.util.StringUtils;

import java.util.Date;
import java.util.Objects;

public class Pessoa {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private Date dataNascimento;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String email, Integer idade, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.dataNascimento = dataNascimento;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public boolean isValid() {
        return StringUtils.isNotBlank(nome) &&
                StringUtils.isNotBlank(email) &&
                Objects.nonNull(idade) &&
                Objects.nonNull(id) &&
                Objects.nonNull(dataNascimento);
    }
}
