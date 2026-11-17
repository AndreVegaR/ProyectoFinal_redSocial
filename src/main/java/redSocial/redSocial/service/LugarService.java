package redSocial.redSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
