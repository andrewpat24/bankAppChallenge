import java.util.ArrayList;

public class Bank{
  private ArrayList<Branch> branchList = new ArrayList<Branch>();
  private String bankName;

  public Bank(String bankName){
    this.bankName = bankName;
    this.branchList = new ArrayList<Branch>();
  }

  public static Bank createBank(String bankName){
    return new Bank(bankName);
  }

  public String getName(){
    return this.bankName;
  }

  public void addBranch(String branchName){
    Branch newBranch = new Branch(branchName);
    branchList.add(newBranch);
  }

  public boolean removeBranch(String branchName){
    if(findBranch(branchName) < 0){
      System.out.println("This Branch does not exist.");
      return false;
    } else{
      this.branchList.remove(getBranch(branchName));
      return true;
    }
  }

  public Branch getBranch(String branchName){
    int branchIndex = findBranch(branchName);
    if(branchIndex < 0){
      System.out.println("This Branch does not exist.");
      return null;
    } else{
    Branch branch = this.branchList.get(findBranch(branchName));
    return branch;}
  }

  public int findBranch(Branch branch){
    return this.branchList.indexOf(branch);
  }

  public int findBranch(String branchName){
    for(int i = 0; i <this.branchList.size(); i++){
      Branch branch = this.branchList.get(i);
      if(branch.getName().equals(branchName))
        return i;
    }
    return -1;
  }



}
