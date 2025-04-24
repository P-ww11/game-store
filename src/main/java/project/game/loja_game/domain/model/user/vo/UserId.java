public class UserId{

    private UUID id;

    private UserId(UUID id){
        if(id == null){
            throw new IllegalArgumentException("id null");
        }
        this.id = id;
    }

    public static UserId createrRandom(){
        return new UserId(UUID.randomUUID());
    }

    public static UserId createFrom(UUID id){
        return new UserId(id);
    }
    
    public UUID getId() {
        return id;
    }
}