package com.test.demo.Service.Section;

import com.test.demo.Model.Section;
import com.test.demo.Repository.MatiereRepository;
import com.test.demo.Repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService{
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private MatiereRepository matiereRepository;
    @Override
    public Section saveSection(Section section){
        return sectionRepository.save(section);
    }
    @Override
    public List<Section> getSections(){
        return sectionRepository.findAll();
    }
    @Override
    public void updateSection(int sectionId, Section section){
        Section sec = sectionRepository.findById(sectionId).get();
        sec.setNomSection(section.getNomSection());
        sectionRepository.save(sec);
    }
    @Override
    public void deleteSection(int SectionId){

    }
    /*@Override
    public void assignMatiereToSection(int sectionId, int matiereId){
        Section section = sectionRepository.findById(sectionId).get();
        Matiere matiere = matiereRepository.findById(matiereId).get();
        Set<Matiere> matiereSet = section.getMatieres();
        matiereSet.add(matiere);
        section.setMatieres(matiereSet);
        sectionRepository.save(section);
    }*/
    /*@Override
    public void ajouterMatiere(int sectionId, Matiere matiere){
        Section section = sectionRepository.findById(sectionId).get();
        Set<Matiere> matiereSet = section.getMatieres();
        matiereSet.add(matiere);
        section.setMatieres(matiereSet);
        sectionRepository.save(section);
    }
    @Override
    public void updateMatiere(int sectionId, int matiereId, Matiere mat){
        Section section = sectionRepository.findById(sectionId).get();
        Set<Matiere> matiereSet = section.getMatieres();
        matiereSet.forEach(element -> {
            if(element.getId() == matiereId){
                element.setNiveaux(mat.getNiveaux());
                element.setNomMatiere(mat.getNomMatiere());
                element.setSemestre(mat.getSemestre());
            }
        });
        section.setMatieres(matiereSet);
        sectionRepository.save(section);
    }*/
}
