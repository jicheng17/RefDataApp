package com.jaycee.rda;

public interface RuleEngine<T> {
    public T applyRule(T t1, T t2);
}
