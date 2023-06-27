package hust.soict.globalict.aims.exception;

public class PlayerException extends Exception
{
    public PlayerException(String prompt)
    {
        super();
        System.out.println(prompt);
    }
}
