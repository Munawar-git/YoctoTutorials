# Yocto

## 10 Patch

### What are you going to learn?

In this video we are going to learn how to creat a patch in yocto

### What Topics we are going to cover?

* What is a patching?
* How to write a Patch?
* How to save a Patch?
* How to apply a Patch?.

### Steps to create and Apply a Patch

- **bitbake -c devshell \*recipe\***

- **git init**

- **git add \***

- **git commit** (sourcetree recorded by git)

- Edit the file in any editor you like and then save it **eg.(vi \*/path/to/file\*)**

- **git status** (shows that the file is modified)

- **git add \*/path/to/file\***

- **git commit -m \*"a sutaible comment according to the changes you made"\***

- **git log** (shows that changes have be made and commit history)

- **git format-patch HEAD~1** (output sthe patch file created by the last commit)

- **ls** (checks if patch file is there)

- Copy the patch file into **recipe/files** folder

- execute **exit** to exit devshell

- Edit **recipe.bb** OR create **recipe.bbappend** file and add patch file in **SRC_URI** variable

  ```bitbake
   FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
     SRC_URI += " file://patchfile.patch "
  ```

- Build the image again with **bitbake \*image_name\***

## Reference Link

https://docs.yoctoproject.org/ref-manual/tasks.html

https://docs.yoctoproject.org/bitbake/2.2/bitbake-user-manual/bitbake-user-manual-metadata.html

