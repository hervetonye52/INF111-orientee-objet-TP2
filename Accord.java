/******************************************************************
 * Classe qui implémente un accord, à l'aide d'un nom d'accord et
 * d'une collection de notes.
 * 
 * On teste cette classe à l'aide de la méthode test2 qui utilise
 * le générateur d'accords
 *
 * @author   Simon St-Pierre et Hervé Tonye
 * @version  Mars 2020
 *****************************************************************/

//  Importation des librairies
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import java.util.ArrayList;

public class Accord {

    // Le nom de l'accord
    private String nomAccord;

    // La collection de notes (de type Notes)
    private ArrayList<Note> notes;

    /**
	 * Le constructeur qui recoit le nom de l'accord et un tableau de notes
     * et qui ajoute chaque note à la collection 
	 */
    public Accord(String nomAccord, Note[] notes){
        this.nomAccord = nomAccord;
        this.notes = new ArrayList<Note>();

        // On ajoute la note à la collection
        if(notes != null){
            for(int i = 0; i< notes.length;i++){
                this.notes.add(i, notes[i]);
            }
        }
    }

    /**
	 * Retourne le nom de l'accord
	 * 
	 * @return Le nom de l'accord
	 */
    public String getNom(){
        return nomAccord; 
    }

    /**
	 * Retourne la collection de notes
	 * 
	 * @return La collection de notes en question
	 */
    public ArrayList<Note> getNotes(){
        return this.notes;
    }

    /**
	 * Modifie le nom de l'accord par celui reçu
	 * 
	 * @param nomAccord le nouveau nom de l'accord
	 */
    public void  setNomAccord(String nomAccord){
        this.nomAccord = nomAccord;
    }

    /**
	 * Modifie la collection de notes
	 * 
	 * @param notes la nouvelle collection de notes
	 */
    public void setNotes(ArrayList<Note> notes){
        this.notes = notes;
    }
    
    /**
	 * Compare/verifie que deux accorsd sont identiques. 
     * C'est-à-dire s’ils ont le même nom
	 * 
	 * @param arg0: L'object a comparer avec les accords
     * @return egal: le resultat de la comparaison
	 */
    public boolean equals(Object arg0){
        // attribut de type boolean a retourner suite à la comparaison
        boolean egal; 
        
        // Condition vérifiant si arg0 est null ou s'il n'est pas de type accord 
        if(arg0 == null || arg0.getClass() != this.getClass()){
            egal = false; 
        }
        
        // L'objet arg0 est transformé en objet de type Accord 
        Accord accordTemp = (Accord) arg0;

        // On assigne a egal le resultat de la comparaison entre accordTemp et 
        // nomAccord
        egal = accordTemp.getNom().equals(this.getNom());
        return egal; 
    }

    
    /**
	 * Presente le/les elements sous formes de chaine de caractere
	 * 
	 * @return affichage: affiche le nom de l'accord ainsi que ses notes
	 */
    public String toString(){
        // Affichage du nom de l'accord
        String affichage = Constantes.MSG_NOM_ACCORD + this.getNom() + 
                "\n Notes: ";

        // Affichage des note de l'accord
        for(int i = 0; i < notes.size(); i++){
            affichage += notes.get(i).getNom_();
        }
        return affichage; 
    }

    /**
	 * Permet de pauser l'application pour donner du temps à
     * un autre processus dans un univers multitâches.
	 * 
	 * @param duree La durée de la pause (en ms)
	 */
	private static void pause2(int duree) {
        try {
            Thread.sleep(duree);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
	 * Joue une note sur une ligne audio à un cetain volume sonore.
     */
    public void jouer(){
        
        // Déclarer et instancier un tableau avec autant de 
        // SourceDataLine qu’il y a de notes 
        SourceDataLine[] line = new SourceDataLine[this.notes.size()];

        // Obtenir une instance de la classe AudioFormat
        AudioFormat audioFmt = new AudioFormat(20500, 16, 1, true, true);
        
        //  Ouverture des lignes
        for (int i = 0; i<notes.size();i++){
            try {
                line[i] = AudioSystem.getSourceDataLine(audioFmt);
                line[i].open(audioFmt);
            } catch (LineUnavailableException lue) {
               System.out.println("#Erreur : impossible de trouver une ligne de" 
                                                  + "sortie audio au format :");
                System.out.println("#   " + audioFmt);
                System.exit(1);
            }

            //  Retenir i dans une variable j (utile au Thread)
            int j =i;

            //  Démarrer la production de son
            Thread t = new Thread (new Runnable(){
                @Override
                public void run(){
                        //  Pour chaque ligne, on place une note et on la joue
                        line[j].start();
                        Note notesDeAccord = notes.get(j); 
                        notesDeAccord.jouer(line[j], Constantes.NIVEAU);
                }
            });
            t.start();
        }
    }

    /**
	 * Méthode test2 qui teste les accords
	 */
    public static void test2(){

        // Accord de C
        GenerateurAccord accordGenere = new GenerateurAccord();
        Accord accordAJouer = accordGenere.obtenirAccord(Constantes.ACCORD_C,
                                                     Constantes.DUREE_MILLE_MS);
        accordAJouer.jouer();
        System.out.println(Constantes.MSG_ACCORD+accordAJouer);
        pause2(Constantes.DUREE_MILLE_MS);

        // Accord de Dm
        accordAJouer = accordGenere.obtenirAccord(Constantes.ACCORD_DM,
                                                  Constantes.DUREE_MILLE_MS);
        accordAJouer.jouer();
        System.out.println(Constantes.MSG_ACCORD+accordAJouer);
        pause2(Constantes.DUREE_MILLE_MS);

        // Accord de Em
        accordAJouer = accordGenere.obtenirAccord(Constantes.ACCORD_EM,
                                                  Constantes.DUREE_MILLE_MS);
        accordAJouer.jouer();
        System.out.println(Constantes.MSG_ACCORD+accordAJouer);
        pause2(Constantes.DUREE_MILLE_MS);

        // Accord de F
        accordAJouer = accordGenere.obtenirAccord(Constantes.ACCORD_F,
                                                  Constantes.DUREE_MILLE_MS);
        accordAJouer.jouer();
        System.out.println(Constantes.MSG_ACCORD+accordAJouer);
        pause2(Constantes.DUREE_MILLE_MS);

        // Accord de G
        accordAJouer = accordGenere.obtenirAccord(Constantes.ACCORD_G,
                                                  Constantes.DUREE_MILLE_MS);
        accordAJouer.jouer();
        System.out.println(Constantes.MSG_ACCORD+accordAJouer);
        pause2(Constantes.DUREE_MILLE_MS);

        // Accord de Am
        accordAJouer = accordGenere.obtenirAccord(Constantes.ACCORD_AM,
                                                  Constantes.DUREE_MILLE_MS);
        accordAJouer.jouer();
        System.out.println(Constantes.MSG_ACCORD+accordAJouer);
        pause2(Constantes.DUREE_MILLE_MS);

        // Accord de B7
        accordAJouer = accordGenere.obtenirAccord(Constantes.ACCORD_B7,
                                                  Constantes.DUREE_MILLE_MS);
        accordAJouer.jouer();
        System.out.println(Constantes.MSG_ACCORD+accordAJouer);
        pause2(Constantes.DUREE_MILLE_MS);
    }
}