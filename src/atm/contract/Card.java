package atm.contract;
 
import atm.domain.AtmOperationException;
import atm.domain.CardAccountImpl;
 
public interface Card {
 
  Customer getCustomer();
 
  void setCustomer(Customer customer);
 
  CardAccountImpl getAccount();
 
  void setAccount(CardAccountImpl account);
 
  int getPin();
 
  void setPin(int pin);
 
  void deposit(long amount);
 
  void withdraw(long amount) throws AtmOperationException;
}