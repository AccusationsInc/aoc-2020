import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class dayFour {
    private static String[] fields = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    private static String[] eyeColors = {"amb", "blu", "brn", "gry", "grn", "hzl", "oth"};
    public static void main(String args[]) throws FileNotFoundException {
        File text = new File("input.txt");
        Scanner file = new Scanner(text);
        ArrayList<String []> data = new ArrayList<>();
        StringBuilder stringToAdd = new StringBuilder("");
        while(file.hasNextLine()) {
            String currLine = file.nextLine();
            if(!currLine.equals(""))
                stringToAdd.append(currLine + " ");
            else {
                data.add(stringToAdd.toString().split(" "));
                stringToAdd = new StringBuilder("");
            }
        }
        data.add(stringToAdd.toString().split(" "));
        for(String[] dc : data) {
            System.out.println(Arrays.toString(dc));
        }
        //problem 1
        int count = 0;
        for(String[] document : data) {
            boolean valid = true;
            int index = 0;
            while(index < fields.length && valid) {
                valid = false;
                for(int i = 0; i < document.length; i++){
                    if(document[i].contains(fields[index])){
                        valid = true;
                        break;
                    }
                }
                index++;
            }
            if(valid)
                count++;
        }
        System.out.println("Count :: " + count);

        //problem 2
        count = 0;
        for(String[] document : data) {
            boolean valid = true;
            int index = 0;
            while(index < fields.length && valid) {
                //valid = false;
                for(int i = 0; i < document.length; i++){
                    switch (fields[index]) {
                        case "byr" : 
                            if(document[i].contains("byr")) 
                                valid = checkByr(document[i]);
                            break;
                        case "iyr" :
                            if(document[i].contains("iyr"))
                                valid = checkIyr(document[i]);
                            break;
                        case "eyr" :
                            if(document[i].contains("eyr"))
                                valid = checkEyr(document[i]);
                            break;
                        case "hgt" :
                            if(document[i].contains("hgt"))
                                valid = checkHgt(document[i]);
                            break;
                        case "hcl" :
                            if(document[i].contains("hcl"))
                                valid = checkHcl(document[i]);
                            break;
                        case "ecl" :
                            if(document[i].contains("ecl"))
                                valid = checkEcl(document[i]);
                            break;
                        case "pid" :
                            if(document[i].contains("pid"))
                                valid = checkPid(document[i]);
                            break;   
                    }
                    if(valid) 
                        break;
                }
                index++;
            }
            if(valid)
                count++;
        }
        System.out.println("Count :: " + count);
        System.out.println(checkPid("pid:000000001"));
    }
    public static boolean checkByr(String input) {
        int numToCheck = Integer.parseInt(input.substring(input.indexOf(':') + 1));
        if(1920 <= numToCheck && numToCheck <= 2002)
            return true;
        return false;
    }
    public static boolean checkIyr(String input) {
        int numToCheck = Integer.parseInt(input.substring(input.indexOf(':') + 1));
        if(2010 <= numToCheck && numToCheck <= 2020)
            return true;
        return false;
    }
    public static boolean checkEyr(String input) {
        int numToCheck = Integer.parseInt(input.substring(input.indexOf(':') + 1));
        if(2020 <= numToCheck && numToCheck <= 2030)
            return true;
        return false;
    }
    public static boolean checkHgt(String input) {
        input = input.substring(input.indexOf(':') + 1);
        if(input.contains("cm"))
    
        return false;
    }
    public static boolean checkHcl(String input) {
        if(input.charAt(4) == '#'){
            for(int i = 5; i < input.length(); i++) {
                if(!Character.isDigit(input.charAt(i)))
                    return false;
                else if (!('a' <= input.charAt(i) && input.charAt(i) <= 'f'))
                    return false;
            }
        }
        return false;
    }
    public static boolean checkEcl(String input) {
        for(int i = 0; i < eyeColors.length; i++) {
            if(input.contains(eyeColors[i])) 
                return true;
        }
        return false;
    }
    public static boolean checkPid(String input) {
        int numToCheck = 0;
        if(input.substring(input.indexOf(':') + 1).length() == 9) {
            try {
                numToCheck = Integer.parseInt(input.substring(input.indexOf(':') + 1));
                return true;
            } catch (Exception E) {
                return false;
            }
        }
        return false;
    }
}