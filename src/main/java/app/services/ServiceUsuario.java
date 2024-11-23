package app.services;

import app.entities.Usuario;
import app.entities.dto.CadastrarUsuarioRequest;
import app.entities.dto.UsuarioResponse;
import app.repos.RepositorioUsuario;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServiceUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario cadastrarUsuario(CadastrarUsuarioRequest request) {
        Usuario u = new Usuario(request);
        return repositorioUsuario.save(u);
    }

    public UsuarioResponse buscarPorId(Long id) {

        Usuario response = repositorioUsuario.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return UsuarioResponse.fromEntity(response);
    }
}
