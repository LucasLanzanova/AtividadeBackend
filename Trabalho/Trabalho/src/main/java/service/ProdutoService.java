package com.example.gerenciadorprodutos.service;

import com.example.gerenciadorprodutos.model.Produto;
import com.example.gerenciadorprodutos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoDetalhes) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoDetalhes.getNome());
            produto.setPreco(produtoDetalhes.getPreco());
            return produtoRepository.save(produto);
        }).orElse(null);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}

