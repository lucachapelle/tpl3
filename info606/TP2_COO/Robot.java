import java.io.Console;

public class Robot {
	public static final String RED = "\u001B[41m";

	int nbCube;
	
	private Cube cubeTenu;

    private Table Support;

    public Robot(Table tab) {
		// TODO Auto-generated constructor stub
    	nbCube =3;
    	this.Support = tab;
	}

	public Cube CréerCube() {
        // TODO Auto-generated return
        return null;
    }

    public boolean MainVide() {
        // TODO Auto-generated return
        return this.cubeTenu == null;
    }

    public void CréerCube(final Taille Taille, final Couleur Couleur) {
        // TODO Auto-generated return
    	 Cube cube = new Cube(Taille,Couleur);
    	 cube.setId(nbCube++);
    	 this.cubeTenu = cube;
    }

    public void TenirCube(final Cube Cube) {
    }

    public void DétruireCube(final Cube Cube) {
    }

    public void PoserSurTable() {
    	Support.AddCube(cubeTenu);
    	LacherCube();
		
    }

    public void LacherCube() {
    	this.cubeTenu = null;
    }

    public void PrendreCube(final Taille Taille, final Couleur Couleur) {
    	this.cubeTenu = this.Support.SéléctionnerCube(Taille, Couleur);
    }

    public int PoserSurCube(final Taille Taille, final Couleur Couleur) {
    	int res = Support.RechercheCube(Taille, Couleur,this.cubeTenu);
		return res;
    }

    public Table getSupport() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.Support;
    }

    public void setSupport(final Table value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.Support = value;
    }

    public Cube getCubeTenu() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.cubeTenu;
    }

    public void setCubeTenu(final Cube value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.cubeTenu = value;
    }

	public void afficherRobot() {
		// TODO Auto-generated method stub

		if (MainVide()) {
			System.out.println("     __");
			System.out.println("    /");
			System.out.println("   /\\");
			System.out.println("  /  \\");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("---                   ");
		}else {
			System.out.println("     __");
			System.out.println("    / +---+");
			  System.out.print("   /\\ | ");System.out.print(this.cubeTenu.getTaille().toString().charAt(0) +""+ this.cubeTenu.getCouleur().toString().charAt(0) + ":"+  this.cubeTenu.getId());System.out.println(" |");
			System.out.println("  /  \\+---+");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println(" |");
			System.out.println("---                   ");
		}



	}

}
