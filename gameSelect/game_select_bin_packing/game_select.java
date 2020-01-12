package game_select_bin_packing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import game_tree.game;

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
        	int len = games.size()+1;
        	int limit = 121;
        	int[][] bag = new int[len][limit];
        	for (int i = 0; i < len; i++) {
        		for (int j = 0; j < limit; j++) {
        			bag[i][j] = 0;
        		}
        	}
        	for (int i = 1; i < len; i++) {
        		for (int j = 0; j < limit; j++) {
        			bag[i][j] = bag[i-1][j];
        			int w = games.get(i-1).time;
        			int v = games.get(i-1).payout;
        			if (j >= w) {
        				int new_v = bag[i-1][j-w]+v;
        				if ((bag[i][j] < new_v)) {
        					bag[i][j] = new_v;
        				}
        			}
        			System.out.print(bag[i][j]);
        			System.out.print("-");
        			System.out.print(j);
        			System.out.print(" | ");
        		}
        		System.out.println("\n");
        	}
        	ArrayList<game> game_schedule = new ArrayList<game>();
        	int n = len-1;
        	int m = limit-1;
        	while (n != 0) {
        		if (bag[n][m] != bag[n-1][m]) {
        			game g = games.get(n-1);
        			game_schedule.add(g);
        			m = m - g.time;
        		}
        		n--;
        	}
        	
        	int total = bag[len-1][limit-1];
        	int time = 0;
        	for (game g: game_schedule) {
        		String msg = "Game: " + g.name + " Time: " + g.time + " Payout: " + g.payout;
        		System.out.println(msg);
        		time = time + g.time;
        	}
        	System.out.println("Total: " + total + " Time: "+ time);
        	
        }
        catch(Exception e){
        	e.printStackTrace();
            System.out.println("Error parsing games");
        }
	}
}
