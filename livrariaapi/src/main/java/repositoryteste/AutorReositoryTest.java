package repositoryteste;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;
import criacaoProjetoJPA.com.livrariaapi.repository.AutorRepository;


public class AutorReositoryTest {
	
	@Autowired
	AutorRepository  autorR;
	
	
	@Test
	public void salvarTest( ) {
		Autor autor = new Autor();
		autor.setName("Branca de neve");
		autor.setDataNascimento(LocalDate.of(1950, 01, 31));
		autor.setNacionalidade("brasileiro");
		
		var autorSalvo =autorR.save(autor);
		
		System.out.println("Autor salvo " + autorSalvo.toString());
		
	}

}
