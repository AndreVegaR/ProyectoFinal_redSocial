package redSocial.redSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redSocial.redSocial.model.Categoria;
import redSocial.redSocial.model.Lugar;
import redSocial.redSocial.repository.CategoriaRepository;
import redSocial.redSocial.repository.LugarRepository;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LugarRepository lugarRepository;

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public void guardarCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Long id, String nuevoNombre) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));

        categoria.setNombre(nuevoNombre);
        return categoriaRepository.save(categoria);
    }

    public void eliminarCategoria(Long id) {
        Categoria categoriaEliminar = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Categoria sinCategoria = categoriaRepository.findByNombreIgnoreCase("Sin categoría");
        if (sinCategoria == null) {
            throw new RuntimeException("No existe la categoría 'Sin categoría'");
        }

        if (categoriaEliminar.getId().equals(sinCategoria.getId())) {
            return;
        }

        List<Lugar> lugares = lugarRepository.findByCategoriaId(id);
        for (Lugar lugar : lugares) {
            lugar.setCategoria(sinCategoria);
        }
        lugarRepository.saveAll(lugares);

        categoriaRepository.delete(categoriaEliminar);
    }
}
