package negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TCliente")
public class Cliente {
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String cpf;
	@OneToMany(targetEntity=Compra.class, mappedBy="cliente", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Compra> compras;

	public Cliente() {
		
		
	}
	
	public Cliente(String nome, String sobrenome, String email, String senha) {
		
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setEmail(email);
		this.setSenha(senha);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	
}
