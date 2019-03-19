package tests.integration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import houses.House;
import houses.IHouse;
import org.junit.Assert;
import org.junit.Test;
import people.female.IWoman;
import people.female.WomanProvider;
import people.male.IMan;
import people.male.ManProvider;
import rooms.IRoom;
import rooms.RoomProvider;

public class RoomProviderTests {

    private static final int NUM_ROOMS = 10;

    private Injector injector = Guice.createInjector((Module) binder -> {
        binder.bind(IHouse.class).to(House.class);
        binder.bind(IRoom.class).toProvider(RoomProvider.class);
        binder.bind(IWoman.class).toProvider(WomanProvider.class);
        binder.bind(IMan.class).toProvider(ManProvider.class);
    });

    @Test
    public void roomProviderTest() {

        IHouse house = injector.getInstance(IHouse.class);

        for (int i = 0; i < NUM_ROOMS; i++) {
            house.addRoom("Some Room");
        }

        Assert.assertEquals(NUM_ROOMS, house.getRooms().size());
    }
}