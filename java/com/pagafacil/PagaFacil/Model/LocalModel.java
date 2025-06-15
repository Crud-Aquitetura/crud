
package com.pagafacil.PagaFacil.Model;

import com.example.demo.model.Produto;
import com.pagafacil.PagaFacil.View.local;
import jdk.vm.ci.meta.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LocalModel {

    private final List<Local> locais = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(); // Para gerar IDs simulados

    public LocalModel() {
        // Adiciona alguns produtos de exemplo ao iniciar
        locais.add(new Local(counter.incrementAndGet(), "Notebook Dell", "Core i7, 16GB RAM", new BigDecimal("5500.00")));
        locais.add(new Local(counter.incrementAndGet(), "Mouse Gamer", "RGB, 10000 DPI", new BigDecimal("150.00")));
        locais.add(new Local(counter.incrementAndGet(), "Teclado Mecânico", "Switch Brown", new BigDecimal("300.00")));
    }

    public List<Local> findAll() {
        return new ArrayList<>(locais); // Retorna uma cópia para evitar modificações externas
    }

    public Optional<Local> findById(Long id) {
        return locais.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Local save(Local local) {
        if (local.getId() == null) {
            local.setId(counter.incrementAndGet()); // Gera um novo ID se não houver
        } else {
            // Se o ID já existe, remove o antigo antes de adicionar o novo (simula atualização)
            locais.removeIf(p -> p.getId().equals(local.getId()));
        }
        locais.add(local);
        return local;
    }

    public local update(Long id, Local localAtualizado) {
        return findById(id).map(localExistente -> {
            localExistente.SetId(localExistente.getId());
            localExistente.setNome(localAtualizado.getNome());
            localExistente.setDescricao(localAtualizado.getDescricao());
            localExistente.setPreco(localAtualizado.getPreco());
            localExistente.setCep(localAtualizado.getCep());
            localExistente.setCapacidade(localAtualizado.getCapacidade());
            localExistente.setImagemUrl(localAtualizado.getImagemUrl());
            localExistente.setDataCadastro(localAtualizado.getDataCadastro());
            return localExistente;
        }).orElse(null); // Retorna null se não encontrar
    }

    public boolean deleteById(Long id) {
        return locais.removeIf(local -> local.getId().equals(id));
    }
}