package project.game.loja_game.domain.model.address;

public final class Address{
    private final String country;
    private final String region;
    private final String acronym;
    private final String city;
    private final String streetName;
    private final String streetNumber;

    private Address(final @NotNull String country,final @NotNull String region,final @NotNull String acronym,final @NotNull String city,final @NotNull String streetName,final @NotNull String streetNumber){
        this.country = country;
        this.region = region;
        this.acronym = acronym;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }
    public static Address of(final String country,final String region,final String acronym,final String city,final String streetName,final String streetNumber){
        if (country == null || country.isBlank()) {
            throw new InvalidAddressException("ERROR_COUNTRY_NAME", "Country cannot be null or empty");
        }
        if (region == null || region.isBlank()) {
            throw new InvalidAddressException("ERROR_REGION_NAME", "Region cannot be null or empty");
        }
        if (acronym == null || acronym.isBlank()) {
            throw new InvalidAddressException("ERROR_ACRONYM_NAME", "Acronym cannot be null or empty");
        }
        if (city == null || city.trim().isBlank()) {
            throw new InvalidAddressException("ERROR_CITY_NAME", "City cannot be null or empty");
        }
        if (streetName == null || streetName.isBlank()) {
            throw new InvalidAddressException("ERROR_STREET_NAME", "Street Name cannot be null or empty");
        }
        if (streetNumber == null || streetNumber.isBlank()) {
            throw new InvalidAddressException("ERROR_STREET_NUMBER", "Street Number cannot be null or empty");
        }

       return new Address(country, region, acronym, city, streetName, streetNumber);
    }

    public String getCountry() {
        return country;
    }
    public String getRegion() {
        return region;
    }
    public String getAcronym() {
        return acronym;
    }

    public String getCity() {
        return city;
    }
    public String getStreetName() {
        return streetName;
    }
    public String getStreetNumber() {
        return streetNumber;
    }

     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return country.equals(address.country) &&
               region.equals(address.region) &&
               acronym.equals(address.acronym) &&
               city.equals(address.city) &&
               streetName.equals(address.streetName) &&
               streetNumber.equals(address.streetNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, acronym, city, streetName, streetNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", acronym='" + acronym + '\'' +
                ", city='" + city + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                '}';
    }

}