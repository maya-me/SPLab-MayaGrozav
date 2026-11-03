package ro.uvt.info.splabmayagrozav.models;

public class Author {
    private String name;
    private String surname;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void print() {
        if (surname == null || surname.isEmpty()) {
            System.out.println("Author: " + name);
        } else {
            System.out.println("Author: " + name + " " + surname);
        }
    }
}
