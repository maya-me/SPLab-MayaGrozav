package ro.uvt.info.splabmayagrozav.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseElement extends Element {
    @Id
    @GeneratedValue
    private Integer id;

    public BaseElement() {
    }

    public Integer getId() {
        return id;
    }

    @Override
    public void print() {
    }

    @Override
    public void accept(Visitor visitor) {
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
