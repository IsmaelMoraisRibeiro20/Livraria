package criacaoProjetoJPA.com.livrariaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import criacaoProjetoJPA.com.livrariaapi.repository.AutorRepository;
import criacaoProjetoJPA.com.livrariaapi.repository.LivroRepository;

@Service
public class TransacaoService {

	@Autowired
	private AutorRepository autorRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	
}
