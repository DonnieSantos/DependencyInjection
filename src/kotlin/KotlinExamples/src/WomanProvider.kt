import com.google.inject.Provider

class WomanProvider : Provider<IWoman> {
    override fun get(): IWoman {
        return Woman("", "", "")
    }
}
