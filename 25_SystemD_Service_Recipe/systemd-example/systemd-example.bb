SUMMARY = "A Example of a recipe that utilizes systemd"
DEESCRIPTION = "Runs sysd.sh script using a systemd service"

LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://sysd.sh \
           file://sysd.service "

inherit systemd

S = "${WORKDIR}"

RDEPENDS:${PN}  = "bash"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "sysd.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/sysd.sh ${D}${bindir}
    
#    systemd_unitdir = /lib/systemd/
#    sysconfdir = /etc

    install -d ${D}/${sysconfdir}/systemd/system
    install -m 0644 ${S}/sysd.service ${D}/${sysconfdir}/systemd/system
#    install -d ${D}/${systemd_unitdir}/system
#    install -m 0644 ${S}/sysd.service ${D}/${systemd_unitdir}/system
}
