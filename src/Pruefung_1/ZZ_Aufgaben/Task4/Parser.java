package Pruefung_1.ZZ_Aufgaben.Task4;

import Pruefung_1.JAXP.rss_solution.rss_solution.Feed;
import Pruefung_1.JAXP.rss_solution.rss_solution.FeedMessage;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by tilli_000 on 05.04.2017.
 */
public class Parser {

    static final String CD = "cd";
    static final String TITLE = "title";
    static final String ARTIST = "artist";
    static final String COUNTRY = "country";
    static final String COMPANY = "company";
    static final String PRICE = "price";
    static final String YEAR = "year";


    public static void main(String[] args){

        ArrayList<CD> cds = new ArrayList<CD>();

        CD cd = null;

        try {
            boolean isFeedHeader = true; // each feed starts with a header

            // Set header values initially to the empty string
            String cd1 = "";
            String title = "";
            String artist = "";
            String country = "";
            String company = "";
            String price = "";
            String year = "";


            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();

            // Setup a new eventReader
            URL fURL = new File("CDCatalog.xml").toURI().toURL();
            InputStream in = fURL.openStream();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);

            // read the XML document
            while (eventReader.hasNext()) {

                XMLEvent event = eventReader.nextEvent();

                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName().getLocalPart();

                    switch (localPart) {
                        case CD:
                            if (isFeedHeader) {
                                isFeedHeader = false; // we have read the header
                                //cd = new CD(title, artist, country, company, price,year);
                                // now the header is treated
                            }
                            // go to next event
                            event = eventReader.nextEvent();
                            break;
                        case TITLE:
                            title = getCharacterData(event, eventReader);
                            break;
                        case ARTIST:
                            artist = getCharacterData(event, eventReader);
                            break;
                        case COUNTRY:
                            if (event.asStartElement().getName().getPrefix().isEmpty()) {
                                country = getCharacterData(event, eventReader);
                            }
                            break;
                        case COMPANY:
                            company = getCharacterData(event, eventReader);
                            break;
                        case PRICE:
                            price = getCharacterData(event, eventReader);
                            break;
                        case YEAR:
                            year = getCharacterData(event, eventReader);
                            break;
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart() == (CD)) {
                        cd = new CD(title, artist, country, company, price,year);
                        cds.add(cd);
                        event = eventReader.nextEvent();
                        continue;
                    }
                }
            }
        }
        catch (Exception e) {
            System.err.println("Error While Parsing: "+e.getMessage());
        }

        int numberCDs = cds.size();
        int numberCDsAge = 0;
        double averagePrice = 0;
        ArrayList<String> countries = new ArrayList<String>();
        for(CD element:cds){
            //System.out.println(element.toString());
            try {
                //average price
                averagePrice += Double.valueOf(element.getPrice().trim());

                //older as 20 years
                int year = Integer.valueOf(element.getYear().trim());
                if(year < (2017-20)){
                    numberCDsAge ++;
                }
            }catch (Exception e){
                System.err.println("Error while Parsing: "+element.getPrice());
            }

            //Countries
            if(!countries.contains(element.getCountry())){
                countries.add(element.getCountry());
            }



        }

        averagePrice = averagePrice/numberCDs;

        System.out.println("Anzahl CD's: "+numberCDs);
        System.out.println("Anzahl CD's älter als 20 Jahre: "+numberCDsAge);
        System.out.println("Durchschnitts-Preis: "+averagePrice);

        Map<String, List<CD>> cdLlistGrouped =
                cds.stream().collect(Collectors.groupingBy(w -> w.getCountry()));

        for(Map.Entry<String, List<CD>> entry : cdLlistGrouped.entrySet()){
            System.out.println("Country: "+entry.getKey()+" Size: "+entry.getValue().size());
        }

        //Grouping



    }

    private static String getCharacterData(XMLEvent event, XMLEventReader eventReader)
            throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) result = event.asCharacters().getData();
        return result;
    }
}
