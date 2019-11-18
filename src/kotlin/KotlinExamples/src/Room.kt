import com.google.inject.Inject
import com.google.inject.Provider

import java.util.ArrayList

class Room @Inject constructor(
    override var name: String?,
    override var women: ArrayList<IWoman>?,
    override var men: ArrayList<IMan>?,
    private var womanProvider: Provider<IWoman>,
    private var manProvider: Provider<IMan>
) : IRoom {

    override var people: ArrayList<IPerson>? = ArrayList()
        get() {
            val allPeople = ArrayList<IPerson>()
            this.men?.forEach { allPeople.add(it) }
            this.women?.forEach { allPeople.add(it) }
            return allPeople
        }

    override fun setName(name: String): IRoom {
        this.name = name
        return this
    }

    @Deprecated("Need to find a better design with no down-casting.")
    override fun addPerson(person: IPerson): IRoom {
        (person as? IMan)?.let { men?.add(it) }
        (person as? IWoman)?.let { women?.add(it) }
        return this
    }

    override fun addWoman(firstName: String, lastName: String): IRoom {
        val woman = this.womanProvider.get()
        woman.setFirstName(firstName)
        woman.setLastName(lastName)
        this.women?.add(woman)
        return this
    }

    override fun addMan(firstName: String, lastName: String): IRoom {
        val man = this.manProvider.get()
        man.setFirstName(firstName)
        man.setLastName(lastName)
        this.men?.add(man)
        return this
    }
}
