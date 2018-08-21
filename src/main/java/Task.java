import java.util.HashMap;
import java.util.Map;

public class Task {

    private Map<Integer, String> taskList = new HashMap<Integer, String>();

    public Task(){

    }

    //Insert task in middle of list, change other priorities accordingly
    public void addTask(int priority, String name){
        if (priority > taskList.size() + 1 || priority <= 0){
            throw new IndexOutOfBoundsException("Task priority " + priority + " is invalid");
        } else {
            taskList.put(taskList.size() + 1, name);
            reorderTask(taskList.size(), priority);
        }
    }

    //Insert task at the end of the list
    public void appendTask(String name){
        taskList.put(taskList.size() + 1, name);
    }

    //Change task description
    public void changeTask(int priority, String newName){
        if (taskList.containsKey(priority) == false){
            throw new IndexOutOfBoundsException("Task priority " + priority + " is invalid");
        } else {
            taskList.put(priority, newName);
        }
    }

    //Remove task and change priorities accordingly
    public void removeTask(int priority) {
        if (taskList.containsKey(priority) == false){
            throw new IndexOutOfBoundsException("Task priority " + priority + " is invalid");
        } else {
            while (priority < taskList.size()) {
                taskList.put(priority, taskList.get(priority + 1));
                priority++;
            }
            taskList.remove(taskList.size());
        }
    }

    //Return task description
    public String getTask(int priority) {
        if (taskList.containsKey(priority) == false){
            throw new IndexOutOfBoundsException("Task priority " + priority + " is invalid");
        } else {
            return taskList.get(priority);
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
    public void reorderTask(int oldpriority, int newpriority){
        if (taskList.containsKey(oldpriority) == false || taskList.containsKey(newpriority) == false){
            throw new IndexOutOfBoundsException("Task priorities are invalid");
        } else {
            int highPriority = Math.max(oldpriority, newpriority);
            int lowPriority = Math.min(oldpriority, newpriority);
            while (lowPriority < highPriority) {
                swapTasks(highPriority, lowPriority);
                lowPriority++;
            }

        }
    }

    private void swapTasks(int firstPriority, int secondPriority){
        String firstTask = taskList.get(firstPriority);
        String secondTask = taskList.get(secondPriority);
        taskList.put(firstPriority, secondTask);
        taskList.put(secondPriority, firstTask);
    }
}
