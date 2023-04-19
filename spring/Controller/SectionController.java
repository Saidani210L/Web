package com.test.demo.Controller;

import com.test.demo.Model.Section;
import com.test.demo.Service.Matiere.MatiereService;
import com.test.demo.Service.Niveau.NiveauService;
import com.test.demo.Service.Section.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sections")
@CrossOrigin
public class SectionController {
    @Autowired
    private SectionService sectionService;
    @Autowired
    private NiveauService niveauService;
    @Autowired
    private MatiereService matiereService;
    @PostMapping("/add")
    public String add(@RequestBody Section section){
        sectionService.saveSection(section);
        return "Nouvelle section ajoutée";
    }
    @GetMapping("/getAll")
    public List<Section> getAll(){
        return sectionService.getSections();
    }
    @PatchMapping("/{sectionId}/update")
    public void updateSection(
            @PathVariable int sectionId,
            @RequestBody Section section
    ){
        sectionService.updateSection(sectionId, section);
    }
    /*@PutMapping("/{sectionId}/matiere/{matiereId}")
    public void assignMatiereToSection(
            @PathVariable int sectionId,
            @PathVariable int matiereId
    ){
        sectionService.assignMatiereToSection(sectionId,matiereId);
    }*/



    /*@PatchMapping("/{sectionId}/matiere/{matiereId}/update")
    public void updateMatiere(
            @RequestBody Matiere matiere,
            @PathVariable int sectionId,
            @PathVariable int matiereId
    ){
        sectionService.updateMatiere(sectionId,matiereId,matiere);
    }
    @PatchMapping("/{sectionId}/matiere/add")
    public void ajouterMatiere(
            @RequestBody Matiere matiere,
            @PathVariable int sectionId
    ){
        matiereService.saveMatiere(matiere);
        sectionService.ajouterMatiere(sectionId, matiere);
    }*/
}
