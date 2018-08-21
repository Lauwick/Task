import java.util.HashMap;
import java.util.Map;

public class Task {

    private Map<Integer, String> taskList = new HashMap<Integer, String>();

    public Task(){

    }

    //Insert task in middle of list, change other priorities accordingly
    public void addTask(int number, String name){
        if (number > taskList.size() + 1 || number <= 0){
            throw new IndexOutOfBoundsException();
        } else {
            taskList.put(taskList.size() + 1, name);
            reorderTask(taskList.size(), number);
        }
    }

    //Insert task at the end of the list
    public void appendTask(String name){
        taskList.put(taskList.size() + 1, name);
    }

    //Change task description
    public void changeTask(int number, String newName){
        if (taskList.containsKey(number) == false){
            throw new IndexOutOfBoundsException();
        } else {
            taskList.put(number, newName);
        }
    }

    //Remove task and change priorities accordingly
    public void removeTask(int number) {
        if (taskList.containsKey(number) == false){
            throw new IndexOutOfBoundsException();
        } else {
            while (number < taskList.size()) {
                taskList.put(number, taskList.get(number + 1));
                number++;
            }
            taskList.remove(taskList.size());
        }
    }

    //Return task description
    public String getTask(int number) {
        if (taskList.containsKey(number) == false){
            throw new IndexOutOfBoundsException();
        } else {
            return taskList.get(number);
        }
    }

    //Check if tasks already exists
    public Boolean hasTask(String name) {
        Boolean hasTask = false;
        if (taskList.containsValue(name)){
            hasTask = true;
        }
        return hasTask;
    }

    //Return number of tasks
    public int getSize(){
        return taskList.size();
    }

    //Change the priority of a task
    public void reorderTask(int oldNumber, int newNumber){
        if (taskList.containsKey(oldNumber) == false || taskList.containsKey(newNumber) == false){
            throw new IndexOutOfBoundsException();
        } else {
            int highNumber = Math.max(oldNumber, newNumber);
            int lowNumber = Math.min(oldNumber, newNumber);
            while (lowNumber < highNumber) {
                swapTasks(highNumber, lowNumber);
                lowNumber++;
            }

        }
    }

    private void swapTasks(int firstNumber, int secondNumber){
        String firstTask = taskList.get(firstNumber);
        String secondTask = taskList.get(secondNumber);
        taskList.put(firstNumber, secondTask);
        taskList.put(secondNumber, firstTask);
    }
}
