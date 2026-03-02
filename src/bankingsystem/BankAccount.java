package bankingsystem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private Integer balance;
    private final Integer accountNumber;
    private final Lock reLock = new ReentrantLock();

    public BankAccount(Integer balance, Integer accountNumber){
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void debitAmount(Integer amount){
        reLock.lock();
        try {
            if (balance < amount) {
                throw new IllegalArgumentException("Insufficient funds");
            }
            balance -= amount;
        }finally {
            reLock.unlock();
        }
    }

    public void creditAmount(Integer amount){
        reLock.lock();
        try{
            balance += amount;
        }finally {
            reLock.unlock();
        }
    }

    public Integer getAccountNumber(){
        return this.accountNumber;
    }

    public Integer getBalance(){
        reLock.lock();
        try {
            return this.balance;
        } finally {
            reLock.unlock();
        }
    }
}