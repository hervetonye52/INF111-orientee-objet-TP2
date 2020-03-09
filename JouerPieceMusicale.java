 /***********************************************************************
 * Classe JouerPieceMusicale qui permet de jouer une pièce
 *
 * Ce programme permet d'offrir un menu à l’utilisateur à l’aide de 
 * JOptionPane.showInputDialog.  L'utilisateur sélectionne une pièce ou jouer la 
 * dernière chanson sélectionnée.  S’il n’y a aucune sélection préalable, le 
 * programme avise l’utilisateur qu’il doit sélectionner la pièce d’abord à 
 * l’aide de JOptionPane.showMessageDialog.  
 * 
 * @author Simon St-Pierre et Hervé Tonye
 * @version Mars 2020
 ************************************************************************/

//  Importation des librairies 
import javax.swing.JOptionPane;
import java.io.FileNotFoundException;

public class JouerPieceMusicale {

    /**
     * Programme principal faisant appel à la methode test3 afin de tester le 
     * choix de l'utilisateur et de jouer la pièce choisie
     */
   public static void main(String[] args) {

      test3();
   }

    /**
     * Méthode test3 qui teste la lecture de la pièce musicale en offrant 
     * a l'utilisateur des choix dans un menu JOptionPane.showInputDialog
     */
    public static void test3(){

        //  Déclaration d'un objet de type PieceMusicale 
        PieceMusicale pieceAJouer = null;

        //  Déclaration d'une variable de type String représantant la décision
        String decision = Constantes.RANDOM;
        
        //  Tant que l'utilisateur n'a pas décidé de quitter le menu
        while (!decision.equals(Constantes.QUITTER)){

            //  Le menu s'affiche et le choix de l'utilisateur ira dans décision
            decision = JOptionPane.showInputDialog(null,Constantes.MENU);

            //  Si la décision est de choisir une pièce
            if (decision.equals(Constantes.CHOISIR_PIECE)){
                
                //  Si le tout est valide
                try {
                    //  pieceAJouer devient le fichier choisi par l'utilisateur
                    pieceAJouer = Fichier.obtenirChanson();

                    //  appel de la methode jouer afin de jouer la pieceAJouer
                    pieceAJouer.jouer();

                //  Si le tout est invalide
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            //  Si la décision est de jouer la pièce jouée précédemment 
            else if (decision.equals(Constantes.PIECE_PRECEDENTE)){
                //  Si aucune piece n'a été jouée précédemment, il y aura erreur
                if(pieceAJouer==null){
                   JOptionPane.showMessageDialog(null, Constantes.ERREUR_PIECE);
                }
                //  Si une pièce a été jourée précédemment, la piece est rejouée
                else{
                    pieceAJouer.jouer();
                }
            }
            //  Lorsque l'utilisateur choisi de quitter, Le programme s'arrete
            else if(decision.equals(Constantes.QUITTER)){
            
            }
            //  Lorsque le choix de l'utilisateur est invalide
            else{
                JOptionPane.showMessageDialog(null, Constantes.CHOIX_INVALIDE);
            }
        }
    }
}