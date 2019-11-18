import com.google.inject.Provider

class ManProvider : Provider<IMan> {
    override fun get(): IMan {
        return Man("", "")
    }
}