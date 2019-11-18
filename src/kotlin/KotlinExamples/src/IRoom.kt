import java.util.ArrayList

interface IRoom {
    var name: String?
    var people: ArrayList<IPerson>?
    var women: ArrayList<IWoman>?
    var men: ArrayList<IMan>?
    fun setName(name: String): IRoom
    fun addPerson(person: IPerson): IRoom
    fun addWoman(firstName: String, lastName: String): IRoom
    fun addMan(firstName: String, lastName: String): IRoom
}