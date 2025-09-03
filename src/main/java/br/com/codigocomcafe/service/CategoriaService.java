package br.com.codigocomcafe.service;

import br.com.codigocomcafe.model.CategoriaModel;
import br.com.codigocomcafe.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    // ----------------- LISTAR TODAS CATEGORIAS-----------------
    public ResponseEntity<Iterable<CategoriaModel>> listarTodasCategorias() {
        Iterable<CategoriaModel> categorias = categoriaRepository.findAll();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    // ----------------- BUSCAR POR ID -----------------
    public ResponseEntity<CategoriaModel> buscarPorIdCategoria(Long id) {
        Optional<CategoriaModel> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            return new ResponseEntity<>(categoriaOpt.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ----------------- ATUALIZAR CATEGORIA -----------------
    public ResponseEntity<CategoriaModel> atualizarCategoria(Long id, CategoriaModel categoriaModel) {
        // Obter registro contido na tabela
        Optional<CategoriaModel> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            categoriaModel.setId(id);
            return new ResponseEntity<>(categoriaRepository.save(categoriaModel), HttpStatus.OK);
        }
        // Caso o código não exista
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // ----------------- DELETAR CATEGORIA -----------------
    public ResponseEntity<Void> deletarCategoria(Long id) {
        // Verificar a existência do código
        boolean existeCodigo = categoriaRepository.existsById(id);

        if (existeCodigo) {
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
