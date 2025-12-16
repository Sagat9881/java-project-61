package hexlet.code.engine.interceptors.in;

import hexlet.code.utils.Chain;
import hexlet.code.utils.ChainNode;

public class InterceptorChain {
    private final Chain<InputInterceptor> delegateChain;

    public InterceptorChain(Chain<InputInterceptor> delegateChain) {
        this.delegateChain = delegateChain;
    }

    public static InterceptorChain ofDelegateChain(Chain<InputInterceptor> delegateChain) {
        return new InterceptorChain(delegateChain);
    }

    public String process(String input) {
        ChainNode<InputInterceptor> current = delegateChain.root();
        String value = input;

        while (current != null) {
            value = current.value().intercept(value);
            current = current.next();
        }
        return value;
    }
}
