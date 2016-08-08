import java.util.ArrayList;

public class Customer{
  private ArrayList<Double> transaction = new ArrayList<Double>();
  private String name;


  public Customer(String name){
    this.name = name;
    this.transaction = new ArrayList<Double>();
  }

  public Customer(String name, double transaction){
    this.name = name;
    this.transaction = new ArrayList<Double>();
    this.transaction.add(transaction);
  }

  public String getName(){
    return name;
  }

  public double[] getTransactionHistory(){
    double [] transactionHistory = new double[transaction.size()];
    for(int i = 0; i < transaction.size(); i++)
      transactionHistory[i] = transaction.get(i).doubleValue();
    return transactionHistory;
  }

  public int numberOfTransactions(){
    return transaction.size();
  }

  public ArrayList<Double> getTransaction(){
    return transaction;
  }

  public void addTransaction(double additionalTransaction){
    transaction.add(additionalTransaction);
    System.out.println("$" + additionalTransaction + " has been transacted!");
  }

  public static Customer createCustomer(String name){
    return new Customer(name);
  }

  public static Customer createCustomer(String name, double transaction){
    return new Customer(name, transaction);
  }

}
