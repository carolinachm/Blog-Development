package br.com.codigocomcafe.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_post")
@AllArgsConstructor
@NoArgsConstructor
public class PostModel {

    //Atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String  conteudo;
    private String  autor;
    private String imagem;
    private String video;
    // Agora usando LocalDate
    private LocalDate dataCriacao;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoriaModel;
    
}
