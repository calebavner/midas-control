package app.entities.dto;

import app.entities.Usuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        String password
) {

    public static UsuarioResponse fromEntity(Usuario u) {
        return new UsuarioResponse(
            u.getId(),
            u.getNome(),
            u.getEmail(),
            u.getPassword()
        );
    }
}
