package br.com.codigocomcafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.codigocomcafe.model.CategoriaModel;
import br.com.codigocomcafe.service.CategoriaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api")
@CrossOrigin(value = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // ------------------- CRIAR CATEGORIA-------------------
    @PostMapping("/categorias")
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoriaModel){
        return categoriaService.criarCategoria(categoriaModel);

    }
    // ------------------- LISTAR TODAS CATEGORIAS  -------------------
     @GetMapping("/categorias")
    public ResponseEntity<Iterable<CategoriaModel>> listarTodasCategorias() {
        return categoriaService.listarTodasCategorias();
    }
    
    // ------------------- BUSCAR CATEGORIA POR ID -------------------
    @GetMapping("/categoria/{id}")
    public ResponseEntity<CategoriaModel> buscarPorIdCategoria(@PathVariable Long id) {
        return categoriaService.buscarPorIdCategoria(id);
    }
     // ------------------- ATUALIZAR CATEGORIA -------------------
     @PutMapping("/categorias/{id}")
    public ResponseEntity<CategoriaModel> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoriaModel){
        return categoriaService.atualizarCategoria(id, categoriaModel);
    }
    
}
