package criacaoProjetoJPA.com.livrariaapi.controller;


import criacaoProjetoJPA.com.livrariaapi.controller.dto.AutorDTO;
import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("autores")
public class AutorController {


    private final AutorService service;

    public AutorController(AutorService service){
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Void> salvarAutores(@RequestBody AutorDTO autor){
    //O response entity é uma class que representa uma reposta
        Autor autorEntidade = autor.mapearParaAutor();
        service.salvar(autorEntidade);

        //O componet builds ele vai criar a url.
        // E o fromCurrentRequest ele vai pegar os dados da requisição atual para contruir uma nova URL
        //O path é para dizer que vou pegar o id
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(autorEntidade.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
