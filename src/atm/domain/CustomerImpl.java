package atm.domain;
 
import java.io.Serializable;
import java.time.LocalDate;
 
public class CustomerImpl implements Serializable, atm.contract.Customer {
 
  private String customerName;
  private LocalDate customerBirthDate;
  private String customerGender;
  private int customerPhone;
 
  @Override
  public String getCustomerName() {
    return customerName;
  }
 
  @Override
  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }
 
  @Override
  public LocalDate getCustomerBirthDate() {
    return customerBirthDate;
  }
 
  @Override
  public void setCustomerBirthDate(LocalDate customerBirthDate) {
    this.customerBirthDate = customerBirthDate;
  }
 
  @Override
  public String getCustomerGender() {
    return customerGender;
  }
 
  @Override
  public void setCustomerGender(String customerGender) {
    this.customerGender = customerGender;
  }
 
  @Override
  public int getCustomerPhone() {
    return customerPhone;
  }
 
  @Override
  public void setCustomerPhone(int customerPhone) {
    this.customerPhone = customerPhone;
  }
 
  @Override
  public String toString() {
    return "Customer{" +
        "customerName='" + customerName + '\'' +
        ", customerBirthDate=" + customerBirthDate +
        ", customerGender='" + customerGender + '\'' +
        ", customerPhone='" + customerPhone + '\'' +
        '}';
  }
}