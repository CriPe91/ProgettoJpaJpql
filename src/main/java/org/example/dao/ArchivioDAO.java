package org.example.dao;

import org.example.entities.CatalogoBibliotecario;
import org.example.entities.Prestito;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.time.LocalDate;
import java.util.List;

public class ArchivioDAO {

    private EntityManager em;

    public ArchivioDAO(EntityManager em) {
        this.em = em;
    }

    //METODI
//    public void save(CatalogoBibliotecario c) {
//        em.getTransaction().begin();
//        em.persist(c);
//        em.getTransaction().commit();
//    }

    public CatalogoBibliotecario getById(long id){
         return em.find(CatalogoBibliotecario.class, id);
    }

    public void aggiungiElementoCatalogo(CatalogoBibliotecario c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }


    public void rimuoviElementoPerISBN(Long isbn) {
        try {
            CatalogoBibliotecario catalogo = em.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.codiceIsbn = :isbn", CatalogoBibliotecario.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
            em.getTransaction().begin();
            em.remove(catalogo);
            em.getTransaction().commit();
            System.out.println("Elemento rimosso: " + isbn);
        } catch (NoResultException e) {
            System.out.println("Elemento non trovato con ISBN: " + isbn);
        }
    }


    public CatalogoBibliotecario ricercaPerISBN(Long isbn) {
        try {
            return em.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.codiceIsbn = :isbn", CatalogoBibliotecario.class)
                    .setParameter("isbn", isbn)
                    .getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Elemento non trovato con ISBN: " + isbn);
            return null;
        }
    }


    public List<CatalogoBibliotecario> ricercaPerAnnoPubblicazione(int anno) {
        return em.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.annoPubblicazione = :anno", CatalogoBibliotecario.class)
                .setParameter("anno", anno)
                .getResultList();
    }


    public List<CatalogoBibliotecario> ricercaPerAutore(String autore) {
        return em.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.autore = :autore", CatalogoBibliotecario.class)
                .setParameter("autore", autore)
                .getResultList();
    }


    public List<CatalogoBibliotecario> ricercaPerTitolo(String parteTitolo) {
        return em.createQuery("SELECT c FROM CatalogoBibliotecario c WHERE c.titolo LIKE :titolo", CatalogoBibliotecario.class)
                .setParameter("titolo", "%" + parteTitolo + "%")
                .getResultList();
    }


    public List<CatalogoBibliotecario> ricercaElementiInPrestitoPerTessera(String numeroTessera) {
        return em.createQuery(
                        "SELECT c FROM CatalogoBibliotecario c " +
                                "JOIN c.prestiti p " +
                                "JOIN p.utente u " +
                                "WHERE u.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL",
                        CatalogoBibliotecario.class)
                .setParameter("numeroTessera", numeroTessera)
                .getResultList();
    }


    public List<Prestito> ricercaPrestitiScadutiNonRestituiti() {
        LocalDate dataCorrente = LocalDate.now();
        return em.createQuery(
                        "SELECT p FROM Prestito p " +
                                "WHERE p.dataRestituzionePrevista < :dataCorrente AND p.dataRestituzioneEffettiva IS NULL",
                        Prestito.class)
                .setParameter("dataCorrente", dataCorrente)
                .getResultList();
    }



}
