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
