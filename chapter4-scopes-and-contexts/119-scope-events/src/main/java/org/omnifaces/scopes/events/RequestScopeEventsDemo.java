package org.omnifaces.scopes.events;

import javax.enterprise.context.control.RequestContextController;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class RequestScopeEventsDemo {

	public static void main(String[] args) {
		try (SeContainer container = createContainer()) {
			var requestContextController = container.select(RequestContextController.class).get();

			requestContextController.activate();

			requestContextController.deactivate();
		}
	}

	private static SeContainer createContainer() {
		return SeContainerInitializer.newInstance().disableDiscovery().addBeanClasses(RequestScopeEvents.class).initialize();
	}
}
