package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {
    //  public String addGoods(String shelf, Goods goods) throws OperationNotSupportedException, IllegalArgumentException{
    //        if (!this.shelves.containsKey(shelf)) {
    //            throw new IllegalArgumentException("The shelf doesn't exist!");
    //        }
    private Shop shop;

    @Before
    public void initializeObject() {
this.shop = new Shop();
    }

    @Test (expected = UnsupportedOperationException.class)
    public void testToMakeUnsupportedOperation() {
      shop.getShelves().clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfShelvesDoesNotExist() throws OperationNotSupportedException {
        shop.addGoods("invalid", null);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIfAddExistedShelve() throws OperationNotSupportedException {
        Goods goods = new Goods("name", "petya");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test
    public void testAddSuccessfullyGoods() throws OperationNotSupportedException {
        Goods goods = new Goods("name", "petya");
        String actual = shop.addGoods("Shelves1", goods);
        Assert.assertEquals("Goods: petya is placed successfully!" , actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTryToRemoveUnExistingShelve(){
        Goods goods = new Goods("name", "petya");
        shop.removeGoods("test", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToRemoveUnExistingGoods() throws OperationNotSupportedException {
        Goods goods = new Goods("name", "petya");
        Goods goods1 = new Goods("name1", "petya1");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods1);
    }
    @Test
    public void testRemoveSuccessfully() throws OperationNotSupportedException {
        Goods goods = new Goods("name", "petya");
        shop.addGoods("Shelves1", goods);
        String actual = shop.removeGoods("Shelves1", goods);
        Assert.assertEquals("Goods: petya is removed successfully!", actual);
    }
    @Test
    public void testRemoveSuccessfullyAndCheck() throws OperationNotSupportedException {
        Goods goods = new Goods("name", "petya");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Goods expected = shop.getShelves().get("Shelves1");
        Assert.assertNull(expected);
    }

}