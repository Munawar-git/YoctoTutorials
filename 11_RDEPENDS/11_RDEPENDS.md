# Yocto

## 11 RDEPENDS

### What are you going to learn?

In this video we are going to learn how to use RDEPENDS

### What Topics we are going to cover?

* What is RDEPENDS?
* Why to use RDEPENDS?
* How to use RDEPENDS?
* Where to use RDEPENDS?

### Description

In Yocto Project, `RDEPENDS` is a variable used to specify runtime dependencies for a particular package or recipe. It is used to define the other packages or components that must be present on the target system for the package to function correctly during runtime.

The `RDEPENDS` variable is typically defined within the recipe file (.bb or .bbappend) of the package. It contains a space-separated list of package names that the current package depends on for proper runtime execution.

Here's an example to illustrate the usage of `RDEPENDS`:

Let's say you have a recipe for a package called "myapp" which is an application that requires the "openssl" library to run. In the recipe file for "myapp" (e.g., `myapp.bb`), you can specify the runtime dependency using the `RDEPENDS` variable like this:

```shell
RDEPENDS_${PN} = "openssl"
```

In the example above, `${PN}` refers to the package name itself, which in this case is "myapp". So, we are saying that "myapp" has a runtime dependency on "openssl".

You can specify multiple dependencies by separating them with spaces:

```shell
RDEPENDS_${PN} = "libfoo libbar openssl"
```

In this case, "myapp" has runtime dependencies on "libfoo", "libbar", and "openssl".

The `RDEPENDS` variable helps the package manager in the Yocto Project to automatically include the specified runtime dependencies when generating the root filesystem or image for the target system. This ensures that all the required components are present on the target device for the package to function correctly during runtime.

## Reference Link

https://docs.yoctoproject.org/ref-manual/tasks.html

https://docs.yoctoproject.org/bitbake/2.2/bitbake-user-manual/bitbake-user-manual-metadata.html

