import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
class daytwo{
    public static void main(String[] args) throws FileNotFoundException{
        File text = new File("input.txt");
        Scanner file = new Scanner(text);
        ArrayList<String> data = new ArrayList<>(); 
        while(file.hasNext()) {
            data.add(file.nextLine());
        }
        int count = 0;
        //problem one 
        for(int i = 0; i < data.size(); i++) {
            String currentString = data.get(i);
            int lower = Integer.parseInt(currentString.substring(0, currentString.indexOf('-')));
            int higher = Integer.parseInt(currentString.substring(currentString.indexOf('-') + 1, currentString.indexOf(' ')));
            char tgt = currentString.charAt(currentString.indexOf(" ") + 1);
            String pass = currentString.substring(currentString.indexOf(':') + 2);
            int letterCount = 0;
            for(int c = 0; c < pass.length(); c++) {
                if(pass.charAt(c) == tgt)
                    letterCount++;
            }
            if(lower <= letterCount && letterCount <= higher)
                count++;
        }
        System.out.println("Count :: " + count);
        
        //problem two
        count = 0;
        for(int i = 0; i < data.size(); i++) {
            String currentString = data.get(i);
            int posOne = Integer.parseInt(currentString.substring(0, currentString.indexOf('-'))) - 1;
            int posTwo = Integer.parseInt(currentString.substring(currentString.indexOf('-') + 1, currentString.indexOf(' '))) - 1;
            char tgt = currentString.charAt(currentString.indexOf(" ") + 1);
            String pass = currentString.substring(currentString.indexOf(':') + 2);
            boolean one = pass.charAt(posOne) == tgt;
            boolean two = pass.charAt(posTwo) == tgt;
            if(one != two)
                count++;
        }
        System.out.println("Count :: " + count);
    }
}