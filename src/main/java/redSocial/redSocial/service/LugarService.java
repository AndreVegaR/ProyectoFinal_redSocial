package redSocial.redSocial.service;

import org.apache.coyote.Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import redSocial.redSocial.adapters.AdministradorAdapter;
import redSocial.redSocial.dtos.LugarDTO;
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

    public Lugar registrarLugar(@RequestBody LugarDTO lugardto){
        if(lugardto != null){
            //lugarRepository.save()
        }
        return null;
    }

}
