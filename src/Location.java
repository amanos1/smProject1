package src;

/**
 * Stores information about a single location.
 * Each location, labeled by the county each one is in, has information about the
 * zip code and city it's in.
 * @author Harshkumar Patel, Aaron Browne
 */
public enum Location
{
    Somerset("Bridgewater", "08807"),
    Middlesex("Piscataway","08854"),
    Mercer("Princeton","08542"),
    Morris("Morristown","07969"),
    Union("Union","07083");

    final String CITY;
    final String ZIP_CODE;

    /**
     * Creates an instance of location with the specified city name and zip code.
     * @param cityName The name of the city the location is in.
     * @param zip The zip code of the location.
     */
    Location (String cityName, String zip)
    {
        CITY = cityName;
        ZIP_CODE = zip;
    }

    /**
     * Returns the zip code as an integer.
     * @return The zip code converted to an int.
     */
    public int getZipCode()
    {
        return Integer.parseInt(ZIP_CODE);
    }

    /**
     * Returns a string representation if the location
     */
    public String toString()
    {
        return CITY + ", " + ZIP_CODE + ", " + name() + " County";
    }
}

