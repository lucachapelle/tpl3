
public enum Taille {
    Grand,
    Moyen,
    Petit;

	public static Taille getTaille(String string) {
		// TODO Auto-generated method stub4
		Taille res= null;
		switch(string){
		case "grand":
			res= Grand;
			break;
		case "moyen":
			res= Moyen;
			break;
		case "petit":
			res= Petit;
			break;
		}
		return res;
	}
	public int getTaille() {
		if (Taille.Grand == this) {
			return 3;
		}else if(Taille.Moyen == this ) {
			return 2;
		}else if(Taille.Petit == this) {
			return 1;

		}else{
			return 0;
			
		}

	}
}
