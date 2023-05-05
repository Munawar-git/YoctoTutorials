
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/Munawar-git/bbb-tutorial-code.git;protocol=https;branch=master"
SRCREV = "f1be90c683cc1fe31f58f3f8b081562e8b5c8230"


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