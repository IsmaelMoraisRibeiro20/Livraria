package criacaoProjetoJPA.com.livrariaapi.teste;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import criacaoProjetoJPA.com.livrariaapi.model.GeneroLivro;
import criacaoProjetoJPA.com.livrariaapi.repository.AutorRepository;
import criacaoProjetoJPA.com.livrariaapi.repository.LivroRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTeste {
	
	@Autowired
	LivroRepository livroRepository;
	
	@Autowired
	AutorRepository autorRepository;

	@Test
	void salvarSemCascade() {
		Livro livro = new Livro();
		livro.setIsbn("2258-9999");
		livro.setPreco(100.50);
		livro.setGenero(GeneroLivro.FICCAO);
		livro.setTitulo("Branca de neve");
		livro.setDataPublicacao(LocalDate.of(1980, 1 , 2));
		
		//Referenciar meu autor na minha tabela Livro 
		//Para saber se autor ja foi criado eu vou injetar o autor repository 
		Autor autor = autorRepository
				.findById(UUID.fromString("4537e189-61c4-4bd8-b804-d55bffca7ae9"))
				.orElse(null);
		
		livro.setAutor(autor);

		livroRepository.save(livro);
		
	}
	@Test
	void salvarCascadeTest() {
		Livro livro = new Livro();
		livro.setIsbn("2258-9999");
		livro.setPreco(100.50);
		livro.setGenero(GeneroLivro.ROMANCE);
		livro.setTitulo("Branca de neve");
		livro.setDataPublicacao(LocalDate.of(1980, 1 , 2));
		
		Autor autor = new Autor();
		autor.setNome("Judas");
		autor.setDataNascimento(LocalDate.of(1589, 01, 31));
		autor.setNacionalidade("brasileiro");
		
		livro.setAutor(autor);

		livroRepository.save(livro);
		
	}
	

	@Test
	void atualizarAutorDoLivro() {
		var livroParaAtualizar = livroRepository.findById(UUID.fromString("7bd98081-2e8b-470f-9055-28b4bec073a1")).orElse(null);
		
		
		UUID idAutor = UUID.fromString(("4537e189-61c4-4bd8-b804-d55bffca7ae9"));
		Autor ismael = autorRepository.findById(idAutor).orElse(null);
		
		livroParaAtualizar.setAutor(ismael);
		
		livroRepository.save(livroParaAtualizar);
		
	}
	

	@Test
	void deletar() {
		UUID id = UUID.fromString("7bd98081-2e8b-470f-9055-28b4bec073a1");
		
		livroRepository.deleteById(id);
	}
	

	@Test
	void buscarLivro() {
		UUID id = UUID.fromString("4d15f866-91c0-4e9c-9c55-57f7fbb47951");
		Livro livro = livroRepository.findById(id).orElse(null);
		
		System.out.println("Livro");
		System.out.println(livro.getTitulo());
		System.out.println("Autor:");
		System.out.println(livro.getAutor().getNome());
	}
	
	
	//Pesquisa por titulo

	@Test
	void pesquisaPorTituloTest() {
		List<Livro> lista = livroRepository.findByTitulo("O rouba da casa assombrada");
		
		for(int i =0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getTitulo());
		}
	}
	
	@Test
	void listarLivros() {
		var resultado = livroRepository.listarLivros();
		for(int i = 0; i < resultado.size(); i++) {
			System.out.println(resultado.get(i).getTitulo());
		}
			
	}
	
	@Test
	void listarAutoresDosLivros() {
		var resultado = livroRepository.listarAutoresDoLivro();
		for(int i = 0; i < resultado.size(); i++) {
			System.out.println(resultado.get(i).getNome());
		}
			
	}
	
	@Test
	void listarGenerosDeAutoresBrasileiros() {
		var resultado = livroRepository.listarGenerosAutoresBrasileiros();
		resultado.forEach(System.out::println);
			
	}
	
	@Test
	void listarPorGeneroQueryParamTest() {
		var resultado = livroRepository.findByGenero(GeneroLivro.FICCAO, "preco");
		for(int i =0; i < resultado.size(); i++) {
			System.out.println(resultado.get(i).getGenero() + " " + resultado.get(i).getPreco());
		};
			
	}
	
	@Test
	void listarPorGeneroQueryPositionalParametro() {
		var resultado = livroRepository.findByGeneroPositionalParameters(GeneroLivro.FICCAO);
		for(int i =0; i < resultado.size(); i++) {
			System.out.println(resultado.get(i).getGenero()+ " " + resultado.get(i).getPreco());
		};
			
	}
	
	@Test 
	void deletePorGenero() {
		livroRepository.deleteByGenero(GeneroLivro.FICCAO);
		
	}
	
	
	@Test
	void updateGeneroDoLivroTest() {
		livroRepository.updateGenero(GeneroLivro.ROMANCE);
	}
	
	

}
