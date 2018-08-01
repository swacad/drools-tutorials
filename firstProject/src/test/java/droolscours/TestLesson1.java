package droolscours;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.BeforeClass;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import util.KnowledgeSessionHelper;
import util.OutputDisplay;

@SuppressWarnings("restriction")
public class TestLesson1 {
	
	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;
	static KieContainer kieContainer;
	
	@BeforeClass
	public static void beforeClass() {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
	}

	@Test
	public void testFirstOne() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", outputDisplay);
		Account a = new Account();
		sessionStatefull.insert(a);
		sessionStatefull.fireAllRules();
	}

}
