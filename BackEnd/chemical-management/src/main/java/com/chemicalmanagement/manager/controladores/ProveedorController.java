package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Proveedor;
import com.chemicalmanagement.manager.servicios.Interfaces.ProveedorServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedorController {

    @Autowired
    private ProveedorServiceInt proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> listarProveedores() {
        List<Proveedor> proveedores = proveedorService.obtenerTodosLosProveedores();
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> obtenerProveedorPorId(@PathVariable Long id) {
        Optional<Proveedor> proveedor = proveedorService.obtenerProveedorPorId(id);
        return proveedor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proveedor> crearProveedor(@RequestBody Proveedor proveedor) {
        Proveedor nuevoProveedor = proveedorService.guardarProveedor(proveedor);
        return ResponseEntity.ok(nuevoProveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorActualizado) {
        Proveedor proveedor = proveedorService.actualizarProveedor(id, proveedorActualizado);
        return proveedor != null ? ResponseEntity.ok(proveedor) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProveedor(@PathVariable Long id) {
        proveedorService.eliminarProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
