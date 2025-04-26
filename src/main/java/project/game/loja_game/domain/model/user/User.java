package project.game.loja_game.domain.model.user;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public final class User{

    private final UUID id;
    private final String name;
    private final String email;
    private final String password;
    private final Address address;
    private final String phone;
    private final BirthData birthData;    
    private final Set<Role> roles = new HashSet<>();

    private User(final UUID id,final String name,final String email,final String password,final Address address,final String phone,final BirthData birthData){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.birthData = birthData;
    }
    public static User createUser(final String id,final String name,final String email,final String password,final Address address,final String phone,final BirthData birthData,final PasswordEncoder encoder){
        if (name == null || name.isBlank()) {
            throw new InvalidUserException("USERNAME_ERROR", "Name cannot be null or empty.");
        }

        if (email == null || email.isBlank()) {
            throw new InvalidUserException("EMAIL_ERROR", "Email cannot be null or empty.");
        }

        if (password == null || password.isBlank()) {
            throw new InvalidUserException("PASSWORD_ERROR", "Password cannot be null or empty.");
        }

        if (phone == null || phone.isBlank()) {
            throw new InvalidUserException("PHONE_ERROR", "Phone number cannot be null or empty.");
        }
        UUID newId;
        try {
            newId = (id == null || id.isBlank()) ? UUID.randomUUID() : UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            throw new InvalidUserException("ID_ERROR", "Provided ID is not a valid UUID.");
        }

        return new User(newId, name, email,encoder.encoder(password), address, phone, birthData);
    }

     public UUID getId() {
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

    public  BirthData getBirthData() {
        return birthData;
    }

    public Set<Role> getRoles() {
        return new HashSet<>(roles);
    }

    public boolean addRole(Role role){
        if (role == null) {
            throw new InvalidRoleException("ROLE_NULL", "Role cannot be null");
        }
        if (roles.contains(role)) {
            throw new RoleAlreadyExistsException("Role has already been added");
        }
        if(!Role.isValidRole(role.getRole()).isPresent()){
            throw new RoleNotFoundException("role was not found"); 
        }
        return roles.add(role);
    }

    public boolean removeRole(Role role){
        if (role == null) {
            throw new InvalidRoleException("ROLE_NULL", "Role cannot be null");
        }
        if (!roles.contains(role) || !Role.isValidRole(role.getRole()).isPresent()) {
            throw new RoleNotFoundException("Role was not found and cannot be removed");
        }
        return roles.remove(role);
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
        return Arrays.stream(values()).filter(x -> x.role == role).findFirst();
        }      
    }
}