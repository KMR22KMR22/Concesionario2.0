import Controller.Concesionario;
import View.View;

public class Program {

    public static void main(String[] args) {

        View view = new View();
        Concesionario concesionario = new Concesionario(view, 1000000);

        //Relleno el cncesionario
        concesionario.declarateClients();
        concesionario.declarateVendedores();
        concesionario.declaracionCoches();

        concesionario.run();
    }
}
