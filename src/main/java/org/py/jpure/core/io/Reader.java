package org.py.jpure.core.io;

import java.io.IOException;
import java.nio.charset.Charset;

public interface Reader {
    String readCharacter(Charset charset) throws IOException;
    byte[] readBytes() throws  IOException;
}
