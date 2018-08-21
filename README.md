# Task

Short class used for a prioritized task list. A task consist of a priority (number) and a description (name). The priority is ordered in lowering order : task 1 is the most important. All tasks priority are unique, you can't have two tasks with the same level of priority. However, you can have two tasks with the same description and different priorities.

## List of public methods :

### addTask(int, String):void
- Insert a new task. All following tasks will have their priority adjusted by +1.

### appendTask(String):void
- Insert a new task at the end of the list, with the lowest priority.

### changeTask(int,String):void
- Change task description.

### removeTask(int):void
- Remove a task. All following tasks will have their priority adjusted by -1.

### getTask(int):String
- Return the task description associated with the priority.

### hasTask(String):Boolean
- Return True if the tasks already exists, or false otherwise.

### getTasksNumber():int
- Return the number of Tasks

### reorderTask(int,int):void
- Change the priority of a task and lower the priority of every task after that. For example, task 7 becomes task 3. Then, old task 3 becomes task 4, old task 4 becomes 5, etc. until priority 7. Every task after that is not affected.
