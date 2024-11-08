package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.RegistroUso;
import com.chemicalmanagement.manager.repositorios.RegistroUsoRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.RegistroUsoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroUsoServiceImpl implements RegistroUsoService {

    private final RegistroUsoRepository registroUsoRepository;

    public RegistroUsoServiceImpl(RegistroUsoRepository registroUsoRepository) {
        this.registroUsoRepository = registroUsoRepository;
    }

    @Override
    public List<RegistroUso> listarTodos() {
        return registroUsoRepository.findAll();
    }

    @Override
    public Optional<RegistroUso> buscarPorId(int id) {
        return registroUsoRepository.findById(id);
    }

    @Override
    public RegistroUso guardarRegistro(RegistroUso registroUso) {
        return registroUsoRepository.save(registroUso);
    }

    @Override
    public void eliminarRegistro(int id) {
        registroUsoRepository.deleteById(id);
    }
}
