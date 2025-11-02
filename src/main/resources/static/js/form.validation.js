// Validação simples no cliente — evita submissão com campos vazios
document.addEventListener('DOMContentLoaded', function() {
  const form = document.getElementById('postForm');
  if (!form) return;

  form.addEventListener('submit', function(e) {
    // limpar mensagens antigas
    document.querySelectorAll('.error').forEach(el => { el.textContent = ''; });

    let hasError = false;
    const title = document.getElementById('title').value.trim();
    const content = document.getElementById('content').value.trim();
    const author = document.getElementById('author').value.trim();

    if (!title) {
      document.getElementById('error-title').textContent = 'Título é obrigatório';
      hasError = true;
    }
    if (!content) {
      document.getElementById('error-content').textContent = 'Conteúdo é obrigatório';
      hasError = true;
    }
    if (!author) {
      document.getElementById('error-author').textContent = 'Autor é obrigatório';
      hasError = true;
    }

    if (hasError) {
      // impede envio ao servidor
      e.preventDefault();
      return false;
    }
  });
});
