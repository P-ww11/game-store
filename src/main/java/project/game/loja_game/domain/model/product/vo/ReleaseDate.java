public final class ReleaseDate{
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(DEFAULT_ZONE);
    private final ZoneId defaultZone = ZoneId.of("UTC");

    private final Instant value;



    private ReleaseDate(final @NotNull Instant value){
        this.value = value;
    }
    public static ReleaseDate of(final Instant value){
        isValid(value);
        return new ReleaseDate(value);
    }

    private static void isValid(final Instant value) {
        Instant dateNow = Instant.now();
        if(value == null){
            throw new InvalidReleaseDateException("RELEASE_DATE_NULL", "Release date cannot be null.");
        }
        if(value.isAfter(dateNow)){
            throw new InvalidReleaseDateException("RELEASE_DATE_IN_FUTURE", "The product release date cannot be in the future of the current date");
        }
    }

    public Instant getValue(){
        return value;
    }

     @Override
    public String toString(){
        return formatter.format(value);
    }
     @Override
     public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReleaseDate)) return false;
        ReleaseDate other = (ReleaseDate) o;
        return value.equals(other.getValue());
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}