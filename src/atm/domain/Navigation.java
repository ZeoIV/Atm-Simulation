package atm.domain;
 
import javax.swing.JFrame;
 
public class Navigation {
 
  private JFrame menuPage;
  private JFrame loginPage;
  private JFrame activePage;
 
  public void openMenu() {
    if (null != this.activePage) {
      this.activePage.setVisible(false);
      this.activePage = null;
    }
    if(null != this.loginPage){
      this.loginPage.setVisible(false);
    }
    this.menuPage.setVisible(true);
  }
 
  public void openLoginPage() {
    if (null != this.activePage) {
      this.activePage.setVisible(false);
      this.activePage = null;
    }
    if(null != this.menuPage) {
      this.menuPage.setVisible(false);
    }
    this.loginPage.setVisible(true);
  }
 
  public void navigateTo(JFrame frame) {
    if (null != this.activePage) {
      this.activePage.setVisible(false);
    }
    this.activePage = frame;
    this.activePage.setVisible(true);
  }
 
  public JFrame getMenu() {
    return this.menuPage;
  }
 
  public void setMenu(JFrame menu) {
    this.menuPage = menu;
  }
  public void setLoginPage(JFrame loginPage) {
    this.loginPage = loginPage;
  }
 
  public JFrame getLoginPage() {
    return this.loginPage;
  }
 
  public JFrame getActiveFrame() {
    return this.activePage;
  }
 
  public void setActiveFrame(JFrame activePage) {
    this.activePage = activePage;
  }
}