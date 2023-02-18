# Yocto

## 02 local.conf

### What is local.conf?

* local.conf file is used to customize the image
* add packages

### Default Configurations in local.conf file

* MACHINE ?= "beaglebone-yocto"
* DL_DIR, SSTATE_DIR, TMPDIR
* DISTRO ?= "poky"
* PACKAGE_CLASSES ?= "package_rpm"
* EXTRA_IMAGE_FEATURES ?= "debug-tweaks"
* USER_CLASSES ?= "buildstats"
* PATCHRESOLVE = "noop"
* BB_DISKMON_DIRS
* CONF_VERSION = "2"

### Added Configurations

* RM_OLD_IMAGE = "1"
* INHERIT += "rm_work"

### Configuration Details

#### MACHINE

Specifies the target device for which the image is built.

#List of default Machines

MACHINE ?= "qemuarm"
MACHINE ?= "qemuarm64"
MACHINE ?= "qemumips"
MACHINE ?= "qemumips64"
MACHINE ?= "qemuppc"
MACHINE ?= "qemux86"
MACHINE ?= "qemux86-64"
MACHINE ?= "genericx86"
MACHINE ?= "genericx86-64"
MACHINE ?= "beaglebone"
MACHINE ?= "edgerouter"

default  Machine Conf File locations

**poky/meta/conf/machines**

**poky/meta-yocto-bsp**

#### DL_DIR

**DL_DIR** is a variable in the Yocto Project build system that specifies the directory where source code archives for packages will be downloaded. This directory is used by the build system to store the downloaded source code for packages so that it does not need to download them again if they are required for a subsequent build. 

#### SSTATE_DIR

**SSTATE_DIR** is a variable that specifies the directory where shared state cache files are stored. The shared state cache contains pre-built binary packages for software components used in a build.

The purpose of using a shared state cache is to speed up the build process by avoiding the need to rebuild packages that have already been built previously. When a package is built for the first time, the build system stores the compiled binaries, headers, and other artifacts in the shared state cache, and subsequent builds of the same package can reuse these cached artifacts, saving time and resources.

#### TMPDIR

**TMPDIR** is an environment variable that specifies the directory to be used for temporary files by various programs and scripts. In Yocto and OpenEmbedded, TMPDIR is used as the location for the build directory, where all the build artifacts are stored during the build process.

#### DISTRO

**DISTRO ?= "poky"**

*  **DISTRO** variable specifies the name of the distribution that is being built.
* A distribution is a collection of software components and configuration files that work together to create a complete Linux-based operating system
* Setting **DISTRO** to **"poky"** means that the build system will use the configuration files and package recipes that are part of the reference distribution.

#### PACKAGE_CLASSES

**PACKAGE_CLASSES ?= "package_rpm"**

* PACKAGE_CLASSES is a configuration variable specifies the types of packages to be created for the target system. 
* In this case, it is set to `"package_rpm"`, which means that the Yocto Project will create RPM packages.
* RPM  is a package management system that is widely used in many Linux distributions, including Red Hat, Fedora, CentOS, and openSUSE. 
* DEB package management is used on Debian and Ubuntu systems.

#### EXTRA_IMAGE_FEATURES 

**EXTRA_IMAGE_FEATURES ?= "debug-tweaks"**

* **EXTRA_IMAGE_FEATURES** is a variable that specifies additional features to be included in the target image
* **debug-tweaks** is one of the features that can be included in the image.
* The resulting image will contain additional tools and utilities that can help with debugging and troubleshooting.
* **dbg-pkgs** — adds -dbg packages for all installed packages including symbol information for debugging and profiling.
* **debug-tweaks** — makes an image suitable for debugging. For example, allows root logins without passwords and enables post-installation logging. See the ‘allow-empty-password’ and ‘post-install-logging’ features in the **“Image Features”** section for more information.
* **dev-pkgs** — adds -dev packages for all installed packages. This is useful if you want to develop against the libraries in the image.
* **read-only-rootfs** — creates an image whose root filesystem is read-only. See the “Creating a Read-Only Root Filesystem”** section in the Yocto Project Development Tasks Manual for more information
* **tools-debug** — adds debugging tools such as gdb and strace.
* **tools-sdk** — adds development tools such as gcc, make, pkgconfig and so forth.

#### USER_CLASSES 

**USER_CLASSES ?= "buildstats"**

* The **buildstats** class records performance statistics about each task executed during the build (e.g. elapsed time, CPU usage, and I/O usage).
* The **buildstats** class generates statistics about how long tasks take to build, so it can help identify bottlenecks in the build process. It creates a buildstats database that can be used to analyze the build process.
* When you use this class, the output goes into the **BUILDSTATS_BASE** directory, which defaults to **${TMPDIR}/buildstats/**.

#### PATCHRESOLVE

**PATCHRESOLVE = "noop"**

* Determines the action to take when a patch fails. You can set this variable to one of two values: **noop** and **user**.
* The default value of **noop** causes the build to simply fail when the build system cannot successfully apply a patch.
* Setting the value to **user** causes the build system to launch a shell and places you in the right location so that you can manually resolve the conflicts.

#### BB_DISKMON_DIRS

* Monitors disk space and available inodes during the build and allows you to control the build based on these parameters.
* **STOPTASKS,${TMPDIR},1G,100K** stops the build after all currently executing tasks complete when the minimum disk space in the `${TMPDIR}` directory drops below 1 Gbyte.
* **HALT,${TMPDIR},100M,1K** immediately stops the build when the disk space in the `${TMPDIR}` directory drops below 100 Mbytes.

#### CONF_VERSION

**CONF_VERSION = "2"**

* **CONF_VERSION** is used to specify the version of the configuration syntax to use. 
* It determines which syntax the build system should use when parsing configuration files like **local.conf** and **bblayers.conf**.
* In earlier versions of Yocto, **CONF_VERSION** defaulted to 1
* In practice, setting **CONF_VERSION = "2"** in `local.conf` enables the use of newer features and syntax in Yocto

#### RM_OLD_IMAGE

**RM_OLD_IMAGE = "1"**

* Setting **RM_OLD_IMAGE** to **1** means that Yocto will remove the old image before building a new one, which helps to avoid issues with leftover files and dependencies from previous builds

#### INHERIT 

**INHERIT += "rm_work"** 

* The **rm_work** class is used to remove temporary working files after a package has been built. 
* These files are not necessary for the package to function properly and take up disk space, so removing them can free up space on the device.

### Reference Link

https://docs.yoctoproject.org/ref-manual/variables.html#

### End

In the next chapter we will analyze the **bblayers.conf** file

