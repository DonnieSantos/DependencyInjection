package tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import houses.House;
import houses.IHouse;
import org.junit.Assert;
import org.junit.Test;
import people.IPerson;
import people.female.IWoman;
import people.female.Woman;
import people.female.WomanProvider;
import people.male.IMan;
import people.male.ManProvider;
import rooms.IRoom;
import rooms.RoomProvider;

public class HouseIntegrationTests {

    private IHouse fullHouse;

    private IRoom getFamilyRoom() { return fullHouse.getRooms().get(0); }
    private IRoom getLivingRoom() { return fullHouse.getRooms().get(1); }
    private IPerson getBarack() { return getFamilyRoom().getMen().get(0); }
    private IPerson getMichelle() { return getFamilyRoom().getWomen().get(0); }

    private Injector injector = Guice.createInjector((Module) binder -> {
        binder.bind(IHouse.class).to(House.class);
        binder.bind(IRoom.class).toProvider(RoomProvider.class);
        binder.bind(IWoman.class).toProvider(WomanProvider.class);
        binder.bind(IMan.class).toProvider(ManProvider.class);
    });

    @Test
    public void houseIntegrationTest() {

        fullHouse = injector.getInstance(IHouse.class)
            .addRoom("Family Room")
            .addRoom("Living Room");

        getFamilyRoom()
            .addMan("Barack", "Obama")
            .addWoman("Michelle", "Obama");

        //////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////
        ////                                                                          ////
        //// IWoman extends Provider<IPerson>...                                      ////
        ////                                                                          ////
        /**/ IWoman michelle = getFamilyRoom().getWomen().get(0);                     ////
        /**/ IPerson child = michelle.get();                                          ////
        /**/ String childFirstName = child instanceof Woman ? "Malia" : "Barack Jr."; ////
        /**/ child.setFirstName(childFirstName);                                      ////
        /**/ child.setLastName("Obama");                                              ////
        ////                                                                          ////
        //////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////

        Assert.assertEquals("Family Room", getFamilyRoom().getName());
        Assert.assertEquals("Living Room", getLivingRoom().getName());

        Assert.assertEquals(1, getFamilyRoom().getMen().size());
        Assert.assertEquals(1, getFamilyRoom().getWomen().size());
        Assert.assertEquals(2, getFamilyRoom().getPeople().size());

        Assert.assertEquals(0, getLivingRoom().getMen().size());
        Assert.assertEquals(0, getLivingRoom().getWomen().size());
        Assert.assertEquals(0, getLivingRoom().getPeople().size());

        Assert.assertEquals("Barack Obama", getBarack().getFullName());
        Assert.assertEquals("Michelle Obama", getMichelle().getFullName());
        Assert.assertEquals(childFirstName + " Obama", child.getFullName());
    }
}