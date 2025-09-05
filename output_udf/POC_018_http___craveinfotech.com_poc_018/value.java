package com.sap.xi.tf;
// beginning of import 93473a7344419b15c4219cc2b6c64c6f
import com.sap.aii.mapping.api.*;
import com.sap.aii.mapping.lookup.*;
import com.sap.aii.mappingtool.tf7.rt.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

// end of import 93473a7344419b15c4219cc2b6c64c6f

import java.text.SimpleDateFormat;
import com.sap.aii.ib.bom.flib.types.CalendarPropertiesValue;
import com.sap.aii.mappingtool.tfapi.*;
import com.sap.aii.mappingtool.tf7.*;
import com.sap.aii.mappingtool.flib7.*;



 public class /*!_$ClNRep_*/_POC_018_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;
AStructureNode a$4;
MethodSignature  ms$;
IResIterator a$5;

   public /*!_$ClNRep_*/_POC_018_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/Customers", "/", "");storage.registerRequest(2, "/Customers", "/", "");storage.registerRequest(3, "/Customers/Customer", "/Customers", "");storage.registerRequest(4, "/Customers/Customer/ID", "/Customers/Customer", "");storage.registerRequest(5, "/Customers/Customer/Name", "/Customers/Customer", "");storage.registerRequest(6, "/Customers/Customer/LastName", "/Customers/Customer", "");storage.registerRequest(7, "/Customers/Customer/BirthDate", "/Customers/Customer", "");storage.registerRequest(8, "/Customers/Customer/BirthDate", "/Customers/Customer", "");}
   protected void __CreateStructures(){ 
//Src[/Customers]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_018_Proxy",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/018\"",1); root=(StructureNode)a$1; 
//Src[/Customers]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "Customers",a$,1,1,null,1); a$1.addChildElement(a$2); 
//Src[/Customers/Customer]
 
 a$ = new NodeArgWrapper(3, storage); a$3=AStructureNode.createNode(1, "Customer",a$,1,-1,null,5); a$2.addChildElement(a$3); 
//Src[/Customers/Customer/ID]
 
 a$ = new NodeArgWrapper(4, storage); a$4=AStructureNode.createNode(1, "External_ID",a$,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/Customers/Customer/Name]
 
 a$ = new NodeArgWrapper(5, storage); a$4=AStructureNode.createNode(1, "Name_First",a$,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/Customers/Customer/LastName]
 
 a$ = new NodeArgWrapper(6, storage); a$4=AStructureNode.createNode(1, "Name_Last",a$,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/Customers/Customer/BirthDate]
 
 a$ = new NodeArgWrapper(7, storage); 
//= TransformDate 
ms$=new MethodSignature(new Class[]{String.class, SimpleDateFormat.class, SimpleDateFormat.class, CalendarPropertiesValue.class}, new String[]{null, "iform", "oform", "calend"}); 
a$5 = new com.sap.aii.mappingtool.flib7.DateTransformer(this); a$5.setArgument(0,a$);//<html><body><font color=gray>/Customers/Customer/<font color=green><b>BirthDate</b><font color=black>;
 
a$5.setParameter("iform", new SimpleDateFormat("MMddyyyy"));
 
a$5.setParameter("oform", new SimpleDateFormat("yyyy/MM/dd"));
 
a$5.setParameter("calend", new CalendarPropertiesValue(1, 1, true));
 a$4=AStructureNode.createNode(1, "Date_Birth",a$5,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/Customers/Customer/BirthDate]
 
 a$ = new NodeArgWrapper(8, storage); a$4=AStructureNode.createNode(1, "Date_Creation",a$,1,1,null,0); a$3.addChildElement(a$4);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    
    if (uris.isEmpty())
    return Collections.EMPTY_MAP; else return uris;
  }
  public void preStart() throws StreamTransformationException {
    params.assignVars();
    libs.libsinit();
    super.preStart();
  }
  public void postStart() throws StreamTransformationException {
    libs.libscleanup();
    super.postStart();
  }
  

  public String getFileName(Container container) throws StreamTransformationException{
  // beginning of getFileName e60244d5c5722f4b4235db2a86541887
DynamicConfiguration conf = (DynamicConfiguration) container.getTransformationParameters().get(StreamTransformationConstants.DYNAMIC_CONFIGURATION);

DynamicConfigurationKey key = DynamicConfigurationKey.create("http://sap.com/xi/XI/System/File","FileName");

String fileName = conf.get(key);

return fileName;
  // end of getFileName e60244d5c5722f4b4235db2a86541887
  }


  public void init(GlobalContainer container) throws StreamTransformationException{
  // beginning of init f2bfdf97b7d432d057584464aabdb643

  // end of init f2bfdf97b7d432d057584464aabdb643
  }


  public void cleanUp(GlobalContainer container) throws StreamTransformationException{
  // beginning of cleanUp 7e26d344ee3a9ad7648ebff5b3eb584b
  
  // end of cleanUp 7e26d344ee3a9ad7648ebff5b3eb584b
  }
// beginning of attributes and methods 72418d956989a1e71aecbea9d5a90ecf

// end of attributes and methods 72418d956989a1e71aecbea9d5a90ecf


  
  private class MT$InnerLibsList{
      
      private MT$InnerLibsList(){
        
      }
      private void libsinit() throws StreamTransformationException {
        init(getGlobalContainer());

      }
      private void libscleanup() throws StreamTransformationException {
        cleanUp(getGlobalContainer());

      }
  }
  private class MT$InnerParamsList{
      
      private MT$InnerParamsList(){
      }
      private void assignVars(){
       
      }
  }
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_018_ st = new /*!_$ClNRep_*/_POC_018_(); st.testExecute(); }
}
