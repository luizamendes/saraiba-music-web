package dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import conexao.Conexao;
import negocio.Artista;
import negocio.Musica;

public class MusicaDao {

	private static EntityManager conexao = null;
	private static EntityTransaction transacao = null;

	@SuppressWarnings("unchecked")
	public static List<Musica> obterMusicas(){
		
		conexao = Conexao.obterConexao();
		
		return conexao.createQuery("select u from Musica as u order by u.nome").getResultList();	
	}
	
	//FUNCIONANDO
	@SuppressWarnings("unchecked")
	public static List<Musica> obterPorNome(String nome) {
			
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Musica as u where u.nome LIKE :pNome");
		query.setParameter("pNome", "%"+nome+"%");

		return query.getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public static List<Musica> obterPorArtista(Artista artista){
		
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Musica as u where u.artista = :pArtista");
		query.setParameter("pArtista", artista);
			
		return query.getResultList();
		
	}
	
	//FUNCIONANDO
	public static Musica obterPorId(long idMusica) {
		
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Musica as u where u.id = :pIdMusica");
		query.setParameter("pIdMusica", idMusica);
			
		try {
			return (Musica)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}	
		
	}
	
	//FUNCIONANDO
	@SuppressWarnings("unchecked")
	public static List<Musica> obterLancamentos(){
		
		conexao = Conexao.obterConexao();

		LocalDate date =  LocalDate.now();
		Query query = conexao.createQuery("SELECT u FROM Musica as u WHERE lancamento BETWEEN :start AND :end", Musica.class);
		query.setParameter("start", date.minusDays(15));
		query.setParameter("end", date);
	
		return query.getResultList();

	}
}
