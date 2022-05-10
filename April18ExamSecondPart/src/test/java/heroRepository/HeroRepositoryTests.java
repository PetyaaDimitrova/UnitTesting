package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.beans.BeanProperty;
import java.util.ArrayList;
import java.util.Collection;

public class HeroRepositoryTests {

    private HeroRepository heroRepository;

    @Before
    public void initializeObject() {
        this.heroRepository = new HeroRepository();
    }

    @Test
    public void testGetCount() {
        heroRepository.create(new Hero("Petya", 10));
        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateHeroIfIsNull() {
        heroRepository.create(null);
    }

    // if (this.data.stream().anyMatch(h -> h.getName().equals(hero.getName()))) {
    //            throw new IllegalArgumentException("Hero with name %s already exists");
    //        }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroWhichAlreadyExist() {
        heroRepository.create(new Hero("Petya", 10));
        heroRepository.create(new Hero("Petya", 10));
    }

    @Test
    public void testCreateHeroSuccessfully() {
        Assert.assertEquals(0, heroRepository.getCount());
        Hero hero = new Hero("Petya", 10);
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
        Assert.assertEquals("Petya", hero.getName());
        Assert.assertEquals(10, hero.getLevel());
    }


    @Test(expected = NullPointerException.class)
    public void testCreateHeroWithNullName() {
        heroRepository.remove(null);
    }
    @Test(expected = NullPointerException.class)
    public void testCreateHeroWithEmptyStringName() {
        heroRepository.remove(" ");
    }
    @Test
    public void testRemoveHeroIfExist() {
        Hero hero = new Hero("Petya", 10);
        heroRepository.create(hero);
        Assert.assertTrue(heroRepository.remove("Petya"));
    }
    @Test
    public void testRemoveHeroIfDoesNotExist() {
        Hero hero = new Hero("Petya", 10);
        heroRepository.create(hero);
        Assert.assertFalse(heroRepository.remove("niki"));
    }

    @Test
    public void testGetMaxLevel(){
        Hero hero = new Hero("Petya", 10);
        Hero hero1 = new Hero("Niki", 14);
        heroRepository.create(hero);
        heroRepository.create(hero1);
        Assert.assertEquals(hero1, heroRepository.getHeroWithHighestLevel());
    }


    @Test
    public void testGetHero(){
        Hero hero = new Hero("Petya", 10);
        heroRepository.create(hero);
        Assert.assertEquals(hero, heroRepository.getHero("Petya"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiable(){
        heroRepository.getHeroes().clear();
    }

}
