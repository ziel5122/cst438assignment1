package edu.csumb.cst438fa16.azielinski;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * A half-secretive map of questions to answers (at most one answer per question).
 * Gives out random questions (keys) from the map, and
 * can be queried to test if a given question maps to a given answer.
 */

public class QuestionsAnswers {
	
	HashMap<String, String> questions_to_answers = new HashMap<String, String>();
	Random rand = new Random();
	
	/**
	 * Maps question to answer
	 */
	void put(String question, String answer) {
		if (!questions_to_answers.containsKey(question)) {
			questions_to_answers.put(question, answer);
			System.out.println("Successfully added:\n\t" + question + "\n\t" + answer + "\n");
		}
		else 
			System.out.println("Question already mapped to an answer\n");
	}
	
	/**
	 * Queries if question maps to answer
	 */
	boolean testAnswer(String question, String answer) {
		String match = questions_to_answers.get(question);
		if (match == null || !match.equalsIgnoreCase(answer))
			return false;
		return true;
	}
	
	/**
	 * Gives out a random question for the key set
	 */
	String getRandomQuestion() {
		Set<String> question_set = questions_to_answers.keySet();
		String[] questions = question_set.toArray(new String[question_set.size()]);
		return questions[rand.nextInt(questions.length)];
	}
}
