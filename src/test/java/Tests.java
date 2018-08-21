import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Tests {

    private Task tasks = new Task();

    private Logger LOGGER = LoggerFactory.getLogger("Unit tests");

    @Test
    public void unitTests() {

        //Append tests : see if the task is correctly added at the end of the list
        tasks.appendTask("Buy Milk");
        Assert.assertEquals("Buy Milk", tasks.getTask(1));
        tasks.appendTask("Wash Laundry");
        Assert.assertEquals("Wash Laundry", tasks.getTask(2));
        tasks.appendTask("Take train ticket");
        Assert.assertEquals(3,tasks.getSize());

        //Reorder test : see if the task is correctly re-prioritized
        tasks.appendTask("Shop groceries");
        tasks.appendTask("Pass technical test");
        tasks.reorderTask(2, 4);
        Assert.assertEquals("Shop groceries", tasks.getTask(2));
        Assert.assertEquals("Wash Laundry", tasks.getTask(3));
        Assert.assertEquals("Take train ticket", tasks.getTask(4));
        Assert.assertEquals("Pass technical test", tasks.getTask(5));

        //Add test : see if the task is correctly inserted in the middle of the list
        tasks.addTask(4, "Clean dishes");
        Assert.assertEquals("Clean dishes", tasks.getTask(4));
        Assert.assertEquals("Take train ticket", tasks.getTask(5));
        Assert.assertEquals("Pass technical test", tasks.getTask(6));

        //Change test : see if the task is correctly modified
        tasks.changeTask(2, "Throw out garbage");
        Assert.assertEquals("Throw out garbage", tasks.getTask(2));

        //Remove test : see if the task is correctly removed
        tasks.removeTask(4);
        Assert.assertEquals("Take train ticket", tasks.getTask(4));
        Assert.assertEquals("Pass technical test", tasks.getTask(5));
        Assert.assertEquals(5, tasks.getSize());
        tasks.removeTask(5);
        Assert.assertEquals(4, tasks.getSize());

        //HasTask test : see if the task exists already
        Assert.assertEquals(true, tasks.hasTask("Buy Milk"));
        Assert.assertEquals(false, tasks.hasTask("Playing video games"));

        //Out of bounds tests
        try {
            tasks.addTask(25, "Learning math");
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.addTask(-2, "Learning math");
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.changeTask(25, "Learning math");
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.changeTask(-25, "Learning math");
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.removeTask(25);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.removeTask(-25);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.getTask(25);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.getTask(-25);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.reorderTask(25, 3);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.reorderTask(-25, 3);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.reorderTask(2, 30);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }

        try {
            tasks.reorderTask(2, 30);
            Assert.fail();
        } catch (IndexOutOfBoundsException e) {
            LOGGER.info("Successfully caught exception : " + e.getMessage());
        }
    }
}
