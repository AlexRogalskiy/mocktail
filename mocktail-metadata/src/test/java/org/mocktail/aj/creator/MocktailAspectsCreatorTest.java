package org.mocktail.aj.creator;

import static junit.framework.Assert.assertTrue;
import static org.mocktail.FileTestUtil.absolutePath;
import static org.mocktail.FileTestUtil.deleteDir;

import java.io.File;

import org.junit.Test;
import org.mocktail.MocktailContainer;
import org.mocktail.MocktailContext;
import org.mocktail.MocktailObjectMother;
import org.mocktail.xml.domain.MocktailMode;
import org.springframework.beans.DirectFieldAccessor;

public class MocktailAspectsCreatorTest {

	@Test
	public void testCreateAspects() throws Exception {
		MocktailContainer.initializeContainer("");
		MocktailContext mocktailContext = MocktailContext.getMocktailContext("");
		DirectFieldAccessor dfa = new DirectFieldAccessor(mocktailContext);
		//Need to set as Mocktail Context is a singleton class and is getting set-upped from multiple places
		dfa.setPropertyValue("recordingDirectory", "");
		
		String testAspectsDirectory = absolutePath("src", "test", "resources",
				"org", "mocktail", "aspectsDirectory");
		MocktailAspectsCreator.ASPECTS_CREATOR.createAspects(MocktailObjectMother
				.getMocktailsForAspects(), new File(testAspectsDirectory),
				MocktailMode.RECORDING_MODE);

		String firstMocktailFile = absolutePath("src", "test", "resources", "org", "mocktail", "aspectsDirectory", "org", "mocktail",
				"aj", "creator", "AspectTemplateProcesser.aj");
		assertTrue(new File(firstMocktailFile).isFile());

		String secondMocktailFile = absolutePath("src", "test", "resources", "org", "mocktail", "aspectsDirectory", "org", "mocktail",
				"xml", "domain", "AspectMocktail.aj");
		assertTrue(new File(secondMocktailFile).isFile());
		// Uncomment the deleteDir if you want to see the aspects
		deleteDir(new File(testAspectsDirectory));
	}

}