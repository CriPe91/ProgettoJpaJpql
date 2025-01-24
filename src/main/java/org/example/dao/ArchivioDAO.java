package org.example.dao;

import org.example.entities.CatalogoBibliotecario;

import javax.persistence.EntityManager;

public class ArchivioDAO {

    private EntityManager em;

    public ArchivioDAO(EntityManager em) {
        this.em = em;
    }

    //METODI

    public void save(CatalogoBibliotecario c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }


}
