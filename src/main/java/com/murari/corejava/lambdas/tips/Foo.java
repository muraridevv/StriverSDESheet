package com.murari.corejava.lambdas.tips;

@FunctionalInterface
public interface Foo {

  String method();

  default void defaultMethod() {}
}
