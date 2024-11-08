package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Reactivos;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reactivos")
@CrossOrigin(origins = "*")
public class ReactivosController {

    private final ReactivosService reactivosService;

    public ReactivosController(ReactivosService reactivosService) {
        this.reactivosService = reactivosService;
    }

    // Obtener todos los reactivos
    @GetMapping
    public ResponseEntity<List<Reactivos>> listarReactivos() {
        return ResponseEntity.ok(reactivosService.listarReactivos());
    }

    // Obtener reactivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reactivos> obtenerReactivoPorId(@PathVariable int id) {
        Optional<Reactivos> reactivo = reactivosService.buscarPorId(id);
        return reactivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear un nuevo reactivo
    @PostMapping
    public ResponseEntity<Reactivos> crearReactivo(@RequestBody Reactivos reactivo) {
        Reactivos nuevoReactivo = reactivosService.guardarReactivo(reactivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoReactivo);
    }

    // Actualizar un reactivo existente
    @PutMapping("/{id}")
    public ResponseEntity<Reactivos> actualizarReactivo(@PathVariable int id, @RequestBody Reactivos reactivo) {
        if (reactivosService.buscarPorId(id).isPresent()) {
            reactivo.setId(id);
            Reactivos reactivoActualizado = reactivosService.guardarReactivo(reactivo);
            return ResponseEntity.ok(reactivoActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un reactivo por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReactivo(@PathVariable int id) {
        if (reactivosService.buscarPorId(id).isPresent()) {
            reactivosService.eliminarReactivo(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
