package course;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test
	public void testStep() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResult", outputDisplay);
		
		Step step = new Step(1, "Shanghai", "Rotterdam", 22000, "boat");
		sessionStateful.insert(step);
		sessionStateful.fireAllRules();
	}
	
	@Test
	public void testTrip() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
		sessionStateful = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-rules");
		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStateful.setGlobal("showResult", outputDisplay);
		
		Step s1 = new Step(1, "Shanghai", "Rotterdam", 22000, "boat");
		Step s2 = new Step(2, "Rotterdam", "Tournai", 300, "train");
		Step s3 = new Step(3, "Tournai", "Lille", 20, "truck");
		
		Trip trip = new Trip();
		ArrayList<Step> steps = new ArrayList<Step>();
		steps.add(s1);
		steps.add(s2);
		steps.add(s3);
		trip.setSteps(steps);
		
		sessionStateful.insert(trip);
		sessionStateful.fireAllRules();
	}

}
