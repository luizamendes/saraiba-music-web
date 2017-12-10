package negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TGenero")
public class Genero {
	@Id
	@GeneratedValue
	private long id;
	public String nome;
	
	public Genero() {
		
		
	}
	
	public Genero(String nome) {
		
		this.nome = nome;
	}

	@Override
	public String toString() {
		
		return nome;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
