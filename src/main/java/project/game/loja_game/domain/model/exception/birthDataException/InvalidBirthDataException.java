public class InvalidBirthDataException extends RuntimeException{
    private final String errorCode

    
    public InvalidBirthDataException(String errorCode, String message){
        super(validateMessage(message));
        this.errorCode = validateErrorCode(errorCode);
    }

    private String validateErrorCode(String errorCode){
        if(errorCode == null || errorCode.trim().isEmpty()){
            throw new IllegalArgumentException("Error code cannot be null or empty");
        }
        return errorCode;
    }

    private String validateMessage(String message){
        if(message == null || message.trim().isEmpty()){
            throw new IllegalArgumentException("Error message cannot be null or empty");
        }
        return message;
    }


    public String getErrorCode(){
        return errorCode;
    }
}