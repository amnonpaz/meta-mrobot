DESCRIPTION = "Python-based video streaming application using GStreamer"
HOMEPAGE = "https://github.com/amnonpaz/v4l2-rtp-streamer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCBRANCH = "master"
SRC_URI = "git://github.com/amnonpaz/v4l2-rtp-streamer.git;protocol=https;branch=${SRCBRANCH};user=git"
SRCREV = "${AUTOREV}"

SRC_URI += " file://config.json"
SRC_URI += " file://video-streamer.service"

S = "${WORKDIR}/git"

inherit setuptools3 systemd

RDEPENDS_${PN} = "\
    python3 \
    python3-gi \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
"

FILES_${PN} += "${systemd_unitdir}"
FILES_${PN} += "${systemd_unitdir}/system/"
FILES_${PN} += "${systemd_unitdir}/system/video-streamer.service"
FILES_${PN} += "${sysconfdir}/video-streamer/config.json"

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}/video-streamer
    install -d ${D}${systemd_unitdir}/system

    install -m 0755 ${S}/main.py ${D}${bindir}/video_streamer.py
    install -m 0644 ${WORKDIR}/config.json ${D}${sysconfdir}/video-streamer/config.json
    install -m 0644 ${WORKDIR}/video-streamer.service ${D}${systemd_unitdir}/system/video-streamer.service
}

SYSTEMD_SERVICE_${PN} = "video-streamer.service"
