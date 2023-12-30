package atm.contract;
 
import java.time.LocalDate;
 
public interface Customer {
 
  String getCustomerName();
 
  void setCustomerName(String customerName);
 
  LocalDate getCustomerBirthDate();
 
  void setCustomerBirthDate(LocalDate customerBirthDate);
 
  String getCustomerGender();
 
  void setCustomerGender(String customerGender);
 
  int getCustomerPhone();
 
  void setCustomerPhone(int customerPhone);
}