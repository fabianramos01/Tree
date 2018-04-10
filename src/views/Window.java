package views;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import models.Node;

public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTree jTree;
	private DefaultMutableTreeNode model;
	
	public Window() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		model = new DefaultMutableTreeNode();
		jTree = new JTree(model);
		add(new JScrollPane(jTree), BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void paintTree(Node root) {
		DefaultMutableTreeNode uiRoot = new DefaultMutableTreeNode(root);
		model.add(uiRoot);
		createNode(uiRoot, root.getLeft());
		createNode(uiRoot, root.getRight());
	}
	
	private void createNode(DefaultMutableTreeNode actual, Node node) {
		if (node != null) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(node);
			actual.add(newNode);
			createNode(newNode, node.getLeft());
			createNode(newNode, node.getRight());
		}
	}
}