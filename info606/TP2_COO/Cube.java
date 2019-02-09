import java.util.ArrayList;
import java.util.List;

public class Cube {
	private Taille Taille;

    private Couleur Couleur;
    
    private int id;
    
    private Cube dessous;

    private Cube dessus;

    public Cube(Taille taille, Couleur couleur) {
		// TODO Auto-generated constructor stub
    	this.Taille = taille;
    	this.Couleur = couleur;
    	this.dessous = null;
    	this.dessus = null;

	}

	public Cube getDessous() {
		return dessous;
	}

	public Cube getDessus() {
		return dessus;
	}

	public void SuisJeBonCube(final Taille Taille, final String Couleur) {
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public Taille getTaille() {
		return Taille;
	}

	public void setTaille(Taille taille) {
		Taille = taille;
	}

	public Couleur getCouleur() {
		return Couleur;
	}

	public void setCouleur(Couleur couleur) {
		Couleur = couleur;
	}

	public Cube getVoisin() {
        // TODO Auto-generated return
        return null;
    }

    public void setVoisin(final Cube p1) {
    	
    }

	public void setDessous(Cube p1) {
		// TODO Auto-generated method stub
		this.dessous = p1;
	}
	public void setDessus(Cube p1) {
		// TODO Auto-generated method stub
		this.dessus = p1;
	}

	@Override
	public String toString() {
		if(this.dessous != null ){
			return "Cube [Taille=" + Taille + ", Couleur=" + Couleur + ", id=" + id + ", dessous=" + dessous.toString() +"]";
		}	
			else {
				return "Cube [Taille=" + Taille + ", Couleur=" + Couleur + ", id=" + id;
		}

		
	}

	public List<Cube> getListe() {
		// TODO Auto-generated method stub
		List<Cube> tab = new ArrayList<Cube> (); 
		tab.add(this);
		Cube c = this;
		while( c.dessous != null) {
			tab.add(c.dessous);
			c = c.dessous;
		}
		return tab;
	}


}
