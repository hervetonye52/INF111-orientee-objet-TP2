/******************************************************************
 * Classe PieceMusicale qui crée un pièce musicale jouable
 * 
 * On teste cette classe à l'aide de la méthode test2 qui utilise
 * le générateur d'accords
 *
 * @author   Simon St-Pierre et Hervé Tonye
 * @version  Mars 2020
 *****************************************************************/

//  Importation des librairies
import java.util.Vector;

public class PieceMusicale{

    //le nom de la pièce musicale
    private String nomPiece;
    
    //Le nombre de battements par minute
    private int bpm;

    //La collection d'accord
    private Vector<Accord> accords;
    
     /**
	 * Constructeur par copie d'attributs de PieceMusicale
     * 
     *  @param nomPiece: le nom de la piece musicale
	 *  @param bpm: le nombre de battements par minute                    
	 */
    public PieceMusicale(String nomPiece, int bpm){

        this.nomPiece = nomPiece;
        this.bpm = bpm;
        this.accords = new Vector<Accord>();
    }

    
    /**
    * Permet d'ajouter un accord a la collection en fin de liste
    *
    * @param accordsAjouter: l'accord a ajouter dans la collection
    */
    public void ajoutAccord(Accord accordsAjouter){
       
        this.accords.add(accordsAjouter);

    }

    /**
    * Permet de pauser l'application pour donner du temps à
    * un autre processus dans un univers multitâches.
    *
    * @param duree Le temps de la pause (en ms).
    */
    private void pause(int duree) {
        try {
            Thread.sleep(duree);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

     /**
	 * Méthode jouer qui permet de jouer un accord de la bonne durée
     * 
     * On appelle la méthode jouer pour chaque accord de la collection, et
     * on fait une pause entre chaque accord
     */
    public void jouer(){

        for(int i=0; i<accords.size();i++){

            accords.get(i).jouer();
            double duree = accords.get(i).getNotes().get(0).getDuree();
            //On fait une pause entre chaque accord de la durée de l'accord
            pause((int)duree);

        }
    }

     /**
	 * Méthode toString qui appelle la méthode toString de la classe Accord,
     * et la concaténer en sauter une ligne à tous les 4 accords
     *
     * @return accordsRetourne La série d'accord concaténée
     */
    public String toString(){
        String accordsRetourne = Constantes.ESPACE;

        // Il faut appeller toString de la classe Accord en boucle
        for (int i=0; i<accords.size(); ++i){
            accordsRetourne = accordsRetourne + accords.get(i).toString();

            if( (i+Constantes.UN) % Constantes.ESPACE_NOTE == Constantes.ZERO){
                accordsRetourne = accordsRetourne + Constantes.SAUT_LIGNE;
            }
        }
        return accordsRetourne;
    }   
}