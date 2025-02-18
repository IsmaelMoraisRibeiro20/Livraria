package criacaoProjetoJPA.com.livrariaapi.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.model.GeneroLivro;
import criacaoProjetoJPA.com.livrariaapi.model.Livro;
import jakarta.transaction.Transactional;

public interface LivroRepository extends JpaRepository<Livro, UUID>{
	
	//Query method 
	
	//É uma convenção do spring data JPA utilizar o findBy 
	//qunado você quiser trazer os dados de alguma entidade 
	List<Livro> findByAutor(Autor autor);
	
	List<Livro> findByTitulo(String titulo);
	
	//consgo fazer a pesquisa tanto pelo o titulo quanto pelo o preco
	List<Livro> findByTituloAndPreco(String titulo, float preco);
	
	
	//Começar trabalhar com query
	
	
	// JPQL -> referencia as entidades e as propriedades 
	@Query(" select l from Livro as l order by l.titulo, l.preco ")
	List<Livro> listarLivros();
	
	
	
	@Query(" select a from Livro l join l.autor a ")
	List<Autor> listarAutoresDoLivro();
	
	
	
	@Query("""
			select l.genero
			from Livro l
			join l.autor a
			where a.nacionalidade = 'brasileiro'
			order by l.genero	
	""")
	List<String> listarGenerosAutoresBrasileiros();

	
	
	// named parameters -> parametros nomeados, ou seja ela vai jogar o valor  pelo o nome do parametro 
	@Query(" select l from Livro l where l.genero = :genero order by :paramOrdenacao")
	List<Livro> findByGenero(@Param("genero") GeneroLivro generoLivro, @Param("paramOrdenacao") String nomePropriedade);
	
	
	// positional parameters
	@Query(" select l from Livro l where l.genero = ?1")
	List<Livro> findByGeneroPositionalParameters(GeneroLivro generoLivro);
	
	
	
	//Query para deletar 
	@Modifying
	@Transactional
	@Query(" delete from Livro where genero = ?1")
	void deleteByGenero(GeneroLivro genero);
	
	
	//Qury para atualizar
	@Modifying
	@Transactional
	@Query(" update Livro set genero = ?1 ")
	void updateGenero(GeneroLivro genero);
	
	
	
	
	
	
	
	
	
	
	
	
}
