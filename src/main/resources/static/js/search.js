
document.addEventListener('DOMContentLoaded', function () {
  // Toggle dropdown on form page (id authors-btn / authors-list)
  const authorsBtn = document.getElementById('authors-btn');
  const authorsList = document.getElementById('authors-list');

  if (authorsBtn && authorsList) {
    authorsBtn.addEventListener('click', function (e) {
      e.preventDefault();
      authorsList.style.display = (authorsList.style.display === 'block') ? 'none' : 'block';
    });

    // Delegation: se o dropdown tem links, captura clicks neles
    authorsList.addEventListener('click', function (e) {
      const target = e.target;
      if (target && target.matches('[data-author]')) {
        e.preventDefault();
        const author = target.getAttribute('data-author');
        const input = document.getElementById('author');
        if (input) {
          input.value = author;
          authorsList.style.display = 'none';
        }
      }
    });
  }

  // Toggle dropdown on search page (id authors-btn-search / authors-list-search)
  const authorsBtnSearch = document.getElementById('authors-btn-search');
  const authorsListSearch = document.getElementById('authors-list-search');

  if (authorsBtnSearch && authorsListSearch) {
    authorsBtnSearch.addEventListener('click', function (e) {
      e.preventDefault();
      authorsListSearch.style.display = (authorsListSearch.style.display === 'block') ? 'none' : 'block';
    });

    authorsListSearch.addEventListener('click', function (e) {
      const target = e.target;
      if (target && target.matches('[data-author]')) {
        e.preventDefault();
        const author = target.getAttribute('data-author');
        const input = document.getElementById('author');
        if (input) {
          input.value = author;
          authorsListSearch.style.display = 'none';
        }
      }
    });
  }
});
