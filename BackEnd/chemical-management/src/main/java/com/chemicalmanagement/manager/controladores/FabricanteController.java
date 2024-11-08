package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Fabricante;
import com.chemicalmanagement.manager.servicios.Interfaces.FabricanteServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fabricantes")
@CrossOrigin(origins = "*")
public class FabricanteController {

    @Autowired
    private FabricanteServiceInt fabricanteService;

    @GetMapping
    public ResponseEntity<List<Fabricante>> listarFabricantes() {
        List<Fabricante> fabricantes = fabricanteService.obtenerTodosLosFabricantes();
        return ResponseEntity.ok(fabricantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> obtenerFabricantePorId(@PathVariable Long id) {
        Optional<Fabricante> fabricante = fabricanteService.obtenerFabricantePorId(id);
        return fabricante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fabricante> crearFabricante(@RequestBody Fabricante fabricante) {
        Fabricante nuevoFabricante = fabricanteService.guardarFabricante(fabricante);
        return ResponseEntity.ok(nuevoFabricante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> actualizarFabricante(@PathVariable Long id, @RequestBody Fabricante fabricanteActualizado) {
        Fabricante fabricante = fabricanteService.actualizarFabricante(id, fabricanteActualizado);
        return fabricante != null ? ResponseEntity.ok(fabricante) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFabricante(@PathVariable Long id) {
        fabricanteService.eliminarFabricante(id);
        return ResponseEntity.noContent().build();
    }
}
