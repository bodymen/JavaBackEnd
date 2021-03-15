package cursoJava.M8.Tread;

import cursoJava.M8.N2.VideoStatusLoadEnum;
import cursoJava.M8.N3.VideoStateEnum;

public class VideoThread extends Thread {

	private Video video;
	private int startedAtSecond;

	public VideoThread(Video video) {
		super(video.getTitol());
		setVideo(video);
	}

	public void run() {
		try {
			Thread.sleep(1000);
			video.setStatusLoad(VideoStatusLoadEnum.Verifying);
			Thread.sleep(1000);
			video.setStatusLoad(VideoStatusLoadEnum.Public);

			if (video.getStatusLoad().equals(VideoStatusLoadEnum.Public)) {
				video.setStatus(VideoStateEnum.Started);
				setStartedAtSecond(3000); // Es fara amb segonds, pero acortar la durada. //get fecha in seconds
			}
			
			if (video.getStatus().equals(VideoStateEnum.Started)) { 
				//	(video.getSegonsDuration() + getStartedAtSeconds()) = ) {
				//Sleep la duració del video, i després el para.
				Thread.sleep(video.getSegonsDuration());
				video.setStatus(VideoStateEnum.Stoped);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Termina thread " + video.getTitol());
	}

	public Video getVideo() {
		return video;
	}

	public int getStartedAtSecond() {
		return startedAtSecond;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public void setStartedAtSecond(int startedAtSecond) {
		this.startedAtSecond = startedAtSecond;
	}

}
