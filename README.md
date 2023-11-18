# javaclassloaderdemo


## demo 目的
验证不同classloader `对象`（object级别， 而不是class 级别）,获取的class是不一样的


[相关阅读](https://docs.oracle.com/javase/specs/jls/se8/jls8.pdf)
```
4.3.4 When Reference Types Are the Same
Two reference types are the same compile-time type if they have the same binary
name (§13.1) and their type arguments, if any, are the same, applying this definition
recursively.
When two reference types are the same, they are sometimes said to be the same
class or the same interface.
At run time, several reference types with the same binary name may be loaded
simultaneously by different class loaders. These types may or may not represent
the same type declaration. Even if two such types do represent the same type
declaration, they are considered distinct.
Two reference types are the same run-time type if:
• They are both class or both interface types, are defined by the same class loader,
and have the same binary name (§13.1), in which case they are sometimes said
to be the same run-time class or the same run-time interface.
• They are both array types, and their component types are the same run-time type
(§10 (Arrays)).
```