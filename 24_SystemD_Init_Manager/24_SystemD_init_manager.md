## Brief Intro of Init Manager

An init manager, or init system, is a fundamental software component in a Unix-like operating system that is responsible for initializing the system during the boot process and managing system processes and services throughout the system's runtime. It is the first program to run when the operating system starts and is assigned the process ID (PID) of 1.

## What does Init Manager do?

1. **System Boot and Initialization**: The init manager is responsible for initializing the system hardware, mounting filesystems, setting up essential system parameters, and starting essential system services. It ensures that the system reaches a functional state.
2. **Service Management**: It manages system services and daemons. This includes starting, stopping, restarting, and monitoring processes. Services can be system-level processes, user-level processes, or background daemons.
3. **Dependency Resolution**: An init manager often manages service dependencies, ensuring that services are started in the correct order. For example, a database service may depend on a network service, so the init manager ensures the network service starts before the database service.
4. **Process Monitoring and Restart**: It monitors running processes and can restart them if they fail or crash. This feature is crucial for maintaining system stability.
5. **Shutdown and Reboot**: The init manager handles the graceful shutdown or reboot of the system. It stops running services and ensures a clean system shutdown.

## Available Init Managers

By default, the Yocto Project uses [SysVinit](https://en.wikipedia.org/wiki/Init#SysV-style) as the initialization manager. There is also support for BusyBox init, a simpler implementation, as well as support for systemd.

## What is SystemD Init Manager?

SystemD is a full replacement for init with parallel starting of services, reduced shell overhead, increased security and resource limits for services, and other features that are used by many distributions.

## How to integrate SystemD in Yocto?

```bash
DISTRO_FEATURES:append = " systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
```

`DISTRO_FEATURES_append = "systemd"` is used to specify that systemd is among the features your Linux distribution supports. It doesn't directly dictate the init system.

`VIRTUAL-RUNTIME_init_manager = "systemd"` explicitly specifies systemd as the init system for your distribution, ensuring that systemd is used for managing system initialization and services.

In practical terms, by setting `DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"`, you are ensuring that the "sysvinit" feature is included in the consideration process when determining the features that your Linux distribution supports. This can be useful when you want to ensure compatibility or support for software or components that rely on the SysVinit init system or related features.

**systemd-compat-units**: This specific value for `VIRTUAL-RUNTIME_initscripts` refers to a set of compatibility units designed to work with systemd. These units are used to launch and manage services that rely on SysVinit-style init scripts.

## Comparision between Init Managers

In systems with SysVinit or BusyBox init, services load sequentially (i.e. one by one) during init and parallelization is not supported. With systemd, services start in parallel. This method can have an impact on the startup performance of a given service, though systemd will also provide more services by default, therefore increasing the total system boot time. systemd also substantially increases system size because of its multiple components and the extra dependencies it pulls.

On the contrary, BusyBox init is the simplest and the lightest solution and also comes with BusyBox mdev as device manager, a lighter replacement to [udev](https://en.wikipedia.org/wiki/Udev), which SysVinit and systemd both use.
