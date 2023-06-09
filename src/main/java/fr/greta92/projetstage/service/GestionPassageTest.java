package fr.greta92.projetstage.service;

import fr.greta92.projetstage.entity.Candidat;
import fr.greta92.projetstage.entity.PassageTest;
import fr.greta92.projetstage.entity.Status;
import fr.greta92.projetstage.entity.TestResponse;
import fr.greta92.projetstage.exception.PassageTestDejaExistantException;
import fr.greta92.projetstage.exception.PassageTestNonExistantException;
import fr.greta92.projetstage.exception.PassageTestTooEarlyException;
import fr.greta92.projetstage.exception.PassageTestTooLateException;

import java.util.List;

public interface GestionPassageTest {
    public PassageTest getPassageTest(Long id);
    public List<PassageTest> getAllPassageTest(Status status);
    public List<PassageTest> getAllPassageTestFromCandidat(Candidat candidat);
    List<PassageTest> getAllPassageTestFromCandidat(Candidat candidat, Status status);
    public List<PassageTest> getAllPassageTest();
    public void ajouterPassageTest(PassageTest passageTest) throws PassageTestDejaExistantException;
    public void modifierPassageTest(PassageTest passageTest) throws PassageTestNonExistantException;
    public void supprimerTest(PassageTest passageTest);
    public void lancerPassageTest(Long testId) throws PassageTestTooEarlyException, PassageTestTooLateException;
    public void verifierPassageTest(TestResponse testResponse) throws PassageTestTooLateException;
    public void annulerPassageTest(PassageTest passageTest);
}
