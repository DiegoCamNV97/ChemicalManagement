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
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
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
    public ResponseEntity<?> crearRegistroUso(@RequestBody RegistroUso registroUso) {
        if (registroUso.getReactivo() == null || registroUso.getUsuario() == null) {
            return ResponseEntity.badRequest().body("Reactivo y Usuario son obligatorios.");
        }
        RegistroUso nuevoRegistro = registroUsoService.crear(registroUso);
        return ResponseEntity.ok(nuevoRegistro);
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

    @GetMapping("/buscar")
    public ResponseEntity<List<RegistroUso>> buscarRegistros(
            @RequestParam(required = false) Integer usuarioId,
            @RequestParam(required = false) Integer reactivoId) {
        List<RegistroUso> resultados;
        if (usuarioId != null && reactivoId != null) {
            resultados = registroUsoService.buscarPorUsuarioIdYReactivoId(usuarioId, reactivoId);
        } else if (usuarioId != null) {
            resultados = registroUsoService.buscarPorUsuarioId(usuarioId);
        } else if (reactivoId != null) {
            resultados = registroUsoService.buscarPorReactivoId(reactivoId);
        } else {
            resultados = registroUsoService.obtenerTodos();
        }
        return ResponseEntity.ok(resultados);
    }
}
