package atm.domain;
 
public class CardAccountImpl extends AccountImpl implements atm.contract.CardAccount {
 
  public CardAccountImpl(){
    super();
  }
  @Override
  public void deposit(long amount) {
    this.setBalance(this.getBalance() + amount);
  }
 
  @Override
  public void withdraw(long amount) {
    this.setBalance(this.getBalance() - amount);
  }
}