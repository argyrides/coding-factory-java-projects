package gr.aueb.cf.projects.project2;

import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) {
        runTheApp();
    }

    public static void showMenu(){
        System.out.println("Application Menu");
        System.out.println("1. Search for a phone contact");
        System.out.println("2. Insert a phone contact");
        System.out.println("3. Update a phone contact");
        System.out.println("4. Delete a phone contact");
        System.out.println("5. Exit App");
    }

    public static int getChoice() {
        Scanner in = new Scanner(System.in);
        int choice;

        System.out.print("Please choose:");
        choice = in.nextInt();

        return choice;
    }

    public static int telephoneContactSearch(String[][] phoneContactsArray){
        boolean isFound = false;
        Scanner in = new Scanner(System.in);
        String userInput;
        int i = 0;
        System.out.print("Give a phone contact to search:");
        userInput = in.nextLine();

        if(!isContactListNull(phoneContactsArray)) {
            for (String[] row: phoneContactsArray) {
                for (String column : row) {
                    if(column != null) {
                        if (column.equals(userInput)) {
                            isFound = true;
                            System.out.println(phoneContactsArray[i][0] + " | " + phoneContactsArray[i][1] + " | " + phoneContactsArray[i][2]);
                            return i;
                        }
                    }
                }
                i++;
            }
        }

        return -1;
    }

    public static void manageChoice(int choice, String[][] phoneContactsArray) {

        Scanner in = new Scanner(System.in);
        String lastName, firstName, telephoneNumber;
        if (choice == 1) {
            if(telephoneContactSearch(phoneContactsArray) == -1){
                System.out.println("Phone contact not found!");
            }
        } else if (choice == 2) {
            System.out.print("Give a surname:");
            lastName = in.nextLine();
            System.out.print("Give a name:");
            firstName = in.nextLine();
            System.out.print("Give a telephone number:");
            telephoneNumber = in.nextLine();
            if(!isContactExist(phoneContactsArray,telephoneNumber)) {
                int nextNullArrayIndex = findNextNullIndex(phoneContactsArray);
                if (nextNullArrayIndex != -1) {
                    phoneContactsArray[nextNullArrayIndex][0] = lastName;
                    phoneContactsArray[nextNullArrayIndex][1] = firstName;
                    phoneContactsArray[nextNullArrayIndex][2] = telephoneNumber;
                    System.out.println("Insert completed.");
                }
            }
            else{
                System.out.println("Contact already exists!");
            }
        } else if ( choice == 3) {
            int arrayIndex = telephoneContactSearch(phoneContactsArray);
            if(arrayIndex != -1){
                System.out.print("Give a new last name:");
                lastName = in.nextLine();
                System.out.print("Give a new first name:");
                firstName = in.nextLine();
                System.out.print("Give a new telephone number:");
                telephoneNumber = in.nextLine();

                phoneContactsArray[arrayIndex][0] = lastName;
                phoneContactsArray[arrayIndex][1] = firstName;
                phoneContactsArray[arrayIndex][2] = telephoneNumber;
                System.out.println("Update completed.");
            }
            else{
                System.out.println("Phone contact not found!");
            }
        } else if (choice == 4) {
            int arrayIndex = telephoneContactSearch(phoneContactsArray);
            if(arrayIndex != -1) {
                phoneContactsArray[arrayIndex][0] = null;
                phoneContactsArray[arrayIndex][1] = null;
                phoneContactsArray[arrayIndex][2] = null;
                System.out.println("Delete completed.");
            }
            else{
                System.out.println("Phone contact not found!");
            }
        } else if (choice == 5) {
            System.out.println("You choose exit.");
        } else {
            System.out.println("Oops wrong choose. Please choose between 1-5.");
        }
    }

    public static boolean isContactExist(String[][] phoneContactsArray, String userInput){

        if(!isContactListNull(phoneContactsArray)) {
            for (String[] row: phoneContactsArray) {
                for (String column : row) {
                    if(column != null) {
                        if (column.equals(userInput)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean isContactListNull(String[][] array){

        for (String[] row: array) {
            for (String column : row) {
                if(column != null){
                    return false;
                }
            }
        }
        return true;
    }

    public static int findNextNullIndex(String[][] array){
        int i = 0;
        for (String[] row: array) {
            for (String column : row) {
                if(column != null){
                    i++;
                }
                else{
                    break;
                }
            }
        }
        return i;

    }

    public static void runTheApp() {
        int choice;
        String[][] phoneContactsArray = new String[500][3];

        do {
            showMenu();
            choice = getChoice();
            manageChoice(choice,phoneContactsArray);

        } while (choice != 5);

        System.out.println("Have a nice day!!");
    }
}
