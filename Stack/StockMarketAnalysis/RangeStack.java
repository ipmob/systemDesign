package StockMarketAnalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class RangeStack<T extends Comparable<T>> implements Stack<T> {

    private List<T> stack;
    private List<T> maxStack;
    private List<T> minStack;
    private int range;
    private BinaryOperator<T> operator;

    public RangeStack( int range, BinaryOperator<T> operator) {
        stack = new ArrayList<>();
        maxStack = new ArrayList<>();
        minStack = new ArrayList<>();
        this.range = range;
        this.operator = operator;
    }

    @Override
    public void push(T item) {
        stack.add(item);
        if (maxStack.isEmpty() || item.compareTo(maxStack.get(maxStack.size()-1)) >= 0) {
            maxStack.add(item);
        }
        if (minStack.isEmpty() || item.compareTo(minStack.get(minStack.size()-1)) <= 0) {
            minStack.add(item);
        }
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T item = stack.remove(stack.size()-1);
        if (item.equals(maxStack.get(maxStack.size()-1))) {
            maxStack.remove(maxStack.size()-1);
        }
        if (item.equals(minStack.get(minStack.size()-1))) {
            minStack.remove(minStack.size()-1);
        }
        return item;
    }

    @Override
    public T peek() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    public T getMax() {
        if (maxStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return maxStack.get(maxStack.size()-1);
    }

    public T getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return minStack.get(minStack.size()-1);
    }

    public Pair<T,T> get(int start, int end) {
        if (start < 0 || end >= stack.size() || start > end) {
            throw new IllegalArgumentException("Invalid range");
        }
        T max = stack.get(start);
        T min = stack.get(start);
        for (int i = start+1; i <= end; i++) {
            T item = stack.get(i);
            if (item.compareTo(max) > 0) {
                max = item;
            }
            if (item.compareTo(min) < 0) {
                min = item;
            }
        }
        return new Pair<>(min,max);
    }
}

