package br.com.codigocomcafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.codigocomcafe.model.PostModel;
import br.com.codigocomcafe.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // Criar novo post
    public ResponseEntity<PostModel> criarPost(PostModel post) {
        PostModel salvo = postRepository.save(post);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    // Listar todos os posts
    public ResponseEntity<Iterable<PostModel>> listarPosts() {
        List<PostModel> posts = postRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    // Buscar post por ID
    public ResponseEntity<PostModel> buscarPorId(Long id) {
        Optional<PostModel> post = postRepository.findById(id);
        return post.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Atualizar post
    public ResponseEntity<PostModel> atualizarPost(PostModel postModel) {
        if(!postRepository.existsById(postModel.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        PostModel atualizado = postRepository.save(postModel);
        return new ResponseEntity<>(atualizado, HttpStatus.OK);
    }

    // Deletar post
    public ResponseEntity<Void> deletarPost(Long id) {
        if (postRepository.existsById(id)) {
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
