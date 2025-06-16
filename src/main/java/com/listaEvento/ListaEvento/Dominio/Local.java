package com.listaEvento.ListaEvento.Dominio;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Local {

    private Long id;
    private String nome;
    private String descricao; // Adicionado para ser consistente com LocalModel e LocalController
    private BigDecimal preco; // Adicionado
    private String cep;
    private int capacidade;
    private String imagemUrl; // Renomeado
    private LocalDate dataCadastro; // Renomeado

    // Construtor completo
    public Local(Long id, String nome, String descricao, BigDecimal preco, String cep, int capacidade, String imagemUrl, LocalDate dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.cep = cep;
        this.capacidade = capacidade;
        this.imagemUrl = imagemUrl;
        this.dataCadastro = dataCadastro;
    }

    // Construtor sem ID para criação de novos locais (o ID será gerado)
    public Local(String nome, String descricao, BigDecimal preco, String cep, int capacidade, String imagemUrl, LocalDate dataCadastro) {
        this(null, nome, descricao, preco, cep, capacidade, imagemUrl, dataCadastro);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getCep() {
        return cep;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", cep='" + cep + '\'' +
                ", capacidade=" + capacidade +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}