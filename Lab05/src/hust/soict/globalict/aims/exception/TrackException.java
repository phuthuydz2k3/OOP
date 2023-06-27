package hust.soict.globalict.aims.exception;

import javax.naming.LimitExceededException;

public class TrackException extends LimitExceededException {
    public TrackException(String prompt)
    {
        super();
        System.out.println(prompt);
    }
}
