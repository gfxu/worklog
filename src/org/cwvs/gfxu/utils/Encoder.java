package org.cwvs.gfxu.utils;

public interface Encoder {
	
	String getName();
	/**
     * encode a string
     * @param source the source string that prepare to encode
     * @return String
     */
    String encode(String source);

}
