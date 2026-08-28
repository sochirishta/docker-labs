#!/bin/bash

Xvfb :99 -screen 0 1280x800x24 &
export DISPLAY=:99

x11vnc -display :99 -forever -nopw -listen 0.0.0.0 -rfbport 5900 &

/usr/share/novnc/utils/novnc_proxy \
    --vnc localhost:5900 \
    --listen 6080 &

sleep 2

xeyes

wait