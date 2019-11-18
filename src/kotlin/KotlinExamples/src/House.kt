import com.google.inject.Inject
import com.google.inject.Provider
import java.util.ArrayList

class House @Inject
constructor(override var rooms: ArrayList<IRoom>, private val roomProvider: Provider<IRoom>) : IHouse {
    override fun addRoom(name: String): IHouse {
        val room = roomProvider.get()
        room.setName(name)
        this.rooms.add(room)
        return this
    }
}