package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import com.chemicalmanagement.manager.servicios.Interfaces.RegistroUsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/registros-uso")
public class RegistroUsoController {

    @Autowired
    private RegistroUsoService registroUsoService;

    @PostMapping
    public ResponseEntity<RegistroUso> guardarRegistroUso(@RequestBody RegistroUso registroUso) {
        RegistroUso nuevoRegistro = registroUsoService.guardarRegistroUso(registroUso);
        return ResponseEntity.ok(nuevoRegistro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegistroUso> actualizarRegistroUso(@PathVariable Long id, @RequestBody RegistroUso registroUso) {
        registroUso.setId(id);
        RegistroUso registroActualizado = registroUsoService.actualizarRegistroUso(registroUso);
        return ResponseEntity.ok(registroActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRegistroUso(@PathVariable Long id) {
        registroUsoService.eliminarRegistroUso(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroUso> obtenerRegistroUsoPorId(@PathVariable Long id) {
        RegistroUso registroUso = registroUsoService.obtenerRegistroUsoPorId(id);
        return registroUso != null ? ResponseEntity.ok(registroUso) : ResponseEntity.notFound().build();
    }

    @GetMapping("/reactivo/{reactivoId}")
    public ResponseEntity<List<RegistroUso>> buscarRegistrosPorReactivoId(@PathVariable Long reactivoId) {
        List<RegistroUso> registros = registroUsoService.buscarRegistrosPorReactivoId(reactivoId);
        return ResponseEntity.ok(registros);
    }

    @GetMapping("/reactivo-nombre")
    public ResponseEntity<List<RegistroUso>> buscarRegistrosPorNombreReactivo(@RequestParam String nombreReactivo) {
        List<RegistroUso> registros = registroUsoService.buscarRegistrosPorNombreReactivo(nombreReactivo);
        return ResponseEntity.ok(registros);
    }

    @GetMapping
    public ResponseEntity<List<RegistroUso>> listarRegistrosUso() {
        List<RegistroUso> registros = registroUsoService.listarRegistrosUso();
        return ResponseEntity.ok(registros);
    }
}
