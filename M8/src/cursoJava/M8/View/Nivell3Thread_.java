package cursoJava.M8.View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursoJava.M8.Tread.*;


public class Nivell3Thread_ {

	static void Process() throws Exception {
		
		/* Només es pel meu estudi!! Versió amb Thread*/

		System.out.println("Milestone 3");

		List<Video> listVideos = new ArrayList<Video>();
		String newVideo;
		String newtag;

		try {
			String nom = JOptionPane.showInputDialog("Introdueix el teu nom.");
			String cognom = JOptionPane.showInputDialog("Introdueix el teu cognom.");
			String password = JOptionPane.showInputDialog("Introdueix el teu password.");
			//Es fan servir segons per acurtar la durada.
			int segons = Integer.parseInt(JOptionPane.showInputDialog("Introdueix la durada del video en seconds"));

			Usuari user = new Usuari(nom, cognom, password);

			do {
				String titol = JOptionPane.showInputDialog("Video: Introdueix el titol: ");
				String url = JOptionPane.showInputDialog("Video: Introdueix la URL:");

				
				List<String> listTags = new ArrayList<String>();

				do {
					String tag = JOptionPane.showInputDialog("Introdueix el nom del tag");
					listTags.add(tag);
					newtag = JOptionPane.showInputDialog("Vols crear altre Tag?: S o N").toUpperCase();
				} while (newtag.equals("S"));

				//Al crear el video es posa el status Inicial (Uploading i Stoped), i es crea la data.
				Video video = new Video(titol, url, segons, listTags);
				video.setTags(listTags);
				
				listVideos.add(video);
				//Es posa en marxa la execució del thread. Es crea un per cada video, per no aturar l'aplicació
				new VideoThread(video).start();

				newVideo = JOptionPane.showInputDialog("Vols crear un video?: S o N").toUpperCase();

			} while (newVideo.equals("S"));

			user.setVideos(listVideos);
			
			System.out.println(user);

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

}
