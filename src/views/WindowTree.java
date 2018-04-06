package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ActionCommand;
import models.Node;

public class WindowTree extends JFrame {

	private static final long serialVersionUID = 1L;
	private Node root;

	public WindowTree(ActionListener listener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		panelButtons(listener);
		setVisible(true);
	}

	private void panelButtons(ActionListener listener) {
		JPanel panel = new JPanel(new GridLayout(1, 2));
		JButton btnAdd = new JButton(ActionCommand.COMMAND_ADD.getTitle());
		btnAdd.setActionCommand(ActionCommand.COMMAND_ADD.getCommand());
		btnAdd.addActionListener(listener);
		panel.add(btnAdd);
		JButton btnDelete = new JButton(ActionCommand.COMMAND_DELETE.getTitle());
		btnDelete.setActionCommand(ActionCommand.COMMAND_DELETE.getCommand());
		btnDelete.addActionListener(listener);
		panel.add(btnDelete);
		add(panel, BorderLayout.PAGE_END);
	}

	public void paintTree(Node root) {
		this.root = root;
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if (root != null) {
			addNode(root, 0, getContentPane().getWidth() / 2, 50, g);
		}
	}

	public void addNode(Node node, int x, int width, int height, Graphics g) {
		if (node != null) {
			g.fillOval(x + width, height, 50, 50);
			g.setColor(Color.WHITE);
			g.drawString(node.toString(), x + width + 20, height + 30);
			g.setColor(Color.BLACK);
			addNode(node.getLeft(), x + width, -1 * (Math.abs(width) / 2), height + 100, g);
			addNode(node.getRight(), x + width, (Math.abs(width) / 2), height + 100, g);
		}
	}
}