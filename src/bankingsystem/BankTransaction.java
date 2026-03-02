package bankingsystem;

public class BankTransaction implements Runnable {
    public Integer transAmount;
    public BankAccount bankAccount;

    public BankTransaction(Integer transAmount, BankAccount bankAccount){
        this.transAmount = transAmount;
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        if(transAmount >= 0){
            bankAccount.creditAmount(transAmount);
        }else{
            bankAccount.debitAmount(Math.abs(transAmount));
        }
    }
}