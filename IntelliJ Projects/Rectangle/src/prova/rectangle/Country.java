package prova.rectangle;

public class Country implements Measurable{

    private String countryName;
    private int extensionInSquareKilometers;

    public Country(String countryName, int extensionInSquareKilometers) {
        this.countryName = countryName;
        this.extensionInSquareKilometers = extensionInSquareKilometers;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getExtensionInSquareKilometers() {
        return extensionInSquareKilometers;
    }

    @Override
    public double getMeasure(){
        return getExtensionInSquareKilometers();
    }


}
