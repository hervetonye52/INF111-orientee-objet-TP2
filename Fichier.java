/******************************************************************
 * Classe qui gère le système de fichiers
 * 
 * On ouvre et on lit un fichier .txt local dans l'ordinateur, contenant
 * le titre sur la première ligne, le nombre de battements par minute
 * sur la deuxième ligne et ensuite 4 accords par ligne
 * 
 * @author   Simon St-Pierre et Hervé Tonye
 * @version  Mars 2020
 *****************************************************************/

//  Importation des librairies
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Fichier{

    public static PieceMusicale obtenirChanson() throws FileNotFoundException{

        //  Déclarer un objet de type PieceMusicale
        PieceMusicale chansonChoisie = null;

        // Le chemin pour se rendre au fichier 
        File chemin;

        // Obtenir le chemin du fichier avec JFileChooser
        chemin = fileChooser();

        // On met le nom de la piece dans une variable en utilisant getName
        String nomPiece = chemin.getName();

        // Ouvrir le fichier à l'aide de Java BufferedReader
        BufferedReader lecteur = new BufferedReader(new FileReader(nomPiece));

        try{
            // Déclarer et instancier un objet de la classe Scanner avec 
            // le chemin du fichier
            Scanner scanner = new Scanner (chemin);

            // Déclarer et instancier un objet de la classe GenerateurAccord.
            GenerateurAccord accord = new GenerateurAccord();

            // Lire le titre de la pièce dans le fichier sur la première ligne,
            // et lire son nombre de battements par minute sur la deuxième ligne
            String titre = scanner.nextLine();
            int bpm = scanner.nextInt();

            // Instancier l’objet de la classe PieceMusicale.
            chansonChoisie = new PieceMusicale(titre,bpm);

            // Tant qu’il reste des accords à lire
            while (scanner.hasNext()){

                //Lire un accord et sa durée
                String accordString = scanner.next();
                double doubleBpm =scanner.nextDouble();

                // Convertir la durée par rapport au bpm.
                // Le 60000 équivaut à une minute en millisecondes.
                double duree;
                duree = (doubleBpm)*(Constantes.MIN_EN_MS/bpm);

                // Obtenir l’accord du générateur d’accord avec la bonne durée 
                // et l’ajouter à la pièce musicale.
                chansonChoisie.ajoutAccord(accord.obtenirAccord (accordString, 
                                                                        duree)); 
            }
            scanner.close();

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        // Retourne la pièce.
        return chansonChoisie;
    }

    /**
	 * Méthode qui utilise le Java JFileChooser, pour accéder au répertoire 
     * de l'ordinateur et choisir le fichier de la pièce musicale voulue
     *
     * @return fichierChoisi Le chemin du fichier sélectionné
     */
    private static File fileChooser(){

        // On accède au répertoire de l'ordinateur
        JFileChooser fichier = new JFileChooser(FileSystemView.
                                        getFileSystemView().getHomeDirectory());
        // Variable de retour pour savoir si le fichier est valide
        int valRetour = fichier.showOpenDialog(null);

        // Si le fichier est valide, on retourne le chemin
        if (valRetour == JFileChooser.APPROVE_OPTION){
            File fichierChoisi = fichier.getSelectedFile();
            //On retourne le chemin du fichier
            return fichierChoisi;
        }
        return null;
    }    
}