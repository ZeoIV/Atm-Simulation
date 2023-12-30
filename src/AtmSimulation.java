import atm.contract.Atm;
import atm.domain.AtmImpl;
import atm.util.AtmUtils;
import atm.view.Login;
import atm.view.Menu;
 
public class AtmSimulation {
 
  public static void main(String args[]) {
    
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        Atm atm = AtmUtils.createAtm();
        Menu login = new Menu(atm);
        Login menu = new Login(atm);
        atm.getNavigation().setMenu(menu);
        atm.getNavigation().setLoginPage(login);
        atm.getNavigation().navigateTo(login);
      }
    });
  }
}
//new Menu().setVisible(true);