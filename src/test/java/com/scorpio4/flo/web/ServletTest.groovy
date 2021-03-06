package com.scorpio4.flo.web

import com.scorpio4.iq.vocab.Scorpio4ActiveVocabularies
import com.scorpio4.runtime.MockEngine
import org.junit.Test;

/**
 * scorpio4-oss (c) 2014
 * Module: com.scorpio4.flo.self
 * @author lee
 * Date  : 14/07/2014
 * Time  : 2:46 AM
 */
public class ServletTest extends GroovyTestCase {

	@Test
	public void testPipeline() throws Exception {
		MockEngine engine = new MockEngine();
		engine.provision("scorpio4/flo/web/servlet.n3", getClass().getClassLoader());

		Scorpio4ActiveVocabularies activeVocabularies = new Scorpio4ActiveVocabularies(engine);
		activeVocabularies.startAndWait();

		//TODO: do tests

		activeVocabularies.stop()
		engine.stop();
	}
}
