package dao;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.Conexao;
import negocio.Album;
import negocio.Artista;
import negocio.Genero;
import negocio.Musica;

public class InicializadorDao {

	private static EntityManager conexao = null;
	private static EntityTransaction transacao = null;

	public static void incluirMusicas(){
		conexao = Conexao.obterConexao();
		
		transacao = conexao.getTransaction();
		
		Genero g1 = new Genero("Heavy Metal");
		Genero g2 = new Genero("Hard Rock");
		Genero g3 = new Genero("Grunge");
		Genero g4 = new Genero("Pop");
		
		double preco = 3;
		
		Artista blackSabbath = new Artista("Black Sabbath", g1);
		Artista aerosmith = new Artista("Aerosmith", g2);
		Artista pearljam = new Artista("Pearl Jam", g3);
		Artista sarabareilles = new Artista("Sara Bareilles", g4);
		Artista ironmaiden = new Artista("Iron Maiden", g1);
		Artista blackLabel = new Artista("Black Label Society", g1);
		
		Album paranoid_album = new Album("Paranoid");
		Album aerosmith_album = new Album("Aerosmith");
		Album ten = new Album("Ten");
		Album blessed_unrest = new Album("The Blessed Unrest");
		Album ironmaiden_album = new Album("Iron maiden");
		Album grimmestHits = new Album("Grimmest Hits");
		
		paranoid_album.setCapa("http://4.bp.blogspot.com/-EUADGV_ujl4/T89VEyknxPI/AAAAAAAAA-4/x0pSJ-jRQYs/s1600/Black+Sabbath+-+Paranoid.jpg");
		aerosmith_album.setCapa("https://upload.wikimedia.org/wikipedia/en/5/58/Aerosmith_-_Aerosmith.jpg");
		ten.setCapa("https://img.discogs.com/LQAOG9Oc0ZNPcx1KLQbB92S-3yA=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-9068599-1474213738-2758.jpeg.jpg");
		blessed_unrest.setCapa("http://www.loveispop.com/wp-content/uploads/2013/07/Sara-Bareilles-The-Blessed-Unrest-album-cover-art.jpg");
		ironmaiden_album.setCapa("https://upload.wikimedia.org/wikipedia/en/7/7c/Iron_Maiden_%28album%29_cover.jpg");
		grimmestHits.setCapa("https://is4-ssl.mzstatic.com/image/thumb/Music128/v4/b3/f6/08/b3f608e6-f01b-1e2c-5605-13a23f856b05/BLS-GrimmestHits-cover2.jpg/1200x630bb.jpg");
		
		Musica paranoid = new Musica();
		paranoid.setAlbum(paranoid_album);
		paranoid.setNome("Paranoid");
		paranoid.setArtista(blackSabbath);
		paranoid.setLancamento(LocalDate.of(1970, Month.SEPTEMBER, 18));
		paranoid.setPreco(preco);
		
		Musica dreamOn = new Musica();
		dreamOn.setAlbum(aerosmith_album);
		dreamOn.setNome("Dream On");
		dreamOn.setArtista(aerosmith);
		dreamOn.setLancamento(LocalDate.of(1973, Month.JUNE, 27));
		dreamOn.setPreco(preco);

		Musica black = new Musica();
		black.setAlbum(ten);
		black.setArtista(pearljam);
		black.setNome("Black");
		black.setLancamento(LocalDate.of(1991, Month.AUGUST, 27));
		black.setPreco(preco);
		
		Musica iChooseYou = new Musica();
		iChooseYou.setAlbum(blessed_unrest);
		iChooseYou.setArtista(sarabareilles);
		iChooseYou.setNome("I Choose You");
		iChooseYou.setLancamento(LocalDate.of(2014, Month.JANUARY, 17));
		iChooseYou.setPreco(preco);

		Musica runningFree = new Musica();
		runningFree.setAlbum(ironmaiden_album);
		runningFree.setArtista(ironmaiden);
		runningFree.setNome("Running Free");
		runningFree.setLancamento(LocalDate.of(1980, Month.FEBRUARY, 8));
		runningFree.setPreco(preco);

		Musica roomOfNightmares = new Musica();
		roomOfNightmares.setAlbum(grimmestHits);
		roomOfNightmares.setArtista(blackLabel);
		roomOfNightmares.setNome("Room of Nightmares");
		roomOfNightmares.setLancamento(LocalDate.of(2017, Month.DECEMBER, 10));
		roomOfNightmares.setPreco(preco);

		transacao.begin();
		
		conexao.persist(paranoid);
		conexao.persist(dreamOn);
		conexao.persist(black);
		conexao.persist(iChooseYou);
		conexao.persist(runningFree);
		conexao.persist(roomOfNightmares);
		
		transacao.commit();			
	}
	
}
