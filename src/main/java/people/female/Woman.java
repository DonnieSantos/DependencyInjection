package people.female;

import com.google.inject.Inject;
import people.IPerson;
import people.male.Man;

import java.util.concurrent.ThreadLocalRandom;

public class Woman implements IWoman {

    private String firstName;
    private String lastName;

    @Inject
    public Woman(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public IPerson get() {
        switch (ThreadLocalRandom.current().nextInt(0, 2)) {
            case 0:
                return new Man("", "");
            default:
                return new Woman("", "");
        }
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
    public IWoman setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public IWoman setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
}