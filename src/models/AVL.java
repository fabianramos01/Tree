package models;

import javax.swing.JOptionPane;

public class AVL extends Tree {
	
	public int balanceFactor(Node actual) {
		int right = height(actual.getRight(), 0);
		int left = height(actual.getLeft(), 0);
		if (right - left <= -2) {
			moveRight(actual);
		} else if (2 <= right - left) {
			moveLeft(actual);
		}
		return right - left;
	}
	
	private void moveLeft(Node node) {
		Node high = higher(node);
		Node actual = new Node(node.getInformation());
		actual.setLeft(node.getLeft());
		node.setLeft(actual);
		if (high.getLeft() == null) {
			moveLL(node);
		} else {
			high.setRight(high.getLeft());
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
			small.setLeft(small.getRight());
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
	
	private int height(Node actual, int num) {
		if (actual != null) {
			num += 1;
			if (actual.getLeft() != null || actual.getRight() != null) {
				num = height(actual.getLeft(), num);
				if (num < height(actual.getRight(), num)) {
					num = height(actual.getRight(), num);
				}
			}
		}
		return num;
	}
}