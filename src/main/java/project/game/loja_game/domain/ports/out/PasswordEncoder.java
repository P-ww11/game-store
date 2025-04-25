public interface passwordEncoder {
    String encoder(String password);
    boolean matches(String password, String encryptedPassword);
}