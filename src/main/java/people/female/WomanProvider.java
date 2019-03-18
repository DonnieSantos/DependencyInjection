package people.female;

import com.google.inject.Provider;
import people.IPerson;

public class WomanProvider implements Provider<IWoman> {
    @Override
    public IWoman get() {
        return new Woman("", "");
    }
}