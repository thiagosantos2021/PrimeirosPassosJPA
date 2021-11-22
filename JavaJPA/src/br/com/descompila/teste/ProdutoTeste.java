package br.com.descompila.teste;

import br.com.descompila.model.bean.Categoria;
import br.com.descompila.model.bean.Produto;
import br.com.descompila.model.dao.ProdutoDAO;

/**
 * @author PC
 */

public class ProdutoTeste {
    
    public static void main(String[] args) {
        
        ProdutoDAO dao = new ProdutoDAO();
        
        Categoria categoria = new Categoria();
        categoria.setId(3);
        
        Produto produto = new Produto();
        produto.setId(1);
        produto.setDescricao("Arroz");
        produto.setQtd(5);
        produto.setValor(5.00);
        produto.setCategoria(categoria);
        
        dao.Save(produto);
    }
}
