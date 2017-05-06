package Kapitel_5.exercises.task3RSS;

import java.util.ArrayList;
import java.util.List;

/*
 * Stores an RSS feed
 */
public final class Feed {

	public List<FeedMessage> getEntries() {
		return entries;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	// by definition an RSS feed has these fields!
	private  String title;
	private  String link;
	private  String description;
	private  String language;
	private  String copyright;
	private  String pubDate;

	public void setEntries(List<FeedMessage> entries) {
		this.entries = entries;
	}

	private  List<FeedMessage> entries = new ArrayList<FeedMessage>();

	public Feed(){
		this.title = "";
		this.link = "";
		this.description = "";
		this.language = "";
		this.copyright = "";
		this.pubDate = "";
	}

	public Feed(String title, String link, String description, String language,
			String copyright, String pubDate) {
		this.title = title;
		this.link = link;
		this.description = description;
		this.language = language;
		this.copyright = copyright;
		this.pubDate = pubDate;
	}

	public List<FeedMessage> getMessages() {return entries;}
	public String getTitle() {return title;}
	public String getLink() {return link;}
	public String getDescription() {return description;}
	public String getLanguage() {return language;}
	public String getCopyright() {return copyright;}
	public String getPubDate() {return pubDate;}

	@Override
	public String toString() {
		return "Feed [copyright=" + copyright + ", description=" + description
				+ ", language=" + language + ", link=" + link + ", pubDate="
				+ pubDate + ", title=" + title + "]";
	}
}