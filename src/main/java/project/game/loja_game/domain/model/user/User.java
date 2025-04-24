package project.game.loja_game.domain.model.user;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class User{

    private final UserId id;
    private final String name;
    private final String email;
    private final String password;
    private final Address address;
    private final String phone;
    private final BirthData birthData;    
    private final Set<User.Role> role = new HashSet<>();

    private User(final UserId id,final String name,final String email,final String password,final Address address,final String phone,final BirthData birthData){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.birthData = birthData;
    }
    public User createUser(final UserId id,final String name,final String email,final String password,final Address address,final String phone,final Date birthData){
        if(!name.matches("^[\\w.-]{4,12}$")){
            throw new IllegalArgumentException("Invalid name. The name must be at least 4 characters long and can only contain alphanumeric characters, dots (.), or hyphens (-).")
        }
        if(!email.matches("^[\\w.-]{1,64}@[\\w.-]{2,63}(\\.[A-Za-z]{2,10}){1,3}$")){
            throw new IllegalArgumentException("Invalid email. Please enter a valid email address in the format name@domain.com. ")
        }
        if(!password.matches("^[\\w.-]{4,30}$")){
            throw new IllegalArgumentException("Invalid password. The password must be longer than 4 characters and contain only letters, numbers, dots (.) or hyphens (-).")
        }
        if(!phone.matches("^\\+([\\d]{1,3})\s?([\\d]{1,4})\s?([\\d]{4,15})$")){
            throw new IllegalArgumentException("Invalid phone number: The phone number must be in a valid format (e.g., +55 11 91234-5678). Please ensure it contains a valid country code and DDD.")
        }

        return new User(id, name, email, password, address, phone, birthData);
    }

     public UserId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public  LocalDate getBirthData() {
        return birthData;
    }

    public Set<Role> getRole() {
        return role;
    }

    public enum Role {
        User_ADMIN(1),
        User_COMMON(2);

        private final int role;

        Role(int role){
            this.role = role;
        }

        public int getRole(){
            return role;
        }

        public static Optional<Role> isValidRole(int role){
        return Arrays.stream(values()).filter(x -> x.role == role).findFist();
        }      
    }
}