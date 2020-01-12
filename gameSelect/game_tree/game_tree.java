package game_tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.String;


public class game_tree {
	rootNode root;
	ArrayList<game> games;
	int limit;
	public game_tree(ArrayList<game> games, int limit) {
		this.games = games;
		this.limit = limit;
		this.root = new rootNode();
		for (game g: games) {
			this.add(this.root, g);
		}
	}

	
	private class rootNode {

        public ArrayList<Node> children = new ArrayList<Node>(); 

        private rootNode () {
            
        }
    }
	
	private class Node extends rootNode {
		private int time_total;
		private int cash_total;
		game game;
		ArrayList<game> games_left;
        private Node (int time_total, int cash_total, game game, ArrayList<game> games_left) {
            this.time_total = time_total;
            this.cash_total = cash_total;
            this.game = game;
            this.games_left = games_left;
        }
	}
	
	private class scheduleComparer implements Comparator<game_schedule> 
	{ 
	    public int compare(game_schedule a, game_schedule b) 
	    { 
	        return Integer.compare(a.total, b.total); 
	    } 
	} 
	
	private void add(Node node) {
		for (game g : node.games_left) {
			if ((node.time_total + g.time) <= this.limit) {
				ArrayList<game> games_left_ = (ArrayList<game>) node.games_left.clone();
				games_left_.remove(g);
				Node n = new Node((node.time_total + g.time),(node.cash_total + g.payout), g, games_left_);
				node.children.add(n);
				this.add(n);
			}
		}
	}
	private void add(rootNode root, game g) {
		ArrayList<game> games_left = (ArrayList<game>) this.games.clone();
		games_left.remove(g);
		Node n = new Node(g.time, g.payout, g, games_left);
		root.children.add(n);
		this.add(n);
	}

	public game_schedule find_schedule() {
		return find_schedule(this.root);
	}
	public game_schedule find_schedule(rootNode root) {
		ArrayList<game_schedule> schedules = new ArrayList<game_schedule>();
		ArrayList<game> games = new ArrayList<game>();
		for (Node n : root.children) {
			schedules.add(find_schedule(n, games));
		}
		Collections.sort(schedules, new scheduleComparer().reversed());
		return schedules.get(0);
	}
	public game_schedule find_schedule(Node node, ArrayList<game> games) {
		if (node.children.size() > 0) {
			ArrayList<game_schedule> schedules = new ArrayList<game_schedule>();
			for (Node n : node.children) {
				ArrayList<game> games_clone = (ArrayList<game>) games.clone();
				games_clone.add(node.game);
				schedules.add(find_schedule(n, games_clone));
			}
			Collections.sort(schedules, new scheduleComparer().reversed());
			return schedules.get(0);
		}else {
			ArrayList<game> games_clone = (ArrayList<game>) games.clone();
			games_clone.add(node.game);
			game_schedule games_ = new game_schedule(node.cash_total, games_clone);
			return games_;
		}
	}
}
