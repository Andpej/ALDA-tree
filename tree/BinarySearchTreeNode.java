package alda.tree;

/**
 * Andreas Pejle anpe1436 
 * Patrick Virtanen pavi4902
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
		if (data.compareTo(this.data) > 0) {
			if (right != null) {
				return right.add(data);
			} else {
				right = new BinarySearchTreeNode<T>(data);
				return true;
			}
		} else if (data.compareTo(this.data) < 0) {
			if (left != null) {
				return left.add(data);
			} else {
				left = new BinarySearchTreeNode<T>(data);
				return true;
			}
		}
		return false;
	}

	private T findMin() {
		if (this.left != null) {
			return this.left.findMin();
		} else {
			return this.data;
		}
	}

	public BinarySearchTreeNode<T> remove(T data) {

		if (data.compareTo(this.data) > 0) {
			if (right != null)
				right = right.remove(data);

		} else if (data.compareTo(this.data) < 0) {
			if (left != null)
				left = left.remove(data);

		} else if (this.right != null && this.left != null) {
			this.data = right.findMin();
			right = right.remove(this.data);

		} else {
			return (right != null) ? right : left;
		}
		return this;
	}

	public boolean contains(T data) {

		if (data.compareTo(this.data) > 0) {
			if (right != null) {
				return right.contains(data);
			}

		} else if (data.compareTo(this.data) < 0) {
			if (left != null) {
				return left.contains(data);
			}

		} else if (data.compareTo(this.data) == 0) {
			return true;
		}
		return false;
	}

	public int size() {

		int sizeCounter = 1;

		if (right != null) {
			sizeCounter += right.size();
		}
		if (left != null) {
			sizeCounter += left.size();
		}
		return sizeCounter;
	}

	public int depth() {

		int depthRight = 0;
		int depthLeft = 0;

		if (this.right != null) {
			depthRight += this.right.depth() + 1;
		}
		if (this.left != null) {
			depthLeft += this.left.depth() + 1;
		}
		if (depthRight > depthLeft) {
			return depthRight;
		} else {
			return depthLeft;
		}
	}

	public String toString() {

		String treeString = "";

		if (data == null) {
			return null;
		}
		if (left != null) {
			treeString += left.toString() + ", ";
		}
		treeString += data;
		if (right != null) {
			treeString += ", " + right.toString();
		}
		return treeString;
	}
}