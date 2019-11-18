import com.google.inject.Inject

class Woman @Inject
constructor(override var firstName: String?, override var lastName: String?, override val fullName: String?) : IWoman {
    override fun setFirstName(firstName: String): IPerson {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setLastName(lastName: String): IPerson {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(): IPerson {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}