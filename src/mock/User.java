package mock;

public class User {

    final private Long id;

    final private String passwordHash;

    final private boolean enabled;

    public Long getId() {
        return id;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public User(Long id, String passwordHash, boolean enabled) {
        this.id = id;
        this.passwordHash = passwordHash;
        this.enabled = enabled;
    }
}