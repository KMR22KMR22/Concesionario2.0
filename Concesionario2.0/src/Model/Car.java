package Model;

public class Car {

    private String brand;
    private String model;
    private int year;
    private double price;
    private String numberPlate;
    private double km;
    private boolean sold;


    //Constructor
    public Car(String brand, String model, int year, double prize,  String numberPlate,  boolean sold, double km) {

        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = prize;
        this.numberPlate = numberPlate;
        this.sold = sold;
        this.km = km;
    }


    //Getters and Setters

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public double getKm() {
        return km;
    }

    public boolean isSold() {
        return sold;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }




    public String toString() {
        return " Marca: " + brand +
                " | Modelo: " + model +
                " | Año: " + year +
                " | Precio: " + price +
                " | Matrícula: " + numberPlate +
                " | Kilometros: " + km + "\n";
    }
}
