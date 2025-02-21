# 📖 HU007 - Upload de Imagens

**Como** um usuário do sistema,\
**Eu quero** poder fazer upload de imagens para os posts,\
**Para que** eu possa enriquecer o conteúdo visual do blog.

**Critérios de Aceitação:**

1. Deve ser possível fazer upload de uma imagem ao criar ou editar um post.
2. A imagem deve ser armazenada em um serviço de armazenamento (ex: AWS S3, Google Cloud Storage) ou no sistema de arquivos local.
3. A URL da imagem deve ser salva no campo `imagem` da entidade `Post`.
4. Deve ser possível visualizar a imagem no post.
