package fr.ecole3il.rodez2023;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Cette classe représente le modèle du jeu du Pendu.
 * Elle contient la logique métier du jeu.
 */
public class Modele {
    private ArrayList<String> mots;
    private String motADeviner;
    private String motCache;
    private int tentativesRestantes;
    private ArrayList<Character> lettresProposees;

    /**
     * Constructeur par défaut de PenduModel.
     * Charge les mots depuis le fichier texte et initialise le jeu.
     */
    public Modele() {
        mots = chargerMotsDepuisFichier("mots.txt");
        initialiserJeu();
    }

    /**
     * Charge les mots depuis un fichier texte.
     * @param filename Le nom du fichier contenant les mots.
     * @return Une liste contenant les mots chargés depuis le fichier.
     */
    public static ArrayList<String> chargerMotsDepuisFichier(String filename) {
        ArrayList<String> mots = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("mots.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                mots.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mots;
    }

    /**
     * Tire aléatoirement une ligne depuis un fichier.
     * @param chemin Le chemin du fichier contenant les lignes.
     * @return Une ligne tirée aléatoirement depuis le fichier.
     */
    public String tirerLigneAleatoirement(String chemin) {
        List<String> lignes = chargerMotsDepuisFichier(chemin);
        int nbLignes = lignes.size();

        int random = (int) (1 + (Math.random() * nbLignes));
        return lignes.get(random - 1);
    }


    /**
     * Obtient le mot à partir d'une ligne.
     * @param lignes La ligne contenant le mot et sa définition.
     * @return Le mot extrait de la ligne.
     */
    public String getMot(String lignes){
        String ligne = tirerLigneAleatoirement(lignes);
        String[] parts = ligne.split(" ");
        return parts[0];
    }

    /**
     * Obtient la définition à partir d'une ligne.
     * @param lignes La ligne contenant le mot et sa définition.
     * @return La définition du mot extrait de la ligne.
     */
    public String getDefinition(String lignes) {
        String ligne = tirerLigneAleatoirement(lignes);
        String[] parts = ligne.split(":");
        if (parts.length >= 2) {
            return parts[1].trim(); // Retourner la définition (la deuxième partie après le séparateur)
        } else {
            return ""; // Si la ligne n'a pas de définition, retourner une chaîne vide ou une autre valeur par défaut
        }
    }

    /**
     * Initialise une nouvelle partie du jeu.
     */
    public void initialiserJeu() {
        // Vérifier si la liste de mots n'est pas vide
        if (!mots.isEmpty()) {
            // Choisir un mot aléatoire
            Random rand = new Random();
            motADeviner = mots.get(rand.nextInt(mots.size()));
            motCache = motADeviner.replaceAll("[a-zA-Z]", "_");

            // Initialiser le nombre de tentatives restantes
            tentativesRestantes = 7;

            // Initialiser les lettres déjà proposées
            lettresProposees = new ArrayList<>();
        } else {
            System.out.println("La liste de mots est vide. Veuillez charger des mots depuis le fichier.");
            // Gérer le cas où la liste de mots est vide
        }
    }


    /**
     * Propose une lettre pour le jeu.
     * @param lettre La lettre proposée.
     * @return Vrai si la lettre est présente dans le mot, faux sinon.
     */
    public boolean proposerLettre(char lettre) {
        lettresProposees.add(lettre);

        // Vérifie si la lettre proposée est dans le mot
        boolean lettreTrouvee = false;
        StringBuilder nouveauMotCache = new StringBuilder();
        for (int i = 0; i < motADeviner.length(); i++) {
            if (motADeviner.charAt(i) == lettre) {
                nouveauMotCache.append(lettre);
                lettreTrouvee = true;
            } else {
                nouveauMotCache.append(motCache.charAt(i));
            }
        }
        // Met à jour le mot caché
        motCache = nouveauMotCache.toString();

        // Si la lettre n'est pas dans le mot, décrémente les tentatives restantes
        if (!lettreTrouvee) {
            tentativesRestantes--;
        }

        return lettreTrouvee;
    }

    /**
     * Vérifie si le joueur a gagné la partie.
     * @return Vrai si le joueur a gagné, faux sinon.
     */
    public boolean estGagne() {
        return motCache.equals(motADeviner);
    }

    /**
     * Vérifie si le joueur a perdu la partie.
     * @return Vrai si le joueur a perdu, faux sinon.
     */
    public boolean estPerdu() {
        return tentativesRestantes <= 0;
    }

    /**
     * Obtient le mot à deviner.
     * @return Le mot à deviner.
     */
    public String getMotADeviner() {
        return motADeviner;
    }

    /**
     * Obtient le mot caché.
     * @return Le mot caché.
     */
    public String getMotCache() {
        return motCache;
    }

    /**
     * Obtient le nombre de tentatives restantes.
     * @return Le nombre de tentatives restantes.
     */
    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    /**
     * Obtient les lettres déjà proposées par le joueur.
     * @return Les lettres déjà proposées.
     */
    public ArrayList<Character> getLettresProposees() {
        return lettresProposees;
    }
}

