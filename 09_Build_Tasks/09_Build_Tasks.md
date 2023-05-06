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

------------------

## Fetch Task

### What are we going to learn?

* What is Fetch task?
* Where to define fetch Repo?
* How to define fetch repo?
* What is SRCREV Variable?
* How to fetch source from remote repo?
* Where sources are downloaded?

### What is Fetch task?

Fetch task fetches the package source from the local or remote repository.

### Where to give fetch Repo?

The fetch Repo address has to be stored in  **SRC_URI** variable.

### What is SRCREV Variable?

 In **SRCREV** Variable the commit hash of github repo is defined.

### How to fetch Source?

The source repo is stored in SRC_URI variable. Normaly the build process fetches the source automatically.

There is no explicit need to execute the fetch task.

But in this tutorial, we will be fetching it explicitly so we can analyse how it works.

```bash
bitbake -c do_fetch recipie-name
```

---------------

## Unpack Task

### What are we going to learn?

* What is unpack task?
* How to unpack source?
* Where does it unpack?

### What is Unpack task?

Unpack task unpacks the package that has been downloaded with Fetch task.

### How to unpack Source?

Normaly the build process unpacks the source automatically.

There is no explicit need to execute the unpack task.

But in this tutorial, we will be unpacking  explicitly so we can analyse how it works.

```bash
bitbake -c do_unpack recipie-name
```

### Where does it unpack?

The unpack task unpacks the sources in to WORKDIR folder.

---------------------

## Patch Task

### What are we going to learn?

* What is Patch task?
* What is Patch file?
* Where to give patch file?
* Where does it run?
* How to patch?

### What is Patch task?

Patch task locates the patch files and applies the patches to the sources if any patch is available.

This is optional task, executes if patch is available.

### What is Patch file?

A patch files provides some explicit changes for a specific file. That can be applied to that file.

### Where to give Patch file?

Patch file is also defined in **SRC_URI** variable.

### Where does it run?

By default it runs in current source directory **${S}**.

### How to patch?

The patchees are stored in SRC_URI variable. Normaly the build process apply patches automatically to the desired file.

There is no explicit need to execute the patch task.

But in this tutorial, we will be patching  explicitly so we can analyse how it works.

```bash
bitbake -c do_patch recipie-name
```

## Configure Task

### What are we going to learn?

* What is Configure task?
* How to define configuration?
* Where does it runs?
* How to apply configuration?

### What is Configure task?

The Configuration task configures the source by enabling and disabling any build-time and configuration options for the software being built before compilation if any configuration is available.

This is a optional steps, executes if configuration is available.

### How to define Configuration?

If there are any configuration steps, then these steps are define in do_configure() funtion of bitbake.

```bitbake
do_configure()
{
configutaion 
steps are 
written 
here
}
```

### Where does it runs?

It runs in current source directory **${S}**.

### How to apply Configuration?

Normaly the build applies the defined configuration automatically.

There is no explicit need to execute the configuration task.

But in this tutorial, we will be doing configuration  explicitly so we can analyse how it works.

```bash
bitbake -c do_configure recipie-name
```

----------------

## Compile Task

### What are we going to learn?

* What is Compile task?
* How to define Compilation steps?
* Where does it runs?
* How to execute compilation?

### What is Compilation task?

The Compilation task compiles the source code if any compilation steps are available and generates a binary file.

This is a optional steps, executes if comilation is available.

### How to define Compilation steps?

If there are any compilation steps, then these steps are define in do_compile() funtion of bitbake.

```bitbake
do_compile()
{
compilation 
steps are 
written 
here
}
```

### Where does it runs?

It runs in current source directory **${S}**.

### How to execute Compilation ?

Normaly the build executes the compile step automatically.

There is no explicit need to execute the compilation task.

But in this tutorial, we will be compiling the sources explicitly so we can analyse how it works.

```bash
bitbake -c do_compile recipie-name
```

----------------

## Install Task

### What are we going to learn?

* What is Install task?
* How to define Installtion steps?
* Where does it runs?
* How to do Installation?

### What is Install task?

The Install task copies files that are to be packaged into the holding area **${D}**. This task runs with the current working directory **${S}** which is the compilation directory.

### How to define Installation steps?

If there are any installation steps, then these steps are define in do_install() funtion of bitbake.

```bitbake
do_install()
{
compilation 
steps are 
written 
here
}
```

### Where does it runs?

It runs in current source directory **${S}**.

### How to do Installation ?

Normaly the build executes the Install task automatically.

There is no explicit need to execute the Install task.

But in this tutorial, we will be doing install explicitly so we can analyse how it works.

```bash
bitbake -c do_install recipie-name
```

## Reference Link

https://docs.yoctoproject.org/ref-manual/tasks.html

https://docs.yoctoproject.org/bitbake/2.2/bitbake-user-manual/bitbake-user-manual-metadata.html

