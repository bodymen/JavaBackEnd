package cursoJava.M8.N2;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class Video {

	private String url;
	private String titol;
	private List<String> tags;
	private LocalDateTime dataRegistre;
	private VideoStatusLoadEnum statusLoad;
	ZoneOffset zone = ZoneOffset.of("Z");
	LocalDateTime ldtLoading;
	long loading;
	long download;

	public Video(String titol, String url, List<String> tags) throws Exception {

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

		System.out.println("time: " + this.loading + ": " + current);
		long diff = current - loading;
		System.out.println("diff: " + diff);
		
		if (diff < 1) {
			setStatusLoad(VideoStatusLoadEnum.Uploading);
		} else if (diff >= 1 && diff < 3) {
			setStatusLoad(VideoStatusLoadEnum.Verifying);
		} else if (diff >= 3) {
			setStatusLoad(VideoStatusLoadEnum.Public);
			
			ldtLoading = LocalDateTime.now();
			download = ldtLoading.toEpochSecond(zone);
		}
		return statusLoad;
	}

	public void setStatusLoad(VideoStatusLoadEnum statusLoad) {
		System.out.println("STATUS LOAD video " + this.getTitol() + ": " + statusLoad);
		this.statusLoad = statusLoad;
	}

	@Override
	public String toString() {
		return "Video [url=" + url + ", titol=" + titol + ", tags=" + tags + ", dataRegistre=" + dataRegistre + "]";
	}

}
