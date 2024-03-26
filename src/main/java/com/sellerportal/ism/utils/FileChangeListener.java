package com.sellerportal.ism.utils;

public interface FileChangeListener {
    /** Invoked when a file changes.   
     * @param fileName name of changed file.
     */
    public void fileChanged(String fileName);
}
