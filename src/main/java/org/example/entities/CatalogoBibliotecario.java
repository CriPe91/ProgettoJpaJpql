package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class CatalogoBibliotecario {
    @Id
    @GeneratedValue
    private long codiceIsbn;

    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private int annoPublicazione;
    @Column(nullable = false)
    private int numeroPagine;

    @ManyToMany(mappedBy = "elementoPrestato")
    private Set<Prestito> prestiti;

    public CatalogoBibliotecario() {}

    public CatalogoBibliotecario(String titolo, int annoPublicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numeroPagine = numeroPagine;
    }

    public long getCodiceIsbn() {
        return codiceIsbn;
    }

    public void setCodiceIsbn(long codiceIsbn) {
        this.codiceIsbn = codiceIsbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPublicazione = annoPublicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }


    @Override
    public String toString() {
        return "CatalogoBibliotecario{" +
                "codiceIsbn=" + codiceIsbn +
                ", titolo='" + titolo + '\'' +
                ", annoPublicazione=" + annoPublicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
