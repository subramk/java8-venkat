Java Certification Notes and Examples on github - to include 

  - Generics - usage of ? , ? extends , ? super T etc ) - Bounded Wildcard etc.
  - NIO , Files.walk etc - useful methods 
  - Queue/deque methods like add(), offer(),remove(), push(), poll(), peek(), pop()
  - Executor Service ... other new areas not seen elsewhere so far)., callable/Runnable etc
  - INHERITANCE Rules for default methods 
  - private methods in Interfaces - Java9 , 
  - Atomic Classes - thread safe access to variables so that we can prevent a race condition - 
  - newCachedThreadPool() / newFixedThreadPool(int threads) /newScheduledThreadPool(int threads)
  -	On the Stream class  like  - stream.parallel();
  -	On Collections class like  - collection.parallelStream(); 
  - ForkJoin Framework 
 		1) Create the ForkJoinTask 
		2) Create the ForkJoinPool 
		3) Invoke the Task,using the forkJoinPool.invoke(Task task) method (OR) forkJoinPool.invoke(Collection<? extends Task> tasks) 
  
  - ReentrantReadWriteLock
  - New try with resources example with multiple exception caught in one line ( simple example)
  -  
