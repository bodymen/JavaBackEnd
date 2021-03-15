package cursoJava.M8.View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursoJava.M8.N2.Usuari;
import cursoJava.M8.N2.Video;
import cursoJava.M8.N2.VideoStatusLoadEnum;

public class Nivell2 {

	static void Process() throws Exception {

		System.out.println("Milestone 2");

		List<Video> listVideos = new ArrayList<Video>();
		String newVideo;
		String newtag;

		try {
			String nom = JOptionPane.showInputDialog("Introdueix el teu nom");
			String cognom = JOptionPane.showInputDialog("Introdueix el teu cognom");
			String password = JOptionPane.showInputDialog("Introdueix el teu password");

			Usuari user = new Usuari(nom, cognom, password);

			do {
				String titol = JOptionPane.showInputDialog("Video: Introdueix el titol: ");
				String url = JOptionPane.showInputDialog("Video: Introdueix la URL:");

				List<String> listTags = new ArrayList<String>();

				do {
					String tag = JOptionPane.showInputDialog("Introdueix el nom del tag");
					listTags.add(tag);
					newtag = JOptionPane.showInputDialog("Vols crear altre Tag?: S o N");
				} while (newtag.toUpperCase().equals("S"));

				// Al crear el video es posa el status a Uploading i es crea la data.
				Video video = new Video(titol, url, listTags);
				video.setTags(listTags);

				// Es fa servir un sleep, per lo tant atura l'aplicació, waiting fins que
				// transcorre el temps.
				video.getStatusLoad();
				Thread.sleep(1000);
				video.getStatusLoad();
				Thread.sleep(2000);
				video.getStatusLoad();

				// Una vegada es public es "publica" a la llista.
				listVideos.add(video);

				newVideo = JOptionPane.showInputDialog("Vols crear un video?: S o N");
				if (newVideo == null)
					newVideo = "N";

			} while (newVideo.toUpperCase().equals("S"));

			user.setVideos(listVideos);

			System.out.println(user);

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

}
