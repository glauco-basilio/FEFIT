/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rimisan.file;

import java.io.File;
import java.util.regex.Pattern;

/**
 *
 * @author Glauco
 */
public class RegExpNameFileFilter implements IFileFilter {
    private Pattern p = null;
    public RegExpNameFileFilter(String regExp,int flags){
        p = Pattern.compile(regExp, flags);
    }
    
    public RegExpNameFileFilter(String regExp){
        p = Pattern.compile(regExp,Pattern.CASE_INSENSITIVE);
    }

    public boolean test(File f) {
        return p.matcher(f.getName()).find();
    }

}
