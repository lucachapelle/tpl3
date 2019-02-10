import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Table {
	public List<Cube> CubeSurTable = new ArrayList<Cube>();

	public void AddCube(final Cube Cube) {
		this.CubeSurTable.add(Cube);
	}

	public Cube SéléctionnerCube(final Taille Taille, final Couleur Couleur) {
		ListIterator<Cube> it = CubeSurTable.listIterator();
		Cube cube = null;
		boolean trouve = false;
		while (!trouve  && it.hasNext()) {
			cube = it.next();
			trouve = cube.getTaille() == Taille && cube.getCouleur() == Couleur;
		}
		if (trouve) {
			if (cube.getDessus() != null) {
				it.set(cube.getDessous());;
				cube.getDessous().setDessus(null);
				cube.setDessous(null);
				return cube;
			}else{
				it.remove();
				return cube;
			}
		}else {
			return null;

		}
	}

	public int RechercheCube(final Taille Taille, final Couleur couleur, Cube c) {
		ListIterator<Cube> it = CubeSurTable.listIterator();
		Cube cube = null;
		boolean trouve = false;
		while (!trouve  && it.hasNext()) {
			cube = it.next();
			trouve = cube.getTaille() == Taille && cube.getCouleur() == couleur;
		}
		if (trouve && cube.getTaille().getTaille() >= c.getTaille().getTaille()) {
			it.set(c);
			c.setDessous(cube);
			cube.setDessus(c);
			return 0;
		} else {
			
			if (trouve) {
				return 2;
			} else {
				return 1;

			}
		}

	}

	public ListIterator<Cube> recherche(ListIterator<Cube> it, final Taille Taille, final Couleur couleur) {

		return it;

	}

	public List<Cube> getCubeSurTable() {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		return this.CubeSurTable;
	}

	public void setCubeSurTable(final List<Cube> value) {
		// Automatically generated method. Please delete this comment before entering
		// specific code.
		this.CubeSurTable = value;
	}

	public void afficherTable() {
		Cube var;
		String res = "";
		for (int i = 0; i < this.CubeSurTable.size(); i++) {
			List<Cube> tab = new ArrayList<Cube>();
			tab = this.CubeSurTable.get(i).getListe();
			res = "";
			for (int j = tab.size() - 1; j >= 0; j--) {
				var = tab.get(j);
				res = res + var.getTaille().toString().charAt(0);
				res = res + var.getCouleur().toString().charAt(0);
				res = res + ":" + var.getId() + "   ";
			}
			System.out.println(res);

		}
	}

	public void afficherTabletest() {
		String var = "";
		String res1 = "+----+   ";

		for (int i = 0; i < this.CubeSurTable.size(); i++) {
			System.out.print(res1);
		}
		System.out.println();

		for (int i = 0; i < this.CubeSurTable.size(); i++) {
			var = this.CubeSurTable.get(i).getTaille().toString().charAt(0) + ""
					+ this.CubeSurTable.get(i).getCouleur().toString().charAt(0) + ":"
					+ this.CubeSurTable.get(i).getId();
			String res2 = "|" + var + "|   ";
			System.out.print(res2);
		}
		System.out.println();

		for (int i = 0; i < this.CubeSurTable.size(); i++) {
			System.out.print(res1);
		}
		System.out.println();

		System.out.println("----------------------------------------------------------");
	}

}
