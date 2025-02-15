 package criacaoProjetoJPA.com.livrariaapi.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "livro")
@Data
public class Livro {
	
	

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "isbn", nullable = false, length = 20)
	private String isbn;
	
	@Column(name = "titulo", nullable = false, length = 150)
	private String titulo;
	
	@Column(name = "data_publicacao", nullable = false)
	private LocalDate dataPublicacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "genero", length = 30, nullable = false)
	private GeneroLivro genero;
	
	@Column(name = "preco", precision = 12)//porque aundo eu fiz minha tabela eu disse que vai ter 18 caracteres e 2 decimais
	private Double preco;
	
	@ManyToOne//(cascade = CascadeType.ALL) //To dizendo que vai ter muitos livros para um autor
	@JoinColumn(name = "id_autor") //fazendo o relaciando das minhas tabelas
	private Autor autor;
	
	
	
	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}



	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}



	public GeneroLivro getGenero() {
		return genero;
	}



	public void setGenero(GeneroLivro genero) {
		this.genero = genero;
	}



	public Double getPreco() {
		return preco;
	}



	public void setPreco(Double preco) {
		this.preco = preco;
	}



	public Autor getAutor() {
		return autor;
	}



	public void setAutor(Autor autor) {
		this.autor = autor;
	}



	@Override
	public String toString() {
		return "Livro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", dataPublicacao=" + dataPublicacao
				+ ", genero=" + genero + ", preco=" + preco + ", autor=" + autor + "]";
	}
	

}
