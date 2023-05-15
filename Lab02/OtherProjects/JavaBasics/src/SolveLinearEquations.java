import javax.swing.JOptionPane;
import java.lang.Math;

public class SolveLinearEquations
{
    public static void main(String[] args)
    {
        String[] buttons = { "First-degree equation", "System of first-degree equations(linear system) with two variables", "Second-degree equation"};

        int option = JOptionPane.showOptionDialog(null, "What equation do you want to solve?", "Choosing equation",
        JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[2]);

        if (option == 0)
        {
            String strA, strB;
            String strNotification = "TranAnh, you've just entered: ";
            double a, b;

            strA = JOptionPane.showInputDialog(null, 
                    "Please input coefficient a: ", "Input coefficient a", JOptionPane.INFORMATION_MESSAGE);
            a = Double.parseDouble(strA);
            strNotification += strA + " and ";

            strB = JOptionPane.showInputDialog(null,
                    "Please input coefficient b: ", "Input coefficient b", JOptionPane.INFORMATION_MESSAGE);
            b = Double.parseDouble(strB);
            strNotification += strB;

            JOptionPane.showMessageDialog(null, strNotification,
                "Show two numbers!", JOptionPane.INFORMATION_MESSAGE);
            solveFirstDegreeEquation(a, b);
        }
        else if (option == 1)
        {
            String strA11, strA12, strB1, strA21, strA22, strB2;
            String strNotification = "TranAnh, you've just entered: ";
            double a11, a12, b1, a21, a22, b2, d, d1, d2;

            strA11 = JOptionPane.showInputDialog(null, 
                    "Please input coefficient a11: ", "Input coefficient a11", JOptionPane.INFORMATION_MESSAGE);
            a11 = Double.parseDouble(strA11);
            strNotification += strA11 + " and ";

            strA12 = JOptionPane.showInputDialog(null, 
                    "Please input coefficient a12: ", "Input coefficient a12", JOptionPane.INFORMATION_MESSAGE);
            a12 = Double.parseDouble(strA12);
            strNotification += strA12 + " and ";

            strB1 = JOptionPane.showInputDialog(null, 
                    "Please input b1: ", "Input b1", JOptionPane.INFORMATION_MESSAGE);
            b1 = Double.parseDouble(strB1);
            strNotification += strB1 + " and ";

            strA21 = JOptionPane.showInputDialog(null, 
                    "Please input coefficient a21: ", "Input coefficient a21", JOptionPane.INFORMATION_MESSAGE);
            a21 = Double.parseDouble(strA21);
            strNotification += strA21 + " and ";

            strA22 = JOptionPane.showInputDialog(null, 
                    "Please input coefficient a22: ", "Input coefficient a22", JOptionPane.INFORMATION_MESSAGE);
            a22 = Double.parseDouble(strA22);
            strNotification += strA22 + " and ";

            strB2 = JOptionPane.showInputDialog(null, 
                    "Please input coefficient b2: ", "Input coefficient b2", JOptionPane.INFORMATION_MESSAGE);
            b2 = Double.parseDouble(strB2);
            strNotification += strB2;

            JOptionPane.showMessageDialog(null, strNotification,
                "Show numbers!", JOptionPane.INFORMATION_MESSAGE);
            
            d = a11 * b2 - a21 * b1;
            d1 = b1 * a22 - b2 * a12;
            d2 = b2 * a11 - b1 * a21;
            if (d == 0.0)
            {
                if (d1 == 0.0 && d2 == 0.0)
                {
                    JOptionPane.showMessageDialog(null, "System of equation has infinite solution; x1, x2 belong to R!",
                    "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "System of equation has no solution!",
                    "Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }
                
            else
            {
                JOptionPane.showMessageDialog(null, "System of equation has an unique solution!\n" + d1 / d + " and " + d2 /d,
                "Solution", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if (option == 2)
        {
            String strA, strB, strC;
            String strNotification = "TranAnh, you've just entered: ";
            double a, b, c;

            strA = JOptionPane.showInputDialog(null, 
                    "Please input coefficient a: ", "Input coefficient a", JOptionPane.INFORMATION_MESSAGE);
            a = Double.parseDouble(strA);
            strNotification += strA + " and ";

            strB = JOptionPane.showInputDialog(null,
                    "Please input coefficient b: ", "Input coefficient b", JOptionPane.INFORMATION_MESSAGE);
            b = Double.parseDouble(strB);
            strNotification += strB + " and ";

            strC = JOptionPane.showInputDialog(null,
                    "Please input coefficient c: ", "Input coefficient c", JOptionPane.INFORMATION_MESSAGE);
            c = Double.parseDouble(strC);
            strNotification += strC;

            JOptionPane.showMessageDialog(null, strNotification,
                "Show a, b and c", JOptionPane.INFORMATION_MESSAGE);

            solveSecondDegreeEquation(a, b, c);
        }

        System.exit(0);
    }

    private static void solveFirstDegreeEquation(double a, double b)
    {
        if (a == 0.0)            
        {
            if (b == 0.0)
            {
                JOptionPane.showMessageDialog(null, "The equation has infinite x, x belong to R",
                "Infinite Solution!", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The equation has no solution",
                "No Solution!", JOptionPane.INFORMATION_MESSAGE); 
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "The equation has an unique solution, " + (-b / a + ""),
                "Unique Solution!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void solveSecondDegreeEquation(double a, double b, double c)
    {
        if (a == 0.0)
        {
            solveFirstDegreeEquation(b, c);
        }
        else
        {
            double delta = b * b - 4 * a * c;

            if (delta < 0.0)
            {
                JOptionPane.showMessageDialog(null, "The equation has no solution",
                "No Solution!", JOptionPane.INFORMATION_MESSAGE); 
            }
            else if (delta == 0.0)
            {
                JOptionPane.showMessageDialog(null, "The equation has an unique solution; x1 = x2 = " + -b / 2 / a,
                "Unique Solution!", JOptionPane.INFORMATION_MESSAGE); 
            }
            else
            {
                double sqrtDelta = Math.sqrt(delta);
                JOptionPane.showMessageDialog(null,
                    "The equation has an unique solution; x1 = " + (-b - sqrtDelta) / 2 / a + " and x2 = " + (-b + sqrtDelta) / 2 / a,
                "Unique Solution!", JOptionPane.INFORMATION_MESSAGE); 
            }
        }
    }
}
