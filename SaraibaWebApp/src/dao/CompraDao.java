package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.Conexao;
import negocio.Compra;

public class CompraDao {

	private static EntityManager conexao = null;
	private static EntityTransaction transacao = null;
	
	public static void salvarCompra(Compra compra) {
		
		conexao = Conexao.obterConexao();
		
		transacao = conexao.getTransaction();
		
		transacao.begin();
		
		conexao.persist(compra);
		
		transacao.commit();	
			
	}
	
}
