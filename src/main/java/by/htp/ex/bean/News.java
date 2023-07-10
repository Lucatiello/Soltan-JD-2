package by.htp.ex.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idNews=0;
	private String title="";
	private String briefNews="";
	private String content="";
	private String newsDate="";
	private String imagePath = "";
	
	public News(){}

	
	
	public News(Integer idNews, String title, String briefNews, String content, String newsDate, String imagePath) {
		super();
		this.idNews = idNews;
		this.title = title;
		this.briefNews = briefNews;
		this.content = content;
		this.newsDate = newsDate;
		this.imagePath = imagePath;
	}



	public News(int idNews, String title, String briefNews, String content, String newsDate) {
		super();
		this.idNews = idNews;
		this.title = title;
		this.briefNews = briefNews;
		this.content = content;
		this.newsDate = newsDate;
	}



	public Integer getIdNews() {
		return idNews;
	}



	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getBriefNews() {
		return briefNews;
	}



	public void setBriefNews(String briefNews) {
		this.briefNews = briefNews;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getNewsDate() {
		return newsDate;
	}



	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}



	public String getImagePath() {
		return imagePath;
	}



	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}



	@Override
	public int hashCode() {
		return Objects.hash(briefNews, content, idNews, imagePath, newsDate, title);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(briefNews, other.briefNews) && Objects.equals(content, other.content)
				&& Objects.equals(idNews, other.idNews) && Objects.equals(imagePath, other.imagePath)
				&& Objects.equals(newsDate, other.newsDate) && Objects.equals(title, other.title);
	}



	@Override
	public String toString() {
		return "News [idNews=" + idNews + ", title=" + title + ", briefNews=" + briefNews + ", content=" + content
				+ ", newsDate=" + newsDate + ", imagePath=" + imagePath + "]";
	}

	
	
}