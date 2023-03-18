# Yocto

## 05 Create Layers

### What is  a Layer?

Layers are repositories that contain related metadata (i.e. sets of instructions) that tell the OpenEmbedded build system how to build a target. It contains the recipes to build the target package.

It may also contain, target machines configuration, distro configuration.

### What is layer priority?

Establishes a priority to use for recipes in the layer when the OpenEmbedded build finds recipes of the same name in different layers. A higher numeric value represents a higher priority.

#### How to check priotity

Show layers 

```bash 
bitbake-layers show-layers
```

### How to create Layer?

```bash
bitbake-layers create-layer <path/to/meta-layername>
```

#### Add layer to buind system

```
bitbake-layers add-layer  <path/to/meta-layername>
```





### Reference Link

https://docs.yoctoproject.org/dev/overview-manual/yp-intro.html#the-yocto-project-layer-model

https://docs.yoctoproject.org/dev/dev-manual/layers.html#creating-your-own-layer

### End

In the next video we will learn how to create a recipe
