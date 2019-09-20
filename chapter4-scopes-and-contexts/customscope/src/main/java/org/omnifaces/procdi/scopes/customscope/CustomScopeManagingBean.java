package org.omnifaces.procdi.scopes.customscope;

import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;

public class CustomScopeManagingBean {

	@Inject
	private BeanManager beanManager;

	// TODO: Migrate this to a unit test.
	public void demo() {
		String scopeId = "FOO";
		CustomScopeContext context = (CustomScopeContext) beanManager.getContext(CustomScope.class);

		context.start(scopeId);
		try {
			// Use scoped beans

			context.suspend();
		} finally {
			context.destroy(scopeId);
		}
	}
}
