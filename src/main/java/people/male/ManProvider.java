package people.male;

import com.google.inject.Provider;
import people.IPerson;

public class ManProvider implements Provider<IMan> {
    @Override
    public IMan get() {
        return new Man("", "");
    }
}