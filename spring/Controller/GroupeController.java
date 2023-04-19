package com.test.demo.Controller;

import com.test.demo.Model.Groupe;
import com.test.demo.Model.Niveau;
import com.test.demo.Service.Groupe.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groupes")
@CrossOrigin
public class GroupeController {
    @Autowired
    private GroupeService groupeService;
    @PostMapping("/add")
    public String add(@RequestBody Groupe groupe){
        groupeService.saveGroupe(groupe);
        return "Nouveau groupe ajouté";
    }
    @GetMapping("/getAll")
    public List<Groupe> getAll(){
        return groupeService.getGroupes();
    }
    @PatchMapping("/{groupeId}/update")
    public void updateGroupe(
            @PathVariable int groupeId,
            @RequestBody Groupe groupe
    ){
        groupeService.updateGroupe(groupeId, groupe);
    }
}
