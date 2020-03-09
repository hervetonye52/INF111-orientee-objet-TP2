/**
 * Classe hérditaire de la classe FormeOnde et de son constructeur 
 * Cette classe est détient elle aussi une methode échantillon
 */
public class FormeTriangulaire extends FormeOnde{

    /**
	 * Constructeur par copie d'attributs héritant de celui de FormeOnde
	 * 
     * @param frequence: est le nombre de fois que l'onde oscille par secondes 
	 * @param frequenceEchantillonage: l’intervalle de temps entre deux 
     *                            échantillons . Elle est exprimée en Herz [Hz] 
	 */
    public FormeTriangulaire(double frequence, double frequenceEchantillonage){
        super(frequence,frequenceEchantillonage);
    }

	/**
	 * ECHANTILLON
	 * Description: Permet de retourner dans son premier quart une valeur vers 1  
     * Dans ses 2e et 3e quarts, cela descend de 1 vers -1 
     * et dans son dernier quart, cela remonte vers 0
     * @param i
     * @return valeurRetour : le ième échantillon de la forme d’ondes
	 */
    public double echantillon(int i){
        double periode = Constantes.UN / getFrequence();
       double r = Math.IEEEremainder((i/getFrequenceEchantillonage()), periode);
 
        if (r<Constantes.ZERO){
             r = r + periode;
        }
        
        double valeurRetour;

        if (r <= periode / Constantes.QUATRE){
            valeurRetour= r * Constantes.QUATRE / periode;
        }
        else if(r<= (Constantes.TROIS * periode) / Constantes.QUATRE){
            r = r - (periode / Constantes.QUATRE);
            valeurRetour = (Constantes.UN- r * Constantes.QUATRE) / periode;
        }
        else {
            r = r - ((Constantes.TROIS * periode) / Constantes.QUATRE);
            valeurRetour = (-Constantes.UN + r * Constantes.QUATRE) / periode;
        }
        return valeurRetour;
    }

}