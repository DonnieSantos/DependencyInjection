package people.male;

import com.google.inject.Provider;

public class MockManProvider implements Provider<IMan> {
    @Override
    public IMan get() {
        return new MockMan();
    }
}