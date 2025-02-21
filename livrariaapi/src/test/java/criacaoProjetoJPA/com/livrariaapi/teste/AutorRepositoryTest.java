package criacaoProjetoJPA.com.livrariaapi.teste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.model.GeneroLivro;
import criacaoProjetoJPA.com.livrariaapi.model.Livro;
import criacaoProjetoJPA.com.livrariaapi.repository.AutorRepository;
import criacaoProjetoJPA.com.livrariaapi.repository.LivroRepository;

@SpringBootTest
class AutorRepositoryTest {
	
	@Autowired
	AutorRepository  autorR;
	
	@Autowired
	LivroRepository repositoryLivro;
	
	
	@Test
	public void salvarTest( ) {
		Autor autor = new Autor();
		autor.setNome("Branca de neve");
		autor.setDataNascimento(LocalDate.of(1950, 01, 31));
		autor.setNacionalidade("brasileiro");
		
		var autorSalvo = autorR.save(autor);
		
		System.out.println("Autor salvo " + autorSalvo.toString());
		
	}
	
	@Test
	public void atualizarTest() {
		var id = UUID.fromString("4537e189-61c4-4bd8-b804-d55bffca7ae9");
		
		Optional<Autor> possivelAutor = autorR.findById(id);
		
		if(possivelAutor.isPresent()) {
			 Autor autorEncontrado = possivelAutor.get();
			 System.out.println("Dados do Autor");
			 //System.out.println(autorEncontrado);
		
			 autorEncontrado.setDataNascimento(LocalDate.of(2003, 10, 20));
			 autorEncontrado.setNome("Ismael");
			 
			 autorR.save(autorEncontrado);
		
		}
		
	}
	
	@Test
	void salvarAutorComLivrosTest() {
		Autor autor = new Autor();
		autor.setNome("Mateus");
		autor.setDataNascimento(LocalDate.of(2000, 05, 18));
		autor.setNacionalidade("Americano");
		
		Livro livro = new Livro();
		livro.setIsbn("2258-7899");
		livro.setPreco(489.50);
		livro.setGenero(GeneroLivro.FICCAO);
		livro.setTitulo("O rouba da casa assombrada");
		livro.setDataPublicacao(LocalDate.of(2015, 01 , 02));
		livro.setAutor(autor);
		
		Livro livro2 = new Livro();
		livro2.setIsbn("7456-7899");
		livro2.setPreco(500.50);
		livro2.setGenero(GeneroLivro.MISTERIO);
		livro2.setTitulo("Venus");
		livro2.setDataPublicacao(LocalDate.of(2022, 01 , 02));
		livro2.setAutor(autor);
		
		autor.setLivros(new ArrayList<>());
		autor.getLivros().add(livro);
		autor.getLivros().add(livro2);
		
		autorR.save(autor);
		repositoryLivro.saveAll(autor.getLivros());
		
	}
	
	@Test
	void listarLivrosAutor() {
		var id = UUID.fromString("92d2c4fe-4504-482d-aff3-1e832f359215");
		var autor = autorR.findById(id).get();
		
		//Buscar os livros do autor 
		
		List<Livro> livrosLita = repositoryLivro.findByAutor(autor);
		autor.setLivros(livrosLita);
		
		autor.getLivros().forEach(System.out::println);
		
		
	}
	

	/*
	@Test
	public void listarTest() {
		List<Autor> lista = autorR.findAll();
		lista.forEach(System.out::println);
	}
	
	@Test
	public void countTest() {
		System.out.println("Contagem de autores " + autorR.count());
	}
	
	
	@Test
	public void deletePorIDTest() {
		var id = UUID.fromString("71d3cd33-53fb-44cb-9773-1caa077acbf7");
		autorR.deleteById(id);
	}

	@Test
	public void deleteTest() {
		var id = UUID.fromString("71d3cd33-53fb-44cb-9773-1caa077acbf7");
		
		Optional<Autor> autorPresente = autorR.findById(id);
		
		if(autorPresente.isPresent()) {
			Autor deleteAutor = autorPresente.get();
			autorR.delete(deleteAutor);
		}
		
	}*/
	
}
