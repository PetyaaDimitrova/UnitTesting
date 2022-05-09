package halfLife;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameIfIsNull(){
        Player player = new Player(null, 10);
    }
    @Test(expected = NullPointerException.class)
    public void testSetNameIfIsEmpty(){
        Player player = new Player(" ", 10);
    }
    @Test
    public void testSetNameSuccessfully(){
        Player player = new Player("Petya", 10);
        Assert.assertEquals("Petya", player.getUsername());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testToPutPlayerWithNegativeHealth(){
        Player player = new Player("Petya", -10);
    }
    @Test
    public void testToPutPlayerSuccessfully(){
        Player player = new Player("Petya", 10);
        Assert.assertEquals(10, player.getHealth());
    }
    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiable(){
        Player player = new Player("Petya", 10);
        player.getGuns().remove(0);
    }

    @Test
    public void testTryToTakeDamageToPlayer(){
        Player player = new Player("Petya", 10);
        player.takeDamage(5);
        Assert.assertEquals(5, player.getHealth());
    }
    @Test
    public void testTryToTakeMoreDamageThanHealthToPlayer(){
        Player player = new Player("Petya", 10);
        player.takeDamage(15);
        Assert.assertEquals(0, player.getHealth());
    }
    @Test(expected = NullPointerException.class)
    public void testToAddNullGun(){
        Gun gun = null;
        Player player = new Player("Petya", 10);
        player.addGun(gun);
    }
    @Test
    public void testToAddGunSuccessfully(){
        Gun gun = new Gun("Test", 4);
        Player player = new Player("Petya", 10);
        player.addGun(gun);
        Assert.assertEquals("Test", player.getGuns().get(0).getName());
        Assert.assertEquals(4, player.getGuns().get(0).getBullets());
    }
    @Test
    public void testToRemoveSuccessfully(){
        List<Gun> guns = new ArrayList<>();
        Gun gun = new Gun("petya", 10);
        guns.add(gun);
        Assert.assertTrue(guns.remove(gun));
    }
    @Test
    public void testToRemoveUnsuccessfully(){
        List<Gun> guns = new ArrayList<>();
        Gun gun = new Gun("petya", 10);
        guns.add(new Gun("Test", 5));
        Assert.assertFalse(guns.remove(gun));
    }
    @Test
    public void testToRemoveUnsuccessfully2(){
        Player player = new Player("Petya", 10);
        Gun gun = new Gun("petya", 10);
        player.addGun(gun);
      Gun gun2 = new Gun("Test", 5);
        Assert.assertFalse(player.removeGun(gun2));
    }
    @Test
    public void testToRemoveUnsuccessfully3(){
        Player player = new Player("Petya", 10);
        Gun gun = new Gun("petya", 10);
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }
    // public Gun getGun(String name) {
    //        Gun gun = this.guns.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);
    //        return gun;
    //    }

    @Test
    public void testGetGunSuccessfully(){
        Player player = new Player("Petya", 10);
        List<Gun> guns = new ArrayList<>();
        Gun gun1 = new Gun("petya", 10);
        Gun gun2 = new Gun("Test", 5);
        guns.add(gun1);
        guns.add(gun2);
        player.addGun(gun1);
        Assert.assertEquals(gun1, player.getGun("petya"));
    }

}
