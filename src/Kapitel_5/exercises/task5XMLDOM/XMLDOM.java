package Kapitel_5.exercises.task5XMLDOM;

import java.io.*;
import java.util.ArrayList;

import org.w3c.dom.*;

import javax.xml.parsers.*;

/**
 * XmlDoc program reading the sections.xml and outputting the section information
 * 
 * @author A. Laube, 2017
 * @version 1.0
 */

public class XMLDOM {
	DocumentBuilder db = null;
	DocumentBuilderFactory dbf = null;
	Document doc = null;

	public static void main(String[] args) {
		if (args.length > 0) {
			XMLDOM xd = new XMLDOM(args[0]);
		} else {
			System.out.println("No document file supplied.");
			System.exit(1);
		}
	}

	/** Read the document and create corresponding DOM nodes. */
	/**
	 * @param docFile
	 *          the xml file
	 */
	public XMLDOM(String docFile) {
		System.out.println("Document = " + docFile);
		try {
			dbf = DocumentBuilderFactory.newInstance();

			// Optional: set various configuration options
			dbf.setIgnoringComments(true);
			dbf.setIgnoringElementContentWhitespace(false);

			db = dbf.newDocumentBuilder();

			doc = db.parse(new File(docFile));

			// TODO Implement this method
			ArrayList<Section> sections = readSections(doc, 0);

			// TODO Output the result - Insert your code here
			for(Section section:sections){
				System.out.println(section.toString());
			}
		
			
		} catch (Exception e) {
			System.out.println("Doc File = " + docFile);
			System.out.println("Doc File Error: " + e.getMessage());
		}
	}

	public ArrayList<Section> readSections(Node node, int level) {
        // TODO Insert your code here
		
		// get the node
		int type = node.getNodeType();
		// System.out.println("Node Type: " + type);
		NodeList children = null;
		NamedNodeMap attrs = null;
		Section section = null;
		String name = "";
		String number = "";
		int levelSection = 0;
		ArrayList<Section> sections = new ArrayList<Section>();

		switch (type) {
			case Node.DOCUMENT_NODE:
				System.out.print("Document Node: <?xml");

				System.out.print(" version=\"" + ((Document) node).getXmlVersion());
				String encoding = ((Document) node).getXmlEncoding();
				if (encoding != null)
					System.out.print(" encoding=" + encoding);
				System.out.println("\" ?>");

				children = node.getChildNodes();
				if (children != null) {
					int len = children.getLength();
					for (int i = 0; i < len; i++)
						readSections(children.item(i),level);
				}
				break;

			case Node.DOCUMENT_TYPE_NODE:
				String subset = ((DocumentType) node).getInternalSubset();
				System.out.println("<!DOCTYPE " + node.getNodeName() + " [" + subset + "]>");
				break;

			case Node.ELEMENT_NODE:
				System.out.print("<");
				System.out.print(node.getNodeName());
				attrs = node.getAttributes();

				for (int i = 0; i < attrs.getLength(); i++) {
					Node attr = attrs.item(i);
					System.out.print(" " + attr.getNodeName() + "=\"" + attr.getNodeValue() + "\"");
					switch(attr.getNodeName()){
						case "name":
							name = attr.getNodeValue();
							break;
						case "number":
							number = attr.getNodeValue();
							break;

					}
					levelSection = level;
				}
				if(node.getNodeName().equals("Section")){
					section = new Section(name,number,levelSection);
					sections.add(section);

				}
				System.out.print(">\n");

				children = node.getChildNodes();
				if (children != null) {
					int len = children.getLength();
					for (int i = 0; i < len; i++)
						readSections(children.item(i),level);
				}

				System.out.println("</" + node.getNodeName() + ">");
				break;

			case Node.ENTITY_REFERENCE_NODE:
				System.out.print("&");
				System.out.print(node.getNodeName());
				System.out.println(";");
				break;

			case Node.CDATA_SECTION_NODE:
				System.out.print("<![CDATA[");
				System.out.print(node.getNodeValue());
				System.out.println("]]>\n");
				break;

			case Node.TEXT_NODE:
				System.out.print(node.getNodeValue().trim());
				break;

			case Node.PROCESSING_INSTRUCTION_NODE:
				System.out.print("<?");
				System.out.print(node.getNodeName());
				System.out.print(" " + node.getNodeValue());
				System.out.println("?>\n");
				break;

			case Node.COMMENT_NODE:
				System.out.print("<!--");
				System.out.print(node.getNodeValue());
				System.out.println("-->");
				break;

			default:
				System.out.print("Unknown node");
				break;

		}
		
		// Check if node has type Node.ELEMENT_NODE
		// If yes, store it
		
		// Get the children of the node and call this method recursively
		
		// return the constructed ArrayList
		return sections;
	}
}
