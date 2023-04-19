package com.test.demo.Service.Etudiant;

import com.test.demo.Model.Classe;
import com.test.demo.Model.Etudiant;
import com.test.demo.Repository.ClasseRepository;
import com.test.demo.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService{
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ClasseRepository classeRepository;
    @Override
    public Etudiant saveEtudiant(Etudiant etudiant){
        etudiant.setConnected(false);
        return etudiantRepository.save(etudiant);
    }
    @Override
    public List<Etudiant> getEtudiants(){
        return etudiantRepository.findAll();
    }
    @Override
    public void assignClasseToEtudiant(int etudiantId, int classeId){
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        Classe classe = classeRepository.findById(classeId).get();
        etudiant.setClasse(classe);
        etudiantRepository.save(etudiant);
    }
    @Override
    public void logout(int etudiantId){
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        etudiant.setConnected(false);
        etudiantRepository.save(etudiant);
    }
    @Override
    public Etudiant login(String email, String password) {
        List<Etudiant> etudiants = etudiantRepository.findAll();
        for (Etudiant etudiant : etudiants) {
            if (password.equals(etudiant.getMotDePasse()) && email.equals(etudiant.getEmail())) {
                etudiant.setConnected(true);
                etudiantRepository.save(etudiant);
                return etudiant;
            }
        }
        return null;
    }
    /*@Override
    public void updateEtudiant(int etudiantId, Etudiant etudiant){
        Etudiant e = etudiantRepository.findById(etudiantId).get();
        e.setNom(etudiant.getNom());
        e.setEmail(etudiant.getEmail());
        e.setPrenom(etudiant.getPrenom());
    }*/
}
