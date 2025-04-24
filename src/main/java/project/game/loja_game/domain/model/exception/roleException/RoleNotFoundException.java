public class RoleNotFoundException extends InvalidRoleException{
    public RoleNotFoundException(String message){
        super("ROLE_NOT_FOUND", message);
    }
}