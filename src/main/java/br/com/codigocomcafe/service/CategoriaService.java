package br.com.codigocomcafe.service;

import br.com.codigocomcafe.model.CategoriaModel;
import br.com.codigocomcafe.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // ----------------- CRIAR CATEGORIA -----------------
    public ResponseEntity<CategoriaModel> criarCategoria(CategoriaModel categoria) {
        CategoriaModel salvo = categoriaRepository.save(categoria);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    // ----------------- LISTAR TODAS -----------------
    public ResponseEntity<List<CategoriaModel>> listarCategorias() {
        List<CategoriaModel> categorias = categoriaRepository.findAll();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    // ----------------- BUSCAR POR ID -----------------
    public ResponseEntity<CategoriaModel> buscarPorId(Long id) {
        Optional<CategoriaModel> categoria = categoriaRepository.findById(id);
        return categoria.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // ----------------- ATUALIZAR CATEGORIA -----------------
    public ResponseEntity<CategoriaModel> atualizarCategoria( CategoriaModel categoriaModel) {
        if(!categoriaRepository.existsById(categoriaModel.getId())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CategoriaModel atualizado = categoriaRepository.save(categoriaModel);
        return new ResponseEntity<>(atualizado,HttpStatus.OK);
    }

    // ----------------- DELETAR CATEGORIA -----------------
    public ResponseEntity<Void> deletarCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
