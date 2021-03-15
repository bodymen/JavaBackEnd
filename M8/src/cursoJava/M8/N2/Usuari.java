package cursoJava.M8.N2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuari {

	private String nom;
	private String cognom;
	private String password;
	private String dataRegistre;
	private List<Video> videos;
	
	
	public Usuari(String nom, String cognom,  String password) throws Exception {

		if (nom.trim().equals("") || nom.isEmpty() )
			throw new Exception("Has de posat un nom");
		if (cognom.trim().equals("") || cognom.isEmpty() )
			throw new Exception("Has de posat un cognom");
		if (password.trim().equals("") || password.isEmpty() )
			throw new Exception("Has de posat una password");
		
		this.nom = nom;
		this.cognom = cognom;
		this.password = password;
		
		setVideos(new ArrayList<>());
		
		LocalDate date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.setDataRegistre(date.format(formatter));
	}
	public String getNom() {
		return nom;
	}
	public String getCognom() {
		return cognom;
	}
	public  String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	public String getDataRegistre() {
		return dataRegistre;
	}
	public void setDataRegistre(String dataRegistre) {
		this.dataRegistre = dataRegistre;
	}
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	@Override
	public String toString() {
		return "Usuari [nom=" + nom + ", cognom=" + cognom + ", password=" + password + ", dataRegistre=" + dataRegistre
				+ ", videos=" + videos + "]";
	}
 
}
