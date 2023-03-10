# Yocto

## 04 Add Packages

### How to Add Package?

Add the following line in **local.conf** file.

**IMAGE_INSTALL:append = " package_name"**

E.g:

**IMAGE_INSTALL:append = " python3"**

**IMAGE_INSTALL:append = " git"**

### How to Find Packages?

```bash
bitbake-layers show-recipes 
bitbake-layers show-recipes python3
bitbake-layers show-recipes git
```

### Reference Link

https://docs.yoctoproject.org/ref-manual/variables.html#

### End

In the next video we will learn how to create a recipe
