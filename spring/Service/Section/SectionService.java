package com.test.demo.Service.Section;

import com.test.demo.Model.Section;

import java.util.List;

public interface SectionService {
    public Section saveSection(Section section);
    public List<Section> getSections();
    //public void assignMatiereToSection(int sectionId, int matiereId);
    public void updateSection(int sectionId, Section section);
    public void deleteSection(int SectionId);
    //public void ajouterMatiere(int sectionId, Matiere matiere);
}
