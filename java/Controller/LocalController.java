package com.pagafacil.PagaFacil.Controller;

import com.pagafacil.PagaFacil.Dominio.Local;
import com.pagafacil.PagaFacil.Model.LocalModel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LocalController {

    private final List<Local> locais = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(); // Para gerar IDs simulados

    public LocalController() {
        // Exemplo fictício de locais, substitua conforme seu modelo real
        locais.add(new Local(counter.incrementAndGet(), "Local A", "Auditório grande", new BigDecimal("1200.00"), "12345-678", 100, "url1.jpg", "2024-01-01"));
        locais.add(new Local(counter.incrementAndGet(), "Local B", "Sala de reunião", new BigDecimal("500.00"), "23456-789", 20, "url2.jpg", "2024-02-01"));
        locais.add(new Local(counter.incrementAndGet(), "Local C", "Espaço aberto", new BigDecimal("800.00"), "34567-890", 200, "url3.jpg", "2024-03-01"));
    }

    public List<Local> findAll() {
        return new ArrayList<>(locais);
    }

    public Optional<Local> findById(Long id) {
        return locais.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Local save(Local local) {
        if (local.getId() == null) {
            local.setId(counter.incrementAndGet());
        } else {
            locais.removeIf(p -> p.getId().equals(local.getId()));
        }
        locais.add(local);
        return local;
    }

    public Local update(Long id, Local localAtualizado) {
        return findById(id).map(localExistente -> {
            localExistente.setNome(localAtualizado.getNome());
            localExistente.setDescricao(localAtualizado.getDescricao());
            localExistente.setPreco(localAtualizado.getPreco());
            localExistente.setCep(localAtualizado.getCep());
            localExistente.setCapacidade(localAtualizado.getCapacidade());
            localExistente.setImagemUrl(localAtualizado.getImagemUrl());
            localExistente.setDataCadastro(localAtualizado.getDataCadastro());
            return localExistente;
        }).orElse(null);
    }

    public boolean deleteById(Long id) {
        return locais.removeIf(local -> local.getId().equals(id));
    }
}
