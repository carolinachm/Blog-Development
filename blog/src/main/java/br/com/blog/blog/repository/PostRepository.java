package br.com.blog.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.blog.model.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long>{
     // Aqui você pode adicionar métodos personalizados se quiser, mas por enquanto
    // o CrudRepository já nos dá:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - count()
    // e outros!
    
}
