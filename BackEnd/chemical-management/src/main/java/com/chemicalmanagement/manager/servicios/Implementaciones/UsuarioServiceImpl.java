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
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    @Override
    public Usuario obtenerUsuarioPorDni(String dni) {
        return usuarioRepository.findByDni(dni);
    }

    @Override
    public Usuario obtenerUsuarioPorUser(String user) {
        return usuarioRepository.findByUser(user);
    }

    @Override
    public Usuario autenticarUsuario(String user, String password) {
        return usuarioRepository.findByUserAndPassword(user, password);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
