package io.github.devopMarkz.backend.services;

import io.github.devopMarkz.backend.model.Usuario;
import io.github.devopMarkz.backend.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository ;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario insertUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
