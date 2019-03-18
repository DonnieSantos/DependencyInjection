package houses;

import rooms.IRoom;

import java.util.ArrayList;

public interface IHouse {
    ArrayList<IRoom> getRooms();
    IHouse addRoom(String name);
}