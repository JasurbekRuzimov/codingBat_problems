//package tatu
//data class InterviewRecord(val name: String, val answers: Map<String, String>)
//
//fun main() {
//    println("HR Interview Application (Playground - VERY Limited!)")
//    println("IMPORTANT: Input ALL answers at once, separated by newlines")
//
//    // ... (Get number of developers - you'll have to hardcode this)
//
//    val interviewResults = mutableListOf<InterviewRecord>()
//
//    for (i in 1..2) { // Example with only 2 developers
//        println("\n--- Developer $i ---")
//
//        // Simulate input (replace with hardcoded names)
//        val nameInput = readLine() ?: "Developer $i"
//
//        val answers = conductInterviewWithAllInput()
//        interviewResults.add(InterviewRecord(nameInput, answers))
//    }
//
//    // ... (Rest of the code)
//}
//
//// ... (Other functions)
//
//fun conductInterviewWithAllInput(): Map<String, String> {
//    val questions = listOf("Do you know React?", "Do you know PHP?", "Do you know Java?")
//    val answers = mutableMapOf<String, String>()
//
//    for (question in questions) {
//        println(question)
//        answers[question] = readLine() ?: "No"
//    }
//    return answers
//}






























import java.util.*

data class InterviewRecord(val name: String, val answers: Map<String, Pair<String, Int>>)

fun main() {
    println("HR Interview Application")

    val scanner = Scanner(System.`in`)
    println("Enter the number of developers to interview: ")
    val numDevelopers = scanner.nextInt()
    scanner.nextLine()

    val interviewResults = mutableListOf<InterviewRecord>()

    for (i in 1..numDevelopers) {
        println("\n--- Developer $i ---")
        println("Enter developer name: ")
        val name = scanner.nextLine()

        val answers = conductInterview(scanner)
        interviewResults.add(InterviewRecord(name, answers))
    }

    val recommendations = analyzeResults(interviewResults)
    println("\n--- Recommendations ---")
    println("By the statistics, we recommend you learn the language(s): $recommendations")
}

fun conductInterview(scanner: Scanner): Map<String, Pair<String, Int>> {
    val questions = listOf("Do you prefer React?", "Do you prefer PHP?", "Do you prefer Java?")
    val answers = mutableMapOf<String, Pair<String, Int>>()

    for (question in questions) {
        println(question)
        val answer = scanner.nextLine()

        if (answer.lowercase() == "yes") {
            println("Enter confidence level (1-100): ")
            val confidence = scanner.nextInt()
            scanner.nextLine()
            answers[question] = Pair(answer, confidence)
        } else {
            answers[question] = Pair(answer, 0)
        }
    }
    return answers
}

fun analyzeResults(results: List<InterviewRecord>): String {
    val languageConfidences = mutableMapOf<String, MutableList<Int>>()

    results.forEach { record ->
        record.answers.forEach { (question, answerPair) ->
            val language = extractLanguage(question)
            if (language != null && answerPair.first.lowercase() == "yes") {
                languageConfidences.getOrPut(language) { mutableListOf() }.add(answerPair.second)
            }
        }
    }

    return findTopLanguagesWithAverageConfidence(languageConfidences).joinToString(", ")
}

fun extractLanguage(question: String): String? {
    val keywords = mapOf("React" to "React", "PHP" to "PHP", "Java" to "Java")
    return keywords[question.substringAfter("Do you prefer ").takeWhile { it != '?' }]
}

fun findTopLanguagesWithAverageConfidence(data: Map<String, List<Int>>): List<String> {
    val recommendations = mutableListOf<String>()
    val maxAverage = data.values.map { it.average() }.maxOrNull() ?: 0.0

    data.forEach { (language, confidences) ->
        val averageConfidence = confidences.average().toInt()
        if (averageConfidence.toDouble() == maxAverage) {
            recommendations.add("$language ($averageConfidence%)")
        }
    }
    return recommendations
}
