import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class dayThree {
    public static void main (String[] args) throws FileNotFoundException {
        File text = new File("input.txt");
        Scanner file = new Scanner(text);
        String[][]data = new String[323][0];
        int index = 0;
        while(file.hasNext()) {
            data[index] = file.nextLine().split("");
            index++; 
        }
        //problem 1
        int treeCount = 0;
        int currPos = 0;
        for(int i = 1; i < data.length; i++) {
            currPos += 3;
            try {
                if(data[i][currPos].equals("#")) {
                    treeCount++;
                }
                    
            } catch(Exception E) { 
                currPos -= data[i].length;
                if(data[i][currPos].equals("#")) {
                    treeCount++;
                }
            }
        }
        System.out.println("Tree count :: " + treeCount);

        //problem 2
        long sum = 1;
        int moveDown = 1;
        for(int moveRight = 1; moveRight <= 9; moveRight += 2){
            treeCount = 0;
            currPos = 0;
            if(!(moveRight <= 7))
                 moveDown++;
            System.out.println(moveDown + "," + moveRight);
            for(int i = moveDown; i < data.length; i += moveDown) {
                if(moveRight <= 7)
                    currPos += moveRight;
                else 
                    currPos += 1;
                try {
                    if(data[i][currPos].equals("#")) 
                        treeCount++;
                } catch(Exception E) { 
                    currPos -= data[i].length;
                    if(data[i][currPos].equals("#")) 
                        treeCount++;
                }
            }
            sum *= treeCount;
        }
        System.out.print("Sum :: " + sum);
    }
}