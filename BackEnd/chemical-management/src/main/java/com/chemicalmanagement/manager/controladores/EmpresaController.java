package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Empresa;
import com.chemicalmanagement.manager.servicios.Interfaces.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> guardarEmpresa(@RequestBody Empresa empresa) {
        Empresa nuevaEmpresa = empresaService.guardarEmpresa(empresa);
        return ResponseEntity.ok(nuevaEmpresa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        empresa.setId(id);
        Empresa empresaActualizada = empresaService.actualizarEmpresa(empresa);
        return ResponseEntity.ok(empresaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpresa(@PathVariable Long id) {
        empresaService.eliminarEmpresa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
        Empresa empresa = empresaService.obtenerEmpresaPorId(id);
        return empresa != null ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<Empresa> obtenerEmpresaPorNombre(@PathVariable String nombre) {
        Empresa empresa = empresaService.obtenerEmpresaPorNombre(nombre);
        return empresa != null ? ResponseEntity.ok(empresa) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listarEmpresas() {
        List<Empresa> empresas = empresaService.listarEmpresas();
        return ResponseEntity.ok(empresas);
    }
}
