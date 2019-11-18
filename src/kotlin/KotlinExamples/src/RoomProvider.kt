import com.google.inject.Provider
import java.util.ArrayList

class RoomProvider : Provider<IRoom> {
    override fun get(): IRoom {
        return Room("", ArrayList(), ArrayList(), WomanProvider(), ManProvider())
    }
}