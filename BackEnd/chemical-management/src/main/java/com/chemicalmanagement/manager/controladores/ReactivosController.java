package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reactivos")
public class ReactivosController {

    @Autowired
    private ReactivosService reactivosService;

    @PostMapping
    public ResponseEntity<Reactivo> guardarReactivo(@RequestBody Reactivo reactivo) {
        Reactivo nuevoReactivo = reactivosService.guardarReactivo(reactivo);
        return ResponseEntity.ok(nuevoReactivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reactivo> actualizarReactivo(@PathVariable Long id, @RequestBody Reactivo reactivo) {
        reactivo.setId(id);
        Reactivo reactivoActualizado = reactivosService.actualizarReactivo(reactivo);
        return ResponseEntity.ok(reactivoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReactivo(@PathVariable Long id) {
        reactivosService.eliminarReactivo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reactivo> obtenerReactivoPorId(@PathVariable Long id) {
        Reactivo reactivo = reactivosService.obtenerReactivoPorId(id);
        return reactivo != null ? ResponseEntity.ok(reactivo) : ResponseEntity.notFound().build();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Reactivo>> buscarReactivos(@RequestParam(required = false) String nombre,
                                                          @RequestParam(required = false) String codigo,
                                                          @RequestParam(required = false) String cas) {
        List<Reactivo> reactivos = reactivosService.buscarReactivosPorNombreCodigoOCas(nombre, codigo, cas);
        return ResponseEntity.ok(reactivos);
    }

    @GetMapping
    public ResponseEntity<List<Reactivo>> listarReactivos() {
        List<Reactivo> reactivos = reactivosService.listarReactivos();
        return ResponseEntity.ok(reactivos);
    }
}
