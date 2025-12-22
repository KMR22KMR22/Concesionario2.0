package Model;

public class Seller extends Person{

    private double priceAverage;
    private Car mostExpensiveCar;
    private int carsSold;
    private double totalCashEarned;


    //Constructor

    public Seller(String name, String dni, String phone, double priceAverage, Car mostExpensiveCar, int carsSold,  double totalCashEarned) {
        super(name, dni, phone);
        this.priceAverage = priceAverage;
        this.mostExpensiveCar = mostExpensiveCar;
        this.carsSold = carsSold;
        this.totalCashEarned = totalCashEarned;
    }




    //Getters and setters

    public double getPriceAverage() {
        return priceAverage;
    }

    public void setPriceAverage(double priceAverage) {
        this.priceAverage = priceAverage;
    }

    public Car getMostExpensiveCar() {
        return mostExpensiveCar;
    }

    public void setMostExpensiveCar(Car mostExpensiveCar) {
        this.mostExpensiveCar = mostExpensiveCar;
    }

    public int getCarsSold() {
        return carsSold;
    }

    public void setCarsSold(int carsSold) {
        this.carsSold = carsSold;
    }

    public double getTotalCashEarned() {
        return totalCashEarned;
    }

    public void setTotalCashEarned(double totalCashEarned) {
        this.totalCashEarned = totalCashEarned;
    }




}
