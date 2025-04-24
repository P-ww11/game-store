package project.game.loja_game.domain.model.address;

public final class Address{
    private final String country;
    private final String region;
    private final String acronym;
    private final String city;
    private final String streetName;
    private final String streetNumber;

    private Address(final String country,final String region,final String acronym,final String city,final String streetName,final String streetNumber){
        this.country = country;
        this.region = region;
        this.acronym = acronym;
        this.city = city;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
    }
    public static Address createAddress(final String country,final String region,final String acronym,final String city,final String streetName,final String streetNumber){
        if(!country.matches("^[A-Za-zÀ-ÿ]{1,20}(\\s[A-Za-zÀ-ÿ]{1,20}){0,5}$")){
             throw new InvalidAddressException("COUNTRY_NAME_ERROR","Invalid country. It must have at least 3 characters and contain only letters and spaces.");
        }
        if(!region.matches("^[\\wÀ-ÿ.-]{1,15}(\s[\\wÀ-ÿ.-]{1,15}){0,4}$")){
           throw new InvalidAddressException("REGION_NAME_ERROR","Invalid region. Only alphanumeric characters, periods, and hyphens are allowed.");
        }
        if(!acronym.matches("^[A-Z]{2,6}$")){
            throw new InvalidAddressException("ERROR_IN_ACROYNM","Invalid acronym. It must be between 2 and 6 uppercase characters.");
           }
        if(!city.matches("^[\\wÀ-ÿ.-]{1,20}(\\s[\\wÀ-ÿ.-]{1,20}){0,5}$")){
            throw new InvalidAddressException("CITY_NAME_ERROR","Invalid city. Only alphanumeric characters, periods, and hyphens are allowed.");
          }
        if(!streetName.matches("^[\\wv.-]{1,30}(\\s[\\wÀ-ÿ.-]{1,30}){0,5}$")){
            throw new InvalidAddressException("STREET_NAME_ERROR","Invalid street name. Only alphanumeric characters, periods, and hyphens are allowed.");
        }
                                
        if(!streetNumber.matches("^\\d{1,5}[A-Za-z]?\\s?-?\\s?\\d{1,5}[A-Za-z]?(\/\\d{1,5})?$")){
            throw new InvalidAddressException("STREET_NUMBER_ERROR", "Invalid street number. The number must follow the correct format, including numbers, letters, and fractions if applicable.");
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
    

}