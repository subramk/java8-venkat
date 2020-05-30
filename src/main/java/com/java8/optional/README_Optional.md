

#Rules for Optional 
Stuart Marks - https://www.youtube.com/watch?v=fBYhtvY19xA

1. Never ever use null for a Optional variable or return value 
2. Never use optional.get() unless you can prove that the Optional is present 
3. Prefer alternatives to Optional.isPresent() and Optional.get() 
4. It s not preferred to create an Optional for the purpose of chanining methods from it to get a value
5. If an Optional chain has a nested Optional chain or has an intermediate result of Optional<Optional<T>>, it's probably too complex.
6. Avoid using Optional in fields, method parameters and Collections
7. Avoid using identity-sensitive operations on Optionals. 
