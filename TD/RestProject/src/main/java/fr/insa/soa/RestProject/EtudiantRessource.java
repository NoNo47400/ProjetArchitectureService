package fr.insa.soa.RestProject;

import fr.insa.soa.RestProject.Etudiant;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;

@Path("etudiant")
public class EtudiantRessource {
	
	@GET
	@Path("/{idEtudiant}")
	@Produces(MediaType.APPLICATION_JSON)
	public Etudiant getEtudiant(@PathParam("idEtudiant") int id) {
		Etudiant etudiant = new Etudiant();
		etudiant.setNom("Gauché");
		etudiant.setPrenom("Clément");
		return etudiant;
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addEtudiant(Etudiant etudNouv) {
		System.out.println("Ajout de l'étudiant "+etudNouv.getNom()+" "+etudNouv.getPrenom()+" réussie!");
		System.out.println("Son binome est  "+etudNouv.getBinome().getNom()+" "+etudNouv.getBinome().getPrenom());
	}
}
