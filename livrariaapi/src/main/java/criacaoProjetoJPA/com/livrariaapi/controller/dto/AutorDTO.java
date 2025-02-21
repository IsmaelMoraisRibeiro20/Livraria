package criacaoProjetoJPA.com.livrariaapi.controller.dto;

import java.time.LocalDate;
import java.util.UUID;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;

public record AutorDTO(
		UUID id,
        String nome,
        String nacionalidade,
        LocalDate dataNascimento) 
{

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);

        return autor;
    }
}
