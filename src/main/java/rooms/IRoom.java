package rooms;

import people.male.IMan;
import people.IPerson;
import people.female.IWoman;

import java.util.ArrayList;

public interface IRoom {
    String getName();
    IRoom setName(String name);
    IRoom addWoman(String firstName, String lastName);
    IRoom addMan(String firstName, String lastName);
    ArrayList<IPerson> getPeople();
    ArrayList<IWoman> getWomen();
    ArrayList<IMan> getMen();
}