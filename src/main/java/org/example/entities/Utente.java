package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utenti")

public class Utente {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(nullable = false)
    private LocalDate dataNascita;
    @Column(nullable = false,unique = true)
    private String numeroTessera;

    @OneToMany(mappedBy = "utente")
    private List<Prestito> listaPrestiti;

    public Utente() {}

    public Utente(String nome, String cognome, LocalDate dataNascita, String numeroTessera) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroTessera = numeroTessera;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNumeroTessera() {
        return numeroTessera;
    }

    public void setNumeroTessera(String numeroTessera) {
        this.numeroTessera = numeroTessera;
    }

    public List<Prestito> getListaPrestiti() {
        return listaPrestiti;
    }

    public void setListaPrestiti(List<Prestito> listaPrestiti) {
        this.listaPrestiti = listaPrestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataNascita=" + dataNascita +
                ", numeroTessera='" + numeroTessera + '\'' +
                ", listaPrestiti=" + listaPrestiti +
                '}';
    }
}
