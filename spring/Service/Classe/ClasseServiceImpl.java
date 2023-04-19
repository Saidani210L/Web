package com.test.demo.Service.Classe;

import com.test.demo.Model.Classe;
import com.test.demo.Model.Groupe;
import com.test.demo.Model.Niveau;
import com.test.demo.Model.Section;
import com.test.demo.Repository.ClasseRepository;
import com.test.demo.Repository.GroupeRepository;
import com.test.demo.Repository.NiveauRepository;
import com.test.demo.Repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseServiceImpl implements ClasseService{
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private NiveauRepository niveauRepository;
    @Autowired
    private GroupeRepository groupeRepository;
    @Override
    public Classe saveClasse(Classe classe){
        return classeRepository.save(classe);
    }
    @Override
    public List<Classe> getClasses(){
        return classeRepository.findAll();
    }
    @Override
    public void assignSectionToClasse(int classeId, int sectionId){
        Classe classe = classeRepository.findById(classeId).get();
        Section section = sectionRepository.findById(sectionId).get();
        classe.setSection(section);
        classeRepository.save(classe);
    }
    @Override
    public void assignNiveauToClasse(int classeId, int niveauId){
        Classe classe = classeRepository.findById(classeId).get();
        Niveau niveau = niveauRepository.findById(niveauId).get();
        classe.setNiveau(niveau);
        classeRepository.save(classe);
    }
    @Override
    public void assignGroupeToClasse(int classeId, int groupeId){
        Classe classe = classeRepository.findById(classeId).get();
        Groupe groupe = groupeRepository.findById(groupeId).get();
        classe.setGroupe(groupe);
        classeRepository.save(classe);
    }
}
