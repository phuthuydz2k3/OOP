import java.io.*;
public class NoGarbage
{
    public static void main(String[] args)
    {
        String filename = "text.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder string = new StringBuilder();
        for (byte b : inputBytes)
        {
            string.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}