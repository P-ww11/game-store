public interface AddressConsistencyValidator{
    boolean isValidST(String country, String region, String acronym, String city, String streetName, String streetNumber);
}