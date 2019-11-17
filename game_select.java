package game_tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class game_select {
	public static void main(String[] args) {	
        select();
    }
	
	public static game parseLine (String line) {
		String[] split = line.split(",");
		return new game(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]));
	}
	
	public static void select() {
		FileInputStream stream = null;
		try {
            stream = new FileInputStream("games.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		String strLine;
        ArrayList<String> lines = new ArrayList<String>();
        try {
            while ((strLine = reader.readLine()) != null) {
                lines.add(strLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        	ArrayList<game> games = new ArrayList<game>();
        	for (String s : lines) {
        		games.add(parseLine(s));
        	}
        	game_tree tree = new game_tree(games, 120);
        	game_schedule schedule = tree.find_schedule();
        	int total = schedule.total;
        	for (game g: schedule.games) {
        		System.out.println(g.name);
        	}
        	System.out.println("Payout: " + total);
        }
        catch(Exception e){
        	e.printStackTrace();
            System.out.println("Error parsing games");
        }
	}
}
