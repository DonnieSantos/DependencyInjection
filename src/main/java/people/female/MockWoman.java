package people.female;

import people.IPerson;

public class MockWoman implements IWoman {

    @Override
    public IPerson get() {
        return new MockWoman();
    }

    @Override
    public String getFullName() {
        return "Jane Doe";
    }

    @Override
    public String getFirstName() {
        return "Jane";
    }

    @Override
    public String getLastName() {
        return "Doe";
    }

    @Override
    public IPerson setFirstName(String firstName) {
        return this;
    }

    @Override
    public IPerson setLastName(String lastName) {
        return this;
    }
}
