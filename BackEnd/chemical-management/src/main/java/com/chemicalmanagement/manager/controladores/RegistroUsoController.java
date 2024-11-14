package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import com.chemicalmanagement.manager.servicios.Interfaces.RegistroUsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/registrouso") // Ruta base para registro de uso
public class RegistroUsoController {

    @Autowired
    private RegistroUsoService registroUsoService;

    // Obtener todos los registros de uso
    @GetMapping
    public ResponseEntity<List<RegistroUso>> obtenerTodos() {
        List<RegistroUso> registros = registroUsoService.obtenerTodos();
        return ResponseEntity.ok(registros);
    }

    // Obtener registro de uso por ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistroUso> obtenerRegistroUsoPorId(@PathVariable Integer id) {
        Optional<RegistroUso> registroUso = registroUsoService.obtenerPorId(id);
        return registroUso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo registro de uso
    @PostMapping
    public RegistroUso crearRegistroUso(@RequestBody RegistroUso registroUso) {
        return registroUsoService.crear(registroUso);
    }

    // Actualizar registro de uso
    @PutMapping("/{id}")
    public ResponseEntity<RegistroUso> actualizarRegistroUso(@PathVariable Integer id, @RequestBody RegistroUso registroUso) {
        Optional<RegistroUso> registroUsoActualizado = registroUsoService.actualizar(id, registroUso);
        return registroUsoActualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar registro de uso
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistroUso(@PathVariable Integer id) {
        if (registroUsoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar registros de uso por ID de usuario
    @GetMapping("/buscar/usuario")
    public List<RegistroUso> buscarPorUsuarioId(@RequestParam Integer usuarioId) {
        return registroUsoService.buscarPorUsuarioId(usuarioId);
    }

    // Buscar registros de uso por ID de reactivo
    @GetMapping("/buscar/reactivo")
    public List<RegistroUso> buscarPorReactivoId(@RequestParam Integer reactivoId) {
        return registroUsoService.buscarPorReactivoId(reactivoId);
    }

    // Buscar registros de uso por ID de usuario y reactivo
    @GetMapping("/buscar/usuario-reactivo")
    public List<RegistroUso> buscarPorUsuarioIdYReactivoId(@RequestParam Integer usuarioId, @RequestParam Integer reactivoId) {
        return registroUsoService.buscarPorUsuarioIdYReactivoId(usuarioId, reactivoId);
    }
}
