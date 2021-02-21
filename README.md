Running `mvn test` ends up with:

```
2-21 16:34:21.503 ERROR 3510 --- [           main] o.a.c.impl.engine.AbstractCamelContext   : Error starting CamelContext (MyCamel) due to exception thrown: Failed to start route route6 because of Multiple consumers for the same endpoint is not allowed: servlet:/v1/pets?httpMethodRestrict=GET

org.apache.camel.FailedToStartRouteException: Failed to start route route6 because of Multiple consumers for the same endpoint is not allowed: servlet:/v1/pets?httpMethodRestrict=GET
	at org.apache.camel.impl.engine.InternalRouteStartupManager.doStartOrResumeRouteConsumers(InternalRouteStartupManager.java:357) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.impl.engine.InternalRouteStartupManager.doStartRouteConsumers(InternalRouteStartupManager.java:319) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.impl.engine.InternalRouteStartupManager.safelyStartRouteServices(InternalRouteStartupManager.java:213) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.impl.engine.InternalRouteStartupManager.doStartOrResumeRoutes(InternalRouteStartupManager.java:147) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.impl.engine.AbstractCamelContext.doStartCamel(AbstractCamelContext.java:3150) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.impl.engine.AbstractCamelContext.doStartContext(AbstractCamelContext.java:2846) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.impl.engine.AbstractCamelContext.doStart(AbstractCamelContext.java:2797) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.spring.boot.SpringBootCamelContext.doStart(SpringBootCamelContext.java:43) ~[camel-spring-boot-3.8.0.jar:3.8.0]
	at org.apache.camel.support.service.BaseService.start(BaseService.java:115) ~[camel-api-3.8.0.jar:3.8.0]
	at org.apache.camel.impl.engine.AbstractCamelContext.start(AbstractCamelContext.java:2492) ~[camel-base-engine-3.8.0.jar:3.8.0]
	at org.apache.camel.spring.SpringCamelContext.start(SpringCamelContext.java:130) ~[camel-spring-3.8.0.jar:3.8.0]
	at org.apache.camel.spring.SpringCamelContext.onApplicationEvent(SpringCamelContext.java:167) ~[camel-spring-3.8.0.jar:3.8.0]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:176) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:169) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:143) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:426) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.context.support.AbstractApplicationContext.publishEvent(AbstractApplicationContext.java:383) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.context.support.AbstractApplicationContext.finishRefresh(AbstractApplicationContext.java:943) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:591) ~[spring-context-5.3.3.jar:5.3.3]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:144) ~[spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:767) ~[spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:759) ~[spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:426) ~[spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:326) ~[spring-boot-2.4.2.jar:2.4.2]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:123) ~[spring-boot-test-2.4.2.jar:2.4.2]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99) ~[spring-test-5.3.3.jar:5.3.3]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124) ~[spring-test-5.3.3.jar:5.3.3]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124) ~[spring-test-5.3.3.jar:5.3.3]
	at org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener.outputConditionEvaluationReport(SpringBootDependencyInjectionTestExecutionListener.java:53) ~[spring-boot-test-autoconfigure-2.4.2.jar:2.4.2]
	at org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener.prepareTestInstance(SpringBootDependencyInjectionTestExecutionListener.java:46) ~[spring-boot-test-autoconfigure-2.4.2.jar:2.4.2]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:244) ~[spring-test-5.3.3.jar:5.3.3]
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:138) ~[spring-test-5.3.3.jar:5.3.3]

```

Change the used Camel version inside `pom.xml` to be `3.7.2` to fix the failed test.
