package alda.tree;

/**
 * 
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) De ändringar som är tillåtna är dock
 * begränsade av följande:
 * <ul>
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * </ul>
 * 
 * @author henrikbe
 * 
 * @param <T>
 */
@SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns här
							// tillfälligt för att vi inte ska tro att det är
							// fel i koden. Varningar ska normalt inte döljas på
							// detta sätt, de är (oftast) fel som ska fixas.

public class BinarySearchTreeNode<T extends Comparable<T>> {

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;

	public BinarySearchTreeNode(T data) {
		this.data = data;
	}

	public boolean add(T data) {

		if (data == null) {
			return false;
		}
		// Om den nya noden är större än den nuvarande -> gå höger
		if (data.compareTo(this.data) > 0) {
			// Anropar sig själv tills den når null
			if (right != null) {
				right.add(data);
				// När den når null lägger den till en ny nod
			} else {
				right = new BinarySearchTreeNode<T>(data);
				return true;
			}
		}
		// Om den nya noden är mindre än den nuvarande -> gå vänster
		else if (data.compareTo(this.data) < 0) {
			// Anropar sig själv tils den når null
			if (left != null) {
				left.add(data);
				// När den når null lägger den till en ny nod
			} else {
				left = new BinarySearchTreeNode<T>(data);
				return true;
			}
		}
		return false;
	}

	private T findMin() {
		// så länge vänster sida ej pekar på null -> anropa sig själv
		if (this.left != null) {
			return this.left.findMin();
		// returnerar det lägsta värdet till slut
		} else {
			return this.data;
		}
	}
	
	private T findMax() {
		// så länge höger sida ej pekar på null -> anropa sig själv
		if(this.right != null) {
			return this.right.findMax();
		// returnerar det högsta värdet till slut
		} else {
			return this.data;
		}
	}
	
	// 4 olika cases:
	// 1. Noden finns inte i trädet
	// 2. Noden som ska tas bort har ej några barn
	// 3. Noden som ska tas bort har ett barn
	// 4. Noden som ska tas bort har två barn
	
	public BinarySearchTreeNode<T> remove(T data) {
	return null;
	}

	public boolean contains(T data) {
		if (data == null) {
			return false;
		}
		// Om sökt nod är större än aktuell -> gå höger
		if (data.compareTo(this.data) > 0) {
			if (right != null) {
				return right.contains(data);
			}  
			return false;
		}
		// Om sökt nod är mindre än aktuell -> gå vänster
		else if (data.compareTo(this.data) < 0) {
			if (left != null) {
				return left.contains(data);
			} 
			return false;
		// Om noden hittas
		} else if (data.compareTo(this.data) == 0) {
			return true;
		}
		return false;
	}

	public int size() {
		// Initierad till 1 för att räkna med root-noden
		int sizeCounter = 1;

		// Räknar alla i högerled tills null
		if (right != null) {
			sizeCounter += right.size();
		}
		// Räknar alla i vänsterled tills null
		if (left != null) {
			sizeCounter += left.size();
		}
		// Returnerar resultatet
		return sizeCounter;
	}

	public int depth() {
		// Räknare för både sidor av trädet
		int depthRight = 0;
		int depthLeft = 0;

		//Räknar noder och nivåer på högersida
		if (this.right != null) {
			depthRight += this.right.depth() + 1;
		}

		//Räknar noder och nivåer på vänstersida
		if (this.left != null) {
			depthLeft += this.left.depth() + 1;
		}
		// Returnera höger- eller vänsterdjup beroende på storlek
		if (depthRight > depthLeft) {
			return depthRight;
		} else {
			return depthLeft;
		}
	}
	
	public String toString() {
		
		String treeString = "";
		
		if(data == null) {
			return null;
		}
		// Kör vänstersida av träd toString med ", " mellan varje element
		if(left != null) {
		treeString += left.toString() + ", ";
		}
		treeString += data;
		// Kör högersida av träd toString med ", " mellan varje element
		if(right != null) {
			treeString += ", " + right.toString();
		}	
		return treeString;
	}
}
