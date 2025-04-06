package io.github.devopMarkz.backend.controllers;

import io.github.devopMarkz.backend.model.Usuario;
import io.github.devopMarkz.backend.repositories.UsuarioRepository;
import io.github.devopMarkz.backend.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> insertUsuario(@RequestBody Usuario usuario) {
        var novoUsuario = usuarioService.insertUsuario(usuario);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(novoUsuario.getId())
                        .toUri()
        ).build();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}
