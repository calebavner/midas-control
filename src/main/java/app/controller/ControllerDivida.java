package app.controller;

import app.domain.Divida;
import app.domain.DividaFactory;
import app.domain.NovoRegistro;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/dividas")
public class ControllerDivida {

    @PostMapping
    public ResponseEntity<Divida> novoRegistro(@RequestBody NovoRegistro novoRegistro) {
        Divida a = DividaFactory.gerarDivida(novoRegistro);
        return ResponseEntity.status(HttpStatus.CREATED).body(a);
    }
}
