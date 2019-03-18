package people.female;

import com.google.inject.Provider;

public class MockWomanProvider implements Provider<IWoman> {
    @Override
    public IWoman get() {
        return new MockWoman();
    }
}
