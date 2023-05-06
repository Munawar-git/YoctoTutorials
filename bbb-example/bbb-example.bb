
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/Munawar-git/bbb-tutorial-code.git;protocol=https;branch=master"
SRCREV = "f1be90c683cc1fe31f58f3f8b081562e8b5c8230"

SRC_URI:append = " file://0001-patch-example.patch"

S = "${WORKDIR}/git"

do_configure() {
    echo "#define WELCOME y" > bbb-example.h
}

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} ${S}/bbb-example.c -o bbb-example 
}

do_install() {
install -d ${D}${bindir}
install -m 0755 ${S}/bbb-example ${D}${bindir}
}




# * **Fetch** (do_fetch) :   Fetches the source code
# * **Unpack** (do_upack) : Unpacks the source code into a working directory
# * **Patch** (do_patch) : Locates patch files and applies them to the source code
# * **Configure** (do_configure) : Configures the source by enabling and disabling any build-time and configuration options for the software being built.
# * **Compile** (do_compile) : Compiles the source in the compilation directory
# * **Install** (do_install) : Copies files from the compilation directory to a holding area