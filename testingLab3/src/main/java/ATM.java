public class ATM {

    private final Deposit deposit;
    private final Withdraw withdraw;

    public ATM(){

        this.deposit = new Deposit();
        this.withdraw = new Withdraw();
    }

    public Double deposit(double money, double balance){
        return deposit.add(money, balance);
    }
    public Double withdraw(double money, double balance){
        return withdraw.take(money, balance);
    }


}

class Deposit{
    public double add(double money, double balance){

        if (money <= 0)
            return balance;

        return balance + money;
    }
}

class Withdraw{
    public Double take(double money, double balance){
        if (money <= 0)
            return balance;
        if (money > balance){
            return null;
        }
        return balance - money;
    }
}
