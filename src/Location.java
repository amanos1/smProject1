package src;

public enum Location
{
    Somerset("Bridgewater", "08807"),
    Middlesex("Piscataway","08854"),
    Mercer("Princeton","08542"),
    Morris("Morristown","07969"),
    Union("Union","07083");

    final String CITY;
    final String ZIP_CODE;

    Location (String cityName, String zip){
        CITY = cityName;
        ZIP_CODE = zip;
    }

    public int getZipCode() {
        return Integer.parseInt(ZIP_CODE);
    }

    public String toString()
    {
        return CITY+", "+ZIP_CODE+", "+name()+" County";
    }
}

