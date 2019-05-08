import java.util.List;

import donnee.ArtisteDAO;
import modele.Artiste;
import modele.Demonstration;
import vue.NavigateurDePages;

public class App {

	public static void main(String[] parametres) {

		ArtisteDAO artisteDAO = new ArtisteDAO();
		//List<Artiste> listeArtistes = artisteDAO.listerArtistes();
		
		Demonstration demonstration = new Demonstration();
		demonstration.setIdArtiste(1);
		demonstration.setTitre("Les poemes de soiree");
		demonstration.setResume("Un petit resume");
		demonstration.setDate("aujourd'hui");
		demonstration.setLieu("Matane");
		artisteDAO.ajouterDemonstration(demonstration);
		
		// https://stackoverflow.com/questions/11273773/javafx-2-1-toolkit-not-initialized
		//NavigateurDePages.launch(NavigateurDePages.class, parametres);

	}

}
