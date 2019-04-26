package vue;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
//import javafx.scene.control.ListView;

public class PageListeArtiste extends Page{

	public PageListeArtiste() throws IOException {
		super(FXMLLoader.load(PageListeArtiste.class.getResource("liste-artistes.fxml")));		
	}

	/*
	 * 	public void afficherListeExoplanetes(List<Exoplanete> listeExoplanetes)
	{
		ObservableList<String> items = FXCollections.observableArrayList ();
		ListView grilleDesPlanetes = (ListView) this.lookup("#liste-exoplanetes");
		for(Exoplanete exoplanete : listeExoplanetes)
		{
			items.add(exoplanete.getNom());
			//espaceTexte.appendText(exoplanete.getNom() + "\n");					
		}
		grilleDesPlanetes.setItems(items);
	}*/
}
