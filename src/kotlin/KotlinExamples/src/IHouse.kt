interface IHouse {
    fun addRoom(name: String) : IHouse
    var rooms: ArrayList<IRoom>
}