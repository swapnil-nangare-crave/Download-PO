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



 public class /*Copy*//*!_$ClNRep_*/_POC_005_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;
AStructureNode a$4;
AStructureNode a$5;
AStructureNode a$6;
MethodSignature  ms$;
AStructureNode a$7;
AStructureNode a$8;
AStructureNode a$9;
AStructureNode a$10;
AStructureNode a$11;
AStructureNode a$12;
AStructureNode a$13;
AStructureNode a$14;
AStructureNode a$15;
AStructureNode a$16;
AStructureNode a$17;
AStructureNode a$18;
AStructureNode a$19;
AStructureNode a$20;
AStructureNode a$21;
AStructureNode a$22;
AStructureNode a$23;
AStructureNode a$24;
AStructureNode a$25;
AStructureNode a$26;

   public /*Copy*//*!_$ClNRep_*/_POC_005_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_005", "/", "");storage.registerRequest(2, "/ns0:POC_005/PurchaseOrder", "/ns0:POC_005", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_005]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns1:BAPI_PO_GETDETAIL",a$,1,1," xmlns:ns1=\"urn:sap-com:document:sap:rfc:functions\"",27); root=(StructureNode)a$1; 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "X");
 a$7=AStructureNode.createNode(1, "ITEMS",a$,0,1,null,0); a$1.addChildElement(a$7); 
//Src[/ns0:POC_005/PurchaseOrder]
 
 a$ = new NodeArgWrapper(2, storage); a$8=AStructureNode.createNode(1, "PURCHASEORDER",a$,1,1,null,0); a$1.addChildElement(a$8);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/005","ns0");
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
  public static void main(String[] args) throws Exception{/*Copy*//*!_$ClNRep_*/_POC_005_ st = new /*Copy*//*!_$ClNRep_*/_POC_005_(); st.testExecute(); }
}
