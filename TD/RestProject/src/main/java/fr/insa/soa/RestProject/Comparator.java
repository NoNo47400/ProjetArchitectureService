package fr.insa.soa.RestProject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("comparator") // On ajoute un path
public class Comparator {
	@GET // On ajoute un moyen d'appeler la fonction via une requete GET
	@Produces(MediaType.TEXT_PLAIN) // On envoie la réponse sous forme de texte
	public String sayHello() {
		return "Bonjour BG!";
	}
	
	@GET
	@Path("longueur/{chaine}")
	@Produces(MediaType.TEXT_PLAIN)
	public int getLongueur(@PathParam("chaine") String chaine) {
		return chaine.length();
	}
	
	@GET
	@Path("longueurDouble")
	@Produces(MediaType.TEXT_PLAIN)
	public int getLongueurDouble(@QueryParam("chaine") String chaine) {
		return chaine.length()*2;
	}
	
	@PUT
	@Path("/{idEtudiant}")
	@Consumes(MediaType.TEXT_PLAIN)
	public int getLongueurDouble(@PathParam("idEtudiant") int id) {
		System.out.println("mise à jour réussie !!");
		return id;
	}
}
