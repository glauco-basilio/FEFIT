/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rimisan.file;

/**
 *
 * @author Glauco
 */
public interface IFileScannerEventListener {
    public void onFile(java.io.File f);
    public void onFolder(java.io.File f);
    public void onMatch(java.io.File f);
}
