package redSocial.redSocial.config;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

/*Esta clase se encarga de que si el usuario escribe urls raras, lo redirija para que no le aparezca la pantalla de error.*/

/*
Esto es nuevo, @ControllerAdvice es una anotación de Spring que funciona como un manejador global de excepciones para todos los controladores (@Controller) al mismo tiempo.
En palabras simples, cuando salga una excepción en un controlador va a caer aquí.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoResourceFoundException.class, HttpRequestMethodNotSupportedException.class})
    public String manejarRutaInexistente(HttpSession session) {
        // Si no tiene sesión iniciada, lo regresa al login sin importar qué URL escribió
        if (session == null || (session.getAttribute("admin_id") == null && session.getAttribute("usuario_id") == null)) {
            return "redirect:/admin/inicio-sesion";
        }

        // Si ya había iniciado sesión y escribió una url que no existe, lo regresa a su feed
        if (session.getAttribute("admin_id") != null) {
            return "redirect:/feed-admin";
        }
        return "redirect:/Feed-principal-usuario";
    }
}