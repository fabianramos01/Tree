package models;

public class Tree {

	private Node root;

	public void add(Node node) {
		if (searhNode(root, node.getInformation()) == null) {
			if (root != null) {
				add(root, node);
			} else {
				root = node;
			}
		}
	}

	private void add(Node base, Node newNode) {
		if (newNode.getInformation() < base.getInformation()) {
			if (base.getLeft() != null) {
				add(base.getLeft(), newNode);
			} else {
				base.setLeft(newNode);
			}
		} else {
			if (base.getRight() != null) {
				add(base.getRight(), newNode);
			} else {
				base.setRight(newNode);
			}
		}
	}

	public void deleteNode(int info) {
		Node nodeRemove = searhNode(root, info);
		if (info != root.getInformation()) {
			Node before = before(root, info);
			if (nodeRemove != null) {
				if (nodeRemove.getLeft() == null && nodeRemove.getRight() == null) {
					deleteLeaf(before, nodeRemove);
				} else if (nodeRemove.getLeft() != null && nodeRemove.getRight() != null) {
					deleteBaseLeafs(nodeRemove);
				} else {
					deleteAfter(before, nodeRemove);
				}
			}
		} else {
			deleteRoot(info);
		}
	}

	private void deleteRoot(int info) {
		if (root.getLeft() == null && root.getRight() == null) {
			root = null;
		} else if (root.getLeft() != null && root.getRight() != null) {
			deleteBaseLeafs(root);
		} else if (root.getLeft() != null || root.getRight() == null) {
			root.setInformation(root.getLeft().getInformation());
			root.setLeft(null);
		} else {
			root.setInformation(root.getRight().getInformation());
			root.setRight(null);
		}
	}

	private void deleteBaseLeafs(Node nodeRemove) {
		int higherNum = higher(nodeRemove.getLeft());
		int smallerNum = smaller(nodeRemove.getRight());
		if ((nodeRemove.getInformation() - smallerNum) > (higherNum - nodeRemove.getInformation())) {
			deleteNode(smaller(nodeRemove.getRight()));
			nodeRemove.setInformation(smallerNum);
		} else {
			deleteNode(higher(nodeRemove.getLeft()));
			nodeRemove.setInformation(higherNum);
		}
	}

	private void deleteLeaf(Node before, Node nodeRemove) {
		if (before.getRight() == nodeRemove) {
			before.setRight(null);
		} else {
			before.setLeft(null);
		}
	}

	private void deleteAfter(Node before, Node nodeRemove) {
		if (before.getRight() == nodeRemove) {
			if (nodeRemove.getRight() != null) {
				before.setRight(nodeRemove.getRight());
			} else if (nodeRemove.getLeft() != null) {
				before.setRight(nodeRemove.getLeft());
			}
		} else {
			if (nodeRemove.getRight() != null) {
				before.setLeft(nodeRemove.getRight());
			} else if (nodeRemove.getLeft() != null) {
				before.setLeft(nodeRemove.getLeft());
			}
		}
	}

	private Node before(Node base, int info) {
		if (base != null) {
			if (base.getRight() != null) {
				if (base.getRight().getInformation() == info) {
					return base;
				}
			}
			if (base.getLeft() != null) {
				if (base.getLeft().getInformation() == info) {
					return base;
				}
			}
			if (base.getInformation() < info) {
				return before(base.getRight(), info);
			} else {
				return before(base.getLeft(), info);
			}
		}
		return null;
	}

	private Node searhNode(Node base, int info) {
		if (base != null) {
			if (base.getInformation() == info) {
				return base;
			} else if (base.getInformation() < info) {
				return searhNode(base.getRight(), info);
			} else {
				return searhNode(base.getLeft(), info);
			}
		}
		return null;
	}

	public int higher() {
		if (root != null) {
			return higher(root);
		}
		return 0;
	}

	private int higher(Node node) {
		if (node.getRight() != null) {
			return higher(node.getRight());
		} else {
			return node.getInformation();
		}

	}

	public int smaller() {
		if (root != null) {
			return smaller(root);
		}
		return 0;
	}

	private int smaller(Node node) {
		if (node.getLeft() != null) {
			return smaller(node.getLeft());
		} else {
			return node.getInformation();
		}
	}

	public Node getRoot() {
		return root;
	}
}