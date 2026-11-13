package ro.uvt.info.splabmayagrozav.models;

import jakarta.persistence.Entity;

@Entity
@jakarta.persistence.Table(name = "TableElement")
public class Table extends BaseElement {
    private String title;

    public Table() {
    }

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
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
