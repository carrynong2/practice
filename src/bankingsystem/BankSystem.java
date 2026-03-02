package bankingsystem;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankSystem {
    private static final Map<Integer, BankAccount> accounts = new ConcurrentHashMap<>();
    static void main(String[] args) {
        BankAccount objAcc1 = new BankAccount(1000, 101);
        BankAccount objAcc2 = new BankAccount(2000, 102);

        accounts.put(objAcc1.getAccountNumber(), objAcc1);
        accounts.put(objAcc2.getAccountNumber(), objAcc2);

        BankAccount acc1 = accounts.get(101);
        BankAccount acc2 = accounts.get(102);

        Thread objThread1 = new Thread(new BankTransaction(50, acc1));
        Thread objThread2 = new Thread(new BankTransaction(-150, acc2));
        Thread objThread3 = new Thread(new BankTransaction(250, acc2));
        Thread objThread4 = new Thread(new BankTransaction(250, acc1));

        objThread1.start();
        objThread2.start();
        objThread3.start();
        objThread4.start();

        try{
            objThread1.join();
            objThread2.join();
            objThread3.join();
            objThread4.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== Final Account Balances ===");
        for (Map.Entry<Integer, BankAccount> entry : accounts.entrySet()) {
            BankAccount account = entry.getValue();
            System.out.println("Account " + account.getAccountNumber() +
                             " - Balance: " + account.getBalance());
        }
    }
}
