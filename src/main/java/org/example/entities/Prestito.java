package org.example.entities;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "prestiti")

public class Prestito {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @ManyToMany
    @JoinTable(name = "catalogo_prestiti",
            joinColumns = @JoinColumn(name = "catalogo_id"),
            inverseJoinColumns = @JoinColumn(name = "prestito_id")
    )
    private List<CatalogoBibliotecario> elementoPrestato;

    @Column(nullable = false)
    private LocalDate dataInizioPrestito;
    @Column(nullable = false)
    private LocalDate dataRestituzionePrevista;
    @Column(nullable = true)
    private LocalDate dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, List<CatalogoBibliotecario> elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<CatalogoBibliotecario> getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(List<CatalogoBibliotecario> elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
