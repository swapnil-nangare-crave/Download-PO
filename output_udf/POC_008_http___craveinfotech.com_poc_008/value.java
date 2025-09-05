package com.sap.xi.tf;
// beginning of import 93473a7344419b15c4219cc2b6c64c6f
import com.sap.aii.mapping.api.*;
import com.sap.aii.mapping.lookup.*;
import com.sap.aii.mappingtool.tf7.rt.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

// end of import 93473a7344419b15c4219cc2b6c64c6f

import com.sap.aii.mappingtool.tfapi.*;
import com.sap.aii.mappingtool.tf7.*;
import com.sap.aii.mappingtool.flib7.*;



 public class /*!_$ClNRep_*/_POC_008_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
MethodSignature  ms$;
IResIterator a$2;
MethodSignature  ms$3;
FunctionWrapper a$4;
AStructureNode a$5;
MethodSignature  ms$6;
MethodSignature  ms$7;

   public /*!_$ClNRep_*/_POC_008_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_008", "/", "");storage.registerRequest(2, "/ns0:POC_008/Name", "/ns0:POC_008", "");storage.registerRequest(3, "/ns0:POC_008/Id", "/ns0:POC_008", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_008]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_008",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/008\"",2); root=(StructureNode)a$1; 
//Src[/ns0:POC_008/Name]
 
 a$ = new NodeArgWrapper(2, storage); 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", " queued!");
 
//= concat 
ms$3=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, "delimeter"}); 
a$4 = new FunctionWrapper(ms$3, this);mt$prepareFunc(a$4,"com.sap.aii.mappingtool.flib7.TextFunctions", "concat", ms$3); a$4.setArgument(0,a$);//<html><body><font color=gray>/ns0:POC_008/<font color=green><b>Name</b><font color=black>;
 a$4.setArgument(1,a$2);//<html><body><font color=#808000><b>const</b></font>(value= queued!);
 
a$4.setParameter("delimeter", "");
 a$5=AStructureNode.createNode(1, "Name",a$4,0,1,null,0); a$1.addChildElement(a$5); 
//= const 
ms$6=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "0");
 
//Src[/ns0:POC_008/Id]
 
 a$2 = new NodeArgWrapper(3, storage); 
//= concat 
ms$7=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, "delimeter"}); 
a$4 = new FunctionWrapper(ms$7, this);mt$prepareFunc(a$4,"com.sap.aii.mappingtool.flib7.TextFunctions", "concat", ms$7); a$4.setArgument(0,a$);//<html><body><font color=#808000><b>const</b></font>(value=0);
 a$4.setArgument(1,a$2);//<html><body><font color=gray>/ns0:POC_008/<font color=green><b>Id</b><font color=black>;
 
a$4.setParameter("delimeter", "");
 a$5=AStructureNode.createNode(1, "Id",a$4,0,1,null,0); a$1.addChildElement(a$5);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/008","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_008_ st = new /*!_$ClNRep_*/_POC_008_(); st.testExecute(); }
}
