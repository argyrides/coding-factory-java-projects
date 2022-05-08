package gr.aueb.cf.projects.project4;

import java.util.Arrays;

public class Project4 {
    public static void main(String[] args) {
        int[][] timesArr = {{1012, 1136}, {1317, 1417}, {1015, 1020}, {1000, 1030}, {1320,1415}, {1010,1015}};
        int length = (timesArr.length) * 2;
        int[][] array = new int[length][2];
        int counter = -1;
        int i = 0;
        int j = 0;
        for (int[] row: timesArr) {
            for (int column : row) {
                counter++;
                if(j == 0){
                    array[counter][0] = timesArr[i][0];
                    array[counter][1] = 1;
                    j++;
                }
                else{
                    array[counter][0] = timesArr[i][1];
                    array[counter][1] = 0;
                    j--;
                }
            }
            i++;
        }



        Arrays.sort(array, (a1, a2) -> a1[0] - a2[0]);

       /* for (int[] row: array) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println("\n");
        }*/

        int numberOfCars = 0;
        int maxNumberOfCars = 0;

        for (int[] row: array) {
            for (int column : row) {
                if(column == 1){
                    numberOfCars++;
                }
                else if (column == 0){
                    numberOfCars--;
                }
                if(maxNumberOfCars < numberOfCars){
                    maxNumberOfCars = numberOfCars;
                }
            }
        }

        System.out.println("Max number of cars at the same time: " + maxNumberOfCars);
    }
}
