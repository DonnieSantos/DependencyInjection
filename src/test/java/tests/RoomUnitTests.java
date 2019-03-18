package tests;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.junit.Assert;
import org.junit.Test;
import people.female.IWoman;
import people.female.MockWomanProvider;
import people.male.IMan;
import people.male.MockManProvider;
import rooms.IRoom;
import rooms.Room;

public class RoomUnitTests {

    private Injector injector = Guice.createInjector((Module) binder -> {
        binder.bind(IRoom.class).to(Room.class);
        binder.bind(IWoman.class).toProvider(MockWomanProvider.class);
        binder.bind(IMan.class).toProvider(MockManProvider.class);
    });

    @Test
    public void roomUnitTests() {

        IRoom room = injector
                .getInstance(IRoom.class)
                .setName("Family Room")
                .addWoman("Michelle", "Obama")
                .addMan("Barrack", "Obama");

        Assert.assertEquals(room.getName(), "Family Room");
        Assert.assertEquals(1, room.getWomen().size());
        Assert.assertEquals(1, room.getMen().size());
        Assert.assertEquals(2, room.getPeople().size());

        /////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////
        ////                                                                                 ////
        //// Illustration of Mock Providers for IWoman and IMan...                           ////
        ////                                                                                 ////
        /**/ Assert.assertEquals("John", room.getMen().get(0).getFirstName());       ////
        /**/ Assert.assertEquals("Doe", room.getMen().get(0).getLastName());         ////
        /**/ Assert.assertEquals("John Doe", room.getMen().get(0).getFullName());    ////
        ////                                                                                 ////
        /**/ Assert.assertEquals("Jane", room.getWomen().get(0).getFirstName());     ////
        /**/ Assert.assertEquals("Doe", room.getWomen().get(0).getLastName());       ////
        /**/ Assert.assertEquals("Jane Doe", room.getWomen().get(0).getFullName());  ////
        ////                                                                                 ////
        /**/ Assert.assertEquals("Jane", room.getPeople().get(0).getFirstName());    ////
        /**/ Assert.assertEquals("Doe", room.getPeople().get(0).getLastName());      ////
        /**/ Assert.assertEquals("Jane Doe", room.getPeople().get(0).getFullName()); ////
        ////                                                                                 ////
        /**/ Assert.assertEquals("John", room.getPeople().get(1).getFirstName());    ////
        /**/ Assert.assertEquals("Doe", room.getPeople().get(1).getLastName());      ////
        /**/ Assert.assertEquals("John Doe", room.getPeople().get(1).getFullName()); ////
        ////                                                                                 ////
        /////////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////////
    }
}