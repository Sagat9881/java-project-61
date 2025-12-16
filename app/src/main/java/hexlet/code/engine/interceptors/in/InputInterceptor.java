package hexlet.code.engine.interceptors.in;

public interface InputInterceptor {
    String doIntercept(String input);
    boolean isAcceptable(String input);

    default String intercept(String input){
        if(isAcceptable(input)){
            return doIntercept(input);
        }
        return input;
    }

}
