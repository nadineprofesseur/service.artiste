package donnee;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modele.Artiste;
import modele.Demonstration;

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
	
	private String convertirHashEnUrl(Map<String,String> arguments)
	{
		StringJoiner sj = new StringJoiner("&");
		for(Map.Entry<String,String> entry : arguments.entrySet())
			try {
				sj.add(URLEncoder.encode(entry.getKey(), "UTF-8") + "=" 
				     + URLEncoder.encode(entry.getValue(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		return sj.toString();
	}
	
	// http://localhost/service.artiste/demonstration-ajouter.php?id_artiste=1&titre=bla&resume=blabla&date=unedate&lieu=Matane
	public void ajouterDemonstration(Demonstration demonstration)
	{
		// TODO factoriser ce code de Hashmap dans le modele dans une fonction exporterTableauAssociatif( )
		//Map<String,String> arguments = new HashMap<>();
		//arguments.put("titre", demonstration.getTitre());
		//arguments.put("resume", demonstration.getResume());
		//arguments.put("lieu", demonstration.getLieu());
		//arguments.put("date", demonstration.getDate());
		//arguments.put("id_artiste", demonstration.getArtiste().getId());
		
		// TODO generer cette chaine a partir du modele dans une fonction exporterFormatURL( )
		// Note : utiliser URLEncoder.encode(entry.getKey(), "UTF-8") pour encoder les valeurs
		String parametres = "";
		try {
			parametres = "id_artiste="+URLEncoder.encode(demonstration.getIdArtiste() + "", "UTF-8")
								+"&titre="+URLEncoder.encode(demonstration.getTitre(), "UTF-8")
								+"&resume="+URLEncoder.encode(demonstration.getResume(), "UTF-8")
								+"&date="+URLEncoder.encode(demonstration.getDate(), "UTF-8")
								+"&lieu="+URLEncoder.encode(demonstration.getLieu(), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
		// pour tester
		// parametres  = "id_artiste="+demonstration.getIdArtiste()+"&titre=blabla&resume=blabla&date=unedate&lieu=Quebec"; // pour tester	
		System.out.println(parametres);

		byte[] message       = parametres.getBytes( StandardCharsets.UTF_8 );
		String requete        = "http://localhost/service.artiste/demonstration-ajouter.php";
		URL url;
		try {
			url = new URL( requete );
			HttpURLConnection connexion= (HttpURLConnection) url.openConnection();           
			connexion.setInstanceFollowRedirects( false );
			connexion.setRequestMethod( "POST" );
			connexion.setDoOutput(true);
			
			connexion.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded"); 
			connexion.setFixedLengthStreamingMode(message.length);			
			connexion.setUseCaches( false );
			
			connexion.connect();
			connexion.getOutputStream().write(message);
			connexion.disconnect();
		}
		catch (IOException e) { e.printStackTrace();}
		
	}
// https://stackoverflow.com/questions/4205980/java-sending-http-parameters-via-post-method-easily
/*
*/
	
}
