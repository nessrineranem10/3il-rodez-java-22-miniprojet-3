package fr.ecole3il.rodez2023;

import javax.swing.*;

public class main {
    public class Main {

        public static void main(String[] args) {
            // Création de l'interface graphique
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Pendu pendu = new Pendu();
                    pendu.setVisible(true); // Rendre la fenêtre visible
                }
            });
        }
    }
}
