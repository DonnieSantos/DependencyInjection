package tests.integration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import org.junit.Assert;
import org.junit.Test;
import people.IPerson;
import people.female.IWoman;
import people.female.WomanProvider;
import people.male.IMan;
import people.male.ManProvider;
import rooms.IRoom;
import rooms.Room;

public class PersonProviderTests {

    public static final int NUM_PEOPLE = 10;
    public static final int NUM_MEN = 5;
    public static final int NUM_WOMEN = 5;

    private Injector injector = Guice.createInjector((Module) binder -> {
        binder.bind(IRoom.class).to(Room.class);
        binder.bind(IWoman.class).toProvider(WomanProvider.class);
        binder.bind(IMan.class).toProvider(ManProvider.class);
    });

    @Test
    public void personProviderTest() {

        IRoom room = injector.getInstance(IRoom.class);

        for (int i = 0; i < NUM_PEOPLE; i++) {
            if ((i % 2) == 0) {
                room.addMan("Mike", "Smith");
            } else {
                room.addWoman("Mary", "Smith");
            }
        }

        Assert.assertEquals(NUM_PEOPLE, room.getPeople().size());

        Assert.assertEquals(NUM_MEN, room.getMen().size());
        Assert.assertEquals("Mike Smith", room.getMen().get(NUM_MEN - 1).getFullName());
        Assert.assertEquals("Mike Smith", room.getPeople().get(NUM_PEOPLE - 1).getFullName());

        Assert.assertEquals(NUM_WOMEN, room.getWomen().size());
        Assert.assertEquals("Mary Smith", room.getWomen().get(NUM_WOMEN - 1).getFullName());
        Assert.assertEquals("Mary Smith", room.getPeople().get(NUM_WOMEN - 1).getFullName());
    }

    @Test
    public void womanAsPersonProviderTest() {

        Provider<IWoman> womanProvider = injector.getInstance(WomanProvider.class);

        IWoman woman = womanProvider.get();

        boolean hasHadBoy = false;
        boolean hasHadGirl = false;

        while (!hasHadBoy || !hasHadGirl) {
            IPerson child = woman.get();
            if (child instanceof IMan) hasHadBoy = true;
            if (child instanceof IWoman) hasHadGirl = true;
        }

        Assert.assertTrue(hasHadBoy);
        Assert.assertTrue(hasHadGirl);
    }
}