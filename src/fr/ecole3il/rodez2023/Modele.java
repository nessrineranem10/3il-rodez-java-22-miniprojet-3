package fr.ecole3il.rodez2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    private ArrayList<String> chargerMotsDepuisFichier(String filename) {
        ArrayList<String> mots = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                mots.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return mots;
    }

    /**
     * Initialise une nouvelle partie du jeu.
     */
    public void initialiserJeu() {
        // Choisir un mot aléatoire
        Random rand = new Random();
        motADeviner = mots.get(rand.nextInt(mots.size()));
        motCache = motADeviner.replaceAll("[a-zA-Z]", "_");

        // Initialiser le nombre de tentatives restantes
        tentativesRestantes = 7;

        // Initialiser les lettres déjà proposées
        lettresProposees = new ArrayList<>();
    }

    /**
     * Propose une lettre pour le jeu.
     *
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

