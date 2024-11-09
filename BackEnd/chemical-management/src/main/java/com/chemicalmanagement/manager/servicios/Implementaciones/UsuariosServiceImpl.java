package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Usuarios;
import com.chemicalmanagement.manager.repositorios.UsuariosRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.UsuariosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    private final UsuariosRepository usuariosRepository;

    public UsuariosServiceImpl(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public Optional<Usuarios> buscarPorId(int id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public Usuarios guardarUsuario(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        usuariosRepository.deleteById(id);
    }

    @Override
    public List<Usuarios> listarTodos() {
        return usuariosRepository.findAll();
    }

    @Override
    public Optional<Usuarios> buscarPorCorreoInstitucional(String correoInstitucional) {
        return usuariosRepository.findByCorreoInstitucional(correoInstitucional);
    }

    @Override
    public Optional<Usuarios> buscarPorUsuarioYPassword(String usuario, String password) {
        return usuariosRepository.findByUsuarioAndPassword(usuario, password);
    }
}
