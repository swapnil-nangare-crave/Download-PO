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



 public class /*!_$ClNRep_*/_Subtract_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
MethodSignature  ms$;
IResIterator a$2;
MethodSignature  ms$3;
FunctionWrapper a$4;
AStructureNode a$5;

   public /*!_$ClNRep_*/_Subtract_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:Add", "/", "");storage.registerRequest(2, "/ns0:Add/Value1", "/ns0:Add", "");storage.registerRequest(3, "/ns0:Add/Value2", "/ns0:Add", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:Add]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns1:Subtract",a$,1,1," xmlns:ns1=\"http://tempuri.org/\"",2); root=(StructureNode)a$1; 
//Src[/ns0:Add/Value1]
 
 a$ = new NodeArgWrapper(2, storage); 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "10");
 
//= sub 
ms$3=new MethodSignature(new Class[]{String.class, String.class}, new String[]{null, null}); 
a$4 = new FunctionWrapper(ms$3, this);mt$prepareFunc(a$4,"com.sap.aii.mappingtool.flib7.Arithm", "subtract", ms$3); a$4.setArgument(0,a$);//<html><body><font color=gray>/ns0:Add/<font color=green><b>Value1</b><font color=black>;
 a$4.setArgument(1,a$2);//<html><body><font color=#808000><b>const</b></font>(value=10);
 a$5=AStructureNode.createNode(1, "ns1:intA",a$4,1,1,null,0); a$1.addChildElement(a$5); 
//Src[/ns0:Add/Value2]
 
 a$ = new NodeArgWrapper(3, storage); a$5=AStructureNode.createNode(1, "ns1:intB",a$,1,1,null,0); a$1.addChildElement(a$5);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://test.com/tejas02","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_Subtract_ st = new /*!_$ClNRep_*/_Subtract_(); st.testExecute(); }
}
