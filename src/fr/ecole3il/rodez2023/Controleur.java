package fr.ecole3il.rodez2023;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur {

    private Pendu pendu;
    private Modele model;

    /**
     * Constructeur du contrôleur PenduController.
     *
     * @param pendu La vue du jeu.
     * @param model Le modèle du jeu.
     */
    public Controleur(Pendu pendu, Modele model) {
        this.pendu = pendu;
        this.model = model;
// Ajoute des écouteurs aux boutons de proposition et de rejouer
        this.pendu.addProposerListener(new ProposerListener());
        this.pendu.addRejouerListener(new RejouerListener());

    // Initialise la vue avec les informations du modèle
    updateView();
    }
    /**
     * Met à jour la vue avec les informations actuelles du modèle.
     */
    private void updateView() {
        pendu.setMotLabel(model.getMotCache());
        pendu.setLettresLabel(model.getLettresProposees().toString());
        pendu.setMessageLabel("Tentatives restantes: " + model.getTentativesRestantes());
    }
    /**
     * Classe interne pour gérer les événements de proposition de lettre.
     */
    class ProposerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Récupère la lettre proposée par l'utilisateur
            String lettreProposee = pendu.getLettreProposee().toLowerCase().trim().substring(0, 1);

            // Vérifie la validité de la lettre proposée
            if (lettreProposee.length() == 1 && Character.isLetter(lettreProposee.charAt(0))) {
                char lettre = lettreProposee.charAt(0);

                // Propose la lettre dans le modèle
                boolean lettreTrouvee = model.proposerLettre(lettre);

                // Met à jour la vue
                updateView();

                // Vérifie si le joueur a gagné ou perdu
                if (model.estGagne()) {
                    pendu.setMessageLabel("Félicitations, vous avez gagné !");
                } else if (model.estPerdu()) {
                    pendu.setMessageLabel("Désolé, vous avez perdu. Le mot était : " + model.getMotADeviner());
                } else {
                    if (lettreTrouvee) {
                        pendu.setMessageLabel("Bonne proposition !");
                    } else {
                        pendu.setMessageLabel("Mauvaise proposition !");
                    }
                }
            } else {
                pendu.setMessageLabel("Veuillez entrer une seule lettre valide.");
            }

            // Efface le champ de saisie de la lettre
            pendu.clearLettreProposee();
        }
    }

    /**
     * Classe interne pour gérer les événements de rejouer.
     */
    class RejouerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Réinitialise le jeu
            model.initialiserJeu();

            // Met à jour la vue
            updateView();
        }
    }
}