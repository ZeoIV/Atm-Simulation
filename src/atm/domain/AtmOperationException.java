package atm.domain;
 
import java.io.FileNotFoundException;
 
public class AtmOperationException extends Exception{
 
  public AtmOperationException(Exception e) {
    super(e);
  }
 
  public AtmOperationException(String message) {
    super(message);
  }
}