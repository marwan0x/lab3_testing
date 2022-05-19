public class Coffee {
    Stock stock;
    Coins coins;
    public Coffee(){
        stock = new Stock();
        coins = new Coins();
    }

    public int refill(int n){
        return stock.add(n);
    }
    public int getCups(int n){
        int i = n;
        while(i >0 && stock.check()){
            coins.takeInput(1);
            stock.takeOneCup();
            i--;

        }
        return i;
    }


}
class Stock{
    int amount = 15;

    public int add(int n){
        if (n>0) {
            this.amount += n;
        }
        return amount;
    }
    public boolean check(){
        return amount > 0;
    }
    public Integer takeOneCup(){
        if (amount>0) {
            amount--;
            return amount;
        }else {
            return null;
        }
    }


}


class Coins{
    int totalAmount = 0;
    int inputAmount = 0;

    public boolean check(){
        return inputAmount > 0;
    }
    public void takeInput(int input){
        if (input > 0){
            totalAmount += input;
            inputAmount = input;
        }
    }
}