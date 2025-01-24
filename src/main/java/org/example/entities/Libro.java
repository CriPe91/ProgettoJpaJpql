package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "libri")

public class Libro extends CatalogoBibliotecario{

    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)
    private String genere;

    public Libro() {}

    public Libro(String titolo, int annoPublicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPublicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }



    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                ", autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
