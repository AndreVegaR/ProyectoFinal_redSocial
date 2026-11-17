package redSocial.redSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redSocial.redSocial.model.Categoria;
import redSocial.redSocial.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas(){
        return categoriaRepository.findAll();
    }
}
