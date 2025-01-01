# Generic Variances & Type projections

## Why do we need them?

if you put Any type into List<String> by upcasting,
it doesn't guarantee runtime safety while accessing the element.

```java
// The following would not compile with the naive declaration of addAll:
// Collection<String> is not a subtype of Collection<Object>
void copyAll(Collection<Object> to, Collection<String> from) {
    to.addAll(from);
}
```

## How java handles this issue

In the following example Variance is used to limit the upper bound of your API

```java
interface Collection<E> {
    void addAll(Collection<? extends E> items);
}
```

ex. Collection<String> is a subtype of Collection<? extends Object>

> it makes calling addAll(items) that reading items is possible and could further add it to the member,
> accessing items.add() or set() won't work as you don't know what type compliance should follow

Conversely, if you can only put items into the collection, it's okay to take a collection of Objects and put Strings
into it: in Java there is `List<? super String>`, which accepts Strings or any of its supertypes.

__Effective Java, 3rd edition__ proposes the following mnemonic: PECS stands for Producer-Extends, Consumer-Super.

> If you use a producer-object, say, `List<? extends Foo>`, you are not allowed to call `add()` or `set()` on this
> object, but this *does not mean that it is immutable*: for example, nothing prevents you from calling `clear()` to
> remove all the items from the list, since `clear()` does not take any parameters at all.
> The only thing guaranteed by wildcards (or other types of variance) is type safety. Immutability is a completely
> different story.

## Kotlin Declaration-site variance

In Kotlin, by denoting `in` or `out` to the Generic type compiler can understand that the type is safe to use as
Producer/Consumer.
this feature has been already successful in C# world

## Start-projection

Sometimes you want to say that you know nothing about the type argument, but you still want to use it in a safe way. The
safe way here is to define such a projection of the generic type, that every concrete instantiation of that generic type
will be a subtype of that projection.

Kotlin provides so-called star-projection syntax for this:

- For Foo<out T : TUpper>, where T is a covariant type parameter with the upper bound TUpper, Foo<\*> is equivalent to
  Foo<out TUpper>. This means that when the T is unknown you can safely read values of TUpper from Foo<\*>.

- For Foo<in T>, where T is a contravariant type parameter, Foo<\*> is equivalent to Foo<in Nothing>. This means there
  is nothing you can write to Foo<\*> in a safe way when T is unknown.

- For Foo<T : TUpper>, where T is an invariant type parameter with the upper bound TUpper, Foo<\*> is equivalent to
  Foo<out TUpper> for reading values and to Foo<in Nothing> for writing values.

If a generic type has several type parameters, each of them can be projected independently. For example, if the type is
declared as interface Function<in T, out U> you could use the following star-projections:

- Function<\*, String> means Function<in Nothing, String>.

- Function<Int, \*> means Function<Int, out Any?>.

- Function<\*, \*> means Function<in Nothing, out Any?>.

> Star-projections are very much like Java's raw types, but safe.