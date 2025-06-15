package com.pagafacil.PagaFacil.Model;

import com.pagafacil.PagaFacil.Dominio.Evento;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@Service
public class EventoModel {

    private final List<Evento> eventos = new ArrayList<>();
    private int nextId = 1;

    public EventoModel() {
        // Evento de exemplo para iniciar a lista
        eventos.add(new Evento(
                nextId++,
                UUID.randomUUID(),
                "Feira de Tecnologia",
                LocalDate.of(2025, 7, 1),
                LocalDate.of(2025, 7, 3),
                100L,
                "ativo",
                new BigDecimal("50.00"),
                300,
                "Evento sobre inovações tecnológicas",
                "https://exemplo.com/imagem.jpg",
                LocalDate.now(),
                LocalDate.now()
        ));
    }

    public List<Evento> findAll() {
        return new ArrayList<>(eventos); // Evita alterações externas
    }

    public Optional<Evento> findById(int id) {
        return eventos.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public Evento save(Evento evento) {
        if (evento.getId() == 0) {
            evento.setId(nextId++);
            evento.setUuid(UUID.randomUUID());
        } else {
            deleteById(evento.getId());
        }
        eventos.add(evento);
        return evento;
    }

    public Evento update(int id, Evento atualizado) {
        return findById(id).map(evento -> {
            evento.setNome(atualizado.getNome());
            evento.setDescricao(atualizado.getDescricao());
            evento.setDataInicio(atualizado.getDataInicio());
            evento.setDataFim(atualizado.getDataFim());
            evento.setLocalId(atualizado.getLocalId());
            evento.setStatus(atualizado.getStatus());
            evento.setPrecoEntrada(atualizado.getPrecoEntrada());
            evento.setCapacidade(atualizado.getCapacidade());
            evento.setImagemUrl(atualizado.getImagemUrl());
            evento.setDataCadastro(atualizado.getDataCadastro());
            evento.setDataAtualizacao(LocalDate.now()); // Atualiza data de modificação
            return evento;
        }).orElse(null);
    }

    public boolean deleteById(int id) {
        return eventos.removeIf(evento -> evento.getId() == id);
    }
}
