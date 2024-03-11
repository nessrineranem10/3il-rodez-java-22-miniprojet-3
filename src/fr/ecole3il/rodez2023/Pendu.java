package fr.ecole3il.rodez2023;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;

/**
 * Constructeur par défaut de Pendu.
 * Initialise l'interface graphique Swing.
 */
public class Pendu extends JFrame {
    private JLabel motLabel, penduLabel, lettresLabel, messageLabel;
    private JTextField lettreField;
    private JButton proposerButton, rejouerButton;

    /**
     * Constructeur de la classe Pendu.
     */

    public Pendu() {
        // Initialisation de la fenêtre
        super("Le Pendu"); // Appelle le constructeur JFrame
        setSize(400, 300); // Definition taille de la fenêtre
        setLayout(new GridLayout(5, 1)); //Organisation des composants disposés les uns en dessous des autres.

        /** Initialisation des composants */
        motLabel = new JLabel();
        penduLabel = new JLabel();
        lettresLabel = new JLabel();
        messageLabel = new JLabel();
        lettreField = new JTextField(10);
        proposerButton = new JButton("Propose letter");
        rejouerButton = new JButton("Replay");

        /** Ajout des composants à la fenêtre */
        add(motLabel);
        add(penduLabel);
        add(lettresLabel);
        add(messageLabel);
        add(lettreField);
        add(proposerButton);
        add(rejouerButton);

        setVisible(true);
    }

    /**
     * Met à jour le label du mot à deviner.
     * @param mot Le mot à deviner.
     */
    public void setMotLabel(String mot) {
        motLabel.setText("Mot à deviner: " + mot);
    }

    /**
     * Met à jour le label des lettres déjà proposées.
     * @param lettres Les lettres déjà proposées.
     */
    public void setLettresLabel(String lettres) {
        lettresLabel.setText("Lettres proposées: " + lettres);
    }
    /**
     * Met à jour le label de message.
     * @param message Le message à afficher.
     */
    public void setMessageLabel(String message) {
        messageLabel.setText(message);
    }
    /**
     * Récupère la lettre proposée par l'utilisateur.
     * @return La lettre proposée.
     */
    public String getLettreProposee() {
        return lettreField.getText();
    }
    /**
     * Efface le champ de proposition de lettre.
     */
    public void clearLettreProposee() {
        lettreField.setText("");
    }
    /**
     * Ajoute un écouteur pour le bouton de proposition.
     * @param listener L'écouteur à ajouter.
     */
    public void addProposerListener(ActionListener listener) {
        proposerButton.addActionListener(listener);
    }
    /**
     * Ajoute un écouteur pour le bouton de rejouer.
     * @param listener L'écouteur à ajouter.
     */
    public void addRejouerListener(ActionListener listener) {
        rejouerButton.addActionListener(listener);
    }

}



