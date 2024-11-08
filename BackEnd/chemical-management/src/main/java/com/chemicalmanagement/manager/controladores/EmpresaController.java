package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Empresa;
import com.chemicalmanagement.manager.servicios.Interfaces.EmpresaServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins = "*") // Permite el acceso desde cualquier origen
public class EmpresaController {

    @Autowired
    private EmpresaServiceInt empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = empresaService.obtenerTodasLasEmpresas();
        return ResponseEntity.ok(empresas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = empresaService.obtenerEmpresaPorId(id);
        return empresa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Empresa> crearEmpresa(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaService.guardarEmpresa(empresa);
        return ResponseEntity.ok(nuevaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresaActualizada) {
        Empresa empresa = empresaService.actualizarEmpresa(id, empresaActualizada);
        return empresa != null ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        empresaService.eliminarEmpresa(id);
        return ResponseEntity.noContent().build();
    }
}
