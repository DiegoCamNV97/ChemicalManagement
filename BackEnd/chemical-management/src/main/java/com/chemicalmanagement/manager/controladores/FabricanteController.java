package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Fabricante;
import com.chemicalmanagement.manager.servicios.Interfaces.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fabricante") // Ruta base para fabricantes
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    // Obtener todos los fabricantes
    @GetMapping
    public ResponseEntity<List<Fabricante>> obtenerFabricantes() {
        List<Fabricante> fabricantes = fabricanteService.obtenerTodosLosFabricantes();
        return ResponseEntity.ok(fabricantes);
    }

    // Obtener fabricante por ID
    @GetMapping("/{id}")
    public ResponseEntity<Fabricante> obtenerFabricantePorId(@PathVariable Integer id) {
        Optional<Fabricante> fabricante = fabricanteService.obtenerPorId(id);
        return fabricante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo fabricante
    @PostMapping
    public Fabricante crearFabricante(@RequestBody Fabricante fabricante) {
        return fabricanteService.crear(fabricante);
    }

    // Actualizar fabricante
    @PutMapping("/{id}")
    public ResponseEntity<Fabricante> actualizarFabricante(@PathVariable Integer id, @RequestBody Fabricante fabricante) {
        Optional<Fabricante> fabricanteActualizado = fabricanteService.actualizar(id, fabricante);
        return fabricanteActualizado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar fabricante
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFabricante(@PathVariable Integer id) {
        if (fabricanteService.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/buscar")
    public List<Fabricante> buscarFabricantesPorNombre(@RequestParam String nombre) {
        return fabricanteService.buscarPorNombre(nombre);
    }
}
