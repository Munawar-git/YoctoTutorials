# Yocto

## 08 Build Tasks

### What are you going to learn?

In this video we are going to learn about the common build tasks in Yocto.

### What Topics we are going to cover?

* What are build tasks?
* How to list the build tasks of a recipe?
* What are common build tasks in Yocto?
* Brief description of common build tasks.



### What are build tasks?

Tasks can be considered as units of execution to perform a specific function, or
a set of related functions that can be combined together.

### How to list the build tasks of a recipe?

```bash
bitbake -c listtasks <recipe-name>
```

### What are common build tasks in Yocto?

* **Fetch** (do_fetch) :   Fetches the source code
* **Unpack** (do_upack) : Unpacks the source code into a working directory
* **Patch** (do_patch) : Locates patch files and applies them to the source code
* **Configure** (do_configure) : Configures the source by enabling and disabling any build-time and configuration options for the software being built.
* **Compile** (do_compile) : Compiles the source in the compilation directory
* **Install** (do_install) : Copies files from the compilation directory to a holding area

### Reference Link

https://docs.yoctoproject.org/bitbake/2.2/bitbake-user-manual/bitbake-user-manual-metadata.html

### End

In the next video we will learn about bitbake steps.
