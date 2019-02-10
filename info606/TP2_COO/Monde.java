import in.keyboard.Keyboard;

public class Monde {
	
//	public static final int rouge = 31;
//	public static final int vert = 32;
//	public static final int jaune = 33;
//	public static final int bleu = 34;
//	public static final int violet = 35;
//	public static final int cyan = 36;
//	public static final int gris = 37;
//	public static final int noir = 38;
	
	public static void ecrire(Couleur coul, String s) {
		System.out.printf("\033[%d;1m%s\033[0m\n", coul.ordinal()+31, s);
	}
	
	public static void main(String[] args) {
//		Couleur.testCouleur();
		Table tab = new Table();
		Robot D2R2 = new Robot(tab);
		tab.AddCube(new Cube(Taille.Petit,Couleur.rouge));
		tab.AddCube(new Cube(Taille.Moyen,Couleur.rouge));
		tab.AddCube(new Cube(Taille.Grand,Couleur.rouge));

		char c = ' ';
		Couleur coul;
		Taille tc;
		do {
		System.out.println("1 - creer un cube");
		System.out.println("2 - détruire un cube");
		System.out.println("3 - poser un cube sur la table");
		System.out.println("4 - poser un cube sur un cube");
		System.out.println("5 - prendre un cube");
		System.out.println("f - fin du monde");
		System.out.print("Votre choix : ");
		c = Keyboard.getChar();
		switch (c) {
		case '1': 
			System.out.print("Couleur du cube : ");
			coul = Couleur.getCouleur(Keyboard.getString());
//			ecrire (coul, "couleur saisie");
			System.out.print("Taille (grand/moyen/petit) : ");
			tc = Taille.getTaille(Keyboard.getString());
			D2R2.CréerCube(tc, coul);
			break;
		case '2':
			System.out.println("Le cube tenu par le robot va être détruit ");
			Keyboard.pause();
			D2R2.LacherCube();
			break;
		
		case '3':
			if (D2R2.MainVide()) {
				System.out.println("Le robot ne tient pas de cube");
			}else{
				System.out.println("Le cube va etre poser sur la table ");
				Keyboard.pause();
				D2R2.PoserSurTable();
			}
			break;
			
		case '4':
			if (D2R2.MainVide()) {
				System.out.println("Le robot ne tient pas de cube");
			}
			else {
				System.out.print("Couleur du cube : ");
				coul = Couleur.getCouleur(Keyboard.getString());
//				ecrire (coul, "couleur saisie");
				System.out.print("Taille (grand/moyen/petit) : ");
				tc = Taille.getTaille(Keyboard.getString());
				System.out.println("Le cube "+"" + "va etre recherché ");
				int res = D2R2.PoserSurCube(tc, coul);
				if(res == 0 ) {
					System.out.println("Le cube a été posé");
					D2R2.LacherCube();
				}else if(res == 1) {
					System.out.println("Le cube n'a pas été trouvé");
				}else if(res == 2) {
					System.out.println("Le cube est trop grand ");
				}else {
					System.out.println("erreur");

				}
			}
			break;
			
		case '5':
			if (!D2R2.MainVide()) {
				System.out.println("Le robot tient un cube");
			}else{
				System.out.print("Couleur du cube : ");
				coul = Couleur.getCouleur(Keyboard.getString());
//				ecrire (coul, "couleur saisie");
				System.out.print("Taille (grand/moyen/petit) : ");
				tc = Taille.getTaille(Keyboard.getString());
				System.out.println("Le cube "+"" + "va etre recherché ");
				Keyboard.pause();
				D2R2.PrendreCube(tc, coul);;
			}
			break;
		}
		
		afficherMonde(D2R2, tab);
		} while (c != 'f');
	}

	private static void afficherMonde(Robot R, Table T) {
		ecrire(Couleur.noir, "Etat du monde : ");
		R.afficherRobot();
		T.afficherTable();
//		Keyboard.pause();
	
	}
}