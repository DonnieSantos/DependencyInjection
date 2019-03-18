package people;

public interface IPerson {
    String getFullName();
    String getFirstName();
    String getLastName();
    IPerson setFirstName(String firstName);
    IPerson setLastName(String lastName);
}