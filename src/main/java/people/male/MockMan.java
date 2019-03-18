package people.male;

import people.IPerson;

public class MockMan implements IMan {

    @Override
    public String getFullName() {
        return "John Doe";
    }

    @Override
    public String getFirstName() {
        return "John";
    }

    @Override
    public String getLastName() {
        return "Doe";
    }

    @Override
    public IMan setFirstName(String firstName) {
        return this;
    }

    @Override
    public IMan setLastName(String lastName) {
        return this;
    }
}
