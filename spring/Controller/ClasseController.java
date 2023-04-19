package com.test.demo.Controller;

import com.test.demo.Model.Classe;
import com.test.demo.Service.Classe.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
@CrossOrigin
public class ClasseController {
    @Autowired
    private ClasseService classeService;
    @PostMapping("/add")
    public String add(@RequestBody Classe classe){
        classeService.saveClasse(classe);
        return "Nouveau classe ajouté";
    }
    @GetMapping("/getAll")
    public List<Classe> getAll(){
        return classeService.getClasses();
    }
    @PutMapping("/{classeId}/section/{sectionId}")
    public void assignSectionToClasse(
            @PathVariable int classeId,
            @PathVariable int sectionId
    ){
        classeService.assignSectionToClasse(classeId,sectionId);
    }
    @PutMapping("/{classeId}/niveau/{niveauId}")
    public void assignNiveauToClasse(
            @PathVariable int classeId,
            @PathVariable int niveauId
    ){
        classeService.assignNiveauToClasse(classeId,niveauId);
    }
    @PutMapping("/{classeId}/groupe/{groupeId}")
    public void assignGroupeToClasse(
            @PathVariable int classeId,
            @PathVariable int groupeId
    ){
        classeService.assignGroupeToClasse(classeId,groupeId);
    }
}
