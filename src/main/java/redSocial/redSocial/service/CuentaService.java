package redSocial.redSocial.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import redSocial.redSocial.adapters.AdministradorAdapter;
import redSocial.redSocial.bos.AdministradorBO;
import redSocial.redSocial.dtos.AdministradorDTO;
import redSocial.redSocial.model.Administrador;
import redSocial.redSocial.repository.AdministradorRepository;

import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AdministradorDTO autentificarCuenta(String correo, String contrasenia){

        Optional<Administrador> administrador = administradorRepository.findAdministradorByCorreo(correo);

        if(administrador.isPresent()){

            // para trabajar con el bo
            AdministradorBO adminBO = AdministradorAdapter.entity_a_bo(administrador.get());

            // ahora sí matchear
            if(passwordEncoder.matches(contrasenia, adminBO.getContrasenia())){

                // pa que se envíe pa arriba xddd lolol
                return AdministradorAdapter.bo_a_dto(adminBO);
            }
        }
        return null;
    }
}
