package br.edu.unifio.ecommerce.repositorios;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.unifio.ecommerce.entidades.Cliente;
import br.edu.unifio.ecommerce.entidades.ItemPedido;
import br.edu.unifio.ecommerce.entidades.Pedido;
import br.edu.unifio.ecommerce.entidades.Produto;

@SpringBootTest
public class ItemPedidoRepositorioTests {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ItemPedidoRepositorio itemPedidoRepositorio;

    @Autowired
    private PedidoRepositorio pedidoRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    @Test
    public void deveSalvarUmItemPedidoNovo() {

        var cliente = new Cliente();

        cliente.setNome("Cliente Teste");
        cliente.setEmail("cliente@email.com");
        cliente.setTelefone("14999999999");

        clienteRepositorio.save(cliente);


        var pedido = new Pedido();

        pedido.setData(LocalDateTime.now());
        pedido.setStatus("PENDENTE");
        pedido.setValorTotal(new BigDecimal("500.00"));
        pedido.setCliente(cliente);

        pedidoRepositorio.save(pedido);


        var itemPedido = new ItemPedido();

        itemPedido.setQuantidade(2);
        itemPedido.setValorUnitario(new BigDecimal("100.00"));

        Produto produto = produtoRepositorio.findById(1).orElseThrow();

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);

        itemPedidoRepositorio.save(itemPedido);
    }
}