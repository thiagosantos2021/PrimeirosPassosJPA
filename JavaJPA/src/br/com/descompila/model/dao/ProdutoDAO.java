package br.com.descompila.model.dao;

import br.com.descompila.connection.ConnectionFactory;
import br.com.descompila.model.bean.Produto;
import javax.persistence.EntityManager;

/**
 * @author PC
 */

public class ProdutoDAO {
    public Produto Save(Produto produto){
        EntityManager em = new ConnectionFactory().getConnection();
        try {
            em.getTransaction().begin();
                if(produto.getId() == null){
                    em.persist(produto);
                }else{
                    em.merge(produto);
                }
            em.getTransaction().commit();    
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            em.close();
        }
        return produto;
    }
}
