package people.male;

import com.google.inject.Inject;

public class Man implements IMan {

    private String firstName;
    private String lastName;

    @Inject
    public Man(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public IMan setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public IMan setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}