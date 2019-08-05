package org.py.jpure.core.io;

import org.py.jpure.core.util.Classloader;

public abstract class AbstractFileResource extends AbstractResource {
    public AbstractFileResource(String filename) {
        if(null == filename || filename.isEmpty()) throw new IllegalArgumentException("illegal filename.");
        this.filename = filename;
        cl = Classloader.defaultClassLoader();
    }
}
