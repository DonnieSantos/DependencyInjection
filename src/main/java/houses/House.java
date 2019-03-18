package houses;

import com.google.inject.Inject;
import com.google.inject.Provider;
import rooms.IRoom;

import java.util.ArrayList;

public class House implements IHouse {

    private ArrayList<IRoom> rooms;
    private Provider<IRoom> roomProvider;

    @Inject
    public House(ArrayList<IRoom> rooms, Provider<IRoom> roomProvider) {
        this.rooms = rooms;
        this.roomProvider = roomProvider;
    }

    @Override
    public ArrayList<IRoom> getRooms() {
        return rooms;
    }

    @Override
    public IHouse addRoom(String name) {
        IRoom room = roomProvider.get();
        room.setName(name);
        this.rooms.add(room);
        return this;
    }
}