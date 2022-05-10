package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class HouseTests {

    private House house;

    @Before
    public void initializeObject() {
        this.house = new House("test_name", 10);
    }

    @Test
    public void testGetName(){
        Assert.assertEquals("test_name", this.house.getName());
    }

    @Test
    public void testGetCapacity(){
        Assert.assertEquals(10, this.house.getCapacity());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithNullName(){
        House testHouse = new House(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHouseWithEmptyStringName(){
        House testHouse = new House("  "  , 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHouseWithNegativeCapacity(){
        House testHouse = new House("test_name" , -10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatIfCapacityFull(){
        House testHouse = new House("test_name" , 0);
        testHouse.addCat(new Cat("cat"));
    }

    @Test
    public void testAddCatIfCapacityIsBiggerThenCatCollection(){
        House testHouse = new House("test_name" , 1);
        Assert.assertEquals(0, testHouse.getCount());
        testHouse.addCat(new Cat("cat"));
        Assert.assertEquals(1, testHouse.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCatIfIsNull(){
        this.house.removeCat("Petya");
    }

    @Test
    public void testRemoveCatIfExist(){
        this.house.addCat(new Cat("Petya"));
        Assert.assertEquals(1,this.house.getCount());
        this.house.removeCat("Petya");
        Assert.assertEquals(0,this.house.getCount());
    }

    @Test
    public void testGetCount(){
        Assert.assertEquals(0, this.house.getCount());
        this.house.addCat(new Cat("Petya"));
        Assert.assertEquals(1, this.house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleIfIsNull(){
        this.house.catForSale("test_name");
    }

    @Test
    public void testCatForSaleIfExist(){
        Cat cat = new Cat("test_name");
        this.house.addCat(cat);
        Assert.assertEquals(cat, this.house.catForSale("test_name"));
    }

    @Test
    public void testToStringMethod(){
        Cat cat = new Cat("test_name");
        this.house.addCat(cat);
        Assert.assertEquals("The cat test_name is in the house test_name!", this.house.statistics());
    }
    //cat.setHungry(false);
    @Test
    public void testCatIsHungry(){
        Cat cat = new Cat("test_name");
        this.house.addCat(cat);
        this.house.catForSale("test_name");
        Assert.assertFalse(cat.isHungry());
    }

}
