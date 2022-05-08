package gr.aueb.cf.projects.project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Project3 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        int bufSize = 8192;
        int len = 0;
        char[] buf = new char[bufSize];
        int[][] chars = new int[256][2];
        int[][] copied;
        int pivot = -1;
        int position = -1;
        double frequency = -1.0;
        for (int[] row: chars) {
            Arrays.fill(row, 0);
        }
        String fileName = "C:\\Users\\alexa\\Desktop\\CodingFactory\\Java\\src\\gr\\aueb\\cf\\projects\\project3\\test.txt";
        BufferedReader bf = new BufferedReader(new FileReader(fileName));

        while ((n  = bf.read(buf, 0, bufSize)) != -1) {
            sb.append(buf, 0, n);
            len += n;
        }

        for (int i = 0; i < sb.length(); i++) {
            position = checkIfExistsInCharArray(chars,sb.charAt(i));
            if(position != -1){
                chars[position][1] += 1;
            }
            else{
                chars[++pivot][0] = sb.charAt(i);
                chars[pivot][1] = 1;
            }

        }

        copied = new int[pivot + 1][2];
        for (int i = 0; i <= pivot; i++) {
            copied[i] = Arrays.copyOf(chars[i], 2);
        }

        Arrays.sort(copied, (a1, a2) -> a1[1] - a2[1]);

        for (int i = 0; i <= pivot; i++) {
            frequency = ((double)copied[i][1] / len) * 100;
            System.out.println((char) copied[i][0] + ", " + copied[i][1] + " (" + String.format("%.2f", frequency) + "%)");
        }

        System.out.println(sb);
    }

    public static int checkIfExistsInCharArray(int[][] array, char arrayCharacter){

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < 1; j++){
                if(array[i][j] == arrayCharacter){
                    return i;
                }
            }
        }
        return -1;
    }


}
