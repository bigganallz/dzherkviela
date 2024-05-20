public class Car {
    private String model;
    private double pricePerDay;
    private char transmission;
    private String fuel;


    public Car(String model, double pricePerDay, char typeOfTransmission, String typeOfFuel) {
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.transmission = typeOfTransmission;
        this.fuel = typeOfFuel;
    }

    @Override
    public String toString() {
        String strTransmission = "";
        switch (transmission) {
            case 'A':
                strTransmission = "automāts";
                break;
            case 'B':
                strTransmission = "mehanika";
                break;
            default:
                break;

        }

        return "Automašīnas modelis: " + model + "\n" +
                "Cena par dienu: " + pricePerDay + " EUR\n" +
                "Pārnešana veids: " + strTransmission + "\n" +
                "Degvielas veids: " + fuel + "\n";
    }

    public String getModelAndPrice() {
        return model+" "+pricePerDay+" EUR/d";
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public char typeOfTransmission() {
        return transmission;
    }

    public void typeOfTransmission(char typeOfTransmission) {
        this.transmission = typeOfTransmission;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
