package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author PC
 */

public class TesteAlterarPais {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloPersistenciaPU");
        EntityManager em = emf.createEntityManager();
        
        Pais p = em.find(Pais.class, 2);
        p.setNome("Bolívia");
        p.setIso("BOL");
        
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
