package Kapitel_3.examples.data;

/**
   This class reports bad input data.
*/
@SuppressWarnings("serial")
public class BadDataException extends Exception
{
   public BadDataException() {}
   public BadDataException(String message)
   {
      super(message);
   }
}
