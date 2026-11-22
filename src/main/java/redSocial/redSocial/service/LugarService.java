package redSocial.redSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redSocial.redSocial.model.Lugar;
import redSocial.redSocial.repository.LugarRepository;

import java.util.List;

@Service
public class LugarService {

    @Autowired
    private LugarRepository lugarRepository;

    public List<Lugar> listarLugares(String busqueda) {
        if (busqueda != null && !busqueda.isBlank()) {
            return lugarRepository.findByNombreContainingIgnoreCase(busqueda);
        }
        return lugarRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Lugar buscarPorId(Long id) {
        return lugarRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró el lugar con ID: " + id));
    }


}
