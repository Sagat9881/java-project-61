package hexlet.code.utils;

public class ChainNode<VALUE_TYPE > {
    final VALUE_TYPE value;
    ChainNode<VALUE_TYPE> next;

    public static  <VALUE_TYPE > ChainNode<VALUE_TYPE> of(VALUE_TYPE value) {
        return new ChainNode<>(value,null);
    }

    public ChainNode(VALUE_TYPE value, ChainNode<VALUE_TYPE> next) {
        this.value = value;
        this.next = next;
    }

    public VALUE_TYPE value() {
        return value;
    }

    public ChainNode<VALUE_TYPE> next() {
        return next;
    }

    public ChainNode<VALUE_TYPE> next(ChainNode<VALUE_TYPE> next) {
        return this.next = next;
    }
}