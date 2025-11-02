package br.senac.tads.dsw.blog.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Título é obrigatório")
  private String title;

  @NotBlank(message = "Conteúdo é obrigatório")
  @Column(columnDefinition = "TEXT")
  private String content;

  // Autor pode ser obrigatório também
  @NotBlank(message = "Autor é obrigatório")
  private String author;

  // Data da publicação; se o usuário não preencher, podemos setar data atual no servidor
  private LocalDate publishDate;

  // getters e setters (omitidos aqui para brevidade; implemente normalmente)
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
  public String getContent() { return content; }
  public void setContent(String content) { this.content = content; }
  public String getAuthor() { return author; }
  public void setAuthor(String author) { this.author = author; }
  public LocalDate getPublishDate() { return publishDate; }
  public void setPublishDate(LocalDate publishDate) { this.publishDate = publishDate; }
}
