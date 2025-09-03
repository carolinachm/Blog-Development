package br.com.codigocomcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.codigocomcafe.model.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>{
     // Aqui você pode adicionar métodos personalizados se quiser, mas por enquanto
    // o CrudRepository já nos dá:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // - count()
    // e outros!
    
}
