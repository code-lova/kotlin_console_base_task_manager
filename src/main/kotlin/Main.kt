// Define the Task data class to hold task title and description
data class Task(val title: String, val description: String)

// Entry point of the program
fun main() {
    // Welcome message
    println("===== Kotlin Task Manager =====")

    // Mutable list to hold user tasks
    val tasks = mutableListOf<Task>()

    // Infinite loop to display the main menu until user exits
    while (true) {
        // Display menu options
        println("\nChoose an option:")
        // Option to add a new task
        println("1. Add Task")

        // Option to list all tasks
        println("2. List Tasks")

        // Option to remove an existing task
        println("3. Remove Task")

        // Exit option
        println("4. Exit")

        // Prompt user to enter a choice
        print("Enter your choice: ")

        // Read user input
        val input = readLine()

        // Evaluate user's menu selection using 'when'
        when (input) {
            "1" -> addTask(tasks)             // Call function to add task
            "2" -> listTasks(tasks)           // Inline logic to list tasks
            "3" -> removeTask(tasks)          // Call function to remove task
            "4" -> {                          // Exit option
                println("👋 Exiting Task Manager. Goodbye!")
                // Break the loop to exit
                break
            }
            // Invalid option handler
            else -> println("❗ Invalid choice. Please try again.")
        }
    }
}

// Function to handle adding a task to the task list
fun addTask(tasks: MutableList<Task>) {
    print("Enter task title: ")              // Prompt for title
    val title = readLine() ?: ""             // Read title input
    print("Enter task description: ")        // Prompt for description
    val desc = readLine() ?: ""              // Read description input

    // Add task to list
    tasks.add(Task(title, desc))

    // Confirmation message
    println("✅ Task added successfully.")
}

// Function to handle removing a task from the task list
fun removeTask(tasks: MutableList<Task>) {
    if (tasks.isEmpty()) {
        // Alert if no tasks available
        println("⚠️ No tasks to remove.")
    } else {
        println("Enter the task number to remove:")
        tasks.forEachIndexed { index, task ->    // Display all tasks with numbers
            println("${index + 1}. ${task.title}")
        }

        // Read user input and safely parse to Int
        val indexInput = readLine()?.toIntOrNull()
        if (indexInput != null && indexInput in 1..tasks.size) {
            tasks.removeAt(indexInput - 1)           // Remove task if valid number

            // Confirmation
            println("🗑️ Task removed.")

        } else {
            // Handle invalid input
            println("❌ Invalid task number.")
        }
    }
}

// Function to list all tasks (left inline per your request)
fun listTasks(tasks: List<Task>) {
    if (tasks.isEmpty()) {
        println("⚠️ No tasks available.")     // Alert if task list is empty
    } else {
        println("📋 Your Tasks:")             // Header
        tasks.forEachIndexed { index, task -> // Enumerate tasks
            println("${index + 1}. ${task.title} - ${task.description}")
        }
    }
}
