/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.descompila.teste;

import br.com.descompila.model.bean.Categoria;
import br.com.descompila.model.dao.CategoriaDAO;

/**
 * @author PC
 */

public class CategoriaTeste {
    public static void main(String[] args) {    
        CategoriaDAO dao = new CategoriaDAO();
        dao.Remove(4);
    }
}
