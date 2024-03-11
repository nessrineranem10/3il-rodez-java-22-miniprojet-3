package fr.ecole3il.rodez2023;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

/**
 * Cette classe représente le jeu du Pendu avec une interface graphique Swing.
 */
public class Pendu extends JFrame {
    private JLabel motLabel, penduLabel, lettresLabel, messageLabel;
    private JTextField lettreField;
    private JButton proposerButton, rejouerButton;
    private ArrayList<String> mots;
    private String motADeviner, motCache;
    private int tentativesRestantes;
    private Set<Character> lettresProposees;

    /**
     * Chemin vers le fichier contenant la liste des mots à deviner.
     */

    private static final String MOTS_FILE = "mots.txt";

    /**
     * Constructeur de la classe Pendu.
     */

    public Pendu() {
        // Initialisation de la fenêtre
        super("Le Pendu"); // Appelle le constructeur JFrame
        setSize(400, 300); // Definition taille de la fenêtre
        setLayout(new GridLayout(5, 1)); //Organisation des composants disposés les uns en dessous des autres.

        /**Initialisation des composants */
        motLabel = new JLabel();
        penduLabel = new JLabel();
        lettresLabel = new JLabel();
        messageLabel = new JLabel();
        lettreField = new JTextField(10);
        proposerButton = new JButton("Proposer lettre");
        rejouerButton = new JButton("Rejouer");

        /** Ajout des composants à la fenêtre */
        add(motLabel);
        add(penduLabel);
        add(lettresLabel);
        add(messageLabel);
        add(lettreField);
        add(proposerButton);
        add(rejouerButton);


    }
}
