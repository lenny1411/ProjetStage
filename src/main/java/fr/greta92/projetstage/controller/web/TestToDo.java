package fr.greta92.projetstage.controller.web;

import fr.greta92.projetstage.entity.Candidat;
import fr.greta92.projetstage.entity.PassageTest;
import fr.greta92.projetstage.entity.Status;
import fr.greta92.projetstage.repository.CandidatRepo;
import fr.greta92.projetstage.service.GestionPassageTest;
import fr.greta92.projetstage.service.GestionUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class TestToDo {

    @Autowired
    private GestionUtilisateur gestionUtilisateur;
    @Autowired
    private GestionPassageTest gestionPassageTest;

    @GetMapping("/TestToDo")
    public String testToDo(Model model, Principal principal)
    {
        try {
            Candidat candidat = gestionUtilisateur.getCandidat(principal.getName());
            List<PassageTest> passageTests = gestionPassageTest.getAllPassageTestFromCandidat(candidat, Status.TODO);
            model.addAttribute("candidat", candidat);
            model.addAttribute("passageTests", passageTests);
            return "testTodo";

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return "redirect:/Connexion";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/Connexion";
        }

    }
}
