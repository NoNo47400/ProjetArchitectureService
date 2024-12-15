package fr.insa.soap;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import fr.insa.soap.wsdltojava.AnalyserChaineWS;
import fr.insa.soap.wsdltojava.Analyser;

public class ClientOfAnalyser {
	
	public static void main(String [] args) throws MalformedURLException {
		// l'adresse du web service
		final String adresse="http://localhost:8089/analyzer";
		
		// creation de l'url
		final URL url = URI.create(adresse).toURL();
		
		// instanciation de l'image de service
		final Analyser service = new Analyser(url);
		
		// creation du proxy (en utilisant le portType) pour l'appel du service
		final AnalyserChaineWS port = service.getPort(AnalyserChaineWS.class);
		
		String chaine="test";
		//appel de la méthode compare via le port
		System.out.println("La taille de la chaine " + chaine + " est "+port.compare(chaine));
	}

}
