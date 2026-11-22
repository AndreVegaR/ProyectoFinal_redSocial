package redSocial.redSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redSocial.redSocial.model.Estado;
import redSocial.redSocial.model.Resena;
import redSocial.redSocial.repository.ResenaRepository;

@Service
public class ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    public void moderarResena(Long id, String justificacion) {
        Resena resena = resenaRepository.findById(id).orElse(null);
        if (resena != null) {
            resena.setEstado(Estado.INACTIVO);
            resenaRepository.save(resena);
        }
    }
}
