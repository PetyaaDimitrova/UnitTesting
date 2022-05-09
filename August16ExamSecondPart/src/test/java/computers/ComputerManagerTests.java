package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {

    private ComputerManager computerManager;
    private Computer computer1;
    private Computer computer2;

    @Before
    public void initializeObject() {
        this.computerManager = new ComputerManager();
        computer1 = new Computer("petya", "dimitrova", 10);
        computer2 = new Computer("niki", "neykov", 4);
    }


    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableCollection() {
        computerManager.getComputers().remove(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerWhichIsNull() {
        this.computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerWhichExist() {
        this.computerManager.addComputer(computer1);
        this.computerManager.addComputer(computer1);
    }

    @Test
    public void testAddComputerSuccessfully() {
        Assert.assertEquals(0, this.computerManager.getCount());
        this.computerManager.addComputer(computer1);
        Assert.assertEquals(1, this.computerManager.getCount());
    }

    //public Computer removeComputer(String manufacturer, String model) {
    //        Computer computer = this.getComputer(manufacturer, model);
    //
    //        this.computers.remove(computer);
    //        return computer;

    @Test
    public void testToRemoveComputerSuccessfully() {
        this.computerManager.addComputer(computer1);
        computerManager.removeComputer("petya", "dimitrova");
        Assert.assertEquals("petya", computer1.getManufacturer());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFirst() {
        this.computerManager.getComputer("dimitrova", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetSecond() {
        this.computerManager.getComputer(computer1.getManufacturer(), computer1.getModel());
    }

    @Test
    public void testGetSuccessfully() {
        computerManager.addComputer(computer1);
        Computer computer = computerManager.getComputer(computer1.getManufacturer(), computer1.getModel());
        Assert.assertNotNull(computer);
        Assert.assertEquals(computer.getManufacturer(), computer1.getManufacturer());
        Assert.assertEquals(computer.getModel(), computer1.getModel());
    }
    //public List<Computer> getComputersByManufacturer(String manufacturer) {
    //        this.validateNullValue(manufacturer, CAN_NOT_BE_NULL_MESSAGE);
    //
    //        List<Computer> computers = this
    //                .computers
    //                .stream()
    //                .filter(c -> c.getManufacturer().equals(manufacturer))
    //                .collect(Collectors.toList());
    //
    //        return computers;

    @Test
    public void testIfNullValue(){
       computerManager.addComputer(computer1);
       computerManager.addComputer(computer2);
        List<Computer> list = computerManager.getComputersByManufacturer(computer1.getManufacturer());
        Assert.assertNotNull(list);
        Assert.assertEquals(list.get(0).getManufacturer(), computer1.getManufacturer());
    }
    @Test
    public void testGetByManIfIsEmpty(){
        List<Computer> list = computerManager.getComputersByManufacturer(computer1.getManufacturer());
        Assert.assertNotNull(list);
        Assert.assertTrue(list.isEmpty());
    }




}