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
public class Niveau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomNiveau;
    /*@ManyToMany(mappedBy = "niveaux")
    @JsonIgnore
    private Set<Matiere> Matieres = new HashSet<>();*/
    /*@ManyToMany
    @JoinTable(name = "Niveau_Groupe",
            joinColumns = @JoinColumn(name = "Niveau_id"),
            inverseJoinColumns = @JoinColumn(name = "Groupe_id")
    )
    private Set<Groupe> groupes = new HashSet<>();*/
    @OneToMany(targetEntity = Classe.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "niveau_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<Classe> classes = new HashSet<>();
    @OneToMany(targetEntity = Matiere.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "niveau_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<Matiere> matieres = new HashSet<>();
}
