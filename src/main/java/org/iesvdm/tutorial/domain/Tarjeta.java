package org.iesvdm.tutorial.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    private String numero;
    private LocalDate fechaCaducidad;

    @OneToOne
    @JoinColumn(name = "socio___id", referencedColumnName = "id")
    private Socio socio;

}