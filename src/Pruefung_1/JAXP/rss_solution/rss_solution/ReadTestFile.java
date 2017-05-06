package Pruefung_1.JAXP.rss_solution.rss_solution;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public final class ReadTestFile {

	public static void main(String[] args) {
		try {
			URL fURL = new File("articles.xml").toURI().toURL();
			RSSFeedParser parser = new RSSFeedParser(fURL);
			Feed feed = parser.readFeed();
			System.out.println(feed);
			for (FeedMessage message : feed.getMessages())
				System.out.println(message);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
