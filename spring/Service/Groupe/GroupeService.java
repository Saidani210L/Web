package com.test.demo.Service.Groupe;

import com.test.demo.Model.Groupe;

import java.util.List;

public interface GroupeService {
    public Groupe saveGroupe(Groupe groupe);
    public List<Groupe> getGroupes();
    public void updateGroupe(int groupeId, Groupe groupe);
}
