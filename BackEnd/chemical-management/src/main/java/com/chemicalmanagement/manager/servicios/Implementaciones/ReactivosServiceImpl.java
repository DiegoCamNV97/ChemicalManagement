package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.repositorios.ReactivosRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReactivosServiceImpl implements ReactivosService {

    @Autowired
    private ReactivosRepository reactivosRepository;

    @Override
    public Reactivo guardarReactivo(Reactivo reactivo) {
        return reactivosRepository.save(reactivo);
    }

    @Override
    public Reactivo actualizarReactivo(Reactivo reactivo) {
        return reactivosRepository.save(reactivo);
    }

    @Override
    public void eliminarReactivo(Long id) {
        reactivosRepository.deleteById(id);
    }

    @Override
    public Reactivo obtenerReactivoPorId(Long id) {
        Optional<Reactivo> reactivo = reactivosRepository.findById(id);
        return reactivo.orElse(null);
    }

    @Override
    public List<Reactivo> buscarReactivosPorNombre(String nombreReactivo) {
        return reactivosRepository.findByNombreReactivoContainingIgnoreCase(nombreReactivo);
    }

    @Override
    public List<Reactivo> buscarReactivosPorCodigo(String qr) {
        return reactivosRepository.findByQr(qr);
    }

    @Override
    public List<Reactivo> buscarReactivosPorNombreCodigoOCas(String nombreReactivo, String qr, String cas) {
        return reactivosRepository.findByNombreReactivoOrQrOrCas(nombreReactivo, qr, cas);
    }

    @Override
    public List<Reactivo> listarReactivos() {
        return reactivosRepository.findAll();
    }
}
