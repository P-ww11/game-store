public final class BirthData{

    private final LocalDate birthData;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private BirthData(final @NotNull LocalDate birthData) {
        this.birthData = formbirthData;
    }

    public static BirthData of(final LocalDate birthData) {
        isValid(birthData);
        return new BirthData(birthData);
    }

    private static void isValid(final LocalDate birthData) {
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
    public String toString(){
        return birthData.format(formatter);
    }
     @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BirthData)) return false;
        BirthData other = (BirthData) o;
        return birthDate.equals(other.getBirthDate());
    }

    @Override
    public int hashCode() {
        return birthData.hashCode();
    }
}