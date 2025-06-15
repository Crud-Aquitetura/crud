package com.pagafacil.PagaFacil.Dominio;

import java.time.LocalDate;

public class Local {

    private int id;
    private String nome;
    private String cep;
    private int capacidade;
    private String descricao;
    private String imagem_url;
    private LocalDate data_cadastro;

    // Construtor completo
    public Local(int id, String nome, String cep, int capacidade, String descricao, String imagem_url, LocalDate data_cadastro) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.imagem_url = imagem_url;
        this.data_cadastro = data_cadastro;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem_url() {
        return imagem_url;
    }

    public LocalDate getData_cadastro() {
        return data_cadastro;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem_url(String imagem_url) {
        this.imagem_url = imagem_url;
    }

    public void setData_cadastro(LocalDate data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cep='" + cep + '\'' +
                ", capacidade=" + capacidade +
                ", descricao='" + descricao + '\'' +
                ", imagem_url='" + imagem_url + '\'' +
                ", data_cadastro=" + data_cadastro +
                '}';
    }
}
