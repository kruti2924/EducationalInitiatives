package StrategyDesignPattern;

//strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

//concrete strategies
class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class GPayPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using GPay");
    }
}

//context
class ShoppingCart {
    private final PaymentStrategy strategy;

    public ShoppingCart(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        strategy.pay(amount);
    }
}