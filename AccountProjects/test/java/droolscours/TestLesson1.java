package droolscours;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import util.KnowledgeSessionHelper;
import util.OutputDisplay;

@SuppressWarnings("restriction")
public class TestLesson1 {
	
	StatelessKieSession sessionStateless = null;
	KieSession sessionStateful = null;
	static KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}
	
	@Before  // Run before every test case
	public void setUp() {
		System.out.println("------------------Before------------------");
	}
	
	@After  // Run after every test case
	public void tearDown() {
		System.out.println("------------------After-------------------");
	}
	
	@Test
	public void testFirstOne() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		sessionStateful.insert(a);
		sessionStateful.fireAllRules();
	}

	@Test
	public void testRuleOneFactWithFactAndUsageOfGlobalAndCallback() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		sessionStateful = KnowledgeSessionHelper
				.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		sessionStateful.addEventListener(new RuleRuntimeEventListener() {
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted \n"
						+ event.getObject().toString());
			}
			
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object was updated \n"
						+ "new content \n" + event.getObject().toString());
			}
			
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object retracted \n"
						+ event.getOldObject().toString());
			}
		});
		Account a = new Account();
		a.setAccountNo(10);
		FactHandle handlea = sessionStateful.insert(a);  // Memorize the fact handle
		a.setBalance(12.0);  // Set the balance
		sessionStateful.update(handlea, a);  // Update fact handle
		sessionStateful.delete(handlea);  // delete (retract) fact handle
		sessionStateful.fireAllRules();
		System.out.println("So you saw something ;)");
	}
	
	@Test
	public void testFirstOneTwoFireAllRules() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		sessionStateful.insert(a);
		System.out.println("First fire all rules");
		sessionStateful.fireAllRules();
		System.out.println("Second fire all rules");
		sessionStateful.fireAllRules();
	}
	
	@Test
	public void testFirstOneTwoFireAllRulesAndSetter() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		sessionStateful.insert(a);
		System.out.println("First fire all rules");
		sessionStateful.fireAllRules();
		a.setAccountNo(1);
		System.out.println("Second fire all rules");
		sessionStateful.fireAllRules();
	}
	
	@Test
	public void testFirstOneTwoFireAllRulesWithUpdateInBetween() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		FactHandle handle = sessionStateful.insert(a);
		sessionStateful.insert(a);
		System.out.println("First fire all rules");
		sessionStateful.fireAllRules();
		sessionStateful.update(handle, a);
		System.out.println("Second fire all rules");
		sessionStateful.fireAllRules();
	}
	
	@Test
	public void testRuleOneFactWithFactThatInsertObject() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		
		sessionStateful = KnowledgeSessionHelper
				.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		
		OutputDisplay display = new OutputDisplay();
		sessionStateful.setGlobal("showResults", display);
		
		sessionStateful.addEventListener(new RuleRuntimeEventListener() {
			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object inserted \n"
						+ event.getObject().toString());
			}
			
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object was updated \n"
						+ "new content \n" + event.getObject().toString());
			}
			
			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object retracted \n"
						+ event.getOldObject().toString());
			}
		});
		CashFlow a = new CashFlow();
		FactHandle handlea = sessionStateful.insert(a);
		sessionStateful.fireAllRules();
	}
}









