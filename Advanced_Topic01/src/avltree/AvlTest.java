package avltree;

public class AvlTest {

	public static void main(String[] args) {
		Tree<Integer> avl = new AVLTree<>();
//		avl.insert(35);
//		avl.insert(20);
//		avl.insert(70);
//		avl.insert(15);
//		avl.insert(30);
//		avl.insert(25);
//		avl.insert(80);
//		avl.insert(88);
//		avl.insert(50);
//		avl.insert(45);
//		avl.insert(60);
//		avl.insert(40);
//		avl.insert(55);
//		avl.insert(65);
//		avl.insert(53);
		
		avl.insert(50);
		avl.insert(20);
		avl.insert(70);
		avl.insert(80);
		
		avl.delete(70);
		
		avl.traverse();
	}

}
