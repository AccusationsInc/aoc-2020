import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class dayOne{
    public static void main (String args[]) throws FileNotFoundException {
        //Scans in the file, storing all the numbers in a ArrayList
        ArrayList<Integer> data = new ArrayList<>();
        File text = new File("input.txt");
        Scanner file = new Scanner(text);
        while(file.hasNextLine()) {
            data.add(Integer.parseInt(file.nextLine()));
        }
        //Solution for problem one
        for(int i = 0; i < data.size() - 1; i++) {
            for(int c = i + 1; c < data.size(); c++) {
                if(data.get(i) + data.get(c) == 2020) {
                    int answer = data.get(i) * data.get(c);
                    System.out.println("This is the solution for"
                        + " problem one :: " + answer);
                }
            }
        }
        //solution for problem two
        for(int i = 0; i < data.size() - 2; i++) {
            for(int c = i + 1; c < data.size() - 1; c++) {
                for(int j = c + 1; j < data.size(); j++) {
                    if((data.get(i) + data.get(c)) + data.get(j) == 2020) {
                        int answer = data.get(i) * data.get(c) * data.get(j);
                        System.out.println("This is the solution for" 
                            + " problem two :: " + answer);
                    }
                }
            }
        }
    }
}