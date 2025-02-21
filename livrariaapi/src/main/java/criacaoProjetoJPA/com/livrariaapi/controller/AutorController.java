package criacaoProjetoJPA.com.livrariaapi.controller;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import criacaoProjetoJPA.com.livrariaapi.controller.dto.AutorDTO;
import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.service.AutorService;

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
                .path("/{id}")
                .buildAndExpand(autorEntidade.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
    
    
    @GetMapping("{id}")//agors tenha que fazer a ligação desse id com o id do parametro 
    public ResponseEntity<AutorDTO> obterDetalhes(@PathVariable("id") String id){
    	var idAutor = UUID.fromString(id);
    	Optional<Autor> autorOptinal = service.obterPorID(idAutor);
    	if(autorOptinal.isPresent()) {
    		Autor autor = autorOptinal.get();
    		AutorDTO dto = new AutorDTO(
    				autor.getId(), 
    				autor.getNome(), 
    				autor.getNacionalidade(),
    				autor.getDataNascimento());
    		return ResponseEntity.ok(dto);
    	}
    	return ResponseEntity.notFound().build();
    }
    
    
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id){
    	var IdAutor = UUID.fromString(id);
    	Optional<Autor> autorOptinal = service.obterPorID(IdAutor);
    	
    	if(autorOptinal.isEmpty()) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	service.deletar(autorOptinal.get());
    	
    	return ResponseEntity.noContent().build();
 
    }
    
    @GetMapping
    public ResponseEntity<List<AutorDTO>> pesquisar(
    		@RequestParam(value = "nome", required = false) String nome, 
    		@RequestParam(value = "nacionalidade", required  = false) String nacionalidade){
    		List<Autor> resultado = service.pesquisa(nome, nacionalidade);
    		List<AutorDTO> lista = resultado
    				.stream()
    				.map(autor -> new AutorDTO(
    						autor.getId(), 
    						autor.getNome(),
    						autor.getNacionalidade(), 
    						autor.getDataNascimento())).collect(Collectors.toList());
    		
    	return ResponseEntity.ok(lista); 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
