package br.senac.tads.dsw.blog.controller;


import br.senac.tads.dsw.blog.model.Post;
import br.senac.tads.dsw.blog.repository.PostRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BlogController {

  @Autowired
  private PostRepository postRepository;

  // 1) Mostrar formulário (Tela 1)
  @GetMapping("/")
  public String showForm(Post post, Model model) {
    // adiciona lista de autores para usar no formulário se desejar
    model.addAttribute("authors", postRepository.findDistinctAuthors());
    return "form";
  }

  // 2) Salvar postagem (POST) -> validação servidor
  @PostMapping("/save")
  public String savePost(@Valid Post post, BindingResult result, Model model,
                         @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate publishDate) {
    // se campos obrigatórios estiverem vazios, volta para form mostrando erros
    if (result.hasErrors()) {
      model.addAttribute("authors", postRepository.findDistinctAuthors());
      return "form";
    }
    // se data não informada, seta data atual
    if (post.getPublishDate() == null) {
      post.setPublishDate(LocalDate.now());
    }
    postRepository.save(post);
    return "redirect:/posts";
  }

  // 3) Tela de lista (Tela 2)
  @GetMapping("/posts")
  public String listPosts(Model model) {
    List<Post> posts = postRepository.findAll();
    model.addAttribute("posts", posts);
    return "list";
  }

  // 4) Deletar publicação
  @GetMapping("/delete/{id}")
  public String deletePost(@PathVariable("id") Long id) {
    postRepository.deleteById(id);
    return "redirect:/posts";
  }

  // 5) Tela buscar (Tela 3)
  @GetMapping("/search")
  public String showSearch(Model model) {
    model.addAttribute("authors", postRepository.findDistinctAuthors());
    return "search";
  }

  // 6) Processar busca por título, autor ou data
  @PostMapping("/search")
  public String doSearch(@RequestParam(required = false) String title,
                         @RequestParam(required = false) String author,
                         @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                         Model model) {
    List<Post> results = List.of();

    if (author != null && !author.isBlank()) {
      results = postRepository.findByAuthorIgnoreCase(author);
    } else if (title != null && !title.isBlank()) {
      results = postRepository.findByTitleContainingIgnoreCase(title);
    } else if (date != null) {
      results = postRepository.findByPublishDate(date);
    }

    model.addAttribute("results", results);
    model.addAttribute("authors", postRepository.findDistinctAuthors());
    return "search";
  }
}

