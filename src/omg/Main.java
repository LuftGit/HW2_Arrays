package omg;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static String[][] array = new String[10][2];
    public static Scanner console = new Scanner(System.in);

    public static void main(String[] args) {
        int[]arr = new int[]{1,2,3,4};
        int[]clonearr = arr.clone();
        System.out.println(arr==clonearr);
        System.out.println(arr[0]==clonearr[0]);

      /* while (true) {


            setValue(array, typeKey(), typeValue());

            //fillArrayWithValue(array, typeValue());

            // System.out.println(isKeyInArray(array, typeKey()));System.out.println(isValueInArray(array, typeValue()));


            //  System.out.println(Arrays.deepToString(array));
            // System.out.println("If u want to stop program, type: stop");if (console.nextLine().equalsIgnoreCase("stop")) {break;}
        }*/
    }

    public static String typeKey() {
        System.out.print("TType key: ");
        return console.nextLine();

    }

    public static String typeValue() {
        System.out.print("Type value: ");
        return console.nextLine();
    }

    public static boolean isKeyInArray(String[][] array, String text) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j == 0; j++) {
                if (array[i][j] == null) {
                    break;
                }
                result = array[i][j].equals(text);
            }
        }
        return result;
    }

    public static int findIndex(String[][] array, String searchString) {
        int resultIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0].equals(searchString)) {
                resultIndex = i;
                break;
            }
        }
        return resultIndex;
    }


    public static void setValue(String[][] array, String key, String value) {
        int indexForExistingKey = findIndex(array, key);
        if (indexForExistingKey != -1) {
            array[indexForExistingKey][1] = value;
        } else {
            int indexForNewKey = searchFirstAvailableKeyIndex(array);
            if (indexForNewKey != -1) {
                array[indexForNewKey][0] = key;
                array[indexForNewKey][1] = value;
            } else {
                // todo do something when array is full
            }
        }
    }

    public static int searchFirstAvailableKeyIndex(String[][] array) {
        int resultIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (Objects.isNull(array[i][0])) {
                resultIndex = i;
                break;
            }
        }
        return resultIndex;
    }


    public static void fillArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == 0) {
                    array[i][j] = typeKey();
                }
                if (j > 0) {
                    array[i][j] = typeValue();
                }
                //  array[i][j] = text;

            }
            System.out.println(Arrays.deepToString(array));

        }

    }

  /*  public static void fillArrayWithValue(String[][] array, String text) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j > 0; j++) {
                array[i][j] = text;

            }

        }

    }*/

}