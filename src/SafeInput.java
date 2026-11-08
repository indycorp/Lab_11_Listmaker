import java.util.Scanner;

public class SafeInput
{
    // Part A
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    // Part B
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();            // clear the newline
                done = true;
            }
            else
            {
                trash = pipe.nextLine();    // read the trash
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);
        return retVal;
    }

    // Part C
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a number, not: " + trash);
            }
        } while (!done);
        return retVal;
    }

    // Part D
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                    done = true;
                else
                    System.out.println("Out of range: " + retVal);
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an integer, not: " + trash);
            }
        } while (!done);
        return retVal;
    }

    // Part E
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";
        do
        {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high)
                    done = true;
                else
                    System.out.println("Out of range: " + retVal);
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a number, not: " + trash);
            }
        } while (!done);
        return retVal;
    }

    // Part F
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";
        boolean retVal = false;
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();
            if (response.matches("[yY]"))
            {
                retVal = true;
                done = true;
            }
            else if (response.matches("[nN]"))
            {
                retVal = false;
                done = true;
            }
            else
                System.out.println("Enter Y or N, not: " + response);
        } while (!done);
        return retVal;
    }

    // Part G
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";
        boolean done = false;
        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx))
                done = true;
            else
                System.out.println("Invalid input: " + response);
        } while (!done);
        return response;
    }

    // Part H
    public static void prettyHeader(String msg)
    {
        int width = 60;
        int inner = width - 6;                       // space between the 3-star ends
        int left = (inner - msg.length()) / 2;
        int right = inner - msg.length() - left;

        for (int i = 0; i < width; i++) System.out.print("*");
        System.out.println();

        System.out.print("***");
        for (int i = 0; i < left; i++) System.out.print(" ");
        System.out.print(msg);
        for (int i = 0; i < right; i++) System.out.print(" ");
        System.out.println("***");

        for (int i = 0; i < width; i++) System.out.print("*");
        System.out.println();
    }
}
