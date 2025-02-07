package org.iesvdm.tutorial.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
public class PeliculaCategoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @ManyToOne
    private Categoria categoria;

    @ManyToOne
    private Pelicula pelicula;


    //2 one to many
}
