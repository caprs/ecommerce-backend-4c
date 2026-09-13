package br.edu.unifio.ecommerce.repositorios;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Produto;
import br.edu.unifio.ecommerce.entidades.Categoria;

@SpringBootTest 

public class ProdutoRepositorioTests {
    @Autowired 
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired 
    private ProdutoRepositorio produtoRepositorio;

    

    public void deveSalvarUmProdutoNovo(){
        var produto = new Produto();
        produto.setNome("Notebook Lenovo Legion 5i");
        produto.setDescricao("Processador I7, Armazenamento SSD de 1TB, Memória 16GB");
        produto.setPreco(new BigDecimal("12570.30"));
        produto.setEstoque(Short.parseShort("10"));


        Categoria categoria = categoriaRepositorio.findById(Short.parseShort("1")).orElseThrow();





    }
}
