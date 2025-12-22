package Model;

public class Cliente extends Person{


    //constructor
    public Cliente(String nombre, String dni, String telefono) {
        super(nombre, dni, telefono);
    }



    //Methods
    public void buy(){

    }


    public String toString(){

        return "nombre: " + getName() +
                " | dni: " + getDni() +
                " | telefono: " + getPhone() + "\n";
    }


}
