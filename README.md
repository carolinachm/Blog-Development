# 📚 Blog API - Spring Boot + PostgreSQL

### API RESTful de um Blog, desenvolvida com Spring Boot e PostgreSQL, que permite:

#### ✍️ Cadastro de autor(a)

🗓️ Data de criação

🖼️ Upload de imagem

🎥 Upload de vídeo

📝 Conteúdo textual

Imagens e vídeos são armazenados diretamente no banco como BLOB (BYTEA no PostgreSQL).

#### 🚀 Tecnologias

Java 17

Spring Boot

Spring Data JPA

PostgreSQL

Lombok

Maven

Swagger (OpenAPI)

Spring Validation

#### 🏗️ Estrutura do Projeto

``` bash
src/

└── main/

├── java/

│   └── com/

│       └── seuprojeto/

│           └── blog/

│               ├── controller/

│               ├── dto/

│               ├── model/

│               ├── repository/

│               ├── service/

│               └── BlogApplication.java

└── resources/

├── application.properties

└── static/
```
#### ⚙️ Configuração

Configure o arquivo application.properties:

properties

``` bash

spring.datasource.url=jdbc:postgresql://localhost:5432/blog\_db

spring.datasource.username=seu\_usuario

spring.datasource.password=sua\_senha

spring.jpa.hibernate.ddl-auto=update

spring.jpa.show-sql=true

spring.jpa.properties.hibernate.format\_sql=true

spring.servlet.multipart.max-file-size=50MB

spring.servlet.multipart.max-request-size=50MB
```

#### ▶️ Como Rodar

Pré-requisitos

Java 17+

Maven

PostgreSQL rodando

Passos

Clone o projeto:

```bash

git clone https://github.com/seuusuario/blog-api.git
```

#### Acesse o diretório:

```bash

cd blog-api
```

#### Crie o banco no PostgreSQL.

Configure seu application.properties.

Rode o projeto:

```bash

./mvnw spring-boot:run
 ```
#### Acesse o Swagger:

```bash

http://localhost:8080/swagger-ui/index.html
```

#### 🛠️ Endpoints

Método	Endpoint	Descrição

POST	/api/posts	Criar post

GET	/api/posts	Listar posts

GET	/api/posts/{id}	Buscar post por ID

PUT	/api/posts/{id}	Atualizar post

DELETE	/api/posts/{id}	Deletar post

#### Upload de arquivos:

Usar multipart/form-data nos endpoints de criação e atualização para enviar imagem e vídeo.

#### 🗄️ Modelo de Dados (Post)

Campo	Tipo	Descrição

id	Long	Identificador

autor	String	Nome do autor

titulo	String	Título do post

conteudo	String	Conteúdo do post

dataCriacao	LocalDate	Data de criação

imagem	byte[]	Arquivo da imagem

video	byte[]	Arquivo do vídeo

#### 🚀 Funcionalidades

✅ Criar post com upload de imagem e vídeo

✅ Atualizar post

✅ Listar posts

✅ Buscar post por ID

✅ Excluir post

✅ Documentação da API via Swagger

# 🐍 Melhorias Futuras

#### 🔒 Autenticação com JWT

#### ☁️ Armazenamento de mídia em nuvem (S3, Azure Blob)

#### 🔍 Filtros, paginação e ordenação

#### 🧪 Testes unitários e integração

#### 🚀 Deploy na nuvem (Render, Railway, Heroku)

## 🤝 Contribuição

Fork o projeto

Crie uma branch (git checkout -b feature/minha-feature)

Commit (git commit -m 'Minha feature')

Push (git push origin feature/minha-feature)

Abra um Pull Request

#### 📜 Licença

Este projeto está licenciado sob a licença MIT. Veja o arquivo LICENSE para mais informações.

#### 👨‍💻 Autor

Desenvolvido por Carolina Mesquita com 💙


