Java 1.7

a)
Garbage-First Collector
The G1 collector is a server-style garbage collector, targeted for multi-processor machines with large memories. It meets garbage collection (GC) pause time goals with high probability, while achieving high throughput. Whole-heap operations, such as global marking, are performed concurrently with the application threads. This prevents interruptions proportional to heap or live-data size.

Recommended Use Cases for G1: The first focus of G1 is to provide a solution for users running applications that require large heaps with limited GC latency. This means heap sizes of around 6GB or larger, and stable and predictable pause time below 0.5 seconds.

Applications running today with either the CMS or the ParallelOld garbage collector would benefit switching to G1 if the application has one or more of the following traits.

More than 50% of the Java heap is occupied with live data.
The rate of object allocation rate or promotion varies significantly.
Undesired long garbage collection or compaction pauses (longer than 0.5 to 1 second)


b) - can you open more than one?
The try-with-resources Statement
The try-with-resources statement ensures that each resource is closed at the end of the statement. Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.

static String readFirstLineFromFile(String path) throws IOException {
  try (BufferedReader br = new BufferedReader(new FileReader(path))) {
    return br.readLine();
  }
}


c) - why now?
In the JDK 7 release, you can use a String object in the expression of a switch statement:

public String getTypeOfDayWithSwitchStatement(String dayOfWeekArg) {
     String typeOfDay;
     switch (dayOfWeekArg) {
         case "Monday":
             typeOfDay = "Start of work week";
             break;
         case "Tuesday":
         case "Wednesday":
         case "Thursday":
             typeOfDay = "Midweek";
             break;
         case "Friday":
             typeOfDay = "End of work week";
             break;
         case "Saturday":
         case "Sunday":
             typeOfDay = "Weekend";
             break;
         default:
             throw new IllegalArgumentException("Invalid day of the week: " + dayOfWeekArg);
     }
     return typeOfDay;
}


d)
Handling More Than One Type of Exception
catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}



Java 1.8
a) - regular lambda
We propose extending the Java Language to support compact lambda expressions (otherwise known as closures or anonymous methods.) Additionally, we will extend the language to support a conversion known as "SAM conversion" to allow lambda expressions to be used where a single-abstract-method interface or class is expected, enabling forward compatibility of existing libraries.

We propose extending the semantics of interfaces in the Java Language to support virtual extension methods, whereby an interface can nominate a static default method to stand in for the implementation of an interface method in the event that an implementation class does not provide an implementation of the extension method. This enables interfaces to be augmented with new methods "after the fact" without breaking existing implementation classes.

Time permitting, we will use these features to augment the core Java SE libraries to support a more lambda-friendly style of programming, such as: 
      Collection collection = ... ;
      collection.sortBy(#{ Foo f -> f.getLastName() });
or

      collection.remove(#{ Foo f -> f.isBlue() });
This will likely be accompanied by a set of standardized "SAM" types such as Predicate, Filter, Mapper, Reducer, etc.



b) - forEach / default interface methods
Ex. - Java 7
for (Shape s : shapes) {
  if (s.getColor() == BLUE)
    s.setColor(RED);
}
In Java 8 you could rewrite the same code by using a forEach and a lambda expression as follows:

shapes.forEach(s -> {
   if (s.getColor() == BLUE)
     s.setColor(RED);
});
The lambda form makes use of a new method on the Collection interface called forEach, which takes a lambda expression and evaluates it for all the contained elements. 

The implementation of forEach on the Collection interface is shown in the following code listing:

interface Collection<T> {
  default void forEach(Block<T> action) {
    Objects.requireNonNull(action);
    for (T t : this)
      action.apply(t);
  }
  // Rest of Collection methods…
}
Notice the new default keyword, which indicates that the method will be followed by a default implementation.  Subclasses are free to create their own implementation of the method, but if there is none defined they will get the same standard behavior as defined in the interface. This allows new methods to be added to existing interfaces in the core Java classes, as well as in your own libraries and projects.

The actual lambda syntax is quite simple…  in its full form you supply the types and parameters on the left, put a dash, greater-than sign [->] in the middle, and follow that with a method body in curly braces:

(int a, int b) -> { return a + b; }
In the case where the function returns a value, this can be simplified by removing the curly braces, return keyword, and semicolon:

(a, b) -> a + b
Furthermore, in the case where there is only one parameter you can leave off the parenthesis:

a -> a * a
And finally, if you have no parameters, you can simply leave the parenthesis blank, which is common for replacing Runnable implementations or other no-parameter methods:

() -> { System.out.println("done"); }

As a convenience, they introduced a new FunctionalInterface annotation that optionally be used to mark interfaces in order to get assistance from the complier in checking to make sure your interface meets the single explicitly declared abstract method requirement:

@FunctionalInterface
interface Sum {
  int add(int a, int b);
}


c) - streams
Collections
Classes in the new java.util.stream package provide a Stream API to support functional-style operations on streams of elements. The Stream API is integrated into the Collections API, which enables bulk operations on collections, such as sequential or parallel map-reduce transformations.

