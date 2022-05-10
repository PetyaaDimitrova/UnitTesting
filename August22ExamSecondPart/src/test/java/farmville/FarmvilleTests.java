package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FarmvilleTests {

    private List<Animal>  animals = new ArrayList<>();
    private Farm farm;
    @Before
    public void initializeObject(){
        this.farm = new Farm("Petya", 10);

    }

    // public int getCount() {
    //        return this.animals.size();
    //    }

    @Test
    public void testCount(){
        Animal animal = new Animal("niki", 4);
       farm.add(animal);
        Assert.assertEquals(1,farm.getCount());
    }
    @Test
    public void  testGetName(){
        Assert.assertEquals("Petya", farm.getName());
    }
    @Test
    public void  testGetCapacity(){
        Assert.assertEquals(10, farm.getCapacity());
    }

    //public void add(Animal animal) {
    //        if (animals.size() == this.getCapacity()) {
    //            throw new IllegalArgumentException(FARM_IS_FULL);
    //        }
    @Test(expected = IllegalArgumentException.class)
    public void testAddIfAnimalExist(){
        Animal animal = new Animal("niki", 4);
        Animal animal1 = new Animal("niki", 4);
       farm.add(animal);
       farm.add(animal1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddIfCapacityFull(){
        Farm farmy = new Farm("petya", 0);
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("niki", 5));
        farmy.add(list.get(0));
    }
    @Test
    public void testAddSuccessfully(){
        Animal animal = new Animal("niki", 4);
        Assert.assertEquals(0, farm.getCount());
        farm.add(animal);
        Assert.assertEquals(1, farm.getCount());
    }

    //public boolean remove(String animalType) {
    //        Animal animal = this.animals
    //                .stream()
    //                .filter(a -> a.getType().equals(animalType))
    //                .findFirst()
    //                .orElse(null);
    //
    //        boolean isRemove = this.animals.remove(animal);
    //        return isRemove;
    @Test
    public void testRemoveTrue(){
        Animal animal = new Animal("niki", 4);
        Assert.assertEquals(0, farm.getCount());
        farm.add(animal);
        Assert.assertTrue(farm.remove("niki"));
    }
    @Test
    public void testRemoveFalse(){
        Animal animal = new Animal("niki", 4);
        Assert.assertEquals(0, farm.getCount());
        farm.add(animal);
        Assert.assertFalse(farm.remove("petya"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCreateFarmWithNegativeCapacity(){
       Farm farm = new Farm("petya", -10);
    }
    @Test
    public void testCreateFarmWithPositiveCapacity(){
        Farm farm = new Farm("petya", 10);
        Assert.assertEquals("petya", farm.getName());
        Assert.assertEquals(10, farm.getCapacity());
    }
    @Test (expected = NullPointerException.class)
    public void testCreateFarmWithEmptyString(){
        Farm farm = new Farm(" ", 10);
    }
    @Test (expected = NullPointerException.class)
    public void testCreateFarmWithNullString(){
        Farm farm = new Farm(null, 10);
    }
    @Test
    public void testCreateFarmWithNormalString(){
        Farm farm = new Farm("petya", 10);
        Assert.assertEquals("petya", farm.getName());
        Assert.assertEquals(10, farm.getCapacity());
    }
}
