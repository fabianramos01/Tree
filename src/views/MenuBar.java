package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.ActionCommand;
import controller.ConstantList;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;

	public MenuBar(ActionListener actionListener) {
		JMenu menuTree = new JMenu(ConstantList.MENU_TREE);
		JMenuItem itemAdd = new JMenuItem(ConstantList.ITEM_ADD);
		itemAdd.setActionCommand(ActionCommand.COMMAND_ADD.getCommand());
		itemAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		itemAdd.addActionListener(actionListener);
		menuTree.add(itemAdd);
		JMenuItem itemDelete = new JMenuItem(ConstantList.ITEM_DELETE);
		itemDelete.setActionCommand(ActionCommand.COMMAND_DELETE.getCommand());
		itemDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		itemDelete.addActionListener(actionListener);
		menuTree.add(itemDelete);
		add(menuTree);
	}
}