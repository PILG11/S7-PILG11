#!/bin/bash
export IP=$(hostname -I | awk '{print $2}')
export DEBIAN_FRONTEND="noninteractive"