DESCRIPTION = "mRobot agent package"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cmake

SECTION = "MROBOT"
PROVIDES = "mrobot"

SRCBRANCH = "master"
SRC_URI = "git://github.com/amnonpaz/mrobot.git;protocol=https;branch=${SRCBRANCH};user=git"
SRCREV = "${AUTOREV}"

DEPENDS = "mosquitto"

S = "${WORKDIR}/git"

EXTRA_OECMAKE:append = " -DLINT=off"

FILES:${PN} = " \
    /usr/bin/mrobot \
    /opt/mrobot/mrobot-setup.sh \
    /opt/mrobot/template.conf"
