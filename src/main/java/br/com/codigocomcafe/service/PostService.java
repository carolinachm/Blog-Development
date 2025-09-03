package br.com.codigocomcafe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.codigocomcafe.model.PostModel;
import br.com.codigocomcafe.repository.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    // ----------------- CRIAR POST -----------------
    public ResponseEntity<PostModel> criarPost(PostModel postModel) {
        return new ResponseEntity<>(postRepository.save(postModel), HttpStatus.CREATED);
    }

    // ----------------- LISTAR TODOS OS POST -----------------
    public ResponseEntity<Iterable<PostModel>> listarPosts() {
        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

   
    // ----------------- BUSCAR POR ID -----------------
    public ResponseEntity<PostModel> buscarPostPorID(Long id) {
        Optional<PostModel> postOpt = postRepository.findById(id);

        if (postOpt.isPresent()) {
            return new ResponseEntity<>(postOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ----------------- Atualizar Post -----------------
    public ResponseEntity<PostModel> atualizarPost(Long id, PostModel postModel) {
        // Obter o registro contido na tabela
        Optional<PostModel> postOpt = postRepository.findById(id);

        // Condicional
        if(postOpt.isPresent()){
            postModel.setId(id);
            return new ResponseEntity<>(this.postRepository.save(postModel), HttpStatus.OK);
        }

        // Caso o código não exista
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /// ----------------- Deletar Post -----------------
    public ResponseEntity<Void> deletarPost(Long id) {
        // Verificar a existência do código
        boolean existeCodigo = this.postRepository.existsById(id);
        if (existeCodigo) {
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
