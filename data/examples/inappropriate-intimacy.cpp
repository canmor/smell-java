class BankAccount {
private:
    double balance;
    std::string accountNumber;
    std::string ownerName;
    
    // 允许Transaction类访问私有成员
    friend class Transaction;
    friend class AccountManager;
    
public:
    double getBalance() const { return balance; }
    std::string getAccountNumber() const { return accountNumber; }
    std::string getOwnerName() const { return ownerName; }
};

class Transaction {
private:
    BankAccount* fromAccount;
    BankAccount* toAccount;
    double amount;
    
public:
    void execute() {
        // 直接访问BankAccount的私有成员
        if (fromAccount->balance >= amount) {
            fromAccount->balance -= amount;
            toAccount->balance += amount;
        }
    }
    
    // 知道BankAccount的内部实现细节
    bool isValidAccount(BankAccount* account) {
        return account->accountNumber.length() == 10 &&
               account->balance >= 0 &&
               !account->ownerName.empty();
    }
    
    // 直接操作私有数据
    void adjustBalance(BankAccount* account, double adjustment) {
        account->balance += adjustment;
    }
};

class AccountManager {
public:
    // 也直接访问私有成员
    void freezeAccount(BankAccount* account) {
        account->balance = 0; // 直接修改私有成员
    }
    
    bool canTransfer(BankAccount* from, BankAccount* to, double amount) {
        return from->balance >= amount && 
               from->accountNumber != to->accountNumber;
    }
};
