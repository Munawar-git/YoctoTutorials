# Yocto

## 01 Flashing BeagleBone Black

### Image Folder

**sources/tmp/deploy/images/beaglebone-yocto**

### Identify  Image File

We need to find the **.wic** file with starts with our Image name.
In our case **core-image-full-cmdline-beaglebone-yocto.wic**

But as we see it is a symblink, we need to find the orignal file. the extention of the file will be the same i.e. **.wic**

To find the original file, execute the following command from **beaglebone-yocto** folder.

```bash
ll  | grep "cmdline" | grep ".wic"
```

### Required Hardware

* Beaglebone Black https://grabcad.com/library/beaglebone-black-rev-c-1
* Min 8Gb  micro-SD-Card
* SD-Card Reader
* FTDI Cable (Serial to USB) https://raw.githubusercontent.com/guyz/pyesp8266/master/ftdi_pinout.png
  https://microcontrollerslab.com/wp-content/uploads/2020/12/FTDI-cable-pinout-diagram.jpg
* 5V Power Supply for BBB https://www.digikey.de/en/products/detail/phihong-usa/PSC12R-050/2384498

### Which Flash Tool to Use?

#### dd

Dangerous to use, unrecoverable data, if wrong device is used to flash.

#### Etcher

* Safe to use
* Hides system memory devices and shows external devices
* Download from https://www.balena.io/etcher

**We will be using Etcher**

### How to Flash?

#### Etcher

* Download  Etcher
* Go to the Download folder
* Right click on Etcher, Go to  **Properties > Permissions**
* Check the box **Allow executing file as progran**
* Close the window
* Now Double click on Etcher, a window will open.

#### Flash

* Insert the SD card to Host PC
* In Etcher Window, select SD-Card
* Click  **Flash from file** and browse the Image file that we found earlier (**.wic**).
* Click **Flash!**, and wait till the flash is complete
* Close Etcher.
* Click on **Unmount ** icon to safely remove the SD-Card.

#### Install Picocom in Host PC

To install the Picocom , execute the following command:
```bash
sudo apt-get install picocom
```

**It is needed to connect the Beaglebone Black to the serial console**

#### Connect FTDI

* Connect the USB Side of FTDI cable to the Host PC

* Execute the following command to verify.
  ```bash
  dmesg | grep ftdi
  ```

  You may see the output like below but not the exact
  ```bash
  [14264.312945] usbcore: registered new interface driver ftdi_sio
  [14264.313235] ftdi_sio 1-4.3:1.0: FTDI USB Serial Device converter detected
  [47027.147164] ftdi_sio ttyUSB0: FTDI USB Serial Device converter now disconnected from ttyUSB0
  [47027.147242] ftdi_sio 1-4.3:1.0: device disconnected
  [57870.337870] ftdi_sio 1-4.3:1.0: FTDI USB Serial Device converter detected
  ```

* **ttyUSB0** is our FTDI device. it can be found under **/dev/ttyUSB0**

* Connect the other end of FTDI cable to Beaglebone Black.
  Orientation:
  Place the board in such a way that USB port should be in front of you.
  Then insert the pin header in such a way, that the Green Pin of FTDI cable should be inserted to the pin which is near to USB  port.

* Go to the terminal and write the following command to connect to Beaglebone Black
  ```bash
  sudo picocom /dev/ttyUSB0 -b 115200
  ```

  Then enter the password.

#### Booting

* At the back side of the Beaglebone Black, there is a SD-Card jack, insert the SD-Card with the image there

* Adjacent to the USB port, there is a small button with the lable **S2** on it.
* Keep the S2 button pressed and insert the Power Supply in Beaglebone Black.
* After 2 to 3 seconds release the S2 button.
* By now you should see the output on your picocom Terminal. 

The Beaglebone Black has been booted successfully

#### Checking image

Execute the following command to check the kernel version 

```bash
uname -r
uname -a
```

Execute the following to see the partitions
```
lsblk
```

Check rootfs folders

```bash
cd /
ls
```



### End

In the next chapter we will talk about local.conf file
