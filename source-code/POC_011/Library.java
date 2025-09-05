package com.craveinfotech.poc._11;

import com.sap.aii.mapping.api.*;
import com.sap.aii.mapping.lookup.*;
import com.sap.aii.mappingtool.tf7.rt.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public class Library {

    public String Calculate(String a, ResultList result) {
        int j = 0;
for (String element : a) {
    if (element != null) {
        int k = Integer.parseInt(element);
        j += k;
    }
}
result.addValue(j);
    }

}