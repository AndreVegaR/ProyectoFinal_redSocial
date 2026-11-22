package redSocial.redSocial.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**") //esto intercepta todas las rutas
                .excludePathPatterns(
                        "/",
                        "/admin/inicio-sesion",
                        "/inicio-sesion",
                        "/registro",
                        "/styles/**",
                        "/recursos/**",
                        "/uploads/**",
                        "/error"
                );
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Path uploadDir = Paths.get("src/main/resources/static/uploads");
        String uploadPath = uploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadPath + "/");
        registry.addResourceHandler("/styles/**")
                .addResourceLocations("classpath:/styles/");
        Path imgsDir = Paths.get("src/main/resources/recursos/imgs").toAbsolutePath();

        registry.addResourceHandler("/recursos/imgs/**")
                .addResourceLocations(imgsDir.toUri().toString(), "classpath:/recursos/imgs/");
        registry.addResourceHandler("/recursos/**")
                .addResourceLocations("classpath:/recursos/");
    }
}