# CodeJourney Blog 🚀

Bem-vindo ao **CodeJourney Blog**! Este projeto é um blog pessoal desenvolvido para documentar meus estudos e experiências em **testes de software** e **desenvolvimento de software**. O sistema foi construído com **Java**, **Spring Boot** e **PostgreSQL**, e inclui funcionalidades básicas de CRUD para posts, comentários, usuários e categorias.

---

## 🛠️ Tecnologias Utilizadas

- **Backend**: Java, Spring Boot
- **Banco de Dados**: PostgreSQL
- **Testes**: JUnit
- **Ferramentas Futuras**:
  - k6 (testes de performance)
  - SonarQube (análise de código)
  - Grafana (monitoramento)

---

## 🚀 Funcionalidades

O **CodeJourney Blog** inclui as seguintes funcionalidades:

### Posts
- Criação, edição, exclusão e visualização de posts.
- Cada post pode ter uma imagem associada.
- Relacionamento com categorias e usuários.

### Comentários
- Criação, edição, exclusão e visualização de comentários.
- Relacionamento com posts e usuários.

### Usuários
- Criação, edição, exclusão e visualização de usuários.
- Autenticação e autorização com Spring Security.

### Categorias
- Criação, edição, exclusão e visualização de categorias.
- Organização de posts por temas.

### Pesquisa
- Pesquisa de posts por título, conteúdo ou categoria.

### Upload de Imagens
- Upload de imagens para posts.

### Autenticação e Autorização
- Login e logout de usuários.
- Controle de acesso baseado em roles (USER, ADMIN).

---

## 📦 Instalação e Configuração

Siga os passos abaixo para configurar e executar o projeto localmente.

### Pré-requisitos
- Java 17 ou superior.
- PostgreSQL instalado e configurado.
- Maven instalado.

### Passos para Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/codejourney-blog.git
   cd codejourney-blog
   ```

   Configure o banco de dados:
Configure o banco de dados:

2. Crie um banco de dados no PostgreSQL.

Atualize as configurações no arquivo application.properties:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```


3.Execute o projeto:
```bash
./mvnw spring-boot:run
```

4.Acesse a API:

O servidor estará disponível em http://localhost:8080.

## 🧪 Testes
Para executar os testes unitários, use o seguinte comando:
```bash
./mvnw test
```


## 🛠️ Melhorias Futuras
Implementar testes de performance com k6.

Integrar com SonarQube para análise de código.

Configurar monitoramento com Grafana e Prometheus.

Adicionar internacionalização (i18n) para suporte a múltiplos idiomas.

## 🤝 Como Contribuir
Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1.Faça um fork do projeto.

2.Crie uma nova branch:
```bash
git checkout -b feature/nova-feature
```

3. Commit suas alterações:
```bash
git commit -m "Adiciona nova feature"
```

4. Faça push para a branch:
```bash
git push origin feature/nova-feature
```

5. Abra um Pull Request.
## 📜 Licença
Este projeto está licenciado sob a Licença MIT. Veja o arquivo LICENSE para mais detalhes.
## 📞 Contato
Se tiver dúvidas ou sugestões, sinta-se à vontade para entrar em contato:

Nome: [Seu Nome]

E-mail: [seu-email@exemplo.com]

GitHub: seu-usuario

Feito com ❤️ por [Seu Nome] 🚀


---

### Como Usar
1. Substitua os placeholders (ex: `seu-usuario`, `seu-email@exemplo.com`, `Seu Nome`) pelas suas informações.
2. Adicione o arquivo `README.md` na raiz do seu repositório no GitHub.
3. Atualize o conteúdo conforme necessário para refletir as mudanças no projeto.

Se precisar de mais ajustes ou informações adicionais, é só me avisar! 😊

