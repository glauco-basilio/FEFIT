/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rimisan.file;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 *
 * @author glauco
 */
public class JavascriptExposedFileFilter implements IFileFilter{

    ScriptEngine se = (new ScriptEngineManager()).getEngineByName("javascript");

    private String functionBody;

    public JavascriptExposedFileFilter(String functionBody){
        this.functionBody = functionBody;
    }

    public boolean test(File f) {
        try {
            Invocable invo = (Invocable)se;
            
            se.eval("function testFile(arquivo){" + functionBody + "}");
            return (Boolean) invo.invokeFunction("testFile", f);
        } catch (ScriptException ex) {
            Logger.getLogger(JavascriptExposedFileFilter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(JavascriptExposedFileFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }



}
