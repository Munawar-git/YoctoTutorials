# Yocto

## 05 Basic Variables

### What are you going to learn?

In this video we are going to learn about some basic default variables used in the Yocto build system.

### Basic Variables

* **PN** (Package Name)
* **PV** (Package Version)
* **PR** (Package Revision)
* **WORKDIR** (Working Directory)
* **S** (Source)
* **D** (Destination)
* **B** (Build Directory)

### Recipe Name Pattern

**PN_PV_PR.bb**

Example:

**example2_0.2_r0**

### How to Read Variable Value 

```bash
bitbake -e <RECIPE_NAME> | grep ^<VARIABLE_NAME>=
```

### Package Name (PN)

**PN** refers to a recipe name used by the Yocto build system as input to create a package. The name is  extracted from the recipe file name.

### Package Version (PV)

**PV** is the version of the recipe. The version is normally extracted from the recipe filename.

### Package Revision (PR)

The revision of the recipe. The default value for this variable is “r0”

### Working Directory (WORKDIR)

The **WORKDIR** is the pathname of the work directory in which the Yocto build system builds a recipe. This directory is located within the TMPDIR directory structure and is specific to the recipe being built and the system for which it is being built.

### Source (S)

**S** is the location in the Build Directory where unpacked recipe source code resides. By default, this directory is **WORKDIR/BPN-PV**, where **BPN** is the base recipe name and **PV** is the recipe version.

### Destination (D)

**D** is the destination directory. It is the  location in the Build Directory where components are installed by the do_install task. This location defaults to **WORKDIR/image**.

### Build Directory (B)

It is same as **S**.

### Reference Link

https://docs.yoctoproject.org/dev/overview-manual/yp-intro.html#the-yocto-project-layer-model

### End

In the next video we will learn about the types of variable assignments.
