import java.util.ArrayList;
import java.util.Vector;

public class GenerateurAccord {
				
	/*
	 * Classe interne pour créer les notes et les accords d'une durée fixée.
	 */
	private class LesAccordsSelonDuree{
		
		// Contiendra tous les accords pour une durée.
		private ArrayList<Accord> tabAccords = new ArrayList<Accord>();
		
		// La durée qui peux être .5, .25, ...
		private double duree;
		
		// Toutes les nomenclatures possibles pour les notes d'une gamme.
		private Note C;
		private Note Cb;
		private Note Cdiese;
		private Note D; 
		private Note Db;
		private Note Ddiese;
		private Note E; 
		private Note Eb;
		private Note Ediese;
		private Note F; 
		private Note Fb;
		private Note Fdiese;
		private Note G; 
		private Note Gb;
		private Note Gdiese;
		private Note A; 
		private Note Ab;
		private Note Adiese;  
		private Note B; 
		private Note Bb;
		private Note Bdiese;
		private Note silence;
		
		
		/* 
		 * On doit crée un accord pour chaque catégorie de temps ( 1 à 4) 
		 * dans une mesure.  Pour ne pas le recréer chaque fois, nous les 
		 * créons tous une seule fois au départ et on sélectionnne l'accord
		 * selon sa durée.
		 */
		

		/**
		 * La durée est le temps que durera l'accord.
		 * 
		 * @param duree La durée de l'accord.
		 */
		private LesAccordsSelonDuree(double duree) {
						
			creerNotes(duree);
			
			// Crée tous les accords connus pour cette durée.
			creerTabAccord();

		}


		/*
		 * Crée des notes de même durée.
		 */
		private void creerNotes(double duree) {
			
			// Par défaut C et C4 sont identiques.
			C = new Note("C4",duree); 
			Cb = new Note("C4b",duree); 
			Cdiese = new Note("C#",duree);
			D = new Note("D4",duree); 
			Db = new Note("D4b",duree); 
			Ddiese = new Note("D4#",duree); 
			E = new Note("E4",duree); 
			Eb = new Note("E4b",duree); 
			Ediese = new Note("E4#",duree); 
			F = new Note("F4",duree);
			Fb = new Note("F4b",duree);
			Fdiese = new Note("F4#",duree);
			G = new Note("G4",duree); 
			Gb = new Note("G4b",duree); 
			Gdiese = new Note("G4#",duree); 
			A = new Note("A4",duree); 
			Ab = new Note("A4b",duree); 
			Adiese = new Note("A4#",duree); 
			B = new Note("B4",duree);
			Bb = new Note("B4b",duree);			
			Bdiese = new Note("B4#",duree);
			silence = new Note(" ",duree);
		}


		/*
		 * La constitution des accords est {tonique, tierce ou tierce mineure
		 * et quinte} pour les accords de base .  Tout cela se calcule mais
		 * pour simplifier l'énoncé nous les avons "hard codé".
		 * 
		 * Ici c'est la gamme de do harmonisée et pour chacun on fait 
		 * les accords : mineur, majeur, dominant 7 et mineur7.
		 */
		private void creerTabAccord() {
			
			// Les accords de do
			creerDo();

			// Les accords de ré
			creerRe();

			// ...
			creerMi();
			creerFa();
			creerSol();						
			creerLa();
			creerSi();

			Note[] tabSilence = {silence, silence, silence};
			tabAccords.add(new Accord("S", tabSilence));
		}
		
		
		private void creerSi() {
			
			Note[] tabB = { B, Ddiese, Fdiese};
			tabAccords.add(new Accord("B", tabB));
			
			Note[] tabB7 = { B, Ddiese, Fdiese, A};
			tabAccords.add(new Accord("B7", tabB7));
			
			Note[] tabBm = { B, D, Fdiese};
			tabAccords.add(new Accord("Bm", tabBm));

			Note[] tabBm7 = { B, D, Fdiese, A};			
			tabAccords.add(new Accord("Bm7", tabBm7));
			
		}


		private void creerSol() {
			
			Note[] tabG = { G, B, D};
			tabAccords.add(new Accord("G", tabG));
			
			Note[] tabG7 = { G, B, D, Fdiese};
			tabAccords.add(new Accord("G7", tabG7));
			
			Note[] tabGm = { G, Bb, D};
			tabAccords.add(new Accord("Gm", tabGm));

			Note[] tabGm7 = { G, Bb, D, Fdiese};			
			tabAccords.add(new Accord("Gm7", tabGm7));			
		}


