package br.com.blog.blog.model;

import java.sql.Blob;
import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_post")
public class PostModel {

    //Atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String  conteudo;
    private String  autor;
    private Blob imagem;
    private Blob video;
    private Date dataCriacao;
    
}
