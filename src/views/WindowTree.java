package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
	private static final Font AGENCY_FB = new Font("Agency FB", Font.BOLD, 20);
	private Node root;

	public WindowTree(ActionListener listener) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		panelButtons(listener);
		setJMenuBar(new MenuBar(listener));
		setVisible(true);
	}

	private void panelButtons(ActionListener listener) {
		JPanel panel = new JPanel(new GridLayout(1, 3));
		JButton btnAdd = new JButton(ActionCommand.COMMAND_ADD.getTitle());
		btnAdd.setActionCommand(ActionCommand.COMMAND_ADD.getCommand());
		btnAdd.addActionListener(listener);
		btnAdd.setFont(AGENCY_FB);
		panel.add(btnAdd);
		JButton btnDelete = new JButton(ActionCommand.COMMAND_DELETE.getTitle());
		btnDelete.setActionCommand(ActionCommand.COMMAND_DELETE.getCommand());
		btnDelete.addActionListener(listener);
		btnDelete.setFont(AGENCY_FB);
		panel.add(btnDelete);
		JButton btnBalance = new JButton(ActionCommand.COMMAND_BALANCE.getTitle());
		btnBalance.setActionCommand(ActionCommand.COMMAND_BALANCE.getCommand());
		btnBalance.addActionListener(listener);
		btnBalance.setFont(AGENCY_FB);
		panel.add(btnBalance);
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
			g.setFont(AGENCY_FB);
			addNode(root, 0, getContentPane().getWidth() / 2, 90, g);
		}
	}

	public void addNode(Node node, int x, int width, int height, Graphics g) {
		if (node != null) {
			g.fillOval(x + width, height, 50, 50);
			g.setColor(Color.WHITE);
			g.drawString(node.toString(), x + width + 19, height + 33);
			g.setColor(Color.BLACK);
			g.drawString(String.valueOf(node.balanceFactor()), x + width, height);
			addNode(node.getLeft(), x + width, -1 * (Math.abs(width) / 2), height + 100, g);
			addNode(node.getRight(), x + width, (Math.abs(width) / 2), height + 100, g);
		}
	}
}