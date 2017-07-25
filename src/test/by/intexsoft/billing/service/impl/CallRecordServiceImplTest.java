package test.by.intexsoft.billing.service.impl;

import static org.testng.Assert.assertEquals;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.intexsoft.billing.model.CallRecord;
import by.intexsoft.billing.service.impl.CallRecordServiceImpl;

/**
 * This test class creates an object, puts it in the CouchBase, then extracts it
 * and compares it with the source
 */
public class CallRecordServiceImplTest {

	ApplicationContext context = new AnnotationConfigApplicationContext("by.intexsoft.billing.config");
	CallRecordServiceImpl service = context.getBean(CallRecordServiceImpl.class);
	CallRecord record = new CallRecord("1", 1, 10000, 30000, 20000, true, 1.0);

	@Test
	public void findOne() {
		CallRecord rezRecord = service.findOne("1");
		assertEquals(rezRecord.callId, record.callId);
		assertEquals(rezRecord.subscriberId, record.subscriberId);
		assertEquals(rezRecord.startTime, record.startTime);
		assertEquals(rezRecord.endTime, record.endTime);
		assertEquals(rezRecord.duration, record.duration);
		assertEquals(rezRecord.type, record.type);
		assertEquals(rezRecord.price, record.price, 0.0);
	}

	@BeforeMethod
	public void write() {
		service.write(record);
	}
}
