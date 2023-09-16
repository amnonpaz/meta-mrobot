# Yocto Layer For mrobot Project
A layer for integrating the mrobot project into Yocto build.
Supports Mickeldore. Might work on previous versions down to Hardknott (tested only with Mickeldore).

## Building
Assuming all Yocto's dependies are installed. 
Clone poky and required layers:
```
git clone git://git.yoctoproject.org/poky -b mickledore
git clone https://git.yoctoproject.org/meta-raspberrypi/ -b mickledore poky/meta-raspberrypi/ 
git clone https://github.com/openembedded/openembedded-core.git  -b mickledore poky/openembedded-core
git clone git@github.com:amnonpaz/meta-mrobot.git poky/meta-mrobot 
```
Execute:
```
source ./poky/oe-init-build-env rpi-build
```
Edit conf/bblayers.conf:
```
# POKY_BBLAYERS_CONF_VERSION is increased each time build/conf/bblayers.conf
# changes incompatibly
POKY_BBLAYERS_CONF_VERSION = "2"

BBPATH = "${TOPDIR}"
BBFILES ?= ""

BBLAYERS ?= " \
  /home/amnon/yocto-mickledore/poky/meta \
  /home/amnon/yocto-mickledore/poky/meta-poky \
  /home/amnon/yocto-mickledore/poky/meta-yocto-bsp \
  /home/amnon/yocto-mickledore/poky/meta-raspberrypi \
  /home/amnon/yocto-mickledore/poky/meta-openembedded/meta-multimedia \
  /home/amnon/yocto-mickledore/poky/meta-openembedded/meta-networking \
  /home/amnon/yocto-mickledore/poky/meta-openembedded/meta-oe \
  /home/amnon/yocto-mickledore/poky/meta-openembedded/meta-python \
  /home/amnon/yocto-mickledore/poky/meta-mrobot \
  "
```
Build:
```
bitbake mrobot-rpi0-w
```
## Notes
Accepting "commercial" licenses is required for allowing installation of gstreamer ugly plugings. If this package is not used, then `commercial` can be removed from the accepted list.

