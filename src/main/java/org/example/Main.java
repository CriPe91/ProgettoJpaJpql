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
//        archivioDao.save(L1);
        CatalogoBibliotecario R1 = new Rivista("Cioe",2023,38, TipoPeriodicita.SETTIMANALE);
//        archivioDao.save(R1);
        CatalogoBibliotecario L2 = new Libro(faker.book().title(),1995,350,faker.book().author(),faker.book().genre());
 //       archivioDao.save(L2);
        CatalogoBibliotecario R2 = new Rivista(faker.book().title(),2024,35,TipoPeriodicita.SEMESTRALE);
//        archivioDao.save(R2);

        //UTENTI

        Utente U1 = new Utente(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1986,05,17),"OP123");
 //       utenteDao.save(U1);
        Utente U2 = new Utente(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1993,04,30),"QR345");
  //      utenteDao.save(U2);
        Utente U3 = new Utente(faker.name().firstName(),faker.name().lastName(), LocalDate.of(1989,06,9),"ST567");
  //      utenteDao.save(U3);


        //PRESTITI
        LocalDate dataInizioPrestito = LocalDate.now();

        List<CatalogoBibliotecario> elementoPrestato = new ArrayList<>();
        elementoPrestato.add(archivioDao.getById(41));
        Prestito P1 = new Prestito(utenteDao.getById(29),elementoPrestato,dataInizioPrestito,dataInizioPrestito.plusDays(30),null);
//        prestitoDao.save(P1);


        elementoPrestato.add(archivioDao.getById(32));
        Prestito P2 = new Prestito(utenteDao.getById(30),elementoPrestato,dataInizioPrestito,dataInizioPrestito.plusDays(30),null);
//        prestitoDao.save(P2);

        elementoPrestato.add(archivioDao.getById(28));
        Prestito P3 = new Prestito(utenteDao.getById(31),elementoPrestato,dataInizioPrestito,dataInizioPrestito.plusDays(30),LocalDate.of(2025,02,25));
//        prestitoDao.save(P3);


//        archivioDao.aggiungiElementoCatalogo(L1);
//        archivioDao.aggiungiElementoCatalogo(R1);

//        archivioDao.rimuoviElementoPerISBN(27L);
//
//        archivioDao.ricercaPerISBN(25L);
//
//        archivioDao.ricercaPerAnnoPubblicazione(2024);
//
//        archivioDao.ricercaPerAutore("Gianantonio Martinelli");
//
//        archivioDao.ricercaPerTitolo("Il");
//
//        archivioDao.ricercaElementiInPrestitoPerTessera("OP123");
//
//        archivioDao.ricercaPrestitiScadutiNonRestituiti();

        em.close();
        emf.close();
    }
}
