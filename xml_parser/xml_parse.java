import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class xml_parse {
    public static void main(String[] args) {	
        System.out.println(checkValues());
    }

    public static boolean checkValues() {
        FileInputStream stream = null;
        xml_Tree tree;
        try {
            stream = new FileInputStream("test5.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        ArrayList<String> lines = new ArrayList<String>();
        try {
            while ((strLine = reader.readLine()) != null) {
                String lastWord = strLine.substring(strLine.lastIndexOf(" ")+1);
                lines.add(lastWord);
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
            tree = new xml_Tree(lines);
            return tree.traverseAndCheck(tree.root);
        }
        catch(Exception e){
            return false;
        }
    }

}