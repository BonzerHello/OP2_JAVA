package Kapitel_5.exercises.task3RSS;

import java.io.File;
import java.net.URL;
import java.util.List;

public final class ReadTest {
  private ReadTest(){}

  public static void main(String[] args) throws Exception{
    URL fURL = new URL("http://www.blick.ch/news/rss");
    RSSFeedParser parser = new RSSFeedParser(fURL);
    Feed feed = parser.readFeed();
    System.out.println(feed);
    for (FeedMessage message : feed.getMessages()) System.out.println(message);
  }
} 