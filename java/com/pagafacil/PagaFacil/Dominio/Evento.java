package com.pagafacil.PagaFacil.Dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class Evento {

    // --- Atributos ---
    private int id;
    private UUID uuid;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Long localId;
    private String status;
    private BigDecimal precoEntrada;
    private int capacidade;
    private String descricao;
    private String imagemUrl;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    // --- Construtor ---
    public Evento(int id, UUID uuid, String nome, LocalDate dataInicio, LocalDate dataFim,
                  Long localId, String status, BigDecimal precoEntrada, int capacidade,
                  String descricao, String imagemUrl, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        this.id = id;
        this.uuid = uuid;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.localId = localId;
        this.status = status;
        this.precoEntrada = precoEntrada;
        this.capacidade = capacidade;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }

    // --- Getters ---
    public int getId() { return id; }
    public UUID getUuid() { return uuid; }
    public String getNome() { return nome; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataFim() { return dataFim; }
    public Long getLocalId() { return localId; }
    public String getStatus() { return status; }
    public BigDecimal getPrecoEntrada() { return precoEntrada; }
    public int getCapacidade() { return capacidade; }
    public String getDescricao() { return descricao; }
    public String getImagemUrl() { return imagemUrl; }
    public LocalDate getDataCadastro() { return dataCadastro; }
    public LocalDate getDataAtualizacao() { return dataAtualizacao; }

    // --- Setters ---
    public void setId(int id) { this.id = id; }
    public void setUuid(UUID uuid) { this.uuid = uuid; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }
    public void setLocalId(Long localId) { this.localId = localId; }
    public void setStatus(String status) { this.status = status; }
    public void setPrecoEntrada(BigDecimal precoEntrada) { this.precoEntrada = precoEntrada; }
    public void setCapacidade(int capacidade) { this.capacidade = capacidade; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setImagemUrl(String imagemUrl) { this.imagemUrl = imagemUrl; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
    public void setDataAtualizacao(LocalDate dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    // --- toString() ---
    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", nome='" + nome + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", localId=" + localId +
                ", status='" + status + '\'' +
                ", precoEntrada=" + precoEntrada +
                ", capacidade=" + capacidade +
                ", descricao='" + descricao + '\'' +
                ", imagemUrl='" + imagemUrl + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                '}';
    }
}
