package app.controller;

import app.entities.Usuario;
import app.entities.dto.CadastrarUsuarioRequest;
import app.entities.dto.UsuarioResponse;
import app.services.ServiceUsuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    private final ServiceUsuario serviceUsuario;

    public ControllerUsuario(ServiceUsuario serviceUsuario) {
        this.serviceUsuario = serviceUsuario;
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody CadastrarUsuarioRequest request, UriComponentsBuilder uriBuilder) {

        Usuario usuario = serviceUsuario.cadastrarUsuario(request);
        URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceUsuario.buscarPorId(id));
    }
}
