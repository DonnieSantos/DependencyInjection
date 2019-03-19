package tests.unit;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.junit.Assert;
import org.junit.Test;
import people.IPerson;
import people.female.IWoman;
import people.female.Woman;
import people.male.IMan;
import people.male.Man;

public class PeopleTests {

    private Injector injector = Guice.createInjector((Module) binder -> {
        binder.bind(IWoman.class).to(Woman.class);
        binder.bind(IMan.class).to(Man.class);
        binder.bind(IPerson.class).toProvider(Woman.class);
    });

    @Test
    public void peopleUnitTests() {

        IMan man = injector.getInstance(IMan.class);
        IWoman woman = injector.getInstance(IWoman.class);
        IPerson child = woman.get();

        man.setFirstName("Barack");
        man.setLastName("Obama");

        woman.setFirstName("Michelle");
        woman.setLastName("Obama");

        child.setFirstName("Malia");
        child.setLastName("Obama");

        Assert.assertEquals("Barack", man.getFirstName());
        Assert.assertEquals("Obama", man.getLastName());
        Assert.assertEquals("Barack Obama", man.getFullName());

        Assert.assertEquals("Michelle", woman.getFirstName());
        Assert.assertEquals("Obama", woman.getLastName());
        Assert.assertEquals("Michelle Obama", woman.getFullName());

        Assert.assertEquals("Malia", child.getFirstName());
        Assert.assertEquals("Obama", child.getLastName());
        Assert.assertEquals("Malia Obama", child.getFullName());
    }
}