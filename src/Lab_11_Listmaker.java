import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;

        do
        {
            displayList(list);
            String choice = SafeInput.getRegExString(in, "Enter A, D, I, P, or Q", "[AaDdIiPpQq]");
            choice = choice.toUpperCase();

            switch (choice)
            {
                case "A": addItem(in, list); break;
                case "D": deleteItem(in, list); break;
                case "I": insertItem(in, list); break;
                case "P": printList(list); break;
                case "Q":
                    done = SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
                    break;
            }
        } while (!done);
    }

    private static void displayList(ArrayList<String> list)
    {
        System.out.println("\n--- Current List ---");
        if (list.size() == 0)
        {
            System.out.println("(list is empty)");
        }
        else
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
        System.out.println("--------------------");
        System.out.println("A - Add  D - Delete  I - Insert  P - Print  Q - Quit");
    }

    private static void addItem(Scanner in, ArrayList<String> list)
    {
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to add");
        list.add(item);
    }

    private static void deleteItem(Scanner in, ArrayList<String> list)
    {
        if (list.size() == 0)
        {
            System.out.println("The list is empty, nothing to delete.");
            return;
        }
        int num = SafeInput.getRangedInt(in, "Enter the item number to delete", 1, list.size());
        String removed = list.remove(num - 1);
        System.out.println("Deleted: " + removed);
    }

    private static void insertItem(Scanner in, ArrayList<String> list)
    {
        int num = SafeInput.getRangedInt(in, "Enter the position to insert at", 1, list.size() + 1);
        String item = SafeInput.getNonZeroLenString(in, "Enter the item to insert");
        list.add(num - 1, item);
    }

    private static void printList(ArrayList<String> list)
    {
        System.out.println("\nThe list contains " + list.size() + " item(s):");
        for (String s : list)
        {
            System.out.println(s);
        }
    }
}