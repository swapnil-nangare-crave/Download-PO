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



 public class /*Copy*//*!_$ClNRep_*/_POC_007_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
MethodSignature  ms$;
IResIterator a$2;
MethodSignature  ms$3;
IResIterator a$4;
MethodSignature  ms$5;
FunctionWrapper a$6;
AStructureNode a$7;

   public /*Copy*//*!_$ClNRep_*/_POC_007_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_007", "/", "");storage.registerRequest(2, "/ns0:POC_007/PurchaseOrder", "/ns0:POC_007", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_007]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_007",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/007\"",1); root=(StructureNode)a$1; 
//Src[/ns0:POC_007/PurchaseOrder]
 
 a$ = new NodeArgWrapper(2, storage); 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "&");
 
//= const 
ms$3=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$4 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$4.setParameter("value", "");
 
//= replaceString 
ms$5=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, null}); 
a$6 = new FunctionWrapper(ms$5, this);mt$prepareFunc(a$6,"com.sap.aii.mappingtool.flib7.TextFunctions", "replaceString", ms$5); a$6.setArgument(0,a$);//<html><body><font color=gray>/ns0:POC_007/<font color=green><b>PurchaseOrder</b><font color=black>;
 a$6.setArgument(1,a$2);//<html><body><font color=#808000><b>const</b></font>(value=&amp;);
 a$6.setArgument(2,a$4);//<html><body><font color=#808000><b>const</b></font>(value=);
 a$7=AStructureNode.createNode(1, "PurchaseOrder",a$6,1,1,null,0); a$1.addChildElement(a$7);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/007","ns0");
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
  public static void main(String[] args) throws Exception{/*Copy*//*!_$ClNRep_*/_POC_007_ st = new /*Copy*//*!_$ClNRep_*/_POC_007_(); st.testExecute(); }
}
