package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import conexao.Conexao;
import negocio.Genero;

public class GeneroDao {

	private static EntityManager conexao = null;
	private static EntityTransaction transacao = null;

	//FUNCIONANDO
	@SuppressWarnings("unchecked")
	public static List<Genero> obterGeneros(){
		
		conexao = Conexao.obterConexao();
		
		return conexao.createQuery("select u from Genero as u order by u.nome").getResultList();	
	}
	
	//FUNCIONANDO
	public static Genero obterPorId(long idGenero) {
		
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Genero as u where u.id = :pIdGenero");
		query.setParameter("pIdGenero", idGenero);
			
		return (Genero)query.getSingleResult();
		
	}
}
