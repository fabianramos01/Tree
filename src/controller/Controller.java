package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.AVL;
import models.Node;
//import models.Tree;
import views.WindowTree;

public class Controller implements ActionListener {

	private AVL tree;
	private WindowTree window;

	public Controller() {
		tree = new AVL();
		// tree.add(new Node(1));
		// tree.add(new Node(2));
		// tree.add(new Node(3));
		// tree.add(new Node(3));
		// tree.add(new Node(1));
		// tree.add(new Node(2));
		tree.add(new Node(1));
		tree.add(new Node(3));
		tree.add(new Node(2));
//		tree.add(new Node(3));
//		tree.add(new Node(2));
//		tree.add(new Node(1));
		window = new WindowTree(this);
		window.paintTree(tree.getRoot());
	}

	public static void main(String[] args) {
		new Controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (ActionCommand.valueOf(e.getActionCommand())) {
		case COMMAND_ADD:
			tree.add(new Node(Integer.valueOf(JOptionPane.showInputDialog("Id para agregar"))));
			window.paintTree(tree.getRoot());
			break;
		case COMMAND_DELETE:
			tree.deleteNode(Integer.valueOf(JOptionPane.showInputDialog("Id para eliminar")));
			window.paintTree(tree.getRoot());
			break;
		case COMMAND_BALANCE:
			tree.balanceFactor(tree.getRoot());
			window.paintTree(tree.getRoot());
			break;
		}

	}
}