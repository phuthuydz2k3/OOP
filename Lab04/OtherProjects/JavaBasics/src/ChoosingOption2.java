import javax.swing.JOptionPane;

public class ChoosingOption2
{
    public static void main(String[] args)
    {
        String[] buttons = {"Yes", "No", "I do", "I don't"};
        int option = JOptionPane.showOptionDialog(null, "Please choose an option!", "Choosing an option!",
                        JOptionPane.INFORMATION_MESSAGE, 0, null, buttons, buttons[3]);
        JOptionPane.showMessageDialog(null, "You have chosen " + buttons[option]);
        System.exit(0);
    }
}
