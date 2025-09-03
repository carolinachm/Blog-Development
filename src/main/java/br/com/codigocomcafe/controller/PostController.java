package br.com.codigocomcafe.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // ------------------- CRIAR -------------------
    @PostMapping(value = "/posts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PostModel> cadastraPost(
        @RequestParam String titulo,
        @RequestParam String conteudo,
        @RequestParam String autor,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataCriacao,
        @RequestParam Long categoriaId,
        @RequestParam("imagem") MultipartFile imagemFile,
        @RequestParam("video") MultipartFile videoFile) {


        try {
            // Upload da imagem e do vídeo
            String caminhoImagem = uploadService.armazenarArquivo(imagemFile);
            String caminhoVideo = uploadService.armazenarArquivo(videoFile);

            // Buscar categoria pelo id
            Optional<CategoriaModel> categoriaOpt = categoriaRepository.findById(categoriaId);
            if(!categoriaOpt.isPresent()){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            CategoriaModel categoriaModel = categoriaOpt.get();

            // Monta objeto Post
            PostModel postModel = new PostModel();
            postModel.setTitulo(titulo);
            postModel.setConteudo(conteudo);
            postModel.setAutor(autor);
            postModel.setImagem(caminhoImagem);
            postModel.setVideo(caminhoVideo);
            postModel.setDataCriacao(dataCriacao);
            postModel.setCategoriaModel(categoriaModel);

            

            return postService.criarPost(postModel);
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
    public ResponseEntity<PostModel> buscarPostPorrId(@PathVariable Long id) {
        return postService.buscarPostPorID(id);
    }

    // ------------------- ATUALIZAR -------------------
    @PutMapping("/posts/{id}")
    public ResponseEntity<PostModel> atualizarPost(@PathVariable Long id, @RequestBody PostModel postModel) {
        postModel.setId(id);
        return postService.atualizarPost(id, postModel);
    }

    // ------------------- EXCLUIR -------------------
    @Operation(summary = "Deletar post por ID")
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Void> deletarPost(@PathVariable Long id) {
        return postService.deletarPost(id);
    }
}
