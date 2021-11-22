/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package br.com.descompila.model.dao;

import br.com.descompila.connection.ConnectionFactory;
import br.com.descompila.model.bean.Categoria;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author PC
 */

public class CategoriaDAO {
    public Categoria Save(Categoria categoria){
        EntityManager em = new ConnectionFactory().getConnection();
        
        try{
            em.getTransaction().begin();
            if(categoria == null){
              em.persist(categoria); //persistindo no banco de dados  
            }else{
               em.merge(categoria);
            }
            
            em.getTransaction().commit();
        }catch(Exception e){
            System.err.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        return categoria;
    }
    
    public Categoria findById(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Categoria categoria = null;
        
        try {
            categoria = em.find(Categoria.class, id);
        } catch (Exception e) {
            System.err.println(e);
        }finally{
            em.close();
        }
        return categoria;
    }
    
    public List<Categoria> findAll(){
        EntityManager em = new ConnectionFactory().getConnection();
        List<Categoria> categorias = null;
        try {
            categorias = em.createQuery("from Categoria c").getResultList();
        } catch (Exception e) {
            System.err.println(e);
        }finally{
           em.close();
        }
        return categorias;
    }
    
    public Categoria Remove(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Categoria categoria = null;
        try {
                categoria = em.find(Categoria.class, id);
                em.getTransaction().begin();
                em.remove(categoria);
                em.getTransaction().commit();
                
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
            
        }finally{
            em.close();
        }
        return categoria;
    }
}
