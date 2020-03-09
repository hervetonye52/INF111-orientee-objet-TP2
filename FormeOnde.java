/**
 * Classe parent la plus haute de la hiérarchie.  Elle a 2 attributs qui sont 
 * la fréquence et la fréquence d’échantillonnage.
 * Cette classe est immuable, n’a qu’un constructeur par copie d’attributs, 2 
 * accesseurs et une methode echantillon
 */
public class FormeOnde{

    //Attributs
    private double frequence;
    private double frequenceEchantillonage;

    /**
	 * Constructeur par copie d'attributs de FormeOnde.
     * 
     *  @param frequence: est le nombre de fois que l'onde oscille par secondes 
	 *  @param frequenceEchantillonage: l’intervalle de temps entre deux 
     *                            échantillons . Elle est exprimée en Herz [Hz]  
	 */
    public FormeOnde(double frequence, double frequenceEchantillonage){
        this.frequence = frequence;
        this.frequenceEchantillonage = frequenceEchantillonage;
    }

    public FormeOnde() {
    }
    
    /**
	 * Accesseur de la frequencence de l'onde
	 * 
	 * @return frequence: la frequence de l'onde
	 */
    public double getFrequence(){
        return frequence;
    }

    /**
	 * Accesseur de la frequence de l'echantillion d'onde
	 * 
	 * @return frequenceEchantillonage: la fréquence de l'échantillonngage
	 */
    public double getFrequenceEchantillonage(){
        return frequenceEchantillonage;
    }

    /**
	 * ECHANTILLON
	 * Description: Permet de retourner le ième échantillon de la forme d’ondes
	 * @param i
     * @return -1 : le ième échantillon de la forme d’ondes
	 */
	public double echantillon(int i) {
		return -Constantes.UN;
	}

}