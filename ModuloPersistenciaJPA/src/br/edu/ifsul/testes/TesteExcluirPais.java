package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author PC
 */

public class TesteExcluirPais {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModuloPersistenciaPU");
        EntityManager em = emf.createEntityManager();
        
        Pais p = em.find(Pais.class, 3);
        
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
