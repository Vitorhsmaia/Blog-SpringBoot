Este é um projeto de blog simples desenvolvido em Java com Spring Boot (MVC) e banco de dados H2, com foco em aprendizado de arquitetura web MVC, validação de formulários, persistência de dados e uso do Thymeleaf para renderização das páginas HTML.

O sistema permite criar, listar, excluir e buscar publicações, com três telas principais e validações tanto no front-end (JavaScript) quanto no back-end (Spring Validation).

🧩 Funcionalidades

Tela 1 – Cadastro de Publicações

Campos: título, texto, data da publicação e autor.

Botões:

Salvar – grava os dados no banco.

Lista – abre a tela de listagem.

Validações:

Campos obrigatórios com alerta visual se deixados em branco.

Dropdown de autores já cadastrados (carregado do banco via Thymeleaf).

Tela 2 – Lista de Publicações

Exibe todas as postagens cadastradas.

Botões:

Excluir – remove uma publicação.

Voltar – retorna à tela de cadastro.

Buscar – vai para a tela de busca.

Tela 3 – Buscar Publicações

Busca por título, autor ou data da publicação.

Dropdown de autores cadastrados para busca rápida.

Exibe os resultados encontrados com título, autor, data e conteúdo.

🛠️ Tecnologias Utilizadas

Java 21

Spring Boot 3 (Spring MVC, Spring Data JPA, Validation)

Banco de dados H2 (em memória)

Thymeleaf (template engine)

Acesse:

Formulário: http://localhost:8080/

Lista: http://localhost:8080/posts

Buscar: http://localhost:8080/search

H2 Console: http://localhost:8080/h2-console (URL JDBC: jdbc:h2:mem:blogdb)

Maven (gerenciador de dependências)
