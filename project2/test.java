package gr.aueb.cf.projects.project2;

public class test {

    public static void main(String[] args) {

        String[][] array = new String[5][3];


        for (String[] row: array) {
            for (String column : row) {
                if(column == null){
                    System.out.println("Null Column!!");
                }
                else {
                    System.out.print(column);
                }
            }
        }

    }
}
