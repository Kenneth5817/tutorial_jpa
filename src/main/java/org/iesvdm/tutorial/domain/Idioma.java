package org.iesvdm.tutorial.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.iesvdm.tutorial.serializer.PeliculaSerializer;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id", scope = Idioma.class)
public class Idioma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String nombre;
    private LocalDateTime ultima_actualizacion;


    @OneToMany(mappedBy = "idioma", fetch = FetchType.EAGER)
    //@JsonIgnore
    //@JsonManagedReference
    private Set<Pelicula> peliculas = new HashSet<>();


    @OneToMany(mappedBy = "idioma")
    //@JsonIgnore
    //@JsonManagedReference
    private Set<Pelicula> peliculasIdiomaOriginal = new HashSet<>();

    public <E> Idioma(int i, String inglés, HashSet<E> es) {
    }
}
