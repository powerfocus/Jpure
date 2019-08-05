package org.py.jpure.core.io;

import java.io.IOException;

public interface Reader {
    String readCharacter() throws IOException;
    byte[] readBytes() throws  IOException;
}
