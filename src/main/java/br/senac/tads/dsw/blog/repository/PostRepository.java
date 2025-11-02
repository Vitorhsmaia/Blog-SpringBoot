package br.senac.tads.dsw.blog.repository;


import br.senac.tads.dsw.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
  // Buscar por título contendo (para a tela de busca)
  List<Post> findByTitleContainingIgnoreCase(String title);

  // Buscar por autor
  List<Post> findByAuthorIgnoreCase(String author);

  // Buscar por data exata
  List<Post> findByPublishDate(LocalDate date);

  // Buscar autores distintos para popular dropdown
  @Query("SELECT DISTINCT p.author FROM Post p")
  List<String> findDistinctAuthors();
}