		private void creerFa() {
			
			Note[] tabF = { F, A, C};
			tabAccords.add(new Accord("F", tabF));			

			Note[] tabF7 = { F, A, C, Eb};
			tabAccords.add(new Accord("F7", tabF7));
			
			Note[] tabFm = { F, Ab, C};
			tabAccords.add(new Accord("F", tabFm));  		

			Note[] tabFm7 = { F, Ab, C, Eb};
			tabAccords.add(new Accord("F7", tabFm7)); 		
			
		}


		private void creerLa() {
			
			Note[] tabA = { A, Cdiese, E};
			tabAccords.add(new Accord("A", tabA));
			
			Note[] tabA7 = { A, Cdiese, E, G};
			tabAccords.add(new Accord("A7", tabA7));

			Note[] tabAm = { A, C, E};
			tabAccords.add(new Accord("Am", tabAm));
			
			Note[] tabAm7 = { A, C, E, G};
			tabAccords.add(new Accord("Am7", tabAm7));
			
		}


		private void creerMi() {
			
			Note[] tabE = { E, Gdiese, B};
			tabAccords.add(new Accord("E", tabE));
			
			Note[] tabE7 = { E, Gdiese, B, D};
			tabAccords.add(new Accord("E7", tabE7));

			Note[] tabEm = { E, G, B};
			tabAccords.add(new Accord("Em", tabEm));
			
			Note[] tabEm7 = { E, G, B, D};
			tabAccords.add(new Accord("Em7", tabEm7));
			
		}


		private void creerRe() {
			
			Note[] tabD = { D, Fdiese, A};
			tabAccords.add(new Accord("D", tabD));

			Note[] tabD7 = { D, Fdiese, A, C};
			tabAccords.add(new Accord("D", tabD7));

			Note[] tabDm = { D, F, A};
			tabAccords.add(new Accord("Dm", tabDm));

			Note[] tabDm7 = { D, F, A, C};
			tabAccords.add(new Accord("Dm7", tabDm7));
			
		}


		private void creerDo() {
			
			Note[] tabC = { C, E, G};
			tabAccords.add(new Accord("C",tabC));
			
			Note[] tabC7 = { C, E, G, Bb};
			tabAccords.add(new Accord("C",tabC7));

			Note[] tabCm = { C, Eb, G};
			tabAccords.add(new Accord("Cm",tabCm));

			Note[] tabCm7 = { C, Eb, G, Bb};
			tabAccords.add(new Accord("Cm7",tabCm7));
			
		}


		@Override
		public boolean equals(Object arg0) {
			
			return duree == ((LesAccordsSelonDuree)arg0).duree;
			
		}

		
		/* 
		 * Fonction privée qui retourne l'accord qui correspond à la chaîne
		 * reçue et qui se trouve dans la collection d'accords.
		 */
		private Accord obtenirAccord(String accord) {

			Accord acc = new Accord(accord, null);

			// equals de la classe Accord doit redéfinir celle de Object.
			return (tabAccords.contains(acc)) 
					? tabAccords.get(tabAccords.indexOf(acc))
							: null;
		}	
		
	}// Fin de la classe interne.


	// ATTRIBUT DU GÉNÉRATEUR ET SEULE MÉTHODE PUBLIQUE.
	
	// Les accords pour chaque durée.
	private Vector<LesAccordsSelonDuree> tabAccordsDuree = 
			                               new  Vector<LesAccordsSelonDuree>();
		

	/**
	 * Retourne l'accord qui correspond à la chaîne reçue de la durée reçue
	 * @param accord
	 * @param duree
	 * @return L'accord qui correspond à la chaîne reçue.
	 */
	public Accord obtenirAccord(String accord, double duree) {

		LesAccordsSelonDuree comparaison = 
				new LesAccordsSelonDuree(duree);

		// Si on ne la trouve pas, on crée tous les accords pour cette durée et
		// on les ajoute.
		if(!tabAccordsDuree.contains(comparaison)) {

			comparaison = new LesAccordsSelonDuree(duree);
			tabAccordsDuree.add(comparaison);
		}

		// On obtient dans une variable pour le debug.
		Accord acc =  comparaison.obtenirAccord(accord);

		return acc;
	}	
}