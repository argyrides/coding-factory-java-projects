package gr.aueb.cf.projects.project1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Project1 {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Integer> arrayList = new ArrayList<>();
        readFile(arrayList);

        if(arrayList.size() == 0){
            System.out.println("All numbers must be between 1-49");
        }
        else if(arrayList.size() < 6 || arrayList.size() > 49){
            System.out.println("The count of numbers must be between 6-49");
        }
        else{
            Collections.sort(arrayList);
            combinationsSix(arrayList);

        }
    }

    public static void combinationsSix(ArrayList<Integer> arrList) throws FileNotFoundException {
        int n = 6;
        int[] row = new int[6];
        File outFile = new File("C:/Users/alexa/Desktop/CodingFactory/Java/src/gr/aueb/cf/projects/project1/combinationOfSix.txt");
        PrintStream ps = new PrintStream(outFile);

        for (int i = 0; i <= arrList.size() - n; i++) {
            for (int j = i + 1; j <= arrList.size() - n + 1; j++) {
                for (int k = j + 1; k <= arrList.size() - n + 2; k++) {
                    for (int m = k + 1; m < arrList.size() - n + 3; m++) {
                        for (int l = m + 1; l < arrList.size() - n + 4; l++) {
                            for (int o = l + 1; o < arrList.size(); o++) {

                                row[0] = arrList.get(i);
                                row[1] = arrList.get(j);
                                row[2] = arrList.get(k);
                                row[3] = arrList.get(m);
                                row[4] = arrList.get(l);
                                row[5] = arrList.get(o);

                                if ((!isEven(row)) && (!isOdd(row)) && (!isContinuous(row)) && (!isSameEnding(row))
                                     && (!isSameTen(row)))
                                {
                                    ps.printf("%d\t%d\t%d\t%d\t%d\t%d\n", arrList.get(i), arrList.get(j), arrList.get(k), arrList.get(m), arrList.get(l), arrList.get(o));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isSameTen(int[] row){
        int count0 = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0;
        int div = 0;

        for (int i = 0; i < row.length; i++) {
            div = row[i] / 10;

            switch(div) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
            }
        }
        return  ((count0 >= 3) || (count1 >= 3) || (count2 >= 3) || (count3 >= 3) || (count4 >= 3));
    }

    public static boolean isSameEnding(int[] row){
        int count0 = 0, count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0,
                count8 = 0, count9 = 0;
        int div = 0;

        for (int i = 0; i < row.length; i++) {
            div = row[i] % 10;
            switch(div) {
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
                case 4:
                    count4++;
                    break;
                case 5:
                    count5++;
                    break;
                case 6:
                    count6++;
                    break;
                case 7:
                    count7++;
                    break;
                case 8:
                    count8++;
                    break;
                case 9:
                    count9++;
                    break;
            }

        }
        return ((count0 >= 3) || (count1 >= 3) || (count2 >= 3) || (count3 >= 3) || (count4 >= 3) || (count5 >= 3) || (count6 >= 3)
                || (count7 >= 3) || (count8 >= 3) || (count9 >= 3));
    }

    public static boolean isContinuous(int[] row){
        int count = 0;

        for (int i = 0; i < row.length - 1; i++) {
            if (row[i+1] - row[i] == 1) count++;
        }

        return count >= 2;
    }

    public static boolean isEven(int[] row) {
        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] % 2 == 0) count++;
        }

        return count >= 4;
    }

    public static boolean isOdd(int[] row) {
        int count = 0;

        for (int i = 0; i < row.length; i++) {
            if (row[i] % 2 != 0) count++;
        }

        return count >= 4;

    }

    public static void readFile(ArrayList<Integer> arrList) throws FileNotFoundException {
        String path = "C:/Users/alexa/Desktop/CodingFactory/Java/src/gr/aueb/cf/projects/project1/project1.txt";
        File inFile = new File(path);
        Scanner in = new Scanner(inFile);
        int num;
        boolean findError = false;

        do{
            num = in.nextInt();
            if (num > 49 || (num < 1 && num != -1)){
                findError = true;
            }
            else{
                if(num != -1) {
                    arrList.add(num);
                }
            }
        }while (num != -1);

        if(findError){
            arrList.clear();
        }
    }
}
