package com.scorpio4.jdbc
import com.scorpio4.iq.vocab.Scorpio4ActiveVocabularies
import com.scorpio4.runtime.MockEngine

import javax.sql.DataSource
/**
 * scorpio4-oss (c) 2014
 * Module: com.scorpio4.jdbc
 * @author lee
 * Date  : 6/07/2014
 * Time  : 4:09 AM
 *
 *
 */
class JDBCFLOTest extends GroovyTestCase {

	public void testFLO() {
		MockEngine engine = new MockEngine();
		engine.provision("scorpio4/flo/jdbc.n3", getClass().getClassLoader());


		Scorpio4ActiveVocabularies activeVocabularies = new Scorpio4ActiveVocabularies(engine);
		activeVocabularies.startAndWait();

		activeVocabularies.stop();
		engine.stop();
	}

	void testBeanRegistry() {
		MockEngine engine = new MockEngine();
		engine.provision("scorpio4/flo/jdbc.n3");

		Scorpio4ActiveVocabularies activeVocabularies = new Scorpio4ActiveVocabularies(engine);
		activeVocabularies.start();

		String jdbcBeanURN = "urn:scorpio4tests:hsqldb"
		def bean2 = engine.getRegistry().getBean(jdbcBeanURN);
		assert bean2!=null;
		assert bean2 instanceof DataSource

		String jdbcBeanURI = "bean:org.hsqldb.jdbc.JDBCDataSource"
		def bean1 = engine.getRegistry().getBean(jdbcBeanURI);
		assert bean1!=null;
		assert bean1 instanceof DataSource

		activeVocabularies.stop();
		engine.stop();
	}
}
