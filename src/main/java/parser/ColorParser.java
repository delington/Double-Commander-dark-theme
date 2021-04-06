package parser;

import model.Color;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class ColorParser implements Parser {

    public void execute() throws URISyntaxException {

        JAXBContext jaxbContext;

        File file = getFileFromResource("Colors.xml");
        try {
            jaxbContext = JAXBContext.newInstance(Color.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Color color = (Color) jaxbUnmarshaller.unmarshal(file);

            System.out.println(color);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }

    private File getFileFromResource(String fileName) throws URISyntaxException {

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            return new File(resource.toURI());
        }
    }
}
