package redSocial.redSocial.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuración de Spring Security.
 * Sólo la usamos para cifrar contraseñas con BCrypt. Por eso dejamos pasar todas las
 * peticiones: el control de acceso a las rutas lo haremos nosotros mismos.
 */
@Configuration
@EnableWebMvc // CONFIGURACIÓN DE SPRING MVC
public class SecurityConfig {

    /**
     * Cada petición http entra por aquí antes de entrar al controlador.
     * Desactiva la lógica por defecto de spring para que podamos manejarla
     * a nuestro antojo con nuestras propias reglas.
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(
                        frameOptions -> frameOptions.disable()))
                // Ninguna ruta pide login aquí; sin esto Spring mostraría su propia pantalla de login
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                );
        return http.build();
    }

    // Objeto que cifra (encode) y compara (matches) contraseñas con BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
