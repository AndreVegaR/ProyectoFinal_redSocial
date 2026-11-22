package redSocial.redSocial.adapters;

import redSocial.redSocial.dtos.LugarDTO;
import redSocial.redSocial.model.Categoria;
import redSocial.redSocial.model.Direccion;
import redSocial.redSocial.model.Estado;
import redSocial.redSocial.model.Lugar;

public class LugarAdapter {


    /**
     * Convierte de DTO (formulario) a Entidad Lugar.
     * Recibe la Categoria ya consultada desde la BD y el nombre/ruta de la imagen guardada.
     */
    public static Lugar toEntity(LugarDTO dto, String imagenUrl) {
        if (dto == null) {
            return null;
        }

        Direccion direccion = new Direccion();
        direccion.setCalle(dto.getCalle());
        direccion.setNumero(dto.getNumero());
        direccion.setColonia(dto.getColonia());
        direccion.setLatitud(limpiarTextoOpcional(dto.getLatitud()));
        direccion.setLongitud(limpiarTextoOpcional(dto.getLongitud()));

        Lugar lugar = new Lugar();
        lugar.setNombre(dto.getNombre());
        lugar.setDescripcion(dto.getDescripcion());
        lugar.setCategoria(dto.getCategoria());
        lugar.setDireccion(direccion);
        lugar.setImagenUrl(imagenUrl);
        lugar.setEstado(Estado.ACTIVO);
        lugar.setCalificacionPromedio(0.0);

        return lugar;
    }

    /**
     * Convierte de Entidad Lugar a DTO (útil por ejemplo al cargar un formulario de edición).
     */
    public static LugarDTO toDTO(Lugar entity) {
        if (entity == null) {
            return null;
        }

        LugarDTO dto = new LugarDTO();
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());

        if (entity.getCategoria() != null) {
            dto.setCategoria(entity.getCategoria());
        }

        if (entity.getDireccion() != null) {
            dto.setCalle(entity.getDireccion().getCalle());
            dto.setNumero(entity.getDireccion().getNumero());
            dto.setColonia(entity.getDireccion().getColonia());
            dto.setLatitud(entity.getDireccion().getLatitud());
            dto.setLongitud(entity.getDireccion().getLongitud());
        }

        return dto;
    }

    /**
     * Convierte cadenas vacías "" a null para evitar que fallen las anotaciones @Pattern
     * de latitud y longitud en Direccion cuando el usuario los deja en blanco.
     */
    private static String limpiarTextoOpcional(String valor) {
        return (valor == null || valor.trim().isEmpty()) ? null : valor.trim();
    }
}
