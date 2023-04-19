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
public class Groupe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomGroupe;
    /*@ManyToMany(mappedBy = "groupes")
    @JsonIgnore
    private Set<Niveau> niveaux = new HashSet<>();*/
    @OneToMany(targetEntity = Classe.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "groupe_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<Classe> classes = new HashSet<>();
}
