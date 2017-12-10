package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import conexao.Conexao;
import negocio.Artista;
import negocio.Genero;

public class ArtistaDao {

	private static EntityManager conexao = null;
	private static EntityTransaction transacao = null;
	
	private static char[] caracteres;
	
	public static char[] obterCaracteres() {
		
		caracteres = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
				'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'W', 'Z',
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

		return caracteres;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<Artista> obterArtistasLetra(char primeiraLetra) {
	
		conexao = Conexao.obterConexao();

		Query query = conexao.createQuery("select u from Artista as u where u.nome like :pInicial");
		
		query.setParameter("pInicial", primeiraLetra+"%");
		
		return query.getResultList();
	}
	
	//FUNCIONANDO
	@SuppressWarnings("unchecked")
	public static List<Artista> obterArtistasGenero(Genero genero) {
		
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Artista as u where u.genero = :pGenero");
		query.setParameter("pGenero", genero);
			
		return query.getResultList();
	}
	
	public static Artista obterArtistaPorId(long idArtista) {
		
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Artista as u where u.id = :pIdArtista");
		query.setParameter("pIdArtista", idArtista);
		try {
			return (Artista)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}	
	}
		
	
}
