package app.entities.dto;

public record CadastrarUsuarioRequest(
        String nome,
        String email,
        String password
) {
}
