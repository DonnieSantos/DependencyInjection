package people.female;

import com.google.inject.Provider;
import people.IPerson;

public interface IWoman extends IPerson, Provider<IPerson> {
}