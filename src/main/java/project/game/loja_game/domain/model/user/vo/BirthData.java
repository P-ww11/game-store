public final class BirthData{

    private final LocalDate birthData;

    private final DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private BirthData(LocalDate birthData) {
        isValid(birthData);
        this.birthData = formbirthData;
    }

    public static BirthData of(LocalDate birthData) {
        return new BirthData(birthData);
    }

    private void isValid(LocalDate birthData) {
        LocalDate dateNow = LocalDate.now();
        if(birthData == null){
            throw new InvalidBirthDateException("BIRTHDATE_NULL", "Birth date cannot be null.");
        }
        if(birthData.isAfter(dateNow) || birthData.equals(dateNow)){
            throw new InvalidBirthDataException("BIRTHDATE_IN_FUTURE","the date of birth cannot be in the future or equal to the current date");
        }
        if(Period.between(birthData, dateNow).getYears() <= 10){
            throw new InvalidBirthDataException("BIRTHDATE_TOO_YOUNG","date of birth cannot be less than or equal to 10 years of age");
        }
    }

    public LocalDate getBirthData() {
        return birthData;
    }
    @Override
    public Strint toString(){
        return birthData.format(formatt);
    }
     @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BirthData)) return false;
        BirthData other = (BirthData) o;
        return birthDate.equals(other.birthDate);
    }

    @Override
    public int hashCode() {
        return birthData.hashCode();
    }
}