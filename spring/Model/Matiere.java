package com.test.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomMatiere;
    @ManyToOne(fetch = FetchType.EAGER)
    private Section section;
    @ManyToOne(fetch = FetchType.EAGER)
    private Niveau niveau;
    @OneToMany(mappedBy = "matiere")
    @JsonIgnore
    private Set<Absence> absences;
    private int semestre;


    /*@ManyToMany(mappedBy = "matieres")
    @JsonIgnore
    private Set<Section> sections = new HashSet<>();*/
    /*@ManyToMany
    @JoinTable(name = "Matiere_Niveau",
            joinColumns = @JoinColumn(name = "Matiere_id"),
            inverseJoinColumns = @JoinColumn(name = "Niveau_id")
    )
    private Set<Niveau> niveaux = new HashSet<>();*/


    /*@OneToMany(targetEntity = Matieres.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "matiere_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<Matiere> matieres = new HashSet<>();*/

}
