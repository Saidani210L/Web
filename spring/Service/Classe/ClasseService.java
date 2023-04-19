package com.test.demo.Service.Classe;

import com.test.demo.Model.Classe;

import java.util.List;

public interface ClasseService {
    public Classe saveClasse(Classe classe);
    public List<Classe> getClasses();
    public void assignSectionToClasse(int classeId, int sectionId);
    public void assignNiveauToClasse(int classeId, int niveauId);
    public void assignGroupeToClasse(int classeId, int groupeId);
}
