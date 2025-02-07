package org.iesvdm.tutorial.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PeliculaActor {

    @Id
    @EqualsAndHashCode.Include
    private Integer id_actor;
    private Integer id_pelicula;
    private LocalDateTime ultima_actualizacion;

    //MAny to many
}
