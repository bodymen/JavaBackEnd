package cursoJava.M8.View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursoJava.M8.Usuari;
import cursoJava.M8.Video;

public class Nivell1 {

	static void Process() throws Exception {
		
		System.out.println("Milestone 1");

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
					newtag = JOptionPane.showInputDialog("Vols crear altre Tag?: S o N").toUpperCase();
				} while (newtag.equals("S"));

				Video video = new Video(titol, url, listTags);
				video.setTags(listTags);
				listVideos.add(video);

				newVideo = JOptionPane.showInputDialog("Vols crear un video?: S o N").toUpperCase();

			} while (newVideo.equals("S"));

			user.setVideos(listVideos);

			System.out.println(user);

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}

	}

}
