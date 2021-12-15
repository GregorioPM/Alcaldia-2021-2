package com.web.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "alcaldes")
@Data
public class Alcalde {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombres;
    private String apellidos;
    private String descripcion;

    /*@OneToOne(mappedBy = "alcaldeDatos")
    private Alcaldia alcaldia;*/

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_alcaldia",referencedColumnName = "id_alcaldia")
    //@JsonIgnore
    private Alcaldia alcaldia;
    /*@OneToOne
    private Foto foto;*/
}
