package criacaoProjetoJPA.com.livrariaapi.teste;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import criacaoProjetoJPA.com.livrariaapi.repository.AutorRepository;

@SpringBootTest
class TransacoesTest {
	
	@Autowired
	AutorRepository autorRepository;
	
	/*
	 *Isso vai dizer que vai abriri uma transação no inicio da execução, 
	  e no final desse metodo ele vai fazer um commit ou um roolback 
	  Commit -> confimar as alterações
	  rollback -> desfazer as alterações 
	 * 
	 * */
	
	@Test
	@Transactional  
	void transacaoSimples() {
		//salvar um livro
		//salvar o autor 
		//alugar o livro
		//enviar um email pro locatario
		//notificar que o livro saiu da livraria 
		
	}
	
	
}
