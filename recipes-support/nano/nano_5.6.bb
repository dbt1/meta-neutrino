DESCRIPTION = "GNU nano (Nano's ANOther editor, or \
Not ANOther editor) is an enhanced clone of the \
Pico text editor."
SUMMARY = "${DESCRIPTION}"
HOMEPAGE = "http://www.nano-editor.org/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"
SECTION = "console/utils"
DEPENDS = "ncurses"
RDEPENDS_${PN} = "ncurses-terminfo nano-syntax-highlighting"

SRC_URI = "http://www.nano-editor.org/dist/v5/nano-${PV}.tar.gz"

inherit autotools gettext

SRC_URI += "file://nanorc"

inherit pkgconfig

SRC_URI[sha256sum] = "b80bc1fa26d5be3c133e6f9f1fb3eb876b84d0e67da141a9ae49c83f2e65b087"

do_install(){
	install -d ${D}/${sysconfdir} ${D}/${bindir}
	install -m 644 ${WORKDIR}/nanorc ${D}${sysconfdir}/
	install -m 755 ${WORKDIR}/build/src/nano ${D}${bindir}/
}

do_install_append() {
	install -d ${D}/home/root/.local/share
}

FILES_${PN} += "/home/root"
