package criacaoProjetoJPA.com.livrariaapi.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.repository.AutorRepository;

@Service
public class AutorService {

    private final AutorRepository autorRepository;


    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public Autor salvar(Autor autor){
        return autorRepository.save(autor);
    }
    
    public Optional<Autor> obterPorID(UUID id){
    	return autorRepository.findById(id);
    }
    
    public void deletar(Autor autor) {
    	autorRepository.delete(autor);
    }
    
    public List<Autor> pesquisa(String nome, String nacionalidade){
    	if(nome != null && nacionalidade != null) {
    		return autorRepository.findByNomeAndNacionalidade(nome, nacionalidade);
    	}
    	
    	if(nome != null) {
    		return autorRepository.findByNome(nome);
    	}else if(nacionalidade != null){
    		return autorRepository.findByNacionalidade(nacionalidade);
    	}
    	
    	return autorRepository.findAll();
    }
}
