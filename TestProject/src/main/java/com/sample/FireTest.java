package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

public class FireTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KieServices kieServices = KieServices.Factory.get();
		KieContainer kContainer = kieServices.getKieClasspathContainer();
		KieSession ksession = kContainer.newKieSession("ksession-userguide");
		
		String[] names = new String[] {"kitchen", "bedroom", "office", "livingroom"};
		Map<String, Room> name2room = new HashMap<String, Room>();
		for( String name : names) {
			Room room = new Room(name);
			name2room.put(name, room);
			ksession.insert(room);
			Sprinkler sprinkler = new Sprinkler(room);
			ksession.insert(sprinkler);
		}
		
		ksession.fireAllRules();
		
		Fire kitchenFire = new Fire(name2room.get("kitchen"));
		Fire officeFire = new Fire(name2room.get("office"));
		
		FactHandle kitchenFireHandle = ksession.insert(kitchenFire);
		FactHandle officeFireHandle = ksession.insert(officeFire);
		
		ksession.fireAllRules();
		
		ksession.delete(kitchenFireHandle);
		ksession.delete(officeFireHandle);
		
		ksession.fireAllRules();
	}

}
