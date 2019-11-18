import com.google.inject.Inject

class Man @Inject
constructor(override var firstName: String?, override var lastName: String?) : IMan {

    override val fullName: String? get() = "$firstName $lastName"

    override fun setFirstName(firstName: String): IPerson {
        this.firstName = firstName
        return this
    }

    override fun setLastName(lastName: String): IPerson {
        this.lastName = lastName
        return this
    }
}