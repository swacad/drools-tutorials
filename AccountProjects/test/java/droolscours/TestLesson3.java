package droolscours;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import droolscours.service.CustomerService;
import util.DateHelper;
import util.KnowledgeSessionHelper;
import util.OutputDisplay;

public class TestLesson3 {
    static KieContainer kieContainer;
    StatelessKieSession sessionStateless = null;
    KieSession  sessionStatefull = null;

    @BeforeClass
    public static void beforeClass(){
        kieContainer=KnowledgeSessionHelper.createRuleBase();
    }
    @Before
    public void setUp() throws Exception{
        System.out.println("------------Before------------");
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("------------After------------");
    }

    /*
    @Test
    public void testInConstraint() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console

        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        CashFlow cashFlow = new CashFlow();
        cashFlow.setType(CashFlow.CREDIT);
        sessionStatefull.insert(cashFlow);
        sessionStatefull.fireAllRules();
    }
    
    @Test
    public void testNestedAccessor() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console

        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        Customer customer = new Customer();
        customer.setName("Héron");
        customer.setSurname("Nicolas");
        PrivateAccount pAccount = new PrivateAccount();
        pAccount.setOwner(customer);
        sessionStatefull.insert(pAccount);
        sessionStatefull.fireAllRules();
    }
    
    @Test
    public void testInOrFact() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console

        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        Customer customer = new Customer();

        customer.setCountry("GB");
        sessionStatefull.insert(customer);
        PrivateAccount pAccount = new PrivateAccount();
        pAccount.setOwner(customer);
        sessionStatefull.insert(pAccount);
        sessionStatefull.fireAllRules();
    }
    
    @Test
    public void testNotCondition() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        sessionStatefull.fireAllRules();
    }
    
    @Test
    public void testExistsCondition() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        Account pAccount = new Account();
        sessionStatefull.insert(pAccount);
        Customer c = new Customer();
        sessionStatefull.insert(c);
        sessionStatefull.fireAllRules();
    }
    
    @Test
    public void testForAll() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        
        Account a = new Account();
        a.setAccountNo(1);
        a.setBalance(0);
        sessionStatefull.insert(a);
        
        CashFlow cash1 = new CashFlow();
        cash1.setAccountNo(1);
        sessionStatefull.insert(cash1);
        
        CashFlow cash2 = new CashFlow();
        cash2.setAccountNo(1);
        sessionStatefull.insert(cash2);
        
        Account a2 = new Account();
        a2.setAccountNo(2);
        a2.setBalance(0);
        sessionStatefull.insert(a2);
        
        CashFlow cash3 = new CashFlow();
        cash3.setAccountNo(2);
        sessionStatefull.insert(cash3);
        
        sessionStatefull.fireAllRules();
    }
    
    @Test
    public void testForAll2() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        
        Account a = new Account();
        a.setAccountNo(1);
        a.setBalance(0);
        sessionStatefull.insert(a);
        
        CashFlow cash1 = new CashFlow();
        cash1.setAccountNo(1);
        sessionStatefull.insert(cash1);
        
        CashFlow cash2 = new CashFlow();
        cash2.setAccountNo(1);
        sessionStatefull.insert(cash2);
        
        Account a2 = new Account();
        a2.setAccountNo(2);
        a2.setBalance(0);
        sessionStatefull.insert(a2);
        
        CashFlow cash3 = new CashFlow();
        cash3.setAccountNo(1);
        sessionStatefull.insert(cash3);
        
        sessionStatefull.fireAllRules();
    }
    
    
    @Test
    public void testFromLHS() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console

        sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer,
                "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        sessionStatefull.setGlobal("serviceCustomer", new CustomerService());
        
        Customer c = new Customer("Héron", "Nicolas", "A");
        sessionStatefull.insert(c);
        sessionStatefull.fireAllRules();
    }
    

    @Test
    public void testCollecting() throws Exception {
    	System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console

        sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer,
                "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        
        Account a = new Account();
        a.setAccountNo(1);
        a.setBalance(0);
        sessionStatefull.insert(a);
        
        sessionStatefull.insert(new CashFlow(DateHelper.getDate("2010-01-15"), 1000, CashFlow.CREDIT, 1));
        sessionStatefull.insert(new CashFlow(DateHelper.getDate("2010-02-15"), 500, CashFlow.DEBIT, 1));
        sessionStatefull.insert(new CashFlow(DateHelper.getDate("2010-04-15"), 1000, CashFlow.CREDIT, 1));
        sessionStatefull
                .insert(new AccountingPeriod(DateHelper.getDate("2010-01-01"), DateHelper.getDate("2010-31-31")));
        sessionStatefull.fireAllRules();
    }
    */
    
    @Test
    public void testAccumulate() throws Exception {
        sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson3");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResult", display);
        
        sessionStatefull.insert(new Account(1,0));
        FactHandle fa = sessionStatefull.insert(new CashFlow(DateHelper.getDate("2010-01-15"), 1000, CashFlow.CREDIT, 1));
        sessionStatefull.insert(new CashFlow(DateHelper.getDate("2010-02-15"),500,CashFlow.DEBIT,1));
        sessionStatefull.insert(new CashFlow(DateHelper.getDate("2010-04-15"),1000,CashFlow.CREDIT,1));
        sessionStatefull.insert(new AccountingPeriod(DateHelper.getDate("2010-01-01"),DateHelper.getDate("2010-12-31")));
        sessionStatefull.fireAllRules();
        sessionStatefull.delete(fa);
        sessionStatefull.fireAllRules();
    }

}
