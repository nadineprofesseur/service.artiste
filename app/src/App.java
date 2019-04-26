import java.util.List;

import donnee.ArtisteDAO;
import modele.Artiste;
import vue.NavigateurDePages;

public class App {

	public static void main(String[] parametres) {

		//ArtisteDAO artisteDAO = new ArtisteDAO();
		//List<Artiste> listeArtistes = artisteDAO.listerArtistes();
		
		// https://stackoverflow.com/questions/11273773/javafx-2-1-toolkit-not-initialized
		NavigateurDePages.launch(NavigateurDePages.class, parametres);

	}

}
