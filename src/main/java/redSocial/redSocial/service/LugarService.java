package redSocial.redSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import redSocial.redSocial.adapters.LugarAdapter;
import redSocial.redSocial.dtos.LugarDTO;
import redSocial.redSocial.model.Lugar;
import redSocial.redSocial.repository.LugarRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

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

    @Transactional
    public Long registrarLugar(LugarDTO lugardto, MultipartFile imagen) throws IOException {
        String nombreArchivo = null;

        if (imagen != null && !imagen.isEmpty()) {
            nombreArchivo = guardarArchivoEnCarpeta(imagen);
            lugardto.setImagenUrl(nombreArchivo);
        }

        Lugar lugar = LugarAdapter.toEntity(lugardto, nombreArchivo);
        Lugar lugarGuardado = lugarRepository.save(lugar);

        return lugarGuardado.getId();
    }

    @Transactional
    public Long actualizarLugar(Long id, LugarDTO lugardto, MultipartFile imagen) throws IOException {
        Lugar existente = buscarPorId(id);

        // Por defecto conservamos la imagen que ya tenía
        String nombreArchivo = existente.getImagenUrl();

        // Si subieron una nueva, la guardamos y borramos la anterior
        if (imagen != null && !imagen.isEmpty()) {
            eliminarArchivo(existente.getImagenUrl());
            nombreArchivo = guardarArchivoEnCarpeta(imagen);
        }

        lugardto.setImagenUrl(nombreArchivo);

        Lugar actualizado = LugarAdapter.toEntity(lugardto, nombreArchivo);
        actualizado.setId(existente.getId());   // con id existente, save() hace UPDATE

        return lugarRepository.save(actualizado).getId();
    }

    private void eliminarArchivo(String nombreArchivo) throws IOException {
        if (nombreArchivo != null && !nombreArchivo.isBlank()) {
            Files.deleteIfExists(Paths.get("src/main/resources/recursos/imgs/").resolve(nombreArchivo));
        }
    }

    private String guardarArchivoEnCarpeta(MultipartFile imagen) throws IOException {
        String carpetaDestino = "src/main/resources/recursos/imgs/";
        Path rutaCarpeta = Paths.get(carpetaDestino);

        if (!Files.exists(rutaCarpeta)) {
            Files.createDirectories(rutaCarpeta);
        }

        String nombreArchivo = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
        Path rutaArchivo = rutaCarpeta.resolve(nombreArchivo);
        Files.copy(imagen.getInputStream(), rutaArchivo, StandardCopyOption.REPLACE_EXISTING);

        return nombreArchivo;
    }
}