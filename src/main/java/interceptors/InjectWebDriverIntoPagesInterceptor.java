package interceptors;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import pages.AbstractPage;
import tests.AbstractWebTest;

import java.lang.reflect.Field;

public class InjectWebDriverIntoPagesInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        AbstractWebTest test = (AbstractWebTest) methodInvocation.getThis();
        for(Field field : test.getClass().getFields()){
            if(field.getAnnotation(Page.class) != null){
                field.setAccessible(true);
                AbstractPage page = (AbstractPage) field.get(test);
                page.init(test.getWebDriver());
            }
        }
        return methodInvocation.proceed();
    }
}
