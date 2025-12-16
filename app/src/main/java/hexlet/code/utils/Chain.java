package hexlet.code.utils;

public class Chain<VALUE_TYPE > {
    private final ChainNode<VALUE_TYPE> root;

    public ChainNode<VALUE_TYPE> root() {
        return root;
    }
    public Chain(ChainNode<VALUE_TYPE> root) {
        this.root = root;
    }

    public static  <VALUE_TYPE> Chain<VALUE_TYPE> of(VALUE_TYPE... values) {
        ChainNode<VALUE_TYPE> root = ChainNode.of(values[0]);
        ChainNode<VALUE_TYPE> current = root;
        for(int i =1; i < values.length; i++){
            current = current.next(ChainNode.of(values[i]));
        }
        return new Chain<>(root);
    }

}
