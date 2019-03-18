package rooms;

import com.google.inject.Provider;
import people.female.WomanProvider;
import people.male.ManProvider;

import java.util.ArrayList;

public class RoomProvider implements Provider<IRoom> {
    @Override
    public IRoom get() {
        return new Room("", new ArrayList<>(), new ArrayList<>(), new WomanProvider(), new ManProvider());
    }
}