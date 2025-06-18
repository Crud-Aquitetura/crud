package com.listaEvento.ListaEvento.Model;

import com.listaEvento.ListaEvento.Dominio.Local; // Importação corrigida
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class LocalModel {

    private final List<Local> locais = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(); // Para gerar IDs simulados

    public LocalModel() {
        // Adiciona alguns locais de exemplo ao iniciar
        locais.add(new Local(counter.incrementAndGet(), "Auditório Principal", "Um grande auditório para eventos", new BigDecimal("1200.00"), "12345-678", 500, "http://exemplo.com/auditorio1.jpg", LocalDate.of(2024, 1, 15)));
        locais.add(new Local(counter.incrementAndGet(), "Sala de Convenções", "Sala equipada para conferências", new BigDecimal("750.00"), "23456-789", 100, "http://exemplo.com/sala2.jpg", LocalDate.of(2024, 2, 20)));
        locais.add(new Local(counter.incrementAndGet(), "Espaço Aberto Park", "Área externa para grandes eventos", new BigDecimal("2000.00"), "34567-890", 1000, "http://exemplo.com/park3.jpg", LocalDate.of(2024, 3, 10)));
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
        }).orElse(null); // Retorna null se não encontrar
    }

    public boolean deleteById(Long id) {
        return locais.removeIf(local -> local.getId().equals(id));
    }
}