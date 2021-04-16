package br.com.bandtec.isabellac2.controle;
import br.com.bandtec.isabellac2.dominio.Lutadores;
import br.com.bandtec.isabellac2.repositorio.LutadoresRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadoresController {


    @Autowired
    private LutadoresRepositorio repositorio;
    List<Lutadores> lutadores;

    @PostMapping
    public ResponseEntity postLutadores(@RequestBody @Valid Lutadores novoLutador) {
        repositorio.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutadores() {
        lutadores = repositorio.findAll();
        if (lutadores.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(lutadores);
    }
    
}

