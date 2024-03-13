package fr.ecole3il.rodez2023;

import javax.swing.*;
import java.util.ArrayList;

public class main {


      public static void main(String[] args) {
          Modele modele = new Modele();
            // Création de l'interface graphique
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Pendu pendu = new Pendu(modele);
                    pendu.setVisible(true); // Rendre la fenêtre visible
                }
            });
        }


}
