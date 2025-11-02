// Funções para abrir dropdown de autores e preencher o campo autor quando clicado
document.addEventListener('DOMContentLoaded', function() {
  // formulário (tela form)
  const authorsBtn = document.getElementById('authors-btn');
  const authorsList = document.getElementById('authors-list');

  if (authorsBtn && authorsList) {
    authorsBtn.addEventListener('click', function() {
      authorsList.style.display = authorsList.style.display === 'none' ? 'block' : 'none';
    });
  }

  // tela de busca
  const authorsBtnSearch = document.getElementById('authors-btn-search');
  const authorsListSearch = document.getElementById('authors-list-search');
  if (authorsBtnSearch && authorsListSearch) {
    authorsBtnSearch.addEventListener('click', function() {
      authorsListSearch.style.display = authorsListSearch.style.display === 'none' ? 'block' : 'none';
    });
  }
});

// Função chamada pelos links do dropdown (inseridos via Thymeleaf)
function selectAuthor(event, author) {
  event.preventDefault();
  document.getElementById('author').value = author;
  document.getElementById('authors-list').style.display = 'none';
}
function selectAuthorSearch(event, author) {
  event.preventDefault();
  document.getElementById('author').value = author;
  document.getElementById('authors-list-search').style.display = 'none';
}
