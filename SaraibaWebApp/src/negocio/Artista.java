package negocio;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TArtista")
public class Artista {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="idGenero")
	private Genero genero;
	
	public Artista() {
		
		
	}
	
	public Artista(String nome, Genero genero) {
		this.setNome(nome);
		this.setGenero(genero);
	}

	public Artista(String nome) {
		this.setNome(nome);
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}

	public String exibir() {
		
		return "Artista: " + this.getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	
}
