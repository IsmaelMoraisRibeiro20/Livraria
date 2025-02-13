package criacaoProjetoJPA.com.livrariaapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, UUID> {

}
