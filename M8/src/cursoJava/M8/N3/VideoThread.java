package cursoJava.M8.N3;

import cursoJava.M8.N2.VideoStatusLoadEnum;
import cursoJava.M8.N3.*;

public class VideoThread extends Thread {

	private Video video;
	private int startedAtSecond;

	public VideoThread(Video video) {
		super(video.getTitol());
		setVideo(video);
	}

	public void run() {
		try {

			video.setStatus(VideoStateEnum.Started);
			Thread.sleep(video.getSegonsDuration());
			video.setStatus(VideoStateEnum.Stoped);

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
