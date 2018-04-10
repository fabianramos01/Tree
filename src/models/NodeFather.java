package models;

import java.util.ArrayList;

public class NodeFather extends NodeNTree{

	public NodeFather(String info) {
		super(info);
	}
	
	public void add(NodeNTree nodeNTree) {
		addChild(nodeNTree);
	}
	
	public ArrayList<NodeNTree> getChilds() {
		return getChilds();
	}
}