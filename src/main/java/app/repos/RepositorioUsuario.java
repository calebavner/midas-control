package app.repos;

import app.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
}
