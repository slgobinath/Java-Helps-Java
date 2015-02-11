/**
 * Sample project to explain the abstraction.
 * The abstract sub classes can decide on overriding.
 * If an abstract class overrides any abstract methods of their super class,
 * upcomping sub classes do not need to override those methods.
 *
 * @author L.Gobinath
 */
public class BankAccountDemo {
    public static void main(String[] args) {
        doStuff(new  ChildrensSavingsAccount());
        doStuff(new GeneralSavingsAccount());
        doStuff(new CurrentAccount());
    }

    public static void doStuff(Account acc) {
        System.out.println("Account name: " + acc.getName());
        System.out.println("Is cheque available: " + acc.isChequeAvailable());
        acc.interest();
    }
}

/**
 * Abstract class Account with two abstract methods.
 */
abstract class Account {
    /**
     * Abstract method.
     */
    public abstract void interest();

    /**
     * Abstract method.
     */
    public abstract boolean isChequeAvailable();

    /**
     * Non-abstract method.
     * An abstract class can have any number of non-abstract methods.
     * @return The name of the account
     */
    public String getName() {
        String accName = this.getClass().toString().replace("class ", "");
        return accName;
    }
}

/**
 * Abstract sub class of Account.
 * Overrides only one abstract method: isChequeAvailable.
 * Sub classes do not need to override isChequeAvailable.
 */
abstract class SavingsAccount extends Account {
    @Override
    public boolean isChequeAvailable() {
        return false;
    }
}

/**
 * Non-abstract sub class of SavingsAccount.
 * No need to override isChequeAvailable.
 * Must override the abstract method interest.
 */
class ChildrensSavingsAccount extends SavingsAccount {
    @Override
    public void interest() {
        System.out.println("Interest: 5.0%");
    }
}

/**
 * Non-abstract sub class of SavingsAccount.
 * No need to override isChequeAvailable.
 * Must override the abstract method interest.
 */
class GeneralSavingsAccount extends SavingsAccount {
    @Override
    public void interest() {
        System.out.println("Interest: 4.0%");
    }
}

/**
 * Non-abstract sub class of Account.
 * It must override both interest and isChequeAvailable.
 */
class CurrentAccount extends Account {
    @Override
    public void interest() {
        System.out.println("No interest");
    }

    @Override
    public boolean isChequeAvailable() {
        return true;
    }
}