package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryBaumList {
	Node root;

	// -----------------------------------------------------------------
	private int findTreeHeightRekursiv(Node temp) {
		if (temp == null)
			return -1;

		int left_subTree = findTreeHeightRekursiv(temp.left);
		int right_subTree = findTreeHeightRekursiv(temp.right);

		if (left_subTree > right_subTree)
			return 1 + left_subTree;

		return 1 + right_subTree;
	}

	public int getHeight() {
		return findTreeHeightRekursiv(root);
	}

	// -----------------------------------------------------------------
	private void additerativ(int value) {
		// erzeuge eine neue knote
		Node newNode = new Node();
		// setze in knote einen Wert
		newNode.value = value;
		// ersetze left Knote auf Null
		newNode.left = null;
		// ersetze rechte Knote auf Null
		newNode.right = null;

		// wenn meine Liste leer ist
		if (root == null) {
			this.root = newNode;
			return;
		}
		// Wenn sie nicht leer!

		// temp root, um einfacher zu suchen
		Node temp = root;
		// da mein Temp bis null Knote läuft,
		// speichere ich seinen vorhängieren Wert
		Node merker = temp;
		while (temp != null) {
			// speichere temp vorhängieren Wert
			merker = temp;
			// wenn soll ich die linke Seite betrachten
			if (value < temp.value)
				temp = temp.left;

			// wenn nein soll ich die rechte Seite betrachten
			else
				temp = temp.right;
		}
		// so wenn ich ganz unten bin, soll ich sehen, ob ich die Knote rechts oder
		// linke einsetzen soll
		// Wenn ja, Knote auf der Linke Seite einsetzen
		if (value < merker.value)
			merker.left = newNode;
		// Wenn nein, Knote auf der rechte Seite einsetzen
		else
			merker.right = newNode;
	}

	private void addRekursiv(Node temp, int value) {

		// erzeuge eine neue knote
		Node newNode = new Node();
		// setze in knote einen Wert
		newNode.value = value;
		// ersetze left Knote auf Null
		newNode.left = null;
		// ersetze rechte Knote auf Null
		newNode.right = null;
		// falls die Liste leer ist!
		if (temp == null) {
			root = newNode;
			System.out.println("Die Root: " + root.value);
			return;
		}
		// Wenn ja die Linke Seite betrachten
		if (value < temp.value) {
			// Wenn mein temp die die Knote null erreicht
			if (temp.left == null) {
				// erstze die Knote
				temp.left = newNode;
				System.out.println("Linke Knote: " + temp.left.value);
			}
			// wenn mein Temp die Knote null nicht erreicht hat
			else {
				// laufe weiter
				addRekursiv(temp.left, value);
			}

		}
		// wenn die Value größer als die Root
		// also die rechte Seite betrachten
		else {
			if (temp.right == null) {
				// erstze die Knote
				temp.right = newNode;
				System.out.println("Rechte Knote: " + temp.right.value);

			} else {
				// laufe Weiter
				addRekursiv(temp.right, value);
			}
		}
	}

	public void addElement(int value) {
		// additerativ(value);
		addRekursiv(root, value);

	}

	// -----------------------------------------------------------------
	private int findMinRekursiv(Node temp) {

		if (temp.left == null)
			return temp.value;

		return findMinRekursiv(temp.left);
	}

	private int findMinIterativ(Node temp) {

		while (temp.left != null)
			temp = temp.left;

		return temp.value;
	}

	public int findMin() {
		return findMinRekursiv(root);
		// return findMinIterativ(root);
	}
	// -----------------------------------------------------------------

	// -----------------------------------------------------------------
	private int findMaxRekursiv(Node temp) {
		// // Wenn es kein rechtes Kind gibt, ist dies das Maximum
		if (temp.right == null)
			return temp.value;

		// Rekursiv weiter nach rechts gehen
		return findMaxRekursiv(temp.right);
	}

	private int findMaxIterativ(Node temp) {
		while (temp.right != null)
			temp = temp.right;

		return temp.value;
	}

	public int findMax() {
		// Es gibt keine Elemente
		if (root == null)
			return -1;

		// Wenn ja, dann hat root den Max Wert
		if (root.right == null)
			return root.value;

		// return findMaxRekursiv(root);
		return findMaxIterativ(root);
	}

	// -----------------------------------------------------------------
	private void printPreorder(Node temp) {// [root][left][right]
		if (temp == null)
			return;
		System.out.print(temp.value + " ");
		printPreorder(temp.left);
		printPreorder(temp.right);
	}

	private void printInorder(Node temp) {// [left][root][right]
		if (temp == null) {
			return;
		}
		printInorder(temp.left);
		System.out.print(temp.value + " ");
		printInorder(temp.right);

	}

	private void printPostoder(Node temp) {// [left][right][root]
		if (temp == null)
			return;

		printPreorder(temp.left);
		printPreorder(temp.right);
		System.out.print(temp.value + " ");
	}

	private void BreadthFirst() {
		// Erstelle eine Queue (Warteschlange) vom Typ LinkedList, um die Knoten für die
		// Level-Order Traversal zu speichern.
		Queue<Node> q1 = new LinkedList<>();

		// Füge den Wurzelknoten des Baums in die Warteschlange ein.
		// Dies ist der Startpunkt für die Breadth-First Traversal.
		q1.add(root);

		// Solange die Warteschlange nicht leer ist, gibt es noch Knoten zu besuchen.
		while (!q1.isEmpty()) {
			// Schau dir das erste Element in der Warteschlange an, ohne es zu entfernen.
			// Dies gibt dir den aktuellen Knoten, den du verarbeiten willst.
			Node temp = q1.peek();

			// Entferne das Element (den Knoten), das gerade verarbeitet wird, aus der
			// Warteschlange.
			// Dies verschiebt die Warteschlange und macht den nächsten Knoten zum
			// "Front"-Element.
			q1.remove();

			// Gib den Wert des aktuellen Knotens aus, den du gerade bearbeitest.
			// Dies ist der eigentliche Schritt, bei dem du die Traversal-Ergebnisse
			// ausgibst.
			System.out.print(temp.value + " ");

			// Wenn der linke Kindknoten existiert, füge ihn zur Warteschlange hinzu.
			// Dies stellt sicher, dass der linke Kindknoten später in der richtigen
			// Reihenfolge bearbeitet wird.
			if (temp.left != null)
				q1.add(temp.left);

			// Wenn der rechte Kindknoten existiert, füge ihn ebenfalls zur Warteschlange
			// hinzu.
			// Dies stellt sicher, dass der rechte Kindknoten nach dem linken Kindknoten
			// bearbeitet wird.
			if (temp.right != null)
				q1.add(temp.right);
		}
	}

	public void printDepth() {
		// printPreorder(root);
		// printInorder(root);
		BreadthFirst();
	}
	// -----------------------------------------------------------------
	
	/*
	 * Löschen von Knoten: 
	 * - wenn eine Knote gelöscht werden soll, sollen erst 4 wichtige Eigenschaften betrachtet werden: 
	 * 		1. ob die Knote überhaupt igrendwo im Baum liegt (suchen)
	 * 		2. ob die Knote ein Blatt (leaf Node) ist,das heißt die Knote hat weder rechte Knote noch linke Knote 
	 * 		3. ob die Knote nur ein einziges Kind hat 
	 * 		4. ob die Knote zwei Kinder hat
	 * 			4.1 hier entscheidt man, was er nehmen möchte:
	 * 				. Inorder-Vorgänger: Suche nach dem größten Knoten im linken Teilbaum
	 * 				. Inorder-Nachfolger: Suche nach dem kleinsten Knoten im rechten Teilbaum.
	 * 
	 */

	// 1. Suchen
	private boolean searchNummberIterativ(int value) {
		if (root == null)
			return false;
		
		Node temp = root;
		while (temp.value != value) {
			if (value < temp.value && temp.left != null)
				temp = temp.left;

			else if (value >= temp.value && temp.right != null)
				temp = temp.right;

			else
				break;
		}
		if (temp.value == value)
			return true;

		return false;

	}
	
	private boolean searchNummberRekursiv(Node temp , int value) {
		if (temp == null)
			return false;
		
		if (temp.value == value)
			return true;
		
		else if(value < temp.value)
			return	searchNummberRekursiv(temp.left , value);
		
		else
			return searchNummberRekursiv(temp.right , value);
			
	}
	
	public void searchNummber(int value) {
		
		if(searchNummberRekursiv(root,value))
			System.out.println("Ist gefunden: " + value);
		else
			System.out.println("Ist nicht gefunden!");
	}
  
	
	//2. löschen als leaf Node
	private void removeleafNode(int value) {
		if (!searchNummberIterativ(value)) {
			System.out.println("Die zahl befindet sich nicht im Baum!");
			return;
		}
		Node temp = root;
		Node merker = null;
		while( temp.value != value) {
			merker = temp;
			if (value < temp.value)
				temp = temp.left;
			
			else if (value >= temp.value)
				temp = temp.right;
		}
		if (temp.value < merker.value)
			merker.left = null;
		
		else
			merker.right = null;
	}
	
	//3. lösche eine Knote mit einem einzigen Kind
	private void removeWithOneChild(int value) {
		if (!searchNummberIterativ(value)) {
			System.out.println("Die zahl befindet sich nicht im Baum!");
			return;
		}
		Node temp = root;
		Node merker = null;
		while( temp.value != value) {
			merker = temp;
			if (value < temp.value)
				temp = temp.left;
			
			else if (value >= temp.value)
				temp = temp.right;
		}
		
		if (temp.left != null)
			merker.left = temp.left;
		else
			merker.right = temp.right;
		
	}
	
	//4. lösche eine Knote mit zwei Kindern
	private void removeWithTwoChildern(int value) {
		if (!searchNummberIterativ(value)) {
			System.out.println("Die zahl befindet sich nicht im Baum!");
			return;
		}
		Node temp = root;
		Node merker = null;
		while( temp.value != value) {
			if (value < temp.value)
				temp = temp.left;
			
			else if (value >= temp.value)
				temp = temp.right;
			
			merker = temp;
		}
		temp = temp.left;
		Node merker2 = temp;
		while(temp.right != null) {
			merker2 = temp;
			temp = temp.right;
		}
		merker.value = temp.value;
		merker2.right = null;
	}
	
	//2,3,4 Cases
	private void removWithAllCases(int value) {
		if (!searchNummberIterativ(value)) {
			System.out.println("Die zahl befindet sich nicht im Baum!");
			return;
		}

		Node temp = root;
		Node merker = null;
		while (temp.value != value) {
			merker = temp;
			if (value < temp.value)
				temp = temp.left;

			else if (value >= temp.value)
				temp = temp.right;

		}

		// Die knote ist ein Blatt (leaf Node)
		if (temp.left == null && temp.right == null) {
			if (merker == null)
				root =null;
			else if (merker.left == temp)
				merker.left = null;
			else
				merker.right = null;
		}
		
		// Die Knote hat genau ein Kind entweder links oder rechts
		if (temp.left == null || temp.right == null) {
			if (temp.left != null && temp.right == null)
				merker.left = temp.left;

			else
				merker.right = temp.right;

			return;
		}

		// Die Knote hat zwei Kinder
		else {
			merker = temp;
			// weg(1): nach links gehen und ganz nach unten rechts gehen
			temp = temp.left;
			Node merker2 = temp;
			while (temp.right != null) {
				merker2 = temp;
				temp = temp.right;
			}
			merker.value = temp.value;
			merker2.right = null;
		}
		
		
		
		

	}
	public void removNode(int value) {
		// removeleafNode(value); 
		//removeWithOneChild(value);
		//removeWithTwoChildern(value);
		 removWithAllCases(value);
	}
	
}
