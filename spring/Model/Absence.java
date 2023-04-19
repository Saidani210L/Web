package com.test.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere; // ******** should be matieres intstead of matiere ***********
    private int nbAbsence;
}
