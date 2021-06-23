require recipes-core/images/rpi-test-image.bb

MACHINE = "raspberrypi0-wifi"

ENABLE_UART = "1"
EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh"

IMAGE_INSTALL_append += " mrobot"
