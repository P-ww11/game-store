public final class UserId{

    private final UUID id;

    private UserId(UUID id) {
        if (id == null) {
            throw new InvalidUserIdException("USER_ID_EMPTY", "User ID cannot be null");
        }
        this.id = id;
    }

    public static UserId fromString(String id) {
        if (id == null || id.isBlank()) {
            throw new InvalidUserIdException("USER_ID_EMPTY", "User ID cannot be null or blank");
        }
        try {
            return new UserId(UUID.fromString(id));
        } catch (IllegalArgumentException e) {
            throw new InvalidUserIdException("USER_ID_INVALID", "User ID must be a valid UUID");
        }
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserId)) return false;
        UserId userId = (UserId) o;
        return id.equals(userId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
