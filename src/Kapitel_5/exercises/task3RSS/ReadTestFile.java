package Kapitel_5.exercises.task3RSS;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public final class ReadTestFile {

	public static void main(String[] args) {
		try {
			URL fURL = new File("Blick_2015_03_26.xml").toURI().toURL();
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
