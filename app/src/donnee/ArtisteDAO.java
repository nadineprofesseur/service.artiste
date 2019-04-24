package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modele.Artiste;

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
	
	public List<Artiste> listerArtistes()
	{
		String xml = this.demanderXMLListeArtistes();
		System.out.println(xml);
		
		List<Artiste> listeArtistes = new ArrayList<Artiste>();
		
		try {
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new StringBufferInputStream(xml));
			NodeList listeNoeudsArtistes = document.getElementsByTagName("artiste");
			
			for(int position = 0; position < listeNoeudsArtistes.getLength(); position++)
			{
				Element elementVendeur = (Element)listeNoeudsArtistes.item(position);
				String nom = elementVendeur.getElementsByTagName("nom").item(0).getTextContent();
				String id = elementVendeur.getElementsByTagName("id").item(0).getTextContent();
				// System.out.println(nom + " " + id); //ok
				
				Artiste artiste = new Artiste();
				artiste.setId(Integer.parseInt(id));
				artiste.setNom(nom);
				listeArtistes.add(artiste);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return listeArtistes;
	}
	
	
	
}
