package com.test.demo.Controller;

import com.test.demo.Model.Etudiant;
import com.test.demo.Service.Etudiant.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@CrossOrigin
public class EtudiantController {
    @Autowired
    private EtudiantService etudiantService;
    @PostMapping("/add")
    public String add(@RequestBody Etudiant etudiant){
        etudiantService.saveEtudiant(etudiant);
        return "Nouveau Etudiant ajouté";
    }
    @GetMapping("/getAll")
    public List<Etudiant> getAll(){
        return etudiantService.getEtudiants();
    }
    @PutMapping("/{etudiantId}/classe/{classeId}")
    public void assignClasseToEtudiant(
            @PathVariable int etudiantId,
            @PathVariable int classeId
    ){
        etudiantService.assignClasseToEtudiant(etudiantId,classeId);
    }
    @PostMapping("/login/{email}/{pass}")
    public Etudiant login(
            @PathVariable String email,
            @PathVariable String pass
    ){
        return etudiantService.login(email,pass);
    }
    @PostMapping("/{etudiantId}/logout")
    public String logout(
            @PathVariable int etudiantId
    ){
        etudiantService.logout(etudiantId);
        return "Disconnected";
    }
}
