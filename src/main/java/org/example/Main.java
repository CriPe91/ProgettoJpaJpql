package org.example;

import com.github.javafaker.Faker;
import org.example.dao.ArchivioDAO;
import org.example.dao.PrestitoDAO;
import org.example.dao.UtenteDAO;
import org.example.entities.*;
import org.example.enumeration.TipoPeriodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * Hello world!
 *
 */
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoMavenPersistenza");
    private static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {

        ArchivioDAO archivioDao = new ArchivioDAO(em);
        UtenteDAO utenteDao = new UtenteDAO(em);
        PrestitoDAO prestitoDao = new PrestitoDAO(em);

        Faker faker = new Faker(Locale.ITALY);

        //LIBRI E RIVISTE

        CatalogoBibliotecario L1 = new Libro("Pinco panco",1987,150,"Pierino","adulti");
        CatalogoBibliotecario R1 = new Rivista("Cioe",2023,38, TipoPeriodicita.SETTIMANALE);
        CatalogoBibliotecario L2 = new Libro(faker.book().title(),1995,350,faker.book().author(),faker.book().genre());
        CatalogoBibliotecario R2 = new Rivista(faker.book().title(),2024,35,TipoPeriodicita.SEMESTRALE);


//        //UTENTI

        Utente U1 = new Utente(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1986,05,17),"OP123");
        Utente U2 = new Utente(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1993,04,30),"QR345");
        Utente U3 = new Utente(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1989,06,9),"ST567");
//        utenteDao.save(U1);
//        utenteDao.save(U2);
//        utenteDao.save(U3);


//        //PRESTITI

        LocalDate dataInizioPrestito = LocalDate.now();

        List<CatalogoBibliotecario> elementoPrestato = new ArrayList<>();
        elementoPrestato.add(archivioDao.getById(2));
        Prestito P1 = new Prestito(utenteDao.getById(3),elementoPrestato,dataInizioPrestito,dataInizioPrestito.plusDays(30),null);
//        prestitoDao.save(P1);

          //AGGIUNTA ELEMENTO
//        archivioDao.aggiungiElementoCatalogo(L1);
//        archivioDao.aggiungiElementoCatalogo(L2);
//        archivioDao.aggiungiElementoCatalogo(R1);
//        archivioDao.aggiungiElementoCatalogo(R2);

          //RIMUOZIONE PER ISBN
//        archivioDao.rimuoviElementoPerISBN(2L);

          //RICERCA PER ISBN
//        System.out.println(archivioDao.ricercaPerISBN(1L));

          //RICERCA PER ANNO DI PUBBLICAZIONE
//        System.out.println(archivioDao.ricercaPerAnnoPubblicazione(2024));

          //RICERCA PER AUTORE
//        System.out.println(archivioDao.ricercaPerAutore("Pierino"));

          //RICERCA PER TITOLO
//        System.out.println(archivioDao.ricercaPerTitolo("Now"));

          //RICERCA ELEMENTI PER TESSERA
//        System.out.println(archivioDao.ricercaElementiInPrestitoPerTessera("OP123"));

          //RICERCA PRESTITI SCADUTI NON RESTITUITI
//        System.out.println(archivioDao.ricercaPrestitiScadutiNonRestituiti());

        em.close();
        emf.close();
    }
}
