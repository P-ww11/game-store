public class RoleAlreadyExistsException extends InvalidRoleException{
    public RoleAlreadyExistsException(String message){
        super("ROLE_ALREADY_EXISTS", message);
    }
}