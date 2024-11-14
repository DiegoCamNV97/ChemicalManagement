package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Usuario;
import com.chemicalmanagement.manager.repositorios.UsuarioRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> actualizar(Integer id, Usuario usuario) {
        return usuarioRepository.findById(id).map(u -> {
            u.setNombres(usuario.getNombres());
            u.setApellidos(usuario.getApellidos());
            u.setCorreoPersonal(usuario.getCorreoPersonal());
            u.setCorreoInstitucional(usuario.getCorreoInstitucional());
            u.setTipoUsuario(usuario.getTipoUsuario());
            u.setUser(usuario.getUser());
            u.setPassword(usuario.getPassword());
            return usuarioRepository.save(u);
        });
    }

    @Override
    public boolean eliminar(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Usuario> iniciarSesion(String user, String password) {
        // Verificación de inicio de sesión utilizando user y password
        return usuarioRepository.findByUserAndPassword(user, password);
    }
}
