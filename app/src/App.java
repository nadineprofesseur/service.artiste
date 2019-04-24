import java.util.List;

import donnee.ArtisteDAO;
import modele.Artiste;

public class App {

	public static void main(String[] args) {

		ArtisteDAO artisteDAO = new ArtisteDAO();
		List<Artiste> listeArtistes = artisteDAO.listerArtistes();
		
	}

}
