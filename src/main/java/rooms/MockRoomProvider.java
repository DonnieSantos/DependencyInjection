package rooms;

import com.google.inject.Provider;

public class MockRoomProvider implements Provider<IRoom> {
    @Override
    public IRoom get() {
        return new MockRoom();
    }
}