package cursoJava.M8.Tread;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import cursoJava.M8.N2.VideoStatusLoadEnum;
import cursoJava.M8.N3.VideoStateEnum;

public class Video {

	private String url;
	private String titol;
	private List<String> tags;
	private String dataRegistre;
	private VideoStatusLoadEnum statusLoad;
	private VideoStateEnum status;
	private int segonsDuration;

	public Video(String titol, String url, int segons, List<String> tags) throws Exception {

		if (url.trim().equals("") || url.isEmpty())
			throw new Exception("Has de posat una URL");
		if (titol.trim().equals("") || titol.isEmpty())
			throw new Exception("Has de posat un titol");

		this.url = url;
		this.titol = titol;
		this.tags = tags;
		this.segonsDuration = segons;
		
        setStatusLoad(VideoStatusLoadEnum.Uploading);
        setStatus(VideoStateEnum.Stoped);
		setTags(new ArrayList<String>());
		
		LocalDate date = LocalDate.now(); 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		this.setDataRegistre(date.format(formatter));
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
	

	public String getDataRegistre() {
		return dataRegistre;
	}

	public void setDataRegistre(String dataRegistre) {
		this.dataRegistre = dataRegistre;
	}

	 
	public VideoStatusLoadEnum getStatusLoad() {
		return statusLoad;
	}

	public void setStatusLoad(VideoStatusLoadEnum statusLoad) {
		System.out.println("STATUS LOAD video " + this.getTitol() + ": " + statusLoad);
		this.statusLoad = statusLoad;
	}

	public VideoStateEnum getStatus() {
		return status;
	}

	public void setStatus(VideoStateEnum status) {
		System.out.println("STATE video " + this.getTitol() + ": " + status);
		this.status = status;
	}

	public int getSegonsDuration() {
		return segonsDuration;
	}

	public void setSegonsDuration(int segonsDuration) {
		this.segonsDuration = segonsDuration;
	}

	@Override
	public String toString() {
		return "Video [url=" + url + ", titol=" + titol + ", tags=" + tags + ", dataRegistre=" + dataRegistre
				+ ", segonsDuration=" + segonsDuration + ", statusLoad=" + statusLoad + ", status=" + status + "]";
	}

}
