package tests;

import com.google.inject.*;
import com.google.inject.Module;
import houses.House;
import houses.IHouse;
import org.junit.Assert;
import org.junit.Test;
import rooms.*;

public class HouseUnitTests {

    private Injector injector = Guice.createInjector((Module) binder -> {
        binder.bind(IHouse.class).to(House.class);
        binder.bind(IRoom.class).toProvider(MockRoomProvider.class);
    });

    @Test
    public void houseUnitTests() {

        IHouse house = injector
            .getInstance(IHouse.class)
                .addRoom("Family Room")
                .addRoom("Living Room")
                .addRoom("Kitchen");

        Assert.assertEquals(3, house.getRooms().size());

        /////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////
        ////                                                                             ////
        //// Illustration of Mock Provider for IRoom...                                  ////
        ////                                                                             ////
        /**/ Assert.assertEquals("MockRoom", house.getRooms().get(0).getName()); ////
        /**/ Assert.assertEquals("MockRoom", house.getRooms().get(1).getName()); ////
        /**/ Assert.assertEquals("MockRoom", house.getRooms().get(2).getName()); ////
        ////                                                                             ////
        /////////////////////////////////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////////////////////////////////
    }
}