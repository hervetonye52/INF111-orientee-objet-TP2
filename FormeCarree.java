/**
 * Classe hérditaire de la classe FormeOnde et de son constructeur 
 * Cette classe est détient elle aussi une methode échantillon
 */
public class FormeCarree extends FormeOnde{

    /**
	 * Constructeur par copie d'attributs héritant de celui de FormeOnde
	 * 
     * @param frequence: est le nombre de fois que l'onde oscille par secondes 
	 * @param frequenceEchantillonage: l’intervalle de temps entre deux 
     *                            échantillons . Elle est exprimée en Herz [Hz] 
	 */
    public FormeCarree(double frequence, double frequenceEchantillonage){
        super(frequence,frequenceEchantillonage);
    }
    
    /**
	 * ECHANTILLON
	 * Description: Permet de retourner un nombre entre - 1 et 1 
     * @param i
     * @return r : le ième échantillon de la forme d’ondes
	 */
    public double echantillon(int i){

       double periode = Constantes.UN / getFrequence();
       double r = Math.IEEEremainder((i/getFrequenceEchantillonage()), periode);

       if (r<0){
            r = r + periode;
       }
      
       if (r < periode/Constantes.DEUX){
            r=Constantes.UN_DOUBLE;
       }
       else{
           r=-Constantes.UN_DOUBLE;
       }
        return r;
    }

}