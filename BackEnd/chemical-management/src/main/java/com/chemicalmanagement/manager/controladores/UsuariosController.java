package com.chemicalmanagement.manager.controladores;

import com.chemicalmanagement.manager.entidades.Usuarios;
import com.chemicalmanagement.manager.servicios.Interfaces.UsuariosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Configuración CORS para permitir solicitudes desde cualquier origen
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    // Obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuarios>> listarUsuarios() {
        return ResponseEntity.ok(usuariosService.listarTodos());
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> obtenerUsuarioPorId(@PathVariable int id) {
        Optional<Usuarios> usuario = usuariosService.buscarPorId(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Usuarios> crearUsuario(@RequestBody Usuarios usuario) {
        Usuarios nuevoUsuario = usuariosService.guardarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    // Actualizar usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> actualizarUsuario(@PathVariable int id, @RequestBody Usuarios usuario) {
        if (usuariosService.buscarPorId(id).isPresent()) {
            usuario.setId(id);
            Usuarios usuarioActualizado = usuariosService.guardarUsuario(usuario);
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable int id) {
        if (usuariosService.buscarPorId(id).isPresent()) {
            usuariosService.eliminarUsuario(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Autenticación de usuario (inicio de sesión)
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginData) {
        String usuario = loginData.get("usuario");
        String password = loginData.get("password");

        Optional<Usuarios> user = usuariosService.buscarPorUsuarioYPassword(usuario, password);

        if (user.isPresent()) {
            // Devuelve el tipo de usuario (e.g., "USER" o "ADMIN")
            return ResponseEntity.ok(user.get().getTipoUsuario());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }
    }
}
