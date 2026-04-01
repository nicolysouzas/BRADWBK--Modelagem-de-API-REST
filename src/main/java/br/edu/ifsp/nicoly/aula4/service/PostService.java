package br.edu.ifsp.nicoly.aula4.service;

import br.edu.ifsp.nicoly.aula4.model.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private List<Post> posts = new ArrayList<>();
    private Long nextId = 1L;

    // LISTAR
    public List<Post> findAll() {
        return posts;
    }

    // BUSCAR POR ID
    public Post findById(Long id) {
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
    }

    // CRIAR
    public Post create(Post post) {
        post.setId(nextId++);
        posts.add(post);
        return post;
    }

    // ATUALIZAR
    public Post update(Long id, Post updatedPost) {
        Post post = findById(id);
        post.setTitulo(updatedPost.getTitulo());
        post.setConteudo(updatedPost.getConteudo());
        post.setDataCriacao(updatedPost.getDataCriacao());
        return post;
    }

    // DELETAR
    public void delete(Long id) {
        Post post = findById(id);
        posts.remove(post);
    }
}