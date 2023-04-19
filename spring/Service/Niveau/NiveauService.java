package com.test.demo.Service.Niveau;

import com.test.demo.Model.Niveau;

import java.util.List;

public interface NiveauService {
    public Niveau saveNiveau(Niveau niveau);
    public List<Niveau> getNiveaux();
    public void updateNiveau(int niveauId, Niveau niveau);
}
