import fr.ecole3il.rodez2023.Modele;
import org.junit.jupiter.api.Test;


/**
 * Cette classe contient des tests pour la classe Modele.
 */
public class ModeleTest {

    /**
     * Test de la méthode getDefinition de la classe Modele.
     * Cette méthode vérifie si la méthode getDefinition retourne correctement la définition du mot "agenda".
     */
    @Test
    public void getDefinitionTest() {
        Modele modele = new Modele();
        modele.chargerMotsDepuisFichier("mots.txt");
        String mot = "agenda";
        System.out.println(modele.getDefinition(mot));
    }

    /**
     * Test de la méthode getMot de la classe Modele.
     * Cette méthode vérifie si la méthode getMot retourne correctement le mot "agenda".
     */
    @Test
    public void getMotTest() {
        Modele modele = new Modele();
        modele.chargerMotsDepuisFichier("mots.txt");
        String motAttendu = "agenda";
        String motObtenu = modele.getMot(motAttendu);
        System.out.println(modele.getDefinition(motAttendu));
    }
}
