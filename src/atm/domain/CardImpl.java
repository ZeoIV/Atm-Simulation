package atm.domain;
 
import atm.contract.Card;
import atm.contract.Customer;
import java.io.*;
 
public class CardImpl implements Serializable, Card {
  private Customer customer;
  private CardAccountImpl account;
  private int pin;
 
  @Override
  public Customer getCustomer() {
    return customer;
  }
 
  @Override
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
 
  @Override
  public CardAccountImpl getAccount() {
    return account;
  }
 
  @Override
  public void setAccount(CardAccountImpl account) {
    this.account = account;
  }
 
  @Override
  public int getPin() {
    return pin;
  }
 
  @Override
  public void setPin(int pin) {
    this.pin = pin;
  }
 
  @Override
  public void deposit(long amount) {
    this.account.deposit(amount);
  }
 
  @Override
  public void withdraw(long amount) throws AtmOperationException {
    if (this.account.getBalance() < amount) {
      throw new AtmOperationException("Not enough balance");
    }
    this.account.withdraw(amount);
  }
 
  @Override
  public String toString() {
    return "Card{" +
        "customer=" + customer +
        ", account=" + account +
        ", pin=" + pin +
        '}';
  }
}