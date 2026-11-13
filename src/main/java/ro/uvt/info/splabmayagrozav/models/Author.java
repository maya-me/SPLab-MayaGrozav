package ro.uvt.info.splabmayagrozav.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue
    private Integer id;
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

    public Integer getId() {
        return id;
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
