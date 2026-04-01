package br.edu.ifsp.nicoly.aula4.controller;

import br.edu.ifsp.nicoly.aula4.model.Post;
import br.edu.ifsp.nicoly.aula4.service.PostService; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService service;

    // GET /posts
    @GetMapping
    public List<Post> listar() {
        return service.findAll();
    }

    // GET /posts/{id}
    @GetMapping("/{id}")
    public Post buscar(@PathVariable Long id) {
        return service.findById(id);
    }

    // POST /posts
    @PostMapping
    public Post criar(@RequestBody Post post) {
        return service.create(post);
    }

    // PUT /posts/{id}
    @PutMapping("/{id}")
    public Post atualizar(@PathVariable Long id, @RequestBody Post post) {
        return service.update(id, post);
    }

    // DELETE /posts/{id}
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.delete(id);
    }
}