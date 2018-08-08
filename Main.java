import java.util.Scanner;

public class Main{
  private static Scanner scanner = new Scanner(System.in);
  private static Bank bank = new Bank("Bank of Patterson");

  private static void printActions(int choice){
    if(choice == 1){
      System.out.println("0 - Quit Banking service");
      System.out.println("1 - Add branch");
      System.out.println("2 - Select branch");
      System.out.println("3 - Print actions");
      System.out.print("Choose your action: ");
    } else if(choice == 2){
      System.out.println("0 - Return to Banking service");
      System.out.println("1 - Add Customer");
      System.out.println("2 - Select Customer");
      System.out.println("3 - Print Customers");
      System.out.println("4 - Print actions");
      System.out.print("Choose your action: ");
    } else if(choice == 3){
      System.out.println("0 - Return to Branch service");
      System.out.println("1 - Add Transaction");
      System.out.println("2 - List Transactions");
      System.out.println("3 - Print actions");
      System.out.print("Choose your action: ");
    }
  }

  public static void main(String[] args) {
      boolean quit = false;
      printActions(1);
      while(!quit){
        System.out.println("Enter action: (3 to show available commands)");
        int action = scanner.nextInt();
        scanner.nextLine();
        switch (action){
          case 0:
            System.out.println("\n\t\t\tQuitting bank service..");
            quit = true;
          break;
          case 1:
            addBranch(); // DONE
            break;
          case 2:
            findBranch(); // DONE
            break;
          case 3:
            printActions(1);
            break;
          default:
            quit = true;
        }
      }
  }




  private static void selectBranch(Branch branch){
    boolean quit = false;
    System.out.println("Welcome to our " + branch.getName() + " Branch!");
    printActions(2);
    while(!quit){
      System.out.println("Enter action: (4 to show available commands)");
      int action = scanner.nextInt();
      scanner.nextLine();
      switch (action){
        case 0:
          System.out.println("\n\t\t\tQuitting branch service..");
          quit = true;
        break;
        case 1:
          addCustomer(branch); // DONE
          break;
        case 2:
          selectCustomer(branch); // DONE
          break;
        case 3:
          printCustomers(branch); // DONE
          break;
        case 4:
          printActions(2);
          break;
        default:
          quit = true;
      }
    }
  }
// BRANCH I/O METHODS

  private static void findBranch(){
    System.out.print("Enter Branch name: ");
    String branchName = scanner.nextLine();
    if(bank.findBranch(branchName) < 0){
      System.out.println("Can't seem to find that one, returned to bank service");
      return;
    }
    Branch currentBranch = bank.getBranch(branchName);
    selectBranch(currentBranch);
  }

  private static void addBranch(){
    System.out.print("Enter the name of your new Branch: ");
    String branchName = scanner.nextLine();
    bank.addBranch(branchName);
    System.out.println("You have added " + branchName + " to your list of Branches!");
  }

  private static void removeBranch(){
    System.out.print("Enter the name of the Branch you'd like to remove: ");
    String branchName = scanner.nextLine();
    bank.removeBranch(branchName);
  }

// CUSTOMER I/O METHODS

  private static void addCustomer(Branch branch){
    boolean quit = false;
    while(!quit){
      System.out.print("Enter 1 to add customer, 2 to quit: ");
      int choice = scanner.nextInt();
      if(choice == 1){
        scanner.nextLine();
        System.out.print("New customer: ");
        String newCustomer = scanner.nextLine();
        branch.addCustomer(newCustomer);
      }else
        quit = true;
    }
  }

  private static void selectCustomer(Branch branch){
    System.out.println("Customer name: ");
    String customerName = scanner.nextLine();
    if(branch.findCustomer(customerName) < 0){
      System.out.println("Could not find Customer.");
      return;
    }
    Customer customer = branch.getCustomer(customerName);
    boolean quit = false;
    printActions(3);
    while(!quit){
      System.out.println("Enter action: (3 to show available commands)");
      int action = scanner.nextInt();
      switch (action){
        case 0:
          System.out.println("\n\t\t\tQuitting Customer service..");
          quit = true;
        break;
        case 1:
          addTransaction(customer); // DONE
          break;
        case 2:
          allTransactions(customer); // DONE
          break;
        case 3:
          printActions(3);
          break;
        default:
          quit = true;
      }
    }
  }

  private static void printCustomers(Branch branch){
    System.out.println("Prints Customer name and number of Transactions");
    branch.printCustomers();
  }

  private static void addTransaction(Customer customer){
    System.out.print("Transaction: ");
    int transaction = scanner.nextInt();
    customer.addTransaction(transaction);
  }

  private static void allTransactions(Customer customer){
    double[] transactionHistory = customer.getTransactionHistory();
    System.out.println("\n\n" + customer.getName() + "'s transaction history: ");
    for(int i = 0; i < transactionHistory.length; i++){
      System.out.println(i + ": $" + transactionHistory[i]);
    }
    System.out.println("END OF TRANSACTION HISTORY\n\n");
  }

}
