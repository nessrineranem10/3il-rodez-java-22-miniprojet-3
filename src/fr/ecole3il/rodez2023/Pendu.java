package fr.ecole3il.rodez2023;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Cette classe représente une interface graphique du jeu du Pendu.
 * Elle permet à l'utilisateur de proposer des lettres pour deviner un mot.
 */
public class Pendu extends JFrame {
    private JLabel motLabel, penduLabel, lettresLabel, messageLabel;
    private JTextField lettreField;
    private JButton proposerButton, rejouerButton;

    private Modele modele;

    /**
     * Constructeur de la classe Pendu.
     * @param modele L'objet Modele à utiliser pour obtenir les mots et les définitions.
     */
    public Pendu(Modele modele) {
        // Initialisation de la fenêtre
        super("Le Pendu"); // Appelle le constructeur JFrame
        setSize(400, 300); // Definition taille de la fenêtre
        setLayout(new GridLayout(5, 1)); //Organisation des composants disposés les uns en dessous des autres.

        this.modele = modele;

        /** Initialisation des composants */
        motLabel = new JLabel();
        penduLabel = new JLabel();
        lettresLabel = new JLabel();
        messageLabel = new JLabel();
        lettreField = new JTextField(10);
        proposerButton = new JButton("Propose letter");
        rejouerButton = new JButton("Replay");

        String ligne = modele.tirerLigneAleatoirement("mots.txt");
        afficherMotAleatoire(ligne);
        afficherDefinitionAleatoire(ligne);


        /** Ajout des composants à la fenêtre */
        add(motLabel);
        add(penduLabel);
        add(lettresLabel);
        add(messageLabel);
        add(lettreField);
        add(proposerButton);
        add(rejouerButton);

        proposerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proposerLettre();
            }
        });
        rejouerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        setVisible(true);
    }
    /**
     * Méthode appelée lorsque l'utilisateur propose une lettre.
     */
    private void proposerLettre() {
        String lettreProposee = lettreField.getText();
        modele.proposerLettre(lettreProposee.charAt(0));
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

    /**
     * Affiche un mot aléatoire à deviner.
     * @param ligne La ligne contenant le mot aléatoire.
     */
    public void afficherMotAleatoire(String ligne) {
        String mot = modele.getMot(ligne);
        motLabel.setText("Mot aléatoire: " + mot);
    }

    /**
     * Affiche une définition aléatoire pour le mot.
     * @param ligne La ligne contenant le mot aléatoire.
     */
    public void afficherDefinitionAleatoire(String ligne) {
        String definition = modele.getDefinition(ligne);
        messageLabel.setText("Définition aléatoire: " + definition);
    }


}



