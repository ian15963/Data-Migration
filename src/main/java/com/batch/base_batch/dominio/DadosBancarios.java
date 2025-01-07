package com.batch.base_batch.dominio;

public class DadosBancarios {

    private Long id;
    private Long banco;
    private Long agencia;
    private Long pessoaId;

    public DadosBancarios() {
    }

    public DadosBancarios(Long id, Long banco, Long agencia, Long pessoaId) {
        this.id = id;
        this.banco = banco;
        this.agencia = agencia;
        this.pessoaId = pessoaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBanco() {
        return banco;
    }

    public void setBanco(Long banco) {
        this.banco = banco;
    }

    public Long getAgencia() {
        return agencia;
    }

    public void setAgencia(Long agencia) {
        this.agencia = agencia;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public String toString() {
        return "DadosBancarios{" +
                "id=" + id +
                ", banco=" + banco +
                ", agencia=" + agencia +
                ", pessoaId=" + pessoaId +
                '}';
    }
}
