package Model;

import java.util.Date;

public class Sale {

    private Car car;
    private Cliente client;
    private Seller seller;
    private int id;
    private Date fecha;


    //Constructor

    public Sale(Car car, Cliente client, Seller seller, int id) {
        this.car = car;
        this.client = client;
        this.seller = seller;
        this.id = id;
        this.fecha = new Date();
    }


    public String toString() {
        return "id: " + id + "\n" +
                "---" + "\n" +
                "Coche: " + "\n" +
                "-------" + "\n" +
                car + "\n" +
                "Cliente: " + "\n" +
                "-------" + "\n" +
                client + "\n" +
                "Cliente: " + "\n" +
                "-------" + "\n" +
                client + "\n" +
                "Fecha: " + "\n" +
                "-------" + "\n" +
                fecha + "\n" ;

    }


}
