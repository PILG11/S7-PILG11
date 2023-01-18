#!/bin/bash
export IP=$(hostname -I | awk '{print $2}')
export APT_OPT="-o Dpkg::Progress-Fancy="0" -q -y"
export DEBIAN_FRONTEND="noninteractive"