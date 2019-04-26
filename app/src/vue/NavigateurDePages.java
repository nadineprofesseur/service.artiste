package vue;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
//import action.ControleurArtiste;

public class NavigateurDePages extends Application {
	protected PageListeArtiste pageListeArtiste;
	protected Stage stade;
	//protected ControleurArtiste controleur;
	
	public NavigateurDePages()
	{
		NavigateurDePages.instance = this;
		
		try {
			this.pageListeArtiste = new PageListeArtiste();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//this.controleur = new ControleurArtiste();		
	}


	public PageListeArtiste getPageListeExoplanete() {
		return pageListeArtiste;
	}

	// semi-singleton
	protected static NavigateurDePages instance = null;
	public static NavigateurDePages getInstance()
	{
		return instance;
	}
	
	
	@Override
	public void start(Stage stade) throws Exception {
		//this.controleur.initialiser();
		this.stade = stade;
		this.stade.setScene(this.pageListeArtiste); // pour dire quelle vue afficher en premier
		//this.pageListeExoplanete.afficherListeExoplanetes("terre + mars");
 		// TODO : activer dans le controleur la premiere vue
		this.stade.show();
	}

	public void naviguerVersPageListeExoplanete()
	{
		this.stade.setScene(this.pageListeArtiste); 	
	}
	
	
}
