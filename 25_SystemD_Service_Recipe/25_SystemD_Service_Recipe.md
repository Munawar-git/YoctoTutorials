# SystemdD Service Recipe

## 1) What is SystemD Service?

 A systemd service is a unit of work that can be started, stopped, or managed by systemd. These services can be custom applications, daemons, or system-level tasks. Systemd services are defined by service unit files (usually with a `.service` extension) that contain configuration information for managing the service's behavior.



## 2) Why to use SystemD Service?

- **Parallelization**: Systemd can start and manage services in parallel, reducing boot times.

- **Dependency Management**: It handles service dependencies, ensuring services start in the correct order.

- **Logging**: Systemd collects and manages service logs, making it easier to troubleshoot issues.

- **Resource Management**: Systemd can set resource limits for services, enhancing system stability.

- **Service Recovery**: It can automatically restart failed services, improving system reliability.

- **Standardization**: Systemd is widely adopted in modern Linux distributions, providing consistency across systems.

  

## 3) How to write a Recipe for SystemD Service?

- Create a code or script if necessary.
- Create a `.service` unit file that defines the service's behavior.
- Place the `.service` file  and code/script files in a location within your recipe (e.g., in the `files` directory).
- In the recipe file (`.bb`), use `do_install` to copy the `.service` and/or code/script files to the appropriate location in the root filesystem.
- Define any dependencies and metadata for your recipe



## 4) Where to place Service File in Root Filesystem?

Use the `do_install` task in your Yocto recipe to specify where the `.service` unit file should be placed in the root filesystem. The location typically follows the FHS (Filesystem Hierarchy Standard) and can be something like `${systemd_system_unitdir}/system`.



## 5) How to Enable the Service by Default?

```bitbake
SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "sysd.service"
```



## 6 Some Basic SystemD Commands

- `systemctl status servicename`: Check the status of a systemd service.
- `systemctl start servicename`: Start a systemd service.
- `systemctl stop servicename`: Stop a systemd service.
- `systemctl restart servicename`: Restart a systemd service.
- `systemctl enable servicename`: Enable a service to start at boot.
- `systemctl disable servicename`: Disable a service from starting at boot.
- `systemctl daemon-reload `: Reloads Systemd Daemons.