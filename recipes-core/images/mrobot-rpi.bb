require recipes-core/images/core-image-base.bb

IMAGE_FEATURES += " debug-tweaks ssh-server-openssh"

IMAGE_INSTALL += " mrobot-controller \
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
                   hostapd \
                 "
MACHINE_FEATURES += " wifi"
DISTRO_FEATURES += " wifi bluetooth systemd"

