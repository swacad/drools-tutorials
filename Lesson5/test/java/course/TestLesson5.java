package course;

import static org.junit.Assert.*;

import util.KnowledgeSessionHelper;
import util.OutputDisplay;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

public class TestLesson5 {
    static KieContainer kieContainer;
    StatelessKieSession sessionStateless = null;
    KieSession  sessionStateful = null;

    @BeforeClass
    public static void beforeClass(){
        kieContainer = KnowledgeSessionHelper.createRuleBase();
    }
    @Before
    public void setUp() throws Exception{
        System.out.println("------------Before------------");
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("------------After-------------");
    }
	
	@Test
	public void testFirstOne() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		System.out.println("sessionStateful created!");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResult", outputDisplay);
		
		Order a = new Order();
		sessionStateful.insert(a);
		sessionStateful.fireAllRules();
	}

}
