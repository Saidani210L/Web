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
public class Section {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomSection;
    /*@ManyToMany
    @JoinTable(name = "Section_Matiere",
            joinColumns = @JoinColumn(name = "Section_id"),
            inverseJoinColumns = @JoinColumn(name = "Matiere_id")
    )
    private Set<Matiere> matieres = new HashSet<>();*/
    @OneToMany(targetEntity = Classe.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<Classe> classes = new HashSet<>();
    @OneToMany(targetEntity = Matiere.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<Matiere> matieres = new HashSet<>();
}
