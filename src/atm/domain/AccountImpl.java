package atm.domain;
 
import atm.contract.Account;
import java.io.Serializable;
 
public class AccountImpl implements Account, Serializable {
  private int accountNo;
  private long balance = 0;
 
  @Override
  public long getBalance() {
    return balance;
  }
 
  @Override
  public void setBalance(long balance) {
    this.balance = balance;
  }
 
  @Override
  public int getAccountNo() {
    return accountNo;
  }
 
  @Override
  public void setAccountNo(int accountNo) {
    this.accountNo = accountNo;
  }
 
  public String toString() {
    return "Account{" +
        "accountNo=" + accountNo +
        ", balance=" + balance +
        '}';
  }
}