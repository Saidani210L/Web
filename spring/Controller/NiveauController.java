package com.test.demo.Controller;

import com.test.demo.Model.Niveau;
import com.test.demo.Model.Section;
import com.test.demo.Service.Niveau.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/niveaux")
@CrossOrigin
public class NiveauController {
    @Autowired
    private NiveauService niveauService;
    @PostMapping("/add")
    public String add(@RequestBody Niveau niveau){
        niveauService.saveNiveau(niveau);
        return "Nouveau niveau ajouté";
    }
    @GetMapping("/getAll")
    public List<Niveau> getAll(){
        return niveauService.getNiveaux();
    }
    @PatchMapping("/{niveauId}/update")
    public void updateNiveau(
            @PathVariable int niveauId,
            @RequestBody Niveau niveau
    ){
        niveauService.updateNiveau(niveauId, niveau);
    }
}
