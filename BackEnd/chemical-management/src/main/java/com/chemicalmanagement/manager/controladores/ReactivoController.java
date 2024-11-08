package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivoServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reactivos")
@CrossOrigin(origins = "*")
public class ReactivoController {

    @Autowired
    private ReactivoServiceInt reactivoService;

    @GetMapping
    public ResponseEntity<List<Reactivo>> listarReactivos() {
        List<Reactivo> reactivos = reactivoService.obtenerTodosLosReactivos();
        return ResponseEntity.ok(reactivos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reactivo> obtenerReactivoPorId(@PathVariable Long id) {
        Optional<Reactivo> reactivo = reactivoService.obtenerReactivoPorId(id);
        return reactivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reactivo> crearReactivo(@RequestBody Reactivo reactivo) {
        Reactivo nuevoReactivo = reactivoService.guardarReactivo(reactivo);
        return ResponseEntity.ok(nuevoReactivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reactivo> actualizarReactivo(@PathVariable Long id, @RequestBody Reactivo reactivoActualizado) {
        Reactivo reactivo = reactivoService.actualizarReactivo(id, reactivoActualizado);
        return reactivo != null ? ResponseEntity.ok(reactivo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReactivo(@PathVariable Long id) {
        reactivoService.eliminarReactivo(id);
        return ResponseEntity.noContent().build();
    }
}
