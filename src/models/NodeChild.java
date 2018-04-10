package models;

public class NodeChild  {
	
	private NodeNTree node;
	
	public NodeChild(String info) {
		node = new NodeNTree(info);
	}

	public String getInfo() {
		return node.getInfo();
	}
}