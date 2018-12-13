/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rimisan.file;

import java.io.File;

/**
 *
 * @author Glauco
 */
public class FileScanner {
    private IFileScannerEventListener eventListener = null;
    private File rootDir = null;
    private IFileFilter filter;
    private FileScannerOptions options;
    public FileScanner(IFileScannerEventListener eventListener){
        setEventListener(eventListener);
    }

    public FileScanner(File rootDir,IFileScannerEventListener eventListener){
        setRootDir(rootDir);
        setEventListener(eventListener);
    }

    public FileScanner(File rootDir,IFileScannerEventListener eventListener,IFileFilter filter){
        setRootDir(rootDir);
        setEventListener(eventListener);
        setFilter(filter);
    }
    public void setOptions(FileScannerOptions pOpt)
    {
        options = pOpt;
    }
    public void setEventListener(IFileScannerEventListener fEvtL){
        this.eventListener = fEvtL;
    }

    public void setRootDir(File rootDir){
        this.rootDir = rootDir;
    }
    
    public void setFilter(IFileFilter filter){
        this.filter = filter;
    }
    
    public Object getEventListener(){
        return eventListener;
    }

    public File getRootDir(){
        return rootDir;
    }
    
    public void startScan() throws RootDirNotSetException, RootDirNotValidException{
        if(getRootDir() == null) throw new FileScanner.RootDirNotSetException();
        if(!getRootDir().isDirectory()) throw new FileScanner.RootDirNotValidException();
        this.scanFolder(getRootDir());
    }
    
    private void scanFolder(File file){
        for( File f : file.listFiles()){
            if(f.isDirectory()){
                eventListener.onFolder(f);
                this.scanFolder(f);
            }else{
                eventListener.onFile(f);
                if(filter!=null){
                    if(filter.test(f)) eventListener.onMatch(f);
                }
            }
        }
    }

    public class RootDirNotSetException extends Exception{
        public RootDirNotSetException(){
            super("RootDir is not set");
        }

    }
    
    public class RootDirNotValidException extends Exception{
        public RootDirNotValidException(){
            super("RootDir not apear to be valid");
        }

    }
}
