package aquarium;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Collectors;

public class AquariumTests {

    @Test(expected = NullPointerException.class)
    public void testIfNameIsNull() {
        Aquarium aquarium = new Aquarium(null, 70);
    }

    @Test(expected = NullPointerException.class)
    public void testIfNameIsEmptyString() {
        Aquarium aquarium = new Aquarium("     ", 70);
    }

    @Test
    public void testSetNameShouldBeCorrect() {
        Aquarium aquarium = new Aquarium("petya", 10);
        Assert.assertEquals("petya", aquarium.getName());
    }

    @Test
    public void testIfNameIsCorrect() {
        Aquarium aquarium = new Aquarium("Petya", 10);
        Assert.assertEquals("Petya", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCapacityIsBellowZero() {
        Aquarium aquarium = new Aquarium("Petya", -1);
    }

    @Test
    public void testIfCapacityIsCorrect() {
        Aquarium aquarium = new Aquarium("Petya", 10);
        Assert.assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFishIfAquariumIsFull() {
        Aquarium aquarium = new Aquarium("Petya", 1);
        Assert.assertEquals(0, aquarium.getCount());
        Fish fish = new Fish("didi");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
        Fish fish2 = new Fish("niki");
        aquarium.add(fish2);
    }

    @Test
    public void testAddIfAquariumIsNotFull() {
        Aquarium aquarium = new Aquarium("Petya", 10);
        Assert.assertEquals(0, aquarium.getCount());
        Fish fish = new Fish("didi");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveIfFishDoesNotExist() {
        Aquarium aquarium = new Aquarium("petya", 10);

        aquarium.remove("valui");
    }

    @Test
    public void testRemoveIfFishExist() {
        Aquarium aquarium = new Aquarium("petya", 10);
        Assert.assertEquals(0, aquarium.getCount());
        Fish fish = new Fish("niki");
        aquarium.add(fish);
        Assert.assertEquals(1, aquarium.getCount());
        aquarium.remove("niki");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSellFishIfNotExist() {
        Aquarium aquarium = new Aquarium("petya", 10);
        aquarium.sellFish("valui");
    }

    @Test
    public void testSellFishIfExist() {
        Aquarium aquarium = new Aquarium("petya", 10);
        Fish fish = new Fish("niki");
        aquarium.add(fish);
        aquarium.sellFish("niki");
        Assert.assertEquals(1, aquarium.getCount());
        Assert.assertEquals(fish, aquarium.sellFish("niki"));
    }

    @Test
    public void testReport() {
        Aquarium aquarium = new Aquarium("Petya", 10);
        Fish fish = new Fish("bibi");
        Fish fish1 = new Fish("boko");
        aquarium.add(fish);
        aquarium.add(fish1);
        Assert.assertEquals("Fish available at Petya: bibi, boko", aquarium.report());
    }
}

