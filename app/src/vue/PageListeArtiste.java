package vue;

import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
//import javafx.scene.control.ListView;
import javafx.scene.control.ListView;
import modele.Artiste;

public class PageListeArtiste extends Page{

	public PageListeArtiste() throws IOException {
		super(FXMLLoader.load(PageListeArtiste.class.getResource("liste-artistes.fxml")));		
	}

	public void afficherListeArtistes(List<Artiste> listeArtistes)
	{
		ObservableList<String> items = FXCollections.observableArrayList ();
		ListView grilleDesArtistes = (ListView) this.lookup("#liste-artistes");
		for(Artiste artiste : listeArtistes)
		{
			items.add(artiste.getNom());
		}
		grilleDesArtistes.setItems(items);
	}
}
