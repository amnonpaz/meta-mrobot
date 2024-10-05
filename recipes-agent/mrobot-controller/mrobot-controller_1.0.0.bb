DESCRIPTION = "Python-based controller application for the mrobot"
HOMEPAGE = "https://github.com/amnonpaz/mrobot-controller"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCBRANCH = "master"
SRC_URI = "git://github.com/amnonpaz/mrobot-controller.git;protocol=https;branch=${SRCBRANCH};user=git"
SRCREV = "ac3521b72661cbcbeaf488d1da34343f0d980ca9"

SRC_URI += " file://config.json"
SRC_URI += " file://mrobot-controller.service"

S = "${WORKDIR}/git"

inherit setuptools3 systemd

RDEPENDS:${PN} = "\
    ${PYTHON_PN} \
    ${PYTHON_PN}-pygobject \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-websockets \
    ${PYTHON_PN}-asyncio \
    ${PYTHON_PN}-msgpack \
    ${PYTHON_PN}-zeroconf \
    ${PYTHON_PN}-netifaces \
    ${PYTHON_PN}-pillow \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
"

FILES:${PN} += "${systemd_unitdir}"
FILES:${PN} += "${systemd_unitdir}/system/"
FILES:${PN} += "${systemd_unitdir}/system/mrobot-controller.service"
FILES:${PN} += "${sysconfdir}/mrobot-controller/config.json"

do_install:append() {
    #install -d ${D}${bindir}
    install -d ${D}${sysconfdir}/mrobot-controller
    install -d ${D}${systemd_unitdir}/system

    install -m 0644 ${WORKDIR}/config.json ${D}${sysconfdir}/mrobot-controller/config.json
    install -m 0644 ${WORKDIR}/mrobot-controller.service ${D}${systemd_unitdir}/system/mrobot-controller.service
}

SYSTEMD_SERVICE_${PN} = "mrobot-controller.service"
