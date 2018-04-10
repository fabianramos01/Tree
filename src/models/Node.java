package models;

public class Node {

	private int information;
	private Node left;
	private Node right;

	public Node(int information) {
		this.information = information;
	}

	public int balanceFactor() {
		if (right != null  && left != null) {
			return right.height() - right.height();
		} else if (right != null  && left == null) {
			return right.height();
		} else if (right == null  && left != null) {
			return left.height();
		} else {
			return 0;
		}
	}
	
	public int height() {
		return height(this, 0);
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

	public int getInformation() {
		return information;
	}

	public void setInformation(int information) {
		this.information = information;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return String.valueOf(information);
	}
}