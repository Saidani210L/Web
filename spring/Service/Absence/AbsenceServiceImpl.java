package com.test.demo.Service.Absence;

import com.test.demo.Model.Absence;
import com.test.demo.Model.Etudiant;
import com.test.demo.Model.Matiere;
import com.test.demo.Repository.AbsenceRepository;
import com.test.demo.Repository.EtudiantRepository;
import com.test.demo.Repository.MatiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AbsenceServiceImpl implements AbsenceService{
    @Autowired
    private AbsenceRepository absenceRepository;
    @Autowired
    private MatiereRepository matiereRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Override
    public Absence saveAbsence(Absence absence){
        return absenceRepository.save(absence);
    }
    @Override
    public List<Absence> getAbsences(){
        return absenceRepository.findAll();
    }
    @Override
    public void assignMatiereToAbsence(int absenceId, int matiereId){
        Absence absence = absenceRepository.findById(absenceId).get();
        Matiere matiere = matiereRepository.findById(matiereId).get();
        absence.setMatiere(matiere);
        absenceRepository.save(absence);
    }
    @Override
    public void assignEtudiantToAbsence(int absenceId, int etudiantId){
        Absence absence = absenceRepository.findById(absenceId).get();
        Etudiant etudiant = etudiantRepository.findById(etudiantId).get();
        absence.setEtudiant(etudiant);
        absenceRepository.save(absence);
    }
    @Override
    public void addAbsence(int absenceId){
        Absence absence = absenceRepository.findById(absenceId).get();
        absence.setNbAbsence(absence.getNbAbsence() + 1);
        absenceRepository.save(absence);
    }
    @Override
    public List<Absence> getAbsencesByEtudiantId(int etudiantId){
        List<Absence> list = new ArrayList<>();
        List<Absence> absences = absenceRepository.findAll();
        for (Absence abs:absences) {
            if (abs.getEtudiant().getId()==etudiantId){
                list.add(abs);
            }
        }
        return list;
    }
}
