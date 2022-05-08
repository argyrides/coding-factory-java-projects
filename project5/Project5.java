package gr.aueb.cf.projects.project5;

import java.util.Arrays;

public class Project5 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,5,5,4,4,4,4,3,3,3,3,6,6,4,7,8,9,3,4,7,8,8,8,9,9,9};
        Arrays.sort(array);
        int key = 1;
        int[] minMaxIndexArray = getLowAndHighIndexOf(array,key);

        for (int item: array) {
            System.out.println(item);
        }

        System.out.println("-----------------------------");
        if(minMaxIndexArray[0] < 0){
            System.out.println("Key not found into array.");
        }
        else{
            System.out.println("Key:"+ key + "," + "Min Index:" + minMaxIndexArray[0] + "," + "Max Index:" + minMaxIndexArray[1]);
        }
    }

    public static int[] getLowAndHighIndexOf(int[] arr, int key){
        int[] returnedArray = new int[2];
        returnedArray[0] = -1;
        returnedArray[1] = -1;
        int counter = 0;

        for (int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                returnedArray[0] = i;
                break;
            }
        }

        for (int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                counter++;
            }
        }

        returnedArray[1] = returnedArray[0] + counter - 1;

        return returnedArray;
    }

}
