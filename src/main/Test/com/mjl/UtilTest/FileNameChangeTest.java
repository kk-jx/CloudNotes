package com.mjl.UtilTest;

import com.mjl.Util.FileNameChange;
import org.junit.Test;

/**
 * Created by Alvin on 15/11/22.
 */
public class FileNameChangeTest {
    @Test
    public void fileNameChangeTest(){
        FileNameChange fnc = new FileNameChange();
        System.out.println(fnc.Change("fdsaf","hahaah.jpn"));
    }
}
