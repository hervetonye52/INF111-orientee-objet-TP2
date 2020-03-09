/***********************************************************************
* Classe qui permet d'effectuer un test de son pour la gamme de Do Majeur
* 
*@authors Simon St-Pierre et Hervé Tonye
*@version 6 Mars 2020
*
************************************************************************/

//  Importation des librairies
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/***************************************************************************
 * Classe qui permette d'effectuer un test de son pour la gamme de Do Majeur
 **************************************************************************/
public class TestDeSon{

    // Attribut
    // Déclaration d'une ligne de type SourceDataLine
    public static SourceDataLine ligne;

    /*********************************************************************
	 * methode qui ouvre des lignes et demarre la production de son pour 
     * les notes voulues avec l'intensité et la durée voulue prédéterminées
	 ********************************************************************/
    public static void test() {

        // Ouverture de ligne
        ouvertureLigne();

        // Execution d'un programme de la classe Thread
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {

                // Démarre la production de son
                ligne.start();

                // Joue la gamme de do majeure à une intensité de
                // 30% pendant une demie seconde. Le 4 signifie
                // la gamme au centre du piano. C3 est plus grave et
                // C5 est plus aigu.
                jouer(ligne, "C4",.3, 500);
                jouer(ligne, "D4",.3, 500);
                jouer(ligne, "E4",.3, 500);
                jouer(ligne, "F4",.3, 500);
                jouer(ligne, "G4",.3, 500);
                jouer(ligne, "A4",.3, 500);
                jouer(ligne, "B4",.3, 500);
                jouer(ligne, "C5",.3, 1000); // do plus aigu, 1 seconde
            }
        });
        t.start();
    }

    /*********************************************************************
	 * Joue une note sur une ligne audio à un cetain volume sonore.
	 * 
	 * @param ligne: est la ligne sur laquelle la note doit être jouée.
	 * @param note: est la note à jouer
     * @param duree: la perdiode de temps pendant laquelle la note sera jouée
     * @param intensite: l'intensité de la note jouée
	 *********************************************************************/
    public static void jouer(SourceDataLine ligne, String note,double intensite,
                                                                  double duree){

        Note n = new Note(note, duree);
        n.jouer(ligne, intensite);
    }

    /*********************************************************************
	 * Permet d'ouvrir une ligne permettant de jouer un son
	 ********************************************************************/
    public static void ouvertureLigne(){

        // d’obtenir une instance de la classe AudioFormat
        AudioFormat audioFmt = new AudioFormat(20500, 16, 1, true, true);

        try {
            ligne = AudioSystem.getSourceDataLine(audioFmt);
            ligne.open(audioFmt);
        } catch (LineUnavailableException lue) {
            System.out.println("#Erreur : impossible de trouver une ligne de" + 
                                                    "sortie audio au format :");
            System.out.println("#   " + audioFmt);
            System.exit(1);
        }
    }
}



