package org.example.dao;

import org.example.entities.Prestito;
import org.example.entities.Utente;

import javax.persistence.EntityManager;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    //METODI
    public void save(Prestito p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }
    public Prestito getById(long id){
        return em.find(Prestito.class,id);
    }
}
