package criacaoProjetoJPA.com.livrariaapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import criacaoProjetoJPA.com.livrariaapi.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, UUID>{

}
