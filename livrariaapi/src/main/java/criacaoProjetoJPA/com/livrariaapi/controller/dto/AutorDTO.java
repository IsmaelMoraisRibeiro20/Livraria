package criacaoProjetoJPA.com.livrariaapi.controller.dto;

import criacaoProjetoJPA.com.livrariaapi.model.Autor;

import java.time.LocalDate;

public record AutorDTO(
        String nome,
        String nacionalidade,
        LocalDate dataNascimento) {

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setName(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);

        return autor;
    }
}
