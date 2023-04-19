package com.test.demo.Service.Etudiant;

import com.test.demo.Model.Etudiant;

import java.util.List;

public interface EtudiantService {
    public Etudiant saveEtudiant(Etudiant etudiant);
    public List<Etudiant> getEtudiants();
    public void assignClasseToEtudiant(int etudiantId, int classeId);
    public Etudiant login(String email, String password);
    public void logout(int etudiantId);
    //public void updateEtudiant(int etudiantId, Etudiant etudiant);
}
