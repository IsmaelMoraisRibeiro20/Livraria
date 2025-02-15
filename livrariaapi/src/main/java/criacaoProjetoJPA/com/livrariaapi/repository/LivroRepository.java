package criacaoProjetoJPA.com.livrariaapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID>{
	
	//Query method 
	
	//É uma convenção do spring data JPA utilizar o findBy 
	//qunado você quiser trazer os dados de alguma entidade 
	List<Livro> findByAutor(Autor autor);
	
	List<Livro> findByTitulo(String titulo);

}
