package controller;

public enum ActionCommand {

	COMMAND_ADD("COMMAND_ADD", "Agregar"), 
	COMMAND_DELETE("COMMAND_DELETE", "Eliminar"),
	COMMAND_BALANCE("COMMAND_BALANCE", "Balancear");
	
	private String command;
	private String title;
	
	private ActionCommand(String command, String title) {
		this.command = command;
		this.title = title;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getTitle() {
		return title;
	}
}