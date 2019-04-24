package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class ArtisteDAO {


	private String demanderXMLListeArtistes()
	{
		String xml = null;
		
		try {
			String derniereBalise = "</artistes>";
			
			URL urlListeVendeurs = new URL("http://localhost/service.artiste/liste-artistes.php");
			InputStream flux = urlListeVendeurs.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise);
			xml = lecteur.next() + derniereBalise;
			//System.out.println(xml);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return xml;
	}
	
	public void listerArtistes()
	{
		String xml = this.demanderXMLListeArtistes();
		System.out.println(xml);
	}
	
	
	
}
