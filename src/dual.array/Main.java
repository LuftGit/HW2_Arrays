package dual.array;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[][] array = new String[10][2];
    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        do {
            System.out.print("Type key: ");

            fillArray(array, getConsoleInput());
            System.out.println("If u want to end program, type key: stop. Continue press: Enter");
        } while (!stopByKey(getConsoleInput()));
    }

    public static String getConsoleInput() {
        //System.out.print("Type key: "); //todo винести
        return console.nextLine();
    }

    public static String typeValue() {
         System.out.print("Type value: ");//todo видалити
        return console.nextLine();
    }

    public static int findExistingKeyIndex(String[][] array, String key) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] != null && array[i][0].equals(key)) {
                System.out.println("this key already exist");
                result = i;
                break;
            }
        }
        return result;
    }

    public static int findFirstEmptyKeyIndex(String[][] array) {
        int result = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == null) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static void fillValue(String[][] array, int keyIndex, String value) {
        if (array[keyIndex][1] == null || !array[keyIndex][1].equals(value)) {
            array[keyIndex][1] = value;
        } else {
            System.out.println("this value already exist");
        }
    }

    /**
     * the method shifts all array data up by 1(array[0] data will be in array[1])
     */
    public static void shiftArrayUp(String[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            array[i][0] = array[i - 1][0];
            array[i][1] = array[i - 1][1];
        }
    }


    public static boolean stopByKey(String key) {
        boolean result = false;
        if (key.equalsIgnoreCase("stop")) {
            System.out.println(Arrays.deepToString(array));
            result = true;
            //System.exit(0);
        }
        return result;
    }
    public static void ifKeyExist (String[][] array){

    }

    public static void fillArray(String[][] array, String key) {


        int existingKeyIndex = findExistingKeyIndex(array, key);
        if (existingKeyIndex != -1) {
            fillValue(array, existingKeyIndex, typeValue());
        } else {
            int firstEmptyKeyIndex = findFirstEmptyKeyIndex(array);
            if (firstEmptyKeyIndex != -1) {
                array[firstEmptyKeyIndex][0] = key;
                array[firstEmptyKeyIndex][1] = typeValue();
            } else {
                shiftArrayUp(array);

                array[0][0] = key;
                array[0][1] = typeValue();
            }
        }

        System.out.println(Arrays.deepToString(array));


    }


}

/*
public static void fillArray(String[][] array, String key) {

        //  stopByKey(key); //todo refactor
        int existingKeyIndex = findExistingKeyIndex(array, key);
        if (existingKeyIndex != -1) {
            fillValue(array, existingKeyIndex, typeValue());
        } else {
            int firstEmptyKeyIndex = findFirstEmptyKeyIndex(array);
            if (firstEmptyKeyIndex != -1) {
                array[firstEmptyKeyIndex][0] = key;
                array[firstEmptyKeyIndex][1] = typeValue();
            } else {
                shiftArrayUp(array);

                array[0][0] = key;
                array[0][1] = typeValue();
            }
        }

        System.out.println(Arrays.deepToString(array));


    }

 */



