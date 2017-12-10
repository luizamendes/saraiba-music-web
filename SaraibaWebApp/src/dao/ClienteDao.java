package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import conexao.Conexao;
import negocio.Cliente;

public class ClienteDao {

	private static EntityManager conexao = null;
	private static EntityTransaction transacao = null;
	
	public static Cliente logar(String email, String senha) {
		
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Cliente as u where u.email = :pUser and u.senha = :pSenha");
		query.setParameter("pUser", email);
		query.setParameter("pSenha", senha);
		
		Cliente cliente;
	
		try {
			cliente = (Cliente)query.getSingleResult();
			return cliente;
		}
		catch(Exception ex) {
			return null;
		} 
			
	}
	
	public static void cadastrarCliente(Cliente cliente) {
				
		conexao = Conexao.obterConexao();
		
		transacao = conexao.getTransaction();
		
		transacao.begin();
		
		conexao.persist(cliente);
		
		transacao.commit();	
		
	}
	
	public static void alterarCadastro(Cliente cliente){
		
		conexao = Conexao.obterConexao();
		
		transacao = conexao.getTransaction();
		
		transacao.begin();
		
		conexao.merge(cliente);
		
		transacao.commit();			
	}
	
	public static void excluir(Cliente cliente){
	
		conexao = Conexao.obterConexao();
		
		transacao = conexao.getTransaction();
		
		Cliente client = conexao.find(Cliente.class, cliente.getId());
		
		transacao.begin();
		
		conexao.remove(client);
		
		transacao.commit();			
	}
	
	public static Cliente obterPorId(Long id){
		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Cliente as u where u.id = :pId");
		query.setParameter("pId", id);
			
		return (Cliente)query.getSingleResult();
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Cliente> obterClientes(){
		
		conexao = Conexao.obterConexao();
		
		return conexao.createQuery("select u from Cliente as u order by u.nome").getResultList();
	}
	
	public static Cliente obterPorEmail(String email){

		conexao = Conexao.obterConexao();
		
		Query query = conexao.createQuery("select u from Cliente as u where u.email = :pEmail");
		query.setParameter("pEmail", email);
			
		return (Cliente)query.getSingleResult();
	
	}
	

}
