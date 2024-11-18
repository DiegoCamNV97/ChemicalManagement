package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/reactivo") // Ruta base para reactivos
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ReactivoController {

    @Autowired
    private ReactivoService reactivoService;

    // Obtener todos los reactivos
    @GetMapping
    public ResponseEntity<List<Reactivo>> obtenerReactivos() {
        List<Reactivo> reactivos = reactivoService.obtenerTodos();
        if (reactivos.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 si no hay datos
        }
        return ResponseEntity.ok(reactivos);
    }

    // Obtener reactivo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reactivo> obtenerReactivoPorId(@PathVariable Integer id) {
        Optional<Reactivo> reactivo = reactivoService.obtenerPorId(id);
        return reactivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo reactivo
    @PostMapping
    public ResponseEntity<?> crearReactivo(@RequestBody Reactivo reactivo) {
        try {
            if (reactivo.getQr() == null || reactivo.getQr().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El campo QR es obligatorio");
            }
            if (reactivo.getFabricante() == null || reactivo.getFabricante().getId() == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El fabricante es obligatorio");
            }
            Reactivo nuevoReactivo = reactivoService.crear(reactivo);
            return ResponseEntity.ok(nuevoReactivo);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el reactivo");
        }
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
    
    @GetMapping("/alertas/por-vencer")
    public ResponseEntity<List<Reactivo>> obtenerReactivosPorVencer() {
        List<Reactivo> reactivosPorVencer = reactivoService.obtenerPorVencer();
        return ResponseEntity.ok(reactivosPorVencer);
    }

    @GetMapping("/alertas/vencidos")
    public ResponseEntity<List<Reactivo>> obtenerReactivosVencidos() {
        List<Reactivo> reactivosVencidos = reactivoService.obtenerVencidos();
        return ResponseEntity.ok(reactivosVencidos);
    }

    @GetMapping("/alertas/poco-stock")
    public ResponseEntity<List<Reactivo>> obtenerReactivosConPocoStock() {
        List<Reactivo> reactivosConPocoStock = reactivoService.obtenerConPocoStock();
        return ResponseEntity.ok(reactivosConPocoStock);
    }
}
