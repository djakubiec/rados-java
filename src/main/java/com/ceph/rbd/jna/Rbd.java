/*
 * RADOS Java - Java bindings for librados and librbd
 *
 * Copyright (C) 2013 Wido den Hollander <wido@42on.com>
 *
 * This is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1, as published by the Free Software
 * Foundation.  See file LICENSE.
 *
 */

package com.ceph.rbd.jna;

import com.ceph.rbd.jna.RbdImageInfo;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.Pointer;

public interface Rbd extends Library {

    Rbd INSTANCE = (Rbd) Native.loadLibrary("rbd", Rbd.class);

    void rbd_version(IntByReference major, IntByReference minor, IntByReference extra);
    int rbd_create(Pointer io, String name, long size, IntByReference order);
    int rbd_create2(Pointer io, String name, long size, long features, IntByReference order);
    int rbd_create3(Pointer io, String name, long size, long features, IntByReference order, long stripe_unit, long stripe_count);
    int rbd_list(Pointer io, byte[] names, IntByReference size);
    int rbd_remove(Pointer io, String name);
    int rbd_rename(Pointer io, String srcname, String destname);
    int rbd_open_read_only(Pointer io, String name, Pointer image, String snap_name);
    int rbd_open(Pointer io, String name, Pointer image, String snap_name);
    int rbd_stat(Pointer image, RbdImageInfo info, long infosize);
}