/**
 * Classe hérditaire de la classe FormeOnde et de son constructeur 
 * Cette classe est détient elle aussi une methode échantillon
 */
public class FormeSinusoidale extends FormeOnde{

    /**
	 * Constructeur par copie d'attributs héritant de celui de FormeOnde
	 * 
     * @param frequence: est le nombre de fois que l'onde oscille par secondes 
	 * @param frequenceEchantillonage: l’intervalle de temps entre deux 
     *                            échantillons . Elle est exprimée en Herz [Hz] 
	 */
    public FormeSinusoidale(double frequence, double frequenceEchantillonage){
        super(frequence,frequenceEchantillonage);
    }

    /**
	 * ECHANTILLON
	 * Description: Permet de retourner un échantillon d’une forme sinusoïdale
     * @param i
     * @return valeurRetour : le ième échantillon de la forme d’ondes
	 */
    public double echantillon(int i){ 
        double periode = Constantes.UN / getFrequence();
        double r =Math.IEEEremainder((i/getFrequenceEchantillonage()), periode);
                                                                    
        double valeurRetour;
        if (r<0){
             r = r + periode;
        }

        valeurRetour = Math.sin(Constantes.DEUX*Math.PI*getFrequence()*r);
         return valeurRetour;
    }

}