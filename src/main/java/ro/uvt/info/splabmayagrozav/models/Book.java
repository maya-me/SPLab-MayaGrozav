package ro.uvt.info.splabmayagrozav.models;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : elements) {
            element.accept(visitor);
        }
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author author : authors) {
            author.print();
        }
        for (Element element : elements) {
            element.print();
        }
    }
}
