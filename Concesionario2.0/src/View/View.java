package View;

import Model.Car;
import java.util.ArrayList;
import java.util.Scanner;
import Controller.Concesionario;

public class View {

    Scanner sc = new Scanner (System.in);

    public int menu(){
        while (true) {
            try {
                System.out.println("=================");
                System.out.println("MENU DE OPCIONES");
                System.out.println("=================");
                System.out.println("1.Mostrar coches");
                System.out.println("2.Comprar coche");
                System.out.println("3.Buscar coche especifico");
                System.out.println("4.Vendedores info");
                System.out.println("5.Vender coche");
                System.out.println("6.Estadisticas del concesionario");
                System.out.println("7.Salir");
                System.out.print("Elige una opción: ");

                int option = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                return option;

            } catch (Exception e) {
                errorMessage("Debe ingresar un numero", Concesionario.COLORES);
                sc.nextLine();
            }
        }
    }


    public void errorMessage(String mensaje, String[] color){
        System.out.println(color[0] + mensaje + color[1]);
    }


    public void showCars(ArrayList<Car> cars){
        for(int i = 0; i < cars.size(); i++){
            System.out.println(i+1 + cars.get(i).toString());
        }
    }

    public void message(String message) {
        System.out.println(message);
    }
}
