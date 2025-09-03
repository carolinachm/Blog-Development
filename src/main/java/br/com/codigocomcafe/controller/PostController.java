package br.com.codigocomcafe.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import br.com.codigocomcafe.model.CategoriaModel;
import br.com.codigocomcafe.model.PostModel;
import br.com.codigocomcafe.repository.CategoriaRepository;
import br.com.codigocomcafe.service.PostService;
import br.com.codigocomcafe.service.UploadService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // ------------------- CRIAR -------------------
    @PostMapping(value = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PostModel> cadastraPost(
            @RequestParam String titulo,
            @RequestParam String conteudo,
            @RequestParam String autor,
            @RequestParam Date dataCriacao,
            @RequestParam Long categoriaId,
            @RequestParam("imagem") MultipartFile imagemFile,
            @RequestParam("video") MultipartFile videoFile) {

        try {
            // Upload da imagem e do vídeo
            String caminhoImagem = uploadService.armazenarArquivo(imagemFile);
            String caminhoVideo = uploadService.armazenarArquivo(videoFile);

            // Buscar categoria pelo id
            CategoriaModel categoria = categoriaRepository.findById(categoriaId);

            // Monta objeto Post
            PostModel postModel = new PostModel();
            postModel.setTitulo(titulo);
            postModel.setConteudo(conteudo);
            postModel.setAutor(autor);
            postModel.setImagem(caminhoImagem);
            postModel.setVideo(caminhoVideo);
            postModel.setDataCriacao(dataCriacao);
            postModel.setCategoriaModel(categoria);

            PostModel salvo = postService.criarPost(postModel);

            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // ------------------- LISTAR TODOS -------------------
    @GetMapping("/posts")
    public ResponseEntity<Iterable<PostModel>> listar() {
        return postService.listarPosts();
    }

    // ------------------- LISTAR POR ID -------------------
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostModel> buscarPorId(@PathVariable Long id) {
        return postService.buscarPorId(id);
    }

    // ------------------- ATUALIZAR -------------------
    @PutMapping("/posts/{id}")
    public ResponseEntity<PostModel> atualizarPost(@PathVariable Long id, @RequestBody PostModel postModel) {
        postModel.setId(id);
        return postService.atualizarPost(postModel);
    }

    // ------------------- EXCLUIR -------------------
    @Operation(summary = "Deletar post por ID")
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletarPost(@PathVariable Long id) {
        return postService.deletarPost(id);
    }
}
