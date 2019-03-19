package rooms;

import com.google.inject.Inject;
import people.male.IMan;
import people.IPerson;
import people.female.IWoman;

import java.util.ArrayList;

public class MockRoom implements IRoom {

    @Inject
    public MockRoom() {
    }

    @Override
    public String getName() {
        return "MockRoom";
    }

    @Override
    public IRoom setName(String name) {
        return this;
    }

    @Override
    public IRoom addPerson(IPerson person) {
        return this;
    }

    @Override
    public IRoom addWoman(String firstName, String lastName) {
        return this;
    }

    @Override
    public IRoom addMan(String firstName, String lastName) {
        return this;
    }

    @Override
    public ArrayList<IPerson> getPeople() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<IWoman> getWomen() {
        return new ArrayList<>();
    }

    @Override
    public ArrayList<IMan> getMen() {
        return new ArrayList<>();
    }
}