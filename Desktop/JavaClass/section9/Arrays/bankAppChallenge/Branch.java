import java.util.ArrayList;

public class Branch {
  private ArrayList<Customer> customerList = new ArrayList<Customer>();
  private String branchName;

  public Branch(String branchName){
    this.branchName = branchName;
    this.customerList = new ArrayList<Customer>();
  }

  public String getName(){
    return branchName;
  }

  public static Branch createBranch(String branchName){
    return new Branch(branchName);
  }

  public boolean addCustomer(String customerName){
    if(findCustomer(customerName) < 0){
      Customer customer = Customer.createCustomer(customerName);
      customerList.add(customer);
      System.out.println("Customer added!");
      return true;
    }
    System.out.println("Customer is already in system.");
    return false;
  }

  public boolean addCustomer(String customerName, double firstTransaction){
    if(findCustomer(customerName) < 0){
      Customer customer = new Customer(customerName, firstTransaction);
      customerList.add(customer);
      System.out.println("Customer added!");
      return true;
    }
    System.out.println("Customer is already in system.");
    return false;
  }


  public boolean addCustomer(Customer customer){
    if(findCustomer(customer.getName()) >= 0){
      System.out.println("Customer is already on file");
      return false;
    }
    customerList.add(customer);
    return true;
  }

  public boolean addTransaction(Customer customer, double transaction){
    int indexPosition = findCustomer(customer);
    if(indexPosition < 0){
      System.out.println(customer.getName() + ", was not found");
      return false;
    }
    customer.addTransaction(transaction);
    System.out.println(customer.getName() + " has transacted $" + transaction);
    return true;
  }

  public int findCustomer(Customer customer){
    return this.customerList.indexOf(customer);
  }

  public int findCustomer(String customerName){
    for(int i = 0; i < this.customerList.size(); i++){
      Customer customer = this.customerList.get(i);
      if(customer.getName().equals(customerName))
        return i;
    }
    return -1;
  }

  public void printCustomers(){

    for(int i = 0; i < this.customerList.size(); i++){
      Customer customer = this.customerList.get(i);
      System.out.println(customer.getName() + " -- " + customer.numberOfTransactions());
    }
  }

  public Customer getCustomer(String customerName){
    return this.customerList.get(findCustomer(customerName));
  }


}
