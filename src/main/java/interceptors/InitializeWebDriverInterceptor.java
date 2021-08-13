package interceptors;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import wrappers.WebDriverWrapper;

public class InitializeWebDriverInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        ((WebDriverWrapper)methodInvocation.getThis()).init();
        return methodInvocation.proceed();
    }
}
