import javax.swing.JOptionPane;
import java.lang.Math;

public class CalculateThings
{
    public static void main(String[] args)
    {
        String strNum1, strNum2;
        String strNotification = "TranAnh! You've just entered: ";
        String strSum, strDifference, strProduct, strQuotient;
        double num1, num2;

        strNum1 = JOptionPane.showInputDialog(null,
                    "Please input your first number, TranAnh: ", "Input the first number",
                    JOptionPane.INFORMATION_MESSAGE);
        num1 = Double.parseDouble(strNum1);
        strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null,
                    "Please input your second number, TranAnh: ", "Input the second number",
                    JOptionPane.INFORMATION_MESSAGE);
        num2 = Double.parseDouble(strNum2);
        strNotification += strNum2;

        String strTwoNumbers = strNum1 + " and " + strNum2;
        strSum = "The sum of the two numbers " + strTwoNumbers + " is: " + Double.toString(num1 + num2);
        strDifference = "The difference between the two numbers " + strTwoNumbers + " is: " + Double.toString(Math.abs(num1 - num2));
        strProduct = "The product of the two numbers " + strTwoNumbers + " is: " + Double.toString(num1 * num2);
        strQuotient = "The quotient of the two numbers " + strTwoNumbers + " is: " + Double.toString(num1 / num2);

        JOptionPane.showMessageDialog(null, strNotification,
                "Show two numbers!", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strSum,
                "Show the sum!", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strDifference,
                "Show the difference!", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strProduct,
                "Show the product!", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strQuotient,
                "Show the quotient!", JOptionPane.INFORMATION_MESSAGE);
                
        System.exit(0);
    }
}
