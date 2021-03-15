package cursoJava.M8.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JOptionPane;

import cursoJava.M8.N3.Usuari;
import cursoJava.M8.N3.Video;
import cursoJava.M8.N3.VideoStateEnum;

public class Nivell3 {

	static void Process() throws Exception {

		System.out.println("Milestone 3");

		List<Video> listVideos = new ArrayList<Video>();
		String newVideo;
		String newtag;

		try {
			String nom = JOptionPane.showInputDialog("Introdueix el teu nom.");
			String cognom = JOptionPane.showInputDialog("Introdueix el teu cognom.");
			String password = JOptionPane.showInputDialog("Introdueix el teu password.");
			long segons = Integer.parseInt(JOptionPane.showInputDialog("Introdueix la durada del video en seconds"));

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

				// Al crear el video es posa el status Inicial (Uploading i Stoped), i es crea
				// la data.
				Video video = new Video(titol, url, listTags, segons);
				video.setTags(listTags);

				// Es fa servir un sleep, per lo tant atura l'aplicació, waiting fins que
				// transcorre el temps.
				video.getStatusLoad();
				Thread.sleep(1000);
				video.getStatusLoad();
				Thread.sleep(2000);
				video.getStatusLoad();

				listVideos.add(video);

				// Es fa servir un metodo per arrencar el video. i un altre per parar lo
//				video.run(1);  //start
//				System.out.println("STATE RUN " + video.getTitol() + ": " + video.getStatus());
//				Thread.sleep(1000);
//				video.run(0);  //pause
//				System.out.println("STATE RUN " + video.getTitol() + ": " + video.getStatus());
//				video.run(1);  //start
//				Thread.sleep(1000); 
//				System.out.println("STATE RUN " + video.getTitol() + ": " + video.getStatus());
				
				
				
				int seconds = (int) segons;
				javax.swing.Timer timer1 = new javax.swing.Timer((int) (1000), new ActionListener(){
				int count=0; 
				public void actionPerformed(ActionEvent e) 
				 { 
					 
				 	 if(count==seconds) 
				 		video.setStatus(VideoStateEnum.Stoped);

				 	 count++;
				 } 
				 });

				timer1.start();
				if(timer1.isRunning())
					video.setStatus(VideoStateEnum.Started);
				timer1.stop();
				if(!timer1.isRunning())
					video.setStatus(VideoStateEnum.Paused);
				timer1.restart();
				

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

/*
 * TIMER con ACTIONlistener PARA PONER EN UN BOTON*
 * 
 * Timer timer = new Timer( );
 * 
 * javax.swing.Timer timer1 = new javax.swing.Timer(1000, new ActionListener(0){
 * int count=0; public void actionPerformed(ActionEvent e) { count ++; if(count)
 * } });
 * 
 * timer1.start();
 * 
 * timer1.stop();
 * 
 * timer1.restart();
 */
