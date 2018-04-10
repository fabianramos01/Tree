package models;

import java.util.ArrayList;

public class NodeNTree {

	private String info;
	private ArrayList<NodeNTree> childs;
	
	public NodeNTree(String info) {
		this.info = info;
		childs = new ArrayList<>();
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ArrayList<NodeNTree> getChilds() {
		return childs;
	}
	
	protected void addChild(NodeNTree nodeNTree) {
		childs.add(nodeNTree);
	}
}