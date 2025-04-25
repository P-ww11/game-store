public final class RegexValidator{
    public final static String REGEX_USERNAME = "^[\\w.-]{4,12}$";
    public final static String REGEX_EMAIL = "^[\\w.-]{1,64}@[\\w.-]{2,63}(\\.[A-Za-z]{2,10}){1,3}$";
    public final static String REGEX_PASSWORD = "^[\\w.-]{4,30}$";
    public final static String REGEX_PHONE = "^\\+([\\d]{1,3})\\s?([\\d]{1,4})\\s?([\\d]{4,15})$";
}