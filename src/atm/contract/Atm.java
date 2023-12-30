package atm.contract;
 
import atm.domain.AtmOperationException;
import atm.domain.CardImpl;
import atm.domain.Navigation;
 
public interface Atm {
 
  void start() throws AtmOperationException;
 
  Card login(int accountNo, int pin) throws AtmOperationException;
 
  void logout();
 
  Card getCurrentCard();
 
  void registerAtmCard(Card atmCard) throws AtmOperationException;
 
  void depositAtmCard(Card atmCard, long amount) throws AtmOperationException;
 
  void withdrawAtmCard(Card atmCard, long amount) throws AtmOperationException;
 
  void changeAtmCardPin(Card atmCard, int newPin) throws AtmOperationException;
 
  Navigation getNavigation();
}