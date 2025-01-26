package org.example.entities;
import javax.persistence.*;



@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)


public abstract class CatalogoBibliotecario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codiceIsbn;

    @Column(nullable = false)
    private String titolo;
    @Column(nullable = false)
    private int annoPubblicazione;
    @Column(nullable = false)
    private int numeroPagine;

    public CatalogoBibliotecario() {}

    public CatalogoBibliotecario(String titolo, int annoPublicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPublicazione;
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
        return annoPubblicazione;
    }

    public void setAnnoPublicazione(int annoPublicazione) {
        this.annoPubblicazione = annoPublicazione;
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
                ", annoPublicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
