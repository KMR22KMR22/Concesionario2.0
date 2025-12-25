package View;

import Model.Car;
import java.util.ArrayList;
import java.util.Scanner;
import Controller.Concesionario;
import Model.Seller;

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



    public int stats(){
        int option = 0;
        boolean retry = true;

        while (retry) {
            try {
                System.out.println("Estadisticas generales:");
                System.out.println("----------------------");
                System.out.println("1. Total de coches en el concesionario");
                System.out.println("2. Total de coches vendidos");
                System.out.println("3. Total de coches disponibles");
                System.out.println("4. Dinero total invertido en compras");
                System.out.println("5. Dinero total ingresado por ventas");
                System.out.println("6. Balance actual del concesionario");
                System.out.println("Precios y mercado:" + "\n");
                System.out.println("-----------------");
                System.out.println("7. Coche más caro disponible");
                System.out.println("8. Coche más barato disponible");
                System.out.println("9. Precio medio de los coches disponibles");
                System.out.println("10. Precio medio de los coches vendidos");
                System.out.println("11. Diferencia entre precio medio de compra y venta");
                System.out.println("Ventas:" + "\n");
                System.out.println("------");
                System.out.println("12. Número total de ventas realizadas");
                System.out.println("13. Última venta realizada");
                System.out.println("14. Venta más cara realizada");
                System.out.println("15. Venta más barata realizada" + "\n");
                System.out.println("Vendedores");
                System.out.println("16. Vendedor con más coches vendidos");
                System.out.println("18. Vendedor con mayor facturación");
                System.out.println("19. Vendedor con la venta más cara");
                System.out.println("20. Promedio de ventas por vendedor");
                System.out.println("21. Ranking de vendedores" + "\n");
                System.out.println("Clientes:");
                System.out.println("--------");
                System.out.println("22. Número total de clientes registrados");
                System.out.println("23. Cliente que más ha gastado");
                System.out.println("24. Cliente con más compras" + "\n");
                System.out.println("Stock y rotación:");
                System.out.println("----------------");
                System.out.println("25. Marca con más coches en stock");
                System.out.println("26. Marca más vendida");
                System.out.println("27. Modelo más vendido");
                System.out.println("28. Año medio de los coches disponibles");
                retry = false;

                option = sc.nextInt();
                sc.nextLine();

            }catch (Exception e){
                errorMessage("Debe ingresar un numero", Concesionario.COLORES);
                sc.nextLine();
                retry = true;
            }
        }
        return option;
    }


    public void errorMessage(String mensaje, String[] color){
        System.out.println(color[0] + mensaje + color[1]);
    }


    public void showCars(ArrayList<Car> cars){
        for(int i = 0; i < cars.size(); i++){
            System.out.println(i+1 + cars.get(i).toString());
        }
    }


    public void showSellers(ArrayList<Seller> sellers){
        for (Seller s : sellers){
            System.out.println(s.toString());
        }
    }

    public void message(String message) {
        System.out.println(message);
    }
}
