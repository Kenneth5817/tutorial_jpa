package org.iesvdm.tutorial.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.*;
import org.iesvdm.tutorial.enums.ClasificacionEnum;
import org.iesvdm.tutorial.serializer.PeliculaSerializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Pelicula.class)
@JsonSerialize(using = PeliculaSerializer.class)
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String titulo;

    private String descripcion;
    private Integer anyoLanzamiento;

    @ManyToOne
    @ToString.Exclude
    private Idioma idiomaOriginal;

    @ManyToOne
    //@JsonBackReference
    @ToString.Exclude
    private Idioma idioma;

    private Integer duracion_alquiler;

    @Column(precision = 4, scale = 2)
    private BigDecimal rental_rate;


    private short duracion;

    @Column(precision = 5, scale=2)
    private BigDecimal replacement_cost;

    private ClasificacionEnum clasificacion;

    @ManyToMany(mappedBy = "peliculas")
    private Set<CaracteristicaEspecial> caracteristicasEspeciales;
    //@ManyToMany
    //private Set<Categoria> categorias;

    @OneToMany(mappedBy = "pelicula")
    private Set<PeliculaCategoria> peliculaCategorias;


    @ManyToMany
    private Set <Actor> actores;
    private LocalDateTime ultimaActualizacion;

    public Pelicula(int i, String pelicula1, Idioma idioma1) {
    }


}
