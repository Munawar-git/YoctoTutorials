# Yocto

## 03 bblayers.conf

### What is bblayers.conf?

* bblayers.conf is a configuration file used by the build systems
* In this file the set of layers are defined that should be included in a build.
* The bblayers.conf file specifies the location of each layer on the local file system.

### What is a Layer?

A layer is a collection of related metadata that provides configuration information, such as recipes, configuration files, and other data required to build and customize an image.

Layers name start with meta

**For Example **

* meta
* meta-poky
* meta-yocto-bsp

### What is a Recipe?

* A set of instructions for building packages
* A recipe describes where you get source code
* Which patches to apply
* How to configure the source
* How to compile it and so on

These all steps we will see in detail in later a video.

Recipes also describe dependencies for libraries or for other recipes

Example **"meta/recipes-extended/minicom/minicom_2.8.bb"**



### Bitbake basic layers commands

#### Show layers  in bblayers.conf

```bitbake
bitbake-layers show-layers
```

#### Add layer to bblayers.conf?

```bitbake
bitbake-layers add-layer <path/to/layer>
```

#### Remove layer from bblayers.conf?

```bitbake
bitbake-layers remove-layer <path/to/layer>
```



### Reference Link

https://docs.yoctoproject.org/ref-manual/variables.html#

### End

In the nect video we will learn how to add packages in our image

