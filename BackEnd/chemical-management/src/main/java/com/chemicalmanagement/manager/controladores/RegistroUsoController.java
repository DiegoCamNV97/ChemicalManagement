package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import com.chemicalmanagement.manager.servicios.Interfaces.RegistroUsoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registroUso")
@CrossOrigin(origins = "*")
public class RegistroUsoController {

    private final RegistroUsoService registroUsoService;

    public RegistroUsoController(RegistroUsoService registroUsoService) {
        this.registroUsoService = registroUsoService;
    }

    // Obtener todos los registros de uso
    @GetMapping
    public ResponseEntity<List<RegistroUso>> listarRegistroUso() {
        return ResponseEntity.ok(registroUsoService.listarTodos());
    }

    // Obtener un registro de uso por ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistroUso> obtenerRegistroUsoPorId(@PathVariable int id) {
        Optional<RegistroUso> registroUso = registroUsoService.buscarPorId(id);
        return registroUso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear un nuevo registro de uso
    @PostMapping
    public ResponseEntity<RegistroUso> crearRegistroUso(@RequestBody RegistroUso registroUso) {
        RegistroUso nuevoRegistroUso = registroUsoService.guardarRegistro(registroUso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistroUso);
    }

    // Actualizar un registro de uso existente
    @PutMapping("/{id}")
    public ResponseEntity<RegistroUso> actualizarRegistroUso(@PathVariable int id, @RequestBody RegistroUso registroUso) {
        if (registroUsoService.buscarPorId(id).isPresent()) {
            registroUso.setId(id);
            RegistroUso registroUsoActualizado = registroUsoService.guardarRegistro(registroUso);
            return ResponseEntity.ok(registroUsoActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un registro de uso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistroUso(@PathVariable int id) {
        if (registroUsoService.buscarPorId(id).isPresent()) {
            registroUsoService.eliminarRegistro(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
