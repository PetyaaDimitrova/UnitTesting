package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpaceshipTests {

    @Test
    public void testAstronautsCount(){
        List<Astronaut> list = new ArrayList<>();
        Assert.assertEquals(0, list.size());
        list.add(new Astronaut("petya", 10.0));
        Assert.assertEquals(1, list.size());
    }

    public void  testGetNameInfo(){
        Spaceship spaceship = new Spaceship("petya", 20);
      Assert.assertEquals("petya", spaceship.getName());

    }
    @Test
    public void  testGetCapacityInfo(){
        Spaceship spaceship = new Spaceship("petya", 20);
        Assert.assertEquals(20, spaceship.getCapacity());

    }


    @Test(expected = IllegalArgumentException.class)
    public void TestAddAstronautIfCapacityIsFull(){
        Spaceship spaceship = new Spaceship("petya", 0);
        spaceship.add(new Astronaut("petya", 10));
    }
// boolean astronautExists = this.astronauts
//                .stream()
//                .anyMatch(a -> a.getName().equals(astronaut.getName()));
@Test(expected = IllegalArgumentException.class)
    public void TestIfAstronautExist(){
    Spaceship spaceship = new Spaceship("petya", 20);
    Astronaut astronaut = new Astronaut("petya", 10);
    spaceship.add(astronaut);
    spaceship.add(astronaut);
}
    @Test
    public void TestIfAstronautDoesNotExist(){
        Spaceship spaceship = new Spaceship("petya", 20);
        Astronaut astronaut = new Astronaut("petya", 10);
        Assert.assertEquals(0, spaceship.getCount());
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void TestRemoveAstronautWhoDoesNotExist(){
        Spaceship spaceship = new Spaceship("petya", 20);
        Assert.assertFalse(spaceship.remove("mimi"));
    }
    @Test
    public void TestRemoveAstronautWhoExist(){
        Spaceship spaceship = new Spaceship("petya", 20);
       Astronaut astronaut = new Astronaut("mimi", 5);
       spaceship.add(astronaut);
        Assert.assertTrue(spaceship.remove("mimi"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityIsLessThanZero(){
        Spaceship spaceship = new Spaceship("petya", -20);
    }
  //  private void setName(String name) {
    //        if (name == null || name.trim().isEmpty()) {
    //            throw new NullPointerException(INVALID_SPACESHIP_NAME);
    //        }
    //
    //        this.name = name;
    //    }
@Test(expected = NullPointerException.class)
    public void testIfNameIsNull(){
    Spaceship spaceship = new Spaceship(null, 20);
}
    @Test(expected = NullPointerException.class)
    public void testIfNameIsAnEmptyString(){
        Spaceship spaceship = new Spaceship("   ", 20);
    }
}
