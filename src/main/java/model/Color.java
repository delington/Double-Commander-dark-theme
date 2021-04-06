package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Colors")
public class Color {

    private boolean useCursorBorder;

    @XmlElement
    public boolean isUseCursorBorder() {
        return useCursorBorder;
    }

    public void setUseCursorBorder(boolean useCursorBorder) {
        this.useCursorBorder = useCursorBorder;
    }
}
