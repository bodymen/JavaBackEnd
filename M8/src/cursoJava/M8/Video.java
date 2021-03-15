package cursoJava.M8;

import java.util.ArrayList;
import java.util.List;

public class Video {


	private String url;
	private String titol;
	private List<String> tags;

	public Video(String url, String titol, List<String> tags) throws Exception {

		if (url.trim().equals("") || url.isEmpty())
			throw new Exception("Has de posat una URL");
		if (titol.trim().equals("") || titol.isEmpty())
			throw new Exception("Has de posat un titol");

		this.url = url;
		this.titol = titol;
		this.tags = tags;

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
	

	@Override
	public String toString() {
		return "Video [url=" + url + ", titol=" + titol + ", tags=" + tags + "]";
	}

}
