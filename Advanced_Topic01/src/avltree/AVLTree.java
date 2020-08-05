package avltree;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;
	
	@Override
	public void insert(T data) {
		root = insert(root,data);
	}

	@Override
	public void traverse() {
		if(root==null)return;
		inOrderTraversal(root);
	}
	
	private void inOrderTraversal(Node<T> node) {
		if(node!=null) {
			inOrderTraversal(node.getLeftNode());
			System.out.print(node + " ");
			inOrderTraversal(node.getRightNode());
		}
	}

	@Override
	public void delete(T data) {
		root = delete(root,data);
	}
	
	private int height(Node<T> node) {
		if(node == null) {
			return -1;
		}
		return node.getHeight();
	}
	
	//LL
	private Node<T> rightRotation(Node<T> parentNode){
		System.out.println("Rotating to the right on node : " + parentNode);
		
		Node<T> newParentNode = parentNode.getLeftNode();
		Node<T> nullNode = newParentNode.getRightNode(); //null이 아닐수도 있음.
		
		newParentNode.setRightNode(parentNode);
		parentNode.setLeftNode(nullNode);
		
		parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode())));
		newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode())));
		
		return newParentNode;
	}
	
	//RR
	private Node<T> leftRotation(Node<T> parentNode){
		System.out.println("Rotating to the left on node : " + parentNode);	
		
		Node<T> newParentNode = parentNode.getRightNode();
		Node<T> nullNode = newParentNode.getLeftNode();
		
		newParentNode.setLeftNode(parentNode);
		parentNode.setRightNode(nullNode);
		
		parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode())));
		newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode())));
		
		return newParentNode;
	}
	
	private Node<T> insert(Node<T> node, T data){
		
		if(node == null) {
			return new Node<>(data);
		}
		
		if(data.compareTo(node.getData())<0) {
			node.setLeftNode(insert(node.getLeftNode(), data));
		} else {
			node.setRightNode(insert(node.getRightNode(),data));
		}
		
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		node = settleViolation(data, node);
		
		return node;
	}
	
	private Node<T> settleViolation(T data, Node<T> node){
		
		int balance = getBalance(node);
		if(balance>1&&data.compareTo(node.getLeftNode().getData())<0) {
			System.out.println("Tree is left-left heavy");
			return rightRotation(node);
		}
		if(balance<-1&&data.compareTo(node.getRightNode().getData())>0) {
			System.out.println("Tree is right-right heavy");
			return leftRotation(node);
		}
		if(balance>1&&data.compareTo(node.getLeftNode().getData())>0) {
			System.out.println("Tree is left-right heavy");
			node.setLeftNode(leftRotation(node.getLeftNode()));
			return rightRotation(node);
		}
		if(balance<-1&&data.compareTo(node.getRightNode().getData())<0) {
			System.out.println("Tree is right-left heavy");
			node.setRightNode(rightRotation(node.getRightNode()));
			return leftRotation(node);
		}
		return node;
	}
	
	private int getBalance(Node<T> node) {
		if(node==null) {
			return 0;
		}
		return height(node.getLeftNode()) - height(node.getRightNode());
	}
	
	private Node<T> delete(Node<T> node, T data){
		
		if(node==null) {
			return null;
		}
		
		if(data.compareTo(node.getData())<0) {
			node.setLeftNode(delete(node.getLeftNode(),data));
		} 
		else if(data.compareTo(node.getData())>0) {
			node.setRightNode(delete(node.getRightNode(),data));
		}
		else {
			if(node.getLeftNode() == null && node.getRightNode() == null) {
				System.out.println("Removing a leaf node..");
				return null;
			}
			
			if(node.getLeftNode() == null) {
				System.out.println("Removing the right child node");
				Node<T> tempNode = node.getRightNode();
				node = null;
				return tempNode;
			}
			else if(node.getRightNode() == null) {
				System.out.println("Removing the left child node");
				Node<T> tempNode = node.getLeftNode();
				node = null;
				return tempNode;
			}
			
			System.out.println("Removing item with the children");
			Node<T> tempNode = getPredecessor(node);
			node.setData(tempNode.getData());
		}
		node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode()))+1);
		return settleDeletion(node);
	}
	
	private Node<T> settleDeletion(Node<T> node){
		int balance = getBalance(node);
		
		if(balance>1) {
			if(getBalance(node.getLeftNode())<0) {
				node.setLeftNode(leftRotation(node.getLeftNode()));
			}
			return rightRotation(node);
		}
		if(balance<-1) {
			if(getBalance(node.getRightNode())>0) {
				node.setRightNode(rightRotation(node.getRightNode()));
			}
			return leftRotation(node);
		}
		return node;
	}
	
	private Node<T> getPredecessor(Node<T> root){
		Node<T> leftNode = root.getLeftNode();
		
		if(leftNode.getRightNode()==null) {
			root.setLeftNode(leftNode.getLeftNode());
			return leftNode;
		}
		Node<T> rightMostChildParent = leftNode;
		Node<T> rightMostChild = rightMostChildParent.getRightNode();
		
		
		while(rightMostChild.getRightNode()!=null) {
			rightMostChildParent = rightMostChild;
			rightMostChild = rightMostChild.getRightNode();
		}
		rightMostChildParent.setRightNode(rightMostChild.getLeftNode());
		
		return rightMostChild;
	}
	
}

























