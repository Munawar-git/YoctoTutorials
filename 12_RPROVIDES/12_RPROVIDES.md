# Yocto

## 12 RPROVIDES

### What are you going to learn?

In this video we are going to learn how to use RPROVIDES

### What Topics we are going to cover?

* What is RPROVIDES?
* Why to use RPROVIDES?
* How to use RPROVIDES?
* Where to use RPROVIDES?

### Description

A list of package name aliases that a package also provides. These aliases are useful for satisfying runtime dependencies of other packages both during the build and on the target (as specified by RDEPENDS).

As with all package-controlling variables, you must always use the variable in conjunction with a package name override. Here is an example:

```
RPROVIDES:${PN} = "foobar"
```

## Reference Link

https://docs.yoctoproject.org/ref-manual/tasks.html

https://docs.yoctoproject.org/bitbake/2.2/bitbake-user-manual/bitbake-user-manual-metadata.html

