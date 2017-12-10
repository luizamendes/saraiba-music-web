package testes;

import dao.MusicaDao;
import negocio.Musica;

public class TestaDao {

	public static void main(String[] args) {
		

		for(Musica m : MusicaDao.obterPorNome("Paranoid")) {
			
			System.out.println(m.getNome());
		}

		
		
	}
	
	
	
}
	
	
