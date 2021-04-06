package process;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.stream.IntStream;

import static process.ColorProps.COLORS_XML_TAG;
import static process.ColorProps.PROPERTY_CURSOR_BORDER;

public class ColorProcess implements Process {

    private static final String XML_BOOLEAN_TRUE = "True";

    public static void manageProperties(Document document) {
        Node colors = document.getElementsByTagName(COLORS_XML_TAG).item(0);

        NodeList list = colors.getChildNodes();

        IntStream.range(0, list.getLength())
            .mapToObj(list::item)
            .forEach(node -> {
                if (PROPERTY_CURSOR_BORDER.equals(node.getNodeName())) {
                    node.setTextContent(XML_BOOLEAN_TRUE);
                }
            });
    }
}
