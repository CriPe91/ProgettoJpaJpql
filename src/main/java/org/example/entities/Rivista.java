package org.example.entities;

import org.example.enumeration.TipoPeriodicita;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "riviste")

public class Rivista extends CatalogoBibliotecario{

@Enumerated(EnumType.STRING)
    private TipoPeriodicita periodicita;

    public Rivista() {}

    public Rivista(String titolo, int annoPublicazione, int numeroPagine, TipoPeriodicita periodicita) {
        super(titolo, annoPublicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public TipoPeriodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(TipoPeriodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Rivista{" +
                ", periodicita=" + periodicita +
                '}';
    }
}
