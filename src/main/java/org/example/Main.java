package org.example;

import org.example.dao.ArchivioDAO;
import org.example.entities.CatalogoBibliotecario;
import org.example.entities.Libro;
import org.example.entities.Rivista;
import org.example.enumeration.TipoPeriodicita;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


/**
 * Hello world!
 *
 */
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("progettoMavenPersistenza");
    private static EntityManager em = emf.createEntityManager();

    public static void main( String[] args ) {

        ArchivioDAO archivioDao = new ArchivioDAO(em);


        CatalogoBibliotecario L1 = new Libro("Il piccolo principe",1943,100,"Antoine de Saint-Exsuperi","bambini");
        archivioDao.save(L1);
        CatalogoBibliotecario R1 = new Rivista("Chi",2025,30, TipoPeriodicita.SETTIMANALE);

    }
}
