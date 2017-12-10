package negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TMusica")
public class Musica {
	
	@Id
	@GeneratedValue
	private long id;
	private String nome;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="idArtista")
	private Artista artista;
	private LocalDate lancamento;
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="idAlbum")
	private Album album;
	private double preco;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "compra")
	private List<Compra> compras;

	public Musica() {
		
		
	}
	
	public Musica(String nome, Artista artista, long id) {
		
		this.setNome(nome);
		this.setArtista(artista);
		this.setId(id);

	}
	
	public Musica(String nome, Artista artista, LocalDate lancamento, Album album) {
		
		this.setNome(nome);
		this.setArtista(artista);
		this.setLancamento(lancamento);
		this.setAlbum(album);

	}
	
	@Override
	public String toString() {
		
		return "Música: " + this.getNome() + " - Artista: " + this.getArtista().getNome();
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

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public LocalDate getLancamento() {
		
		return lancamento;
	}
	
	public String lancamentoToString() {

		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return lancamento.format(formatador);
		
	}

	public void setLancamento(LocalDate lancamento) {
		this.lancamento = lancamento;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
		
	
}
