/**
 * Classe hérditaire de la classe FormeOnde et de son constructeur 
 * Cette classe est détient elle aussi une methode échantillon
 */
public class FormeAleatoire extends FormeOnde{

    /**
	 * Constructeur par copie d'attributs héritant de celui de FormeOnde 
	 * 
	 */
    public FormeAleatoire(){

        super();
    }

    /**
	 * ECHANTILLON
	 * Description: Permet de retourner un nombre entre - 1 et 1 choisit au 
     * hasard.  L'échantillon est un nombre réel choisi au hasard dans 
     * [0.0, 1.0[  puis étendu à l'intervalle [-1, 1[.  
     * Il suffit de retourner 2 * Math.random() - 1.
     * @return numAleatoire : le ième échantillon de la forme d’ondes
	 */
    public double echantillon(){

        double numAleatoire = (Constantes.DEUX*Math.random())-Constantes.UN;
        return numAleatoire;
    }
}