package atm.util;
 
import atm.contract.Atm;
import atm.domain.AtmImpl;
import atm.domain.AtmOperationException;
import atm.view.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class AtmUtils {
  public static Atm createAtm() {
    Atm atm = new AtmImpl();
    try {
      atm.start();
    } catch (AtmOperationException e) {
      Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, e.getMessage());
    }
    return atm;
  }
}