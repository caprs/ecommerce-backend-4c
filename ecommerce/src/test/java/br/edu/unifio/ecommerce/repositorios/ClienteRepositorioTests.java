package br.edu.unifio.ecommerce.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import br.edu.unifio.ecommerce.entidades.Cliente;

@SpringBootTest 
public class ClienteRepositorioTests {
    
    @Autowired 
    private ClienteRepositorio clienteRepositorio;

    @Test 
    public void deveSalvarUmClienteNovo(){
        var cliente = new Cliente();

        cliente.setNome("Ana");
        cliente.setEmail("capriolianalivia7@gmail.com");
        cliente.setTelefone("14991717754");

        clienteRepositorio.save(cliente);
    }
}
