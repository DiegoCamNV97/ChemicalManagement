package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import com.chemicalmanagement.manager.entidades.Usuario;
import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.repositorios.RegistroUsoRepository;
import com.chemicalmanagement.manager.repositorios.UsuarioRepository;
import com.chemicalmanagement.manager.repositorios.ReactivoRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.RegistroUsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroUsoServiceImpl implements RegistroUsoService {

    @Autowired
    private RegistroUsoRepository registroUsoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ReactivoRepository reactivoRepository;

    @Override
    public RegistroUso crear(RegistroUso registroUso) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findById(registroUso.getUsuario().getId());
        Optional<Reactivo> reactivoExistente = reactivoRepository.findById(registroUso.getReactivo().getId());

        if (usuarioExistente.isPresent() && reactivoExistente.isPresent()) {
            registroUso.setUsuario(usuarioExistente.get());
            registroUso.setReactivo(reactivoExistente.get());
            return registroUsoRepository.save(registroUso);
        } else {
            throw new IllegalArgumentException("Usuario o Reactivo no existe en la base de datos.");
        }
    }

    @Override
    public Optional<RegistroUso> actualizar(Integer id, RegistroUso registroUso) {
        return registroUsoRepository.findById(id).map(r -> {
            Optional<Usuario> usuarioExistente = usuarioRepository.findById(registroUso.getUsuario().getId());
            Optional<Reactivo> reactivoExistente = reactivoRepository.findById(registroUso.getReactivo().getId());

            if (usuarioExistente.isPresent() && reactivoExistente.isPresent()) {
                r.setUsuario(usuarioExistente.get());
                r.setReactivo(reactivoExistente.get());
                r.setCantidadUtilizada(registroUso.getCantidadUtilizada());
                r.setFechaUso(registroUso.getFechaUso());
                r.setUnidadMedida(registroUso.getUnidadMedida());
                return registroUsoRepository.save(r);
            } else {
                throw new IllegalArgumentException("Usuario o Reactivo no existe en la base de datos.");
            }
        });
    }

    @Override
    public boolean eliminar(Integer id) {
        if (registroUsoRepository.existsById(id)) {
            registroUsoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<RegistroUso> obtenerTodos() {
        return registroUsoRepository.findAll();
    }

    @Override
    public Optional<RegistroUso> obtenerPorId(Integer id) {
        return registroUsoRepository.findById(id);
    }

    @Override
    public List<RegistroUso> buscarPorUsuarioId(Integer usuarioId) {
        return registroUsoRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<RegistroUso> buscarPorReactivoId(Integer reactivoId) {
        return registroUsoRepository.findByReactivoId(reactivoId);
    }

    @Override
    public List<RegistroUso> buscarPorUsuarioIdYReactivoId(Integer usuarioId, Integer reactivoId) {
        return registroUsoRepository.findByUsuarioIdAndReactivoId(usuarioId, reactivoId);
    }
}
