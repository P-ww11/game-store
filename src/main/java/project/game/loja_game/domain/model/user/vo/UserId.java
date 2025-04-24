public class UserId{

    private UUID id;

    public  UserId(String id){
        if(id == null || id.isBlank()){
            throw new InvalidUserIdException("USER_ID_EMPTY", "User ID cannot be null or blank");
        }
        try{

        this.id = UUID.fromString(id);

        }
        catch(IllegalArgumentException e){

            throw new InvalidUserIdException("USER_ID_INVALID", "User ID must be a valid UUID");
        }
    }

   

    
    
    public UUID getId() {
        return id;
    }
}