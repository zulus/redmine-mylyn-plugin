package net.sf.redmine_mylyn.internal.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import net.sf.redmine_mylyn.api.model.PartialIssue;

public class PartialIssueValidator {

	public final static String RESOURCE_FILE = "/xmldata/issues/issues.xml";

	
	public final static int COUNT = 6;
	
	public static void validate1(PartialIssue obj) throws Exception {
		assertNotNull(obj);
		assertEquals(1, obj.getId());
		assertEquals("Can't print recipes", obj.getSubject());
		assertEquals(1, obj.getStatusId());
		assertEquals(4, obj.getPriorityId());
	}

}

