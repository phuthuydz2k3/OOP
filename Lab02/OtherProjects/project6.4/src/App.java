import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String month, year;
        int monthNum;
        int[] numberOfDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = {"", "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        System.out.print("Enter month: ");
        month = in.nextLine();
        while ((monthNum = checkMonth(month)) == 0)
        {
            System.out.print("Invalid month input\nEnter month: ");
            month = in.nextLine();
        }

        System.out.print("Enter year: ");
        year = in.nextLine();
        int intYear = Integer.parseInt(year.trim());
        while (intYear < 0)
        {
            System.out.print("Year must be positive\nEnter year: ");
            year = in.nextLine();
            intYear = Integer.parseInt(year.trim());
        }

        if (isLeapYear(intYear))
        {
            numberOfDays[2] = 29;
        }

        System.out.println("Number of day in " + months[monthNum] + ": " + numberOfDays[monthNum]);
    }

    private static int checkMonth(String month)
    {
        String[] months = {"", "January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

        for (int i = 1; i <= 12; i++)
        {
            if (month.equals(months[i]) || month.equals(months[i].substring(0, 3)) || month.equals(months[i].substring(0, 3) + "."))
            {
                return i;
            }
        }

        return 0;
    }

    private static boolean isLeapYear(int year)
    {
        if (year % 4 == 0)
        {
            if (year % 100 == 0)
            {
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
    }
}
