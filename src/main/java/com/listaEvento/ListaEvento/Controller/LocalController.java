package com.listaEvento.ListaEvento.Controller;

import com.listaEvento.ListaEvento.Dominio.Local;
import com.listaEvento.ListaEvento.Model.LocalModel; // Importa o LocalModel
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Anotação correta para um controlador REST
@RequestMapping("/locais") // Define o caminho base para este controlador
@CrossOrigin("*") // Permite requisições de qualquer origem (para desenvolvimento)
public class LocalController {

    @Autowired // Injeta a dependência do LocalModel
    private LocalModel localModel;

    @GetMapping
    public ResponseEntity<List<Local>> listarLocais() {
        return ResponseEntity.ok(localModel.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Local> buscarPorId(@PathVariable Long id) {
        Optional<Local> local = localModel.findById(id);
        return local.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Local> criarLocal(@RequestBody Local local) {
        Local criado = localModel.save(local);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Local> atualizarLocal(@PathVariable Long id, @RequestBody Local local) {
        Local atualizado = localModel.update(id, local);
        if (atualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLocal(@PathVariable Long id) {
        boolean removido = localModel.deleteById(id);
        if (!removido) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}