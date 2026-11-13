package ro.uvt.info.splabmayagrozav.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.util.concurrent.TimeUnit;

@Entity
public class Image extends BaseElement {
    private String url;
    @Transient
    private ImageContent content;

    public Image() {
    }

    public Image(String url) {
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ImageContent content() {
        return content;
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + url);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException();
    }
}
