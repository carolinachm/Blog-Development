package br.com.codigocomcafe.model;

import java.util.List;

import br.com.codigocomcafe.enumerador.TipoCategoria;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_categoria")
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoCategoria tipoCategoria;
    private String descricao;

    @OneToMany(mappedBy = "categoriaModel")
    private List<PostModel> posts;
}
