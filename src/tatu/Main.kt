
data class InterviewRecord(val name: String, val answers: Map<String, String>)

fun main() {
    println("HR Interview Application (Playground - VERY Limited!)")
    println("IMPORTANT: Input ALL answers at once, separated by newlines")

    // ... (Get number of developers - you'll have to hardcode this)

    val interviewResults = mutableListOf<InterviewRecord>()

    for (i in 1..2) { // Example with only 2 developers
        println("\n--- Developer $i ---")

        // Simulate input (replace with hardcoded names)
        val nameInput = readLine() ?: "Developer $i"

        val answers = conductInterviewWithAllInput()
        interviewResults.add(InterviewRecord(nameInput, answers))
    }

    // ... (Rest of the code)
}

// ... (Other functions)

fun conductInterviewWithAllInput(): Map<String, String> {
    val questions = listOf("Do you know React?", "Do you know PHP?", "Do you know Java?")
    val answers = mutableMapOf<String, String>()

    for (question in questions) {
        println(question)
        answers[question] = readLine() ?: "No"
    }
    return answers
}