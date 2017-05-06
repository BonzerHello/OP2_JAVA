package Kapitel_5.exercises.task3RSS;

import Kapitel_5.examples.stax.item.Item;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tilli_000 on 22.03.2017.
 */
public class RSSFeedParser {
    URL url;

    String FEED_TITLE = "title";
    String FEED_LINK = "link";
    String FEED_DESCRIPTION = "description";
    String FEED_LANGUAGE = "language";
    String FEED_COPYRIGHT = "copyright";
    String FEED_PUPDATE = "pubDate";

    String FEED_MESSAGE_ITEM = "item";
    String FEED_MESSAGE_TITLE = "title";
    String FEED_MESSAGE_DESCRIPTION = "description";
    String FEED_MESSAGE_LINK = "link";


    public RSSFeedParser(URL s) {
        this.url = s;
    }

    public Feed readFeed() {
        List<FeedMessage> feedMessages = new ArrayList<FeedMessage>();
        Feed feed = new Feed();
        boolean isItem = false;
        try (InputStream in = url.openStream()) {
            // First, create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            // Setup a new eventReader
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            // prepare a List with FeedMessafe

            FeedMessage feedMessage = new FeedMessage();

            // loop over all events
            while (eventReader.hasNext()) {

                // get the next event
                XMLEvent event = eventReader.nextEvent();

                // process only events of interest
                if (event.isStartElement()) {

                    // convert to Start element
                    StartElement startElement = event.asStartElement();

                    // if we have an item element, we create a new item
                    if (startElement.getName().getLocalPart().equals(FEED_MESSAGE_ITEM)) {
                        feedMessage = new FeedMessage();
                        isItem = true;
                    } else
                        if(isItem) {
                            // treat the rest
                            if (startElement.getName().getLocalPart().equals(FEED_MESSAGE_TITLE)) {
                                event = eventReader.nextEvent();
                                feedMessage.setTitle(event.asCharacters().getData());
                                continue;
                            } else if (startElement.getName().getLocalPart()
                                    .equals(FEED_MESSAGE_DESCRIPTION)) {
                                event = eventReader.nextEvent();
                                feedMessage.setDescription(event.asCharacters().getData());
                                continue;
                            } else if (startElement.getName().getLocalPart()
                                    .equals(FEED_MESSAGE_LINK)) {
                                event = eventReader.nextEvent();
                                feedMessage.setLink(event.asCharacters().getData());
                                continue;
                            }
                        }else{
                            if (startElement.getName().getLocalPart().equals(FEED_TITLE)) {
                                event = eventReader.nextEvent();
                                feed.setTitle(event.asCharacters().getData());
                                continue;
                            } else if (startElement.getName().getLocalPart()
                                    .equals(FEED_LINK)) {
                                event = eventReader.nextEvent();
                                feed.setLink(event.asCharacters().getData());
                                continue;
                            }
                            else if (startElement.getName().getLocalPart()
                                    .equals(FEED_DESCRIPTION)) {
                                event = eventReader.nextEvent();
                                feed.setDescription(event.asCharacters().getData());
                                continue;
                            }
                            else if (startElement.getName().getLocalPart()
                                    .equals(FEED_LANGUAGE)) {
                                event = eventReader.nextEvent();
                                feed.setLanguage(event.asCharacters().getData());
                                continue;
                            }
                            else if (startElement.getName().getLocalPart()
                                    .equals(FEED_COPYRIGHT)) {
                                event = eventReader.nextEvent();
                                feed.setCopyright(event.asCharacters().getData());
                                continue;
                            }
                            else if (startElement.getName().getLocalPart()
                                    .equals(FEED_PUPDATE)) {
                                event = eventReader.nextEvent();
                                feed.setPubDate(event.asCharacters().getData());
                                continue;
                            }
                        }
                } else
                    // if we reach the end of an item element, we add it to the list
                    if (event.isEndElement()) {
                        EndElement endElement = event.asEndElement();
                        // it must be an ITEM tag
                        if (endElement.getName().getLocalPart() == (FEED_MESSAGE_ITEM))
                            feedMessages.add(feedMessage);
                    }
            }

        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        feed.setEntries(feedMessages);

        return feed;
    }
}
