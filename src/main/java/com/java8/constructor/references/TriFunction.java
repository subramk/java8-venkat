package com.java8.constructor.references;

import java8.in.action.Apple;

@FunctionalInterface
public interface  TriFunction<T,U,V,R>  {
	
	public R  apply(T arg1,U arg2, V arg3 , R result);

	
}
