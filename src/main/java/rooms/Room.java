package rooms;

import com.google.inject.Inject;
import com.google.inject.Provider;
import people.IPerson;
import people.male.IMan;
import people.female.IWoman;

import java.util.ArrayList;

public class Room implements IRoom {

    private String name;
    private ArrayList<IWoman> women;
    private ArrayList<IMan> men;
    private Provider<IWoman> womanProvider;
    private Provider<IMan> manProvider;

    @Inject
    public Room(String name,
                ArrayList<IWoman> women,
                ArrayList<IMan> men,
                Provider<IWoman> womanProvider,
                Provider<IMan> manProvider) {

        this.name = name;
        this.women = women;
        this.men = men;
        this.womanProvider = womanProvider;
        this.manProvider = manProvider;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IRoom setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @deprecated  Need to find a better design with no down-casting.
     */
    @Deprecated
    @Override
    public IRoom addPerson(IPerson person) {
        if (person instanceof IWoman) {
            this.women.add((IWoman)person);
        } else if (person instanceof IMan) {
            this.men.add((IMan)person);
        }
        return this;
    }

    @Override
    public IRoom addWoman(String firstName, String lastName) {
        IWoman woman = this.womanProvider.get();
        woman.setFirstName(firstName);
        woman.setLastName(lastName);
        this.women.add(woman);
        return this;
    }

    @Override
    public IRoom addMan(String firstName, String lastName) {
        IMan man = this.manProvider.get();
        man.setFirstName(firstName);
        man.setLastName(lastName);
        this.men.add(man);
        return this;
    }

    @Override
    public ArrayList<IPerson> getPeople() {
        ArrayList<IPerson> allPeople = new ArrayList<>();
        allPeople.addAll(this.women);
        allPeople.addAll(this.men);
        return allPeople;
    }

    @Override
    public ArrayList<IWoman> getWomen() {
        return this.women;
    }

    @Override
    public ArrayList<IMan> getMen() {
        return this.men;
    }
}