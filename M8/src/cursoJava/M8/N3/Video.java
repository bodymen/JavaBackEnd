package cursoJava.M8.N3;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import cursoJava.M8.N2.VideoStatusLoadEnum;

public class Video {

	private String url;
	private String titol;
	private List<String> tags;
	private LocalDateTime dataRegistre;
	private VideoStatusLoadEnum statusLoad;
	private VideoStateEnum status;
	ZoneOffset zone = ZoneOffset.of("Z");
	LocalDateTime ldtLoading;
	long loading;
	long start;
	long durada;
	int i = 0;

	public Video(String titol, String url, List<String> tags, long durada) throws Exception {

		if (url.trim().equals("") || url.isEmpty())
			throw new Exception("Has de posat una URL");
		if (titol.trim().equals("") || titol.isEmpty())
			throw new Exception("Has de posat un titol");

		this.url = url;
		this.titol = titol;
		this.tags = tags;

		this.dataRegistre = LocalDateTime.now();

		ldtLoading = LocalDateTime.now();
		loading = ldtLoading.toEpochSecond(zone);

		setTags(new ArrayList<String>());

		this.durada = durada;
	}

	public String getUrl() {
		return url;
	}

	public String getTitol() {
		return titol;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public LocalDateTime getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(LocalDateTime dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	public VideoStatusLoadEnum getStatusLoad() {

		LocalDateTime ldtCurrent = LocalDateTime.now();
		long current = ldtCurrent.toEpochSecond(zone);

		// System.out.println("time: " + this.loading + ": " + current);
		long diff = current - loading;
		System.out.println("diff: " + diff);

		if (diff < 1) {
			setStatusLoad(VideoStatusLoadEnum.Uploading);
		} else if (diff >= 1 && diff < 3) {
			setStatusLoad(VideoStatusLoadEnum.Verifying);
		} else if (diff >= 3) {
			setStatusLoad(VideoStatusLoadEnum.Public);
		}
		return statusLoad;
	}

	public void setStatusLoad(VideoStatusLoadEnum statusLoad) {
		System.out.println("STATUS LOAD video " + this.getTitol() + ": " + statusLoad);
		this.statusLoad = statusLoad;
	}

	public VideoStateEnum getStatus() {

//		System.out.println("durada: " + this.durada);
//		long diff = this.i - this.durada;
//		System.out.println("diff: " + diff);
//
//		if (diff < this.durada) {
//			setStatus(VideoStateEnum.Started);
//		} else if (diff >= this.durada) {
//			setStatus(VideoStateEnum.Stoped);
//		} else
//			setStatus(VideoStateEnum.Paused);

		return status;
	}

	
	// no acaba de funcionar asi, con RUN and PAUSE
	public void run(int start) {

		if (start == 1) {
			setStatus(VideoStateEnum.Started);
			
			int j = 0;
			for (j = 0; i < this.durada; j++) {
				i++;
			}
		} else if (start == 0) {
			setStatus(VideoStateEnum.Paused);

			i = (int) durada - i;
		}

		if (Long.compare(this.durada, i) == 0)
			setStatus(VideoStateEnum.Stoped);
	}

	public void pause() {

		setStatus(VideoStateEnum.Paused);

		i = (int) durada;
	}

	public void setStatus(VideoStateEnum status) {

		this.status = status;
		System.out.println("STATUS RUN video " + this.getTitol() + ": " + status);
	}

	public long getSegonsDuration() {
		return durada;
	}

	public void setSegonsDuration(long durada) {
		this.durada = durada;
	}

	@Override
	public String toString() {
		return "Video [url=" + url + ", titol=" + titol + ", tags=" + tags + ", dataRegistre=" + dataRegistre
				+ ", segonsDuration=" + durada + ", statusLoad=" + statusLoad + ", status=" + status + "]";
	}

}
