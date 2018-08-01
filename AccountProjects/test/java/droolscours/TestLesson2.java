package droolscours;

import util.OutputDisplay;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import org.junit.Assert;
import util.DateHelper;
import util.KnowledgeSessionHelper;


@SuppressWarnings("restriction")
public class TestLesson2 {
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

    @Test
    public void testTwoFacts() {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
         sessionStatefull = KnowledgeSessionHelper
                    .getStatefulKnowledgeSessionWithCallback(kieContainer,"ksession-lesson2");
            OutputDisplay display = new OutputDisplay();
            sessionStatefull.setGlobal("showResults", display);
            Account a = new Account();
            a.setAccountNo(1);
            a.setBalance(0);
            sessionStatefull.insert(a);
            CashFlow cash1 = new CashFlow();
            cash1.setAccountNo(1);
            cash1.setAmount(1000);
            cash1.setType(CashFlow.CREDIT);
            sessionStatefull.insert(cash1);
            sessionStatefull.fireAllRules();            
            Assert.assertEquals(a.getBalance(), 1000,0);

    }
    
    @Test
    public void testTwofactsTwocashFlowMovement() throws Exception {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console
        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer,"ksession-lesson2");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResults", display);
        Account a = new Account();
        a.setAccountNo(1);
        a.setBalance(0);
        sessionStatefull.insert(a);
        CashFlow cash1 = new CashFlow();
        cash1.setAccountNo(1);
        cash1.setAmount(1000);
        cash1.setMvtDate(DateHelper.getDate("2010-01-15"));
        cash1.setType(CashFlow.CREDIT);
        sessionStatefull.insert(cash1);
        CashFlow cash2 = new CashFlow();
        cash2.setAccountNo(2);
        cash2.setAmount(1000);
        cash2.setMvtDate(DateHelper.getDate("2010-01-15"));
        cash2.setType(CashFlow.CREDIT);
        sessionStatefull.insert(cash2);
        sessionStatefull.fireAllRules();
        Assert.assertEquals(a.getBalance(), 1000,0);
    }
    
    @Test
    public void testcalculateBalance() throws Exception {
		System.out.println(new Exception().getStackTrace()[0].getMethodName());  // print current method name to console

        sessionStatefull = KnowledgeSessionHelper
                .getStatefulKnowledgeSessionWithCallback(kieContainer, "ksession-lesson2");
        OutputDisplay display = new OutputDisplay();
        sessionStatefull.setGlobal("showResults", display);
        Account a = new Account();
        a.setAccountNo(1);
        a.setBalance(0);
        sessionStatefull.insert(a);
        CashFlow cash1 = new CashFlow();
        cash1.setAccountNo(1);
        cash1.setAmount(1000);
        cash1.setMvtDate(DateHelper.getDate("2016-01-15"));
        cash1.setType(CashFlow.CREDIT);
        sessionStatefull.insert(cash1);
        CashFlow cash2 = new CashFlow();
        cash2.setAccountNo(1);
        cash2.setAmount(500);
        cash2.setMvtDate(DateHelper.getDate("2016-02-15"));
        cash2.setType(CashFlow.DEBIT);
        sessionStatefull.insert(cash2);
        CashFlow cash3 = new CashFlow();
        cash3.setAccountNo(1);
        cash3.setAmount(1000);
        cash3.setMvtDate(DateHelper.getDate("2016-04-15"));
        cash3.setType(CashFlow.CREDIT);
        sessionStatefull.insert(cash3);
        AccountingPeriod period = new AccountingPeriod();
        period.setStartDate(DateHelper.getDate("2016-01-01"));
        period.setEndDate(DateHelper.getDate("2016-03-31"));
        sessionStatefull.insert(period);
        sessionStatefull.fireAllRules();
        Assert.assertTrue(a.getBalance()==500);
    }
}





