package models;

import javax.swing.JOptionPane;

public class AVL extends Tree {
	
	public void balance(Node actual) {
		if (actual.balanceFactor() <= -2) {
			moveRight(actual);
		} else if (2 <= actual.balanceFactor()) {
			moveLeft(actual);
		}
	}
	
	private void moveLeft(Node node) {
		Node high = higher(node);
		Node actual = new Node(node.getInformation());
		actual.setLeft(node.getLeft());
		node.setLeft(actual);
		if (high.getLeft() == null) {
			moveLL(node);
		} else {
			high.setRight(new Node(high.getInformation()));
			high.setInformation(high.getLeft().getInformation());
			high.setLeft(null);
			JOptionPane.showMessageDialog(null, "RL");
			moveLL(node);
		}
	}
	
	private void moveLL(Node node) {
		if (node != null) {
			if (node.getRight() != null) {
				int num = node.getRight().getInformation();
				deleteNode(num);
				node.setInformation(num);
				moveLL(node.getRight());
			}
		}
	}
	
	private void moveRight(Node node) {
		Node small = smaller(node);
		Node actual = new Node(node.getInformation());
		actual.setRight(node.getRight());
		node.setRight(actual);
		if (small.getRight() == null) {
			moveRR(node);
		} else {
			small.setLeft(new Node(small.getInformation()));
			small.setInformation(small.getRight().getInformation());
			small.setRight(null);
			JOptionPane.showMessageDialog(null, "LR");
			moveRR(node);
		}
	}
	
	private void moveRR(Node node) {
		if (node != null) {
			if (node.getLeft() != null) {
				int num = node.getLeft().getInformation();
				deleteNode(num);
				node.setInformation(num);
				moveRR(node.getLeft());
			}
		}
	}
}