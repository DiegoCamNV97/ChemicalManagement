package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Usuario;
import com.chemicalmanagement.manager.servicios.Interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioService.guardarUsuario(usuario);
        return ResponseEntity.ok(nuevoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        Usuario usuarioActualizado = usuarioService.actualizarUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Usuario> obtenerUsuarioPorDni(@PathVariable String dni) {
        Usuario usuario = usuarioService.obtenerUsuarioPorDni(dni);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<Usuario> obtenerUsuarioPorUser(@PathVariable String user) {
        Usuario usuario = usuarioService.obtenerUsuarioPorUser(user);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> autenticarUsuario(@RequestParam String user, @RequestParam String password) {
        Usuario usuario = usuarioService.autenticarUsuario(user, password);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.status(401).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}
