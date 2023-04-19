package com.test.demo.Service.Groupe;

import com.test.demo.Model.Groupe;
import com.test.demo.Model.Niveau;
import com.test.demo.Repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupeServiceImpl implements GroupeService{
    @Autowired
    private GroupeRepository groupeRepository;
    @Override
    public Groupe saveGroupe(Groupe groupe){
        return groupeRepository.save(groupe);
    }
    @Override
    public List<Groupe> getGroupes(){
        return groupeRepository.findAll();
    }
    @Override
    public void updateGroupe(int groupeId, Groupe groupe){
        Groupe group = groupeRepository.findById(groupeId).get();
        group.setNomGroupe(groupe.getNomGroupe());
        groupeRepository.save(group);
    }
}
