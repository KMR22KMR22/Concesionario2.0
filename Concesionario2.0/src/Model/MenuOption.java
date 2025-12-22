package Model;

public enum MenuOption {

    SHOW_CARS(1),
    BUY_CARS(2),
    SEARCH_CARS(3),
    MANAGE_SELLERS(4),
    SELL_CAR(5),
    SEE_DILER_STATS(6),
    EXIT(7);

    private final int value;


    //Constructor
    MenuOption(int value) {
        this.value = value;
    }


    //Getter

    public int getValue() {
        return value;
    }


    //Method

    public static MenuOption chosenOption(int value){

        for(MenuOption option : values()){

            if(value == option.getValue()){
                return option;
            }
        }
        throw new IllegalArgumentException("Opcion no valida");
    }
}
