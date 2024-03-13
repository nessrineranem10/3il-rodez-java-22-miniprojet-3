import fr.ecole3il.rodez2023.Modele;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ModeleTest {
    @Test
    public void getDefinitionTest() {
        Modele modele = new Modele();
        modele.chargerMotsDepuisFichier("mots.txt");
        String mot = "agenda";
        System.out.println(modele.getDefinition(mot));
    }

    @Test
    public void getMotTest() {
        Modele modele = new Modele();
        modele.chargerMotsDepuisFichier("mots.txt");
        String motAttendu = "agenda";
        String motObtenu = modele.getMot(motAttendu);
        System.out.println(modele.getDefinition(motAttendu));
    }
}