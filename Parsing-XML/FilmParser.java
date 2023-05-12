import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class FilmParser {
    public static void main(String[] args) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("movies.xml"));

            BufferedWriter htmlWriter = new BufferedWriter(new FileWriter("movie.html"));

            htmlWriter.write("<html><body><h1>Результаты парсинга</h1>");

            NodeList movieList = document.getElementsByTagName("movie");

            for (int i = 0; i < movieList.getLength(); i++) {
                Element movie = (Element) movieList.item(i);

                String title = movie.getAttribute("title");
                String year = movie.getAttribute("year");
                String director = movie.getAttribute("director");
                String plot = movie.getAttribute("plot");

                htmlWriter.write("<h2>Film " + (i + 1) + "</h2>");
                htmlWriter.write("<p>Title: " + title + "</p>");
                htmlWriter.write("<p>Year: " + year + "</p>");
                htmlWriter.write("<p>Director: " + director + "</p>");
                htmlWriter.write("<p>Plot: " + plot + "</p>");
            }

            htmlWriter.write("</body></html>");
            htmlWriter.close();

            System.out.println("Parsing complete. The results have been saved to movie.html.");
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
