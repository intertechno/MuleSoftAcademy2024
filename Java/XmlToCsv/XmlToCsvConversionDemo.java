import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;

public class XmlToCsvConversionDemo {
    
    public static void main(String[] args) {
        try {
            // Specify the XML file path
            File inputFile = new File("Persons.xml");

            // Initialize XML Document Builder
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Normalize the XML structure
            doc.getDocumentElement().normalize();

            // Extract all person elements
            NodeList nodeList = doc.getElementsByTagName("person");

            // Specify the CSV file path
            FileWriter csvWriter = new FileWriter("Persons.csv");

            // Write CSV header
            csvWriter.append("Name,Address,Phone\n");

            // Iterate through each person node and extract details
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    // Extract name, address, and phone
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();
                    String phone = element.getElementsByTagName("phone").item(0).getTextContent();
                    
                    // Write data to CSV
                    csvWriter.append(name).append(",");
                    csvWriter.append("\"" + address + "\"").append(",");
                    csvWriter.append(phone).append("\n");
                }
            }

            // Close CSV writer
            csvWriter.flush();
            csvWriter.close();

            System.out.println("Data successfully written to 'Persons.csv'.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
