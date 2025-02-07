package org.iesvdm.tutorial.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(length = 30, nullable = false)
    private String nombre;

    private LocalDateTime ultima_actualizacion;
    //@ManyToMany(mappedBy = "categorias")
    //private Set<Pelicula>peliculas;

    @OneToMany(mappedBy = "categoria")
    private Set<PeliculaCategoria> peliculaCategorias;
}
