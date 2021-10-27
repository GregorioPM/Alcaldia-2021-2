package com.web.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_evento")
    private int id;
    private String titulo;
    private String descripcion;
    @Column(name = "fecha_evento")
    private Date fechaEvento;

    //bi-directional many-to-one association to Alcaldia
    @ManyToOne
    @JoinColumn(name="alcaldia_id")
    @JsonIgnore
    private Alcaldia alcaldia;
}
