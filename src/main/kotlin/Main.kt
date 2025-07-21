data class Task(val title: String, val description: String)

fun main() {
    println("===== Kotlin Task Manager =====")
    val tasks = mutableListOf<Task>()

    while (true) {
        println("\nChoose an option:")
        println("1. Add Task")
        println("2. List Tasks")
        println("3. Remove Task")
        println("4. Exit")
        print("Enter your choice: ")

        val input = readLine()

        when (input) {
            "1" -> {
                print("Enter task title: ")
                val title = readLine() ?: ""
                print("Enter task description: ")
                val desc = readLine() ?: ""
                tasks.add(Task(title, desc))
                println("✅ Task added successfully.")
            }

            "2" -> {
                if (tasks.isEmpty()) {
                    println("⚠️ No tasks available.")
                } else {
                    println("📋 Your Tasks:")
                    tasks.forEachIndexed { index, task ->
                        println("${index + 1}. ${task.title} - ${task.description}")
                    }
                }
            }

            "3" -> {
                if (tasks.isEmpty()) {
                    println("⚠️ No tasks to remove.")
                } else {
                    println("Enter the task number to remove:")
                    tasks.forEachIndexed { index, task ->
                        println("${index + 1}. ${task.title}")
                    }

                    val indexInput = readLine()?.toIntOrNull()
                    if (indexInput != null && indexInput in 1..tasks.size) {
                        tasks.removeAt(indexInput - 1)
                        println("🗑️ Task removed.")
                    } else {
                        println("❌ Invalid task number.")
                    }
                }
            }

            "4" -> {
                println("👋 Exiting Task Manager. Goodbye!")
                break
            }

            else -> println("❗ Invalid choice. Please try again.")
        }
    }
}