# Yocto

## 08 Hello World Recipe

### What are you going to learn?

In this video we are going to create a yocto recipe from scratch.

### What Topics we are going to cover?

* A **helloworld.c** program
* **SUMMARY** : A brief description of the Recipe
* **LICENSE** : Which Type of License are we going to use E.g MIT, GPL, BSD etc.
* **LIC_FILES_CHKSUM** : License file location and its **md5** checksum.
* Calculate checksum using **md5sum** utility
* **SRC_URI** : Source Files
* **do_compile**: Here the compilation takes place.
* **do_install** : Here we tells the recipe where to put the binary file in final image.
*  

### How to Generate md5 Checksum

```bash
md5sum FILENAME
```

### Reference Link

https://docs.yoctoproject.org/bitbake/2.2/bitbake-user-manual/bitbake-user-manual-metadata.html

### End

In the next video we will learn about bitbake steps.
