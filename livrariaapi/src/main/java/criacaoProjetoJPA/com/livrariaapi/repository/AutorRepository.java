package criacaoProjetoJPA.com.livrariaapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
	
	List<Autor> findByNome(String nome);
	List<Autor> findByNacionalidade(String nacionalidade);
	List<Autor> findByNomeAndNacionalidade(String nome , String nacionalidade);
	
}
