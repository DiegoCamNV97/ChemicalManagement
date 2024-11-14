package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reactivo") // Ruta base para reactivos
public class ReactivoController {

    @Autowired
    private ReactivoService reactivoService;

    // Obtener todos los reactivos
    @GetMapping
    public List<Reactivo> obtenerReactivos() {
        return reactivoService.obtenerTodos();
    }

    // Obtener reactivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reactivo> obtenerReactivoPorId(@PathVariable Integer id) {
        Optional<Reactivo> reactivo = reactivoService.obtenerPorId(id);
        return reactivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo reactivo
    @PostMapping
    public Reactivo crearReactivo(@RequestBody Reactivo reactivo) {
        return reactivoService.crear(reactivo);
    }

    // Actualizar reactivo
    @PutMapping("/{id}")
    public ResponseEntity<Reactivo> actualizarReactivo(@PathVariable Integer id, @RequestBody Reactivo reactivo) {
        Optional<Reactivo> reactivoActualizado = reactivoService.actualizar(id, reactivo);
        return reactivoActualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar reactivo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReactivo(@PathVariable Integer id) {
        if (reactivoService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar reactivo por nombre
    @GetMapping("/buscar/nombre")
    public List<Reactivo> buscarPorNombre(@RequestParam String nombre) {
        return reactivoService.buscarPorNombre(nombre);
    }

    // Buscar reactivo por CAS
    @GetMapping("/buscar/cas")
    public List<Reactivo> buscarPorCas(@RequestParam String cas) {
        return reactivoService.buscarPorCas(cas);
    }

    // Buscar reactivo por fabricante ID
    @GetMapping("/buscar/fabricante")
    public List<Reactivo> buscarPorFabricanteId(@RequestParam Integer fabricanteId) {
        return reactivoService.buscarPorFabricanteId(fabricanteId);
    }
}
