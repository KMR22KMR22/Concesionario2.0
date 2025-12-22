package Model;

public class Person {
    private String name;
    private String dni;
    private String phone;


    //Constructor
    public Person(String name, String dni, String phone) {
        this.name = name;
        this.dni = dni;
        this.phone = phone;
    }


    //Getters

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public String getPhone() {
        return phone;
    }



}
