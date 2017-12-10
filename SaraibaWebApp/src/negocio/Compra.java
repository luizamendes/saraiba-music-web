package negocio;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TCompra")
public class Compra {
	@Id
	@GeneratedValue
	@Column(name="idCompra", nullable=true)
	private long id;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "TMusicaXCompra", joinColumns = @JoinColumn(name = "idCompra") , inverseJoinColumns = @JoinColumn(name = "idMusica") )
	private List<Musica> compra;
	@ManyToOne
	@JoinColumn(name="idCliente")
	private Cliente cliente;
	private double precoTotal;

	public List<Musica> getCompra() {
		return compra;
	}

	public void setCompra(List<Musica> compra) {
		this.compra = compra;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}


	
}
