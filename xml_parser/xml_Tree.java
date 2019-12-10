import java.util.ArrayList;
import java.lang.String;

public class xml_Tree {
    public rootNode root;
    
    public xml_Tree(ArrayList<String> xmlList) {
        this.root = new rootNode();
        for (String s : xmlList) {
            add(this.root, s);
        }
    }
    
	private class rootNode {

        public ArrayList<Node> children = new ArrayList<Node>(); 

        private rootNode () {
            
        }
    }
	private class Node extends rootNode {
        public String open = null;
        public String close = null;
        public String data = null;
        private Node () {
            
        }
	}
	private String grabOpenTag(String s) {
		return s.substring(0,s.indexOf(">")+1);
	}
	private String grabCloseTag(String s) {
		return s.substring(s.indexOf("/")-1, s.length());
	}
	private String getInnerData(String s) {
		return s.substring(s.indexOf(">")+1, s.lastIndexOf("<"));
	}
	
	private boolean isSingleLineTag(String s) {
		return (s.substring(0, 1).equals("<") && s.contains("</")) && !isCloseTag(s);
	}
	private boolean isCloseTag(String s) {
		return s.substring(0, 2).equals("</");
	}
	private boolean isOpenTag(String s) {
		return (s.substring(0, 1).equals("<") && !s.contains("</"));
	}
	private boolean tagsMatch(String open, String close) {
		return open.equals(close.replace("/",""));
	}
	private boolean isEmptyNode(Node n) {
		return n.open == null;
	}
	private boolean isClosed(Node n) {
		return n.close != null;
	}
	
	private void add(rootNode root, String s) {
		for (Node n : root.children) {
			if (!isClosed(n)) {
				boolean success = add(n,s);
				if(success) {
					return;
        		}
			}
        }
		Node child = new Node();
		add(child, s);
		root.children.add(child);	
	}
		
	private boolean add(Node node, String s) {
		if (isEmptyNode(node)) {
			if(isSingleLineTag(s)) {
				node.open = grabOpenTag(s);
				node.close = grabCloseTag(s);
				node.data = getInnerData(s);
				if(node.data.length() < 1) {
					return false;
				}
				return tagsMatch(node.open, node.close);
			}else if(isCloseTag(s)) {
				return false;
			}else if(isOpenTag(s)) {
				node.open = s;
				return true;
			}else {
				return false;
			}
		}
		for (Node n : node.children) {
			if(!isClosed(n)) {
				boolean success = add(n,s);
	   	 		if(success) {
	   	 			return true;
	   	 		}
			}
	     }
		if(isSingleLineTag(s)) {
			Node child = new Node();
			if(add(child, s)) {
				node.children.add(child);
				return true;
			}else {
				return false;
			}
		}else if(isCloseTag(s)) {
			if (tagsMatch(node.open, s)) {
				node.close = s;
				return true;
			}else {
				return false;
			}
		}else if(isOpenTag(s)) {
			Node child = new Node();
			if(add(child, s)) {
				node.children.add(child);
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

	private boolean isCorrect(rootNode root) {
		return true;
	}
    private boolean isCorrect(Node node) {
    	return (isOpenTag(node.open) && isCloseTag(node.close) && tagsMatch(node.open, node.close));
    }

    private boolean traverseAndCheck(Node node){
        if(node.children.isEmpty()){
            if(node.data == null){
                return false;
            }
            return isCorrect(node);
        }else{
            if (node.data != null){
                return false;
            }
            ArrayList<Boolean> results  = new ArrayList<Boolean>();
            for (Node n : node.children) {
                results.add(traverseAndCheck(n));
            }
            for(boolean b : results) {
                if (!b){
                    return b;
                }
            }
            return isCorrect(node);
        }
    }
    public boolean traverseAndCheck(rootNode root) {
        for(Node n : root.children) {
        	boolean success = traverseAndCheck(n);
        	if (!success) {
        		return success;
        	}
        }
        return true;
    }
}