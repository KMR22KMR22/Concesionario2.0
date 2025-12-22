package Controller;
import Model.*;
import View.View;

import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {
    Scanner sc = new Scanner(System.in);

    public static final String[] COLORES = new String[]{"\u001B[31m", "\u001B[0m"};



    private View view;
    private float money;
    private double highestPrice = 500000;
    private double lowestPrice = 90000;

    ArrayList<Cliente> clients = new ArrayList<>();
    ArrayList<Seller> sellers = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Sale> sales  = new ArrayList<>();
    ArrayList<Car> unsoldCars = new ArrayList<>();

    /**Llena el arraylist (clientes) con clientes predeterminados para que cuando arranque el progreama el concesionario ya cuente con clientes
     * */
    public void declarateClients() {

        clients.add(new Cliente("12345678A", "Kevin", "+34 1234567"));
        clients.add(new Cliente("87654321B", "Maria", "+34 7654321"));
    }


    /**Llena el arraylist (vendedores) con clientes predeterminados para que cuando arranque el progreama el concesionario ya cuente con vendedores
     * */
    public void declarateVendedores() {

        sellers.add(new Seller("Juan", "3283782A","+34 92472874", 0, null, 0, 0));
        sellers.add(new Seller("Pedro", "3283782A", "+34 9244574", 0, null, 0, 0));
        sellers.add(new Seller("Ana", "3283782A", "+34 755672874",0, null, 0, 0));
    }


    /**Llena el arraylist (coches) con coches predeterminados para que cuando arranque el progreama el concesionario ya cuente con coches
     * */
    public void declaracionCoches() {
        cars.add(new Car( "Lamborghini", "Gallardo", 2011, 100000, "1111ABC", false, 32000));
        cars.add(new Car( "Lamborghini", "Aventador", 2021, 500000, "1111ABC", false, 0));
        cars.add(new Car( "Porsche", "911", 2021, 90000, "1111ABC", false, 10000));
        cars.add(new Car( "Porsche", "Cayanne - SUV", 2024, 95000, "1111ABC", false, 0));
        cars.add(new Car( "BMW", "Serie 7 - Sedan", 2019, 123000, "1111ABC", false, 0));
        cars.add(new Car( "BMW", "X7 - SUV", 2018, 104300, "1111ABC", false, 19000));
    }




    /**El run del programa
     * */
    public void run() {

        boolean salir = false;
        int userimput;
        MenuOption option;

        while (!salir) {

            userimput = view.menu();

            try {

                option = MenuOption.chosenOption(userimput);

                switch (option) {
                    case SHOW_CARS:
                        showCars(cars);
                        break;

                    case BUY_CARS:
                        buyCar();
                        break;

                    case SEARCH_CARS:
                        searchCar();
                        break;

                    //case MANAGE_SELLERS:
                    //    manageSellers();


                    case SELL_CAR:
                        sellCar();
//
                    //case SEE_DILER_STATS:
                    //    seeDilerStats();
//
                    //case EXIT:
                    //    salir = true;
                }

            }catch(Exception e) {
                view.errorMessage("Valor incorrecto. Intentelo de nuevo", COLORES);
                sc.nextLine();

            }
        }
    }


    //Funciones del menu


    /**
     * Revisa la lista de coches y los que tengan el atributo sold en falso lo agrega a la lista de unsoldCars, para luego mostrar esta lista
     *
     * @param cars
     * @return
     */
    private void showCars(ArrayList<Car> cars) {

        for (Car c : cars) {
            if(!c.isSold()) {
                unsoldCars.add(c);
            }
        }
        if(unsoldCars.isEmpty()) {
            view.errorMessage("No tenemos coches disponibles", COLORES);
        }else {
            view.showCars(unsoldCars);
            unsoldCars.clear();
        }
    }


    /**Pide los datos del coche a coomprar para guardar el nuevo coche y le resta el precio del coche al presupuesto del concesionario*/
    private void buyCar() {
        double expent = 0;

        view.message("Necesito los datos del coche");
        view.message("-----------------------------");

        cars.add(new Car(askBrand(), askModel(), askYear(), askPrice(), askNumberPlate(), false, askKm()));
        expent = cars.getLast().getPrice();

        this.money -= expent ;

        view.message("Coche añadido");

        //Compruebo si el nuevo tiene un precio mayor o menor al maximo o minimo establecidos
        stablishLowestPrice();
        stablishHighestPrice();
    }


    /**Busca coches por la marca, el precio y el año
     * */
    public void searchCar() {
        ArrayList<Car> foundCars = new ArrayList<>();
        boolean[] found = new boolean[]{false, false, false};
        String marca = "";
        double[] price = new double[2];
        int[] year = new int[2];

        //pide la marca del coche y comprueba que hayan coches de esa marca
        while (!found[0]) {
            view.message("Que marca de coche le interesa:");
            view.message("------------------------------");
            marca = askBrand();

            for (Car c : cars) {
                if (!c.isSold() & c.getBrand().toLowerCase().equals(marca)) {
                    found[0] = true;
                }
            }
            if (!found[0]) {
                view.errorMessage("No tenemos coches de esa marca",  COLORES);
            }
        }

        //pide un rango de precios y comprueba que hayan coches de esos precios
        while (!found[1]) {

            view.message("Digame un rango de precio:");
            view.message("-------------------------");

            while (true) {
                view.message("Precio minimo:");
                price[0] = askPrice();
                view.message("Precio maximo:");
                price[1] = askPrice();

                if (price[0] > price[1]) {
                    view.errorMessage("el precio minimo no puede ser mayor que le maximo", COLORES);
                }else {
                    break;
                }
            }
            for (Car c : cars) {
                if (!c.isSold() & c.getPrice() >= price[0] & c.getPrice() <= price[1]) {
                    found[1] = true;
                }
            }
            if (!found[1]) {
                view.errorMessage("No tenemos coches en ese rango de precios",  COLORES);
            }
        }

        //pide un rango de años y comprueba que hayan coches de esos años
        while (!found[2]) {
            view.message("Digame un rago de años del coche");
            view.message("--------------------------------");

            while (true) {
                view.message("Año minimo");
                year[0] = askYear();
                view.message("Año maximo");
                year[1] = askYear();

                if (year[0] > year[1]) {
                    view.errorMessage("el año minimo no puede ser mayor que le maximo", COLORES);
                }else {
                    break;
                }
            }
            for (Car c : cars) {
                if (!c.isSold() & c.getYear() >= year[0] & c.getYear() <= year[1]) {
                    found[2] = true;
                }
            }
            if (!found[2]) {
                view.errorMessage("No tenemos coches de esos años",  COLORES);
            }
        }


        //Busca un coche cuyos datos coincidan con la marca, precio y años introducidos anteriormente y los muestra
        for(Car c : cars) {
            if(!c.isSold() & c.getBrand().toLowerCase().equals(marca) & c.getPrice() >= price[0] & c.getPrice() <= price[1] & c.getYear() >= year[0] && c.getYear() <= year[1]) {
                foundCars.add(c);
            }
        }
        if(foundCars.isEmpty()) {
            view.errorMessage("No tenemos coches que coincidan", COLORES);
        }else {
            view.message("Coches enconreatos:");
            view.message("-------------------");
            view.showCars(foundCars);
        }

    }



    public void sellCar(){
        Cliente client = addClient();
        Seller seller = addSeller();
        Car car = null;
        int choise = 0;

        view.message("A continuacion te muestro los coches disponibles");
        showCars(cars);
        view.message("Dame el numero del coche que te interesa");
        view.message("----------------------------------------");
        choise = sc.nextInt();
        sc.nextLine();

        cars.get(choise -1).setSold(true);

        sales.add(new Sale(cars.get(choise -1), client, seller, sales.size() + 1) );

    }






    //Funciones extra


    public void stablishLowestPrice(){
        for(Car c : cars) {
            if(c.getPrice()<lowestPrice & !c.isSold()) {
                lowestPrice = c.getPrice();
            }
        }
    }

    public void stablishHighestPrice(){
        for(Car c : cars) {
            if(c.getPrice()>highestPrice & !c.isSold()) {
                highestPrice = c.getPrice();
            }
        }
    }


    /**Pide la marca del coche
     * @return Marca del coche*/
    public String askBrand() {
        String brand;
        while(true) {
            view.message("Dame la mara del coche");
            brand = sc.nextLine();
            if(brand.equals("")) {
                view.errorMessage("Debe ingresar la mara", COLORES);
            }else {
                break;
            }
        }
        return brand;
    }

    /**Pide el modelo del coche
     * @return modelo del coche*/
    public String askModel() {
        String model;

        while(true) {
            view.message("Dame el modelo del coche");
            model = sc.nextLine();
            if(model.equals("")) {
                view.errorMessage("Debe ingresar el modelo", COLORES);
            }else {
                break;
            }
        }
        return model;
    }

    /**Pide el año del coche
     * @return año del coche*/
    public int askYear() {
        int year;

        while(true) {
            try{
                view.message("Dame el año del coche");
                year = sc.nextInt();
                sc.nextLine();
                if(year <= 1900 || year >= 2026) {
                    view.errorMessage("Año incorrecto", COLORES);
                }else {
                    break;
                }
            }catch(Exception e) {
                view.errorMessage("Valor incorrecto. Intentelo de nuevo", COLORES);
                sc.nextLine();
            }

        }
        return year;
    }


    /**Pide el precio del coche
     * @return precio del coche*/
    public double askPrice() {
        double price;

        while(true) {
            try{
                view.message("Dame el precio del coche");
                price = sc.nextDouble();
                sc.nextLine();
                if(price < 2000) {
                    view.errorMessage("Precio muy bajo", COLORES);
                } else if (price > 30000000) {
                    view.errorMessage("Precio demaciao alto", COLORES);
                } else {
                    break;
                }
            }catch(Exception e) {
                view.errorMessage("Valor incorrecto. Intentelo de nuevo", COLORES);
                sc.nextLine();
            }

        }
        return price;
    }

    /**Pide la chapa del coche
     * @return numero de matriula*/
    public String askNumberPlate() {
        String numberplate;

        while(true) {
            view.message("Dame la chapa del coche");
            numberplate = sc.nextLine();
            if(numberplate.equals("")) {
                view.errorMessage("Debe ingresar la chapa", COLORES);
            }else {
                break;
            }
        }
        return numberplate;

    }


    /**Pide el kilometraje del coche
     * @return km del coche*/
    public double askKm() {
        double km;

        while(true) {
            try{
                view.message("Dame el kilometraje del coche");
                km = sc.nextInt();
                sc.nextLine();
                if(km < 0) {
                    view.errorMessage("El coche no puede tener menos de 0 km", COLORES);
                } else if (km > 60000) {
                    view.errorMessage("No aceptamos coches con ese kilometraje tan alto", COLORES);
                } else {
                    break;
                }
            }catch(Exception e) {
                view.errorMessage("Valor incorrecto. Intentelo de nuevo", COLORES);
                sc.nextLine();
            }

        }
        return km;
    }


    /**Pide el dni
     * @return dni*/
    public String askdni() {
        String dni;
        while (true) {
            view.message("Dame el dni del comprador");
            dni = sc.nextLine();

            if(dni.equals("")) {
                view.errorMessage("Debe ingresar el dni", COLORES);
            }else  {
                break;
            }
        }
        return dni;
    }


    /**Pide el nombre
     * @return nombre*/
    public String askName() {
        String name;
        while(true){
            view.message("Dame el nombre del comprador");
            name = sc.nextLine();

            if(name.equals("")) {
                view.errorMessage("Debe ingresar el nombre", COLORES);
            }else {
                break;
            }
        }
        return name;
    }


    /**Pide el telefono
     * @return telefono*/
    public String askPhone() {
        String phone;
        while(true){
            view.message("Dame el telefono del comprador");
            phone = sc.nextLine();
            if(phone.equals("")) {
                view.errorMessage("Debe ingresar el telefono", COLORES);
            }else {
                break;
            }
        }
        return phone;
    }



    /**Pide el dni del cliente para comprobar si esta registrado y si no le pide el resto de los datos para agregarlo a la base de datos
     * @return Cliente que va a comprar el coche*/
    public Cliente addClient(){
        boolean ourClient = false;
        Cliente client = null;
        String name;
        String phone;
        String dni;

        dni = askdni();


        for (Cliente c : clients) {
            if (c.getDni().equals(dni)) {
                view.message("Veo que ya es cliente nuestro");
                ourClient = true;
                client = c;
            }
        }
        if(!ourClient) {

            name = askName();

            phone = askPhone();


            clients.add(new Cliente(dni, name, phone));
            client = clients.getLast();
        }
        return client;
    }



    /**Pide el dni del vendedor para comprobar si esta registrado y si no le pide el resto de los datos para agregarlo a la base de datos
     * @return vendedor*/
    public Seller addSeller(){
        boolean ourSeller = false;
        Seller seller = null;
        String name;
        String phone;
        String dni;

        dni = askdni();

        for (Seller c : sellers) {
            if (c.getDni().equals(dni)) {
                view.message("Veo que ya es cliente nuestro");
                ourSeller = true;
                seller = c;
            }
        }
        if(!ourSeller) {
            name = askName();

            phone = askPhone();

            sellers.add(new Seller(dni, name, phone, 0, null, 0, 0));
            seller = sellers.getLast();
        }

        return seller;
    }




    //Constructor


    public Concesionario(View view, float money) {
        this.view = view;
        this.money = money;
    }
}
