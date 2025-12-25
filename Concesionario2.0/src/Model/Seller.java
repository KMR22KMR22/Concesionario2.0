package Model;

public class Seller extends Person{

    private double moneyAverage;
    private Car mostExpensiveCar;
    private int carsSold;



    //Constructor

    public Seller(String name, String dni, String phone, double moneyAverage, Car mostExpensiveCar, int carsSold) {
        super(name, dni, phone);
        this.moneyAverage = moneyAverage;
        this.mostExpensiveCar = mostExpensiveCar;
        this.carsSold = carsSold;

    }




    //Getters and setters

    public double getMoneyAverage() {
        return moneyAverage;
    }

    public void setMoneyAverage(double moneyAverage) {
        this.moneyAverage = moneyAverage;
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



    public String toString(){

        return "nombre: " + getName() +
                " | dni: " + getDni() +
                " | telefono: " + getPhone() +
                " | dinero ganado: " + getMoneyAverage() +
                " | coche mas caro vendido: " + getMostExpensiveCar() +
                " | cantidad de coches vendidos: " + getCarsSold() +"\n";
    }


}
