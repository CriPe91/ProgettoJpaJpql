package org.example.dao;

import org.example.entities.CatalogoBibliotecario;
import org.example.entities.Utente;

import javax.persistence.EntityManager;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    //METODI
    public void save(Utente u) {
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();
    }
    public Utente getById(long id){
        return em.find(Utente.class,id);
    }
}
