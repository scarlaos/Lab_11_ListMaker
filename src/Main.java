import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> myArrList = new ArrayList<>();
        String input = "";

        while(true){
            printMenu();
            input = in.nextLine().trim().toUpperCase();

            switch(input){
                case "A":
                    aChoice(in,myArrList);
                    break;
                case "D":
                    dChoice(in,myArrList);
                    break;
                case "I":
                    iChoice(in,myArrList);
                    break;
                case "P":
                    pChoice(myArrList);
                    break;
                case "Q":
                    qChoice(in);
                    return;
                default:
                    System.out.println("Invalid choice. Try again: ");
                    break;
            }
        }
    }


    private static void printMenu()
    {
        System.out.println("List options: ");
        System.out.println("| A - Adds an item to the list | D - Deletes an item | I - Insert an item | P - Prints the list | Q - To quit altering the list |");
        System.out.println("Enter your choice: ");
    }
    private static void aChoice(Scanner in, ArrayList<String> myArrList){
        System.out.println("Type the item you would like to add: ");
        String addedItem = in.nextLine().trim();
        myArrList.add(addedItem);
        System.out.println(addedItem + " is now in the list.");
    }
    private static void dChoice(Scanner in, ArrayList<String> myArrList){

        int indexDelete = SafeInput.getRangedInt(in,"Type the number you would like to delete",1,myArrList.size());
        indexDelete -= 1;


        if(indexDelete >= 0 && indexDelete < myArrList.size()){
            String deletedItem = myArrList.remove(indexDelete);
            System.out.println(deletedItem + " has been removed from the list.");
        } else {
            System.out.println("Invalid location. Nothing deleted.");
        }
    }
    private static void iChoice(Scanner in, ArrayList<String> myArrList){

        System.out.println("Enter the item you would like to inset: ");
        String itemInsert = in.nextLine().trim();
        System.out.println("What index would like this item to be inserted? Enter the index: ");
        int index = in.nextInt();

        if(index >= 0 && index <= myArrList.size()){
            myArrList.add(index, itemInsert);
            System.out.println(itemInsert + " has been inserted at index: " + index);
        }else{
            System.out.println("Invalid index. Item not inserted.");
        }
    }
    private static void pChoice(ArrayList<String>myArrList){
        if(myArrList.isEmpty()){
            System.out.println("List is empty");
        }else{
            System.out.println("List: ");
            for(int i = 0; i < myArrList.size(); i++){
                System.out.println((i+1) + ". " + myArrList.get(i));
            }
        }
    }
    private static void qChoice(Scanner in){
        boolean done = SafeInput.getYN(in,"Are you sure you want to quit? Enter Y for yes or N for No: ");
        if(done) {
            System.out.println();
        }else{
            System.out.println("Back to main menu...");
        }
    }
}
