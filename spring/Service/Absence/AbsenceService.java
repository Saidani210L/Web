package com.test.demo.Service.Absence;

import com.test.demo.Model.Absence;

import java.util.List;

public interface AbsenceService {
    public Absence saveAbsence(Absence absence);
    public List<Absence> getAbsences();
    public void assignMatiereToAbsence(int absenceId, int matiereId);
    public void assignEtudiantToAbsence(int absenceId, int etudiantId);
    public void addAbsence(int absenceId);
    public List<Absence> getAbsencesByEtudiantId(int etudiantId);
}
