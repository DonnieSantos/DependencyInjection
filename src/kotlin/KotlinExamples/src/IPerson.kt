interface IPerson {
    val fullName: String?
    val firstName: String?
    val lastName: String?
    fun setFirstName(firstName: String): IPerson
    fun setLastName(lastName: String): IPerson
}