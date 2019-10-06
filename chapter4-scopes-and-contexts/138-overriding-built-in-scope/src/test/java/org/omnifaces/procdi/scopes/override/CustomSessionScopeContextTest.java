package org.omnifaces.procdi.scopes.override;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomSessionScopeContextTest {

	private SeContainer seContainer;
	private CustomSessionScopeContextExtension extension;

	@BeforeEach
	public void init() {
		extension = new CustomSessionScopeContextExtension();
		seContainer = SeContainerInitializer.newInstance()
		                                    .addExtensions(extension)
		                                    .addBeanClasses(SessionScopedTestBean.class)
		                                    .initialize();
	}

	@Test
	public void test() {
		extension.getContext().start("foo");
		seContainer.select(SessionScopedTestBean.class).get().logHelloSessionScope();
		extension.getContext().suspend();
	}

	@AfterEach
	public void destroy() {
		seContainer.close();
	}
}