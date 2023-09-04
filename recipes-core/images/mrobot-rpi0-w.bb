require recipes-core/images/core-image-base.bb

MACHINE = "raspberrypi0-wifi"

ENABLE_UART = "1"
EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh"

IMAGE_INSTALL_append += " mrobot i2c-tools vim"
IMAGE_INSTALL_append += " gstreamer1.0 \
                          gstreamer1.0-plugins-bad \
                          gstreamer1.0-plugins-base \
                          gstreamer1.0-plugins-good \
                        "
DISTRO_INSTALL_append += " wifi openssh openssh-ssh"
DISTRO_INSTALL_remove += " save-rtc"

DISTRO_FEATURES_append += " systemd"

IMAGE_FEATURES_remove = " splash gnome"

VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""
