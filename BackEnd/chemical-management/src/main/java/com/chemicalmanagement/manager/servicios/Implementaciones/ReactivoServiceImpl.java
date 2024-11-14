package com.chemicalmanagement.manager.servicios.Implementaciones;

import com.chemicalmanagement.manager.entidades.Reactivo;
import com.chemicalmanagement.manager.repositorios.ReactivoRepository;
import com.chemicalmanagement.manager.servicios.Interfaces.ReactivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReactivoServiceImpl implements ReactivoService {

    @Autowired
    private ReactivoRepository reactivoRepository;

    @Override
    public List<Reactivo> obtenerTodos() {
        return reactivoRepository.findAll();
    }

    @Override
    public Optional<Reactivo> obtenerPorId(Integer id) {
        return reactivoRepository.findByIdWithFabricante(id); // Usamos el método que incluye JOIN FETCH
    }

    @Override
    public Reactivo crear(Reactivo reactivo) {
        return reactivoRepository.save(reactivo);
    }

    @Override
    public Optional<Reactivo> actualizar(Integer id, Reactivo reactivo) {
        return reactivoRepository.findById(id).map(r -> {
            r.setNombreReactivo(reactivo.getNombreReactivo());
            r.setQr(reactivo.getQr());
            r.setUbicacion(reactivo.getUbicacion());
            r.setPresentacion(reactivo.getPresentacion());
            r.setUnidadMedida(reactivo.getUnidadMedida());
            r.setLote(reactivo.getLote());
            r.setFechaFabricacion(reactivo.getFechaFabricacion());
            r.setFechaVencimiento(reactivo.getFechaVencimiento());
            r.setExistencia(reactivo.getExistencia());
            r.setCas(reactivo.getCas());
            r.setFormula(reactivo.getFormula().toUpperCase());
            r.setPalabraAdvertencia(reactivo.getPalabraAdvertencia());
            r.setPictogramasSGA(reactivo.getPictogramasSGA());
            r.setFrasesH(reactivo.getFrasesH());
            r.setFrasesP(reactivo.getFrasesP());
            r.setFichaDatosSeguridad(reactivo.getFichaDatosSeguridad());
            r.setVigenciaFDS(reactivo.getVigenciaFDS());
            r.setFabricante(reactivo.getFabricante());
            return reactivoRepository.save(r);
        });
    }

    @Override
    public boolean eliminar(Integer id) {
        if (reactivoRepository.existsById(id)) {
            reactivoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Reactivo> buscarPorNombre(String nombreReactivo) {
        return reactivoRepository.findByNombreReactivoContaining(nombreReactivo);
    }

    @Override
    public List<Reactivo> buscarPorCas(String cas) {
        return reactivoRepository.findByCas(cas);
    }

    @Override
    public List<Reactivo> buscarPorFabricanteId(Integer fabricanteId) {
        return reactivoRepository.findByFabricanteId(fabricanteId);
    }
}
