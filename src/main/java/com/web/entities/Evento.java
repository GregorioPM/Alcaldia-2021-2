package com.web.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    private String categoria;
    @Column(name = "fecha_evento")
    @Temporal(TemporalType.DATE)
    private Date fechaEvento;

    //bi-directional many-to-one association to Alcaldia
    @ManyToOne
    @JoinColumn(name="alcaldia_id")
    @JsonBackReference
    private Alcaldia alcaldia;
}
