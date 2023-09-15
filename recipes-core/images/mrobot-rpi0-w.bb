require recipes-core/images/core-image-base.bb
#require recipes-core/images/meta-oe-image-base.bb
#require recipes-extended/images/core-image-full-cmdline.bb

MACHINE = "raspberrypi0-wifi"

IMAGE_FEATURES += " debug-tweaks ssh-server-openssh"

IMAGE_INSTALL += " mrobot \
                   i2c-tools \
                   vim \
                   gstreamer1.0 \
                   gstreamer1.0-libav \
                   gstreamer1.0-plugins-base \
                   gstreamer1.0-plugins-bad \
                   gstreamer1.0-plugins-good \
                   gstreamer1.0-plugins-ugly \
                   v4l-utils \
                   linux-firmware-bcm43430 \
                   iw \
                   wpa-supplicant \
                   bluez5 \
                 "
MACHINE_FEATURES += " wifi"
DISTRO_FEATURES += " wifi bluetooth systemd"

