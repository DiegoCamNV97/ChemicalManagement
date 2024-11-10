package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import com.chemicalmanagement.manager.repositorios.RegistroUsoRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.RegistroUsoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroUsoServiceImpl implements RegistroUsoService {

    @Autowired
    private RegistroUsoRepository registroUsoRepository;

    @Override
    public RegistroUso guardarRegistroUso(RegistroUso registroUso) {
        return registroUsoRepository.save(registroUso);
    }

    @Override
    public RegistroUso actualizarRegistroUso(RegistroUso registroUso) {
        return registroUsoRepository.save(registroUso);
    }

    @Override
    public void eliminarRegistroUso(Long id) {
        registroUsoRepository.deleteById(id);
    }

    @Override
    public RegistroUso obtenerRegistroUsoPorId(Long id) {
        Optional<RegistroUso> registroUso = registroUsoRepository.findById(id);
        return registroUso.orElse(null);
    }

    @Override
    public List<RegistroUso> buscarRegistrosPorReactivoId(Long reactivoId) {
        return registroUsoRepository.findByReactivoId(reactivoId);
    }

    @Override
    public List<RegistroUso> buscarRegistrosPorNombreReactivo(String nombreReactivo) {
        return registroUsoRepository.findByReactivoNombreReactivoContainingIgnoreCase(nombreReactivo);
    }

    @Override
    public List<RegistroUso> listarRegistrosUso() {
        return registroUsoRepository.findAll();
    }
}
