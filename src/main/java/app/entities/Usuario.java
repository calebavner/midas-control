package app.entities;

import app.entities.dto.CadastrarUsuarioRequest;
import app.services.CryptoService;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String encryptPassword;

    @Transient
    private String password;

    public Usuario(CadastrarUsuarioRequest request) {
        this.nome = request.nome();
        this.email = request.email();
        this.password = request.password();
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @PrePersist
    public void prePersist() {
        this.encryptPassword = CryptoService.encrypt(password);
    }

    @PostLoad
    public void postLoad() {
        this.password = CryptoService.decrypt(encryptPassword);
    }
}
