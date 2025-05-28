package br.com.blog.blog.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.blog.blog.model.PostModel;

@Repository
public interface PostRepository extends CrudRepository<PostModel, Long>{
    
}
