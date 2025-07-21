package br.com.LucasCrippa.Market.services;

import br.com.LucasCrippa.Market.entities.Produto;
import br.com.LucasCrippa.Market.entities.enums.TipoProduto;
import br.com.LucasCrippa.Market.repositories.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProdutoServiceTest {


    @Mock
    private ProdutoRepository produtoRepository;

    @InjectMocks
     private  ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void findAllRetornaListaProdutos() {

        Produto produto = new Produto(1L, "Perfume", TipoProduto.PERFUME, 12.56);
        Produto produto2 = new Produto(2L, "Shampoo", TipoProduto.PRODUTOSCAPILARES, 15.00);

        when(produtoRepository.findAll()).thenReturn(Arrays.asList(produto, produto2));

        List<Produto> produtos = produtoService.findAll();

        assertEquals(2, produtos.size());
        verify(produtoRepository, times(1)).findAll();

    }

    @Test
    void findById_DeveRetornarUsuario() {

        Produto produto = new Produto(1L, "Perfume", TipoProduto.PERFUME, 12.56);
        Produto produto2 = new Produto(2L, "Shampoo", TipoProduto.PRODUTOSCAPILARES, 15.00);
        Produto produto3 = new Produto(3L, "Hidratante", TipoProduto.HIDRATANTES, 30.00);

        when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto));

        Produto resultado = produtoService.findById(1l);

        assertEquals("Perfume", resultado.getProduto());
        verify(produtoRepository, times(1)).findById(1L);



    }
}