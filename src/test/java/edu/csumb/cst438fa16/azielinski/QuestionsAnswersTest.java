package edu.csumb.cst438fa16.azielinski;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuestionsAnswersTest {

	private QuestionsAnswers qa;
	
	@Before
	public void create() {
		qa = new QuestionsAnswers();
	}
	
	/**
	 * Tests to make sure put successfully maps a question to an answer
	 */
	@Test
	public void testPut() {
		qa.put("question", "answer");
		assertTrue(qa.questions_to_answers.containsKey("question") &&
				qa.questions_to_answers.get("question").equals("answer"));
	}
	
	/**
	 * Tests to make sure duplicate questions can't be added
	 */
	@Test
	public void testPutDuplicate() {
		qa.put("question", "answer");
		qa.put("question", "other answer");
		assertTrue(qa.questions_to_answers.containsKey("question") &&
				qa.questions_to_answers.get("question").equals("answer") && 
				qa.questions_to_answers.size() == 1);
	}
		
}