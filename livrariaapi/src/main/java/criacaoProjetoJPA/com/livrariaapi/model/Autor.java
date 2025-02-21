package criacaoProjetoJPA.com.livrariaapi.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class Autor {
	
	@Id
	@Column(name = "id_autor")
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "nome", length = 100, nullable = false )//nesse parametro passo o nome, quantidade de caracteres permitido e digo que nao pode ficar null
	private String nome;
	
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(name = "nacionalidade", length = 100, nullable = false )
	private String nacionalidade;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)//Aqui é um autor para muitos livros, como ele nao faz parte da tabela, eu tenho qeu colocar (mappedBy = "autor")
	private List<Livro> livros;//aqui é seu quiser pegar os livros que é do autor
	
	@CreatedDate //Com essa anotação eu nao precisar em me preocupar em ficar colocando data, ele automaticamente coloca 
	@Column(name = "data_cadastro")
	private LocalDateTime dataCadastro; //LocalDateTime guarda a data e a hora 
	
	@LastModifiedDate//Ele atualiza a data sozinho
	@Column(name = "data_atualizacao")
	private LocalDateTime dataAtualizacao;
	
	@Column(name = "id_usuario")
	private UUID usuario;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String name) {
		this.nome = name;
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
		return "Autor [id=" + id + ", name=" + nome + ", dataNascimento=" + dataNascimento + ", nacionalidade="
				+ nacionalidade + ", livros=" + livros + "]";
	}
	
	
	
}
