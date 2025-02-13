package criacaoProjetoJPA.com.livrariaapi.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "autor", schema = "public")
@Getter
@Setter
@Data
public class Autor {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "nome", length = 100, nullable = false )//nesse parametro passo o nome, quantidade de caracteres permitido e digo que nao pode ficar null
	private String name;
	
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name = "nacionalidade", length = 100, nullable = false )
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor")//Aqui é um autor para muitos livros, como ele nao faz parte da tabela, eu tenho qeu colocar (mappedBy = "autor")
	private List<Livro> livros;//aqui é seu quiser pegar os livros que é do autor

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", name=" + name + ", dataNascimento=" + dataNascimento + ", nacionalidade="
				+ nacionalidade + ", livros=" + livros + "]";
	}
	
	
	
}
