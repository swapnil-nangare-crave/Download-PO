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



 public class /*!_$ClNRep_*/_POC_009_Insert_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;
MethodSignature  ms$;
AStructureNode a$4;
MethodSignature  ms$5;
AStructureNode a$6;

   public /*!_$ClNRep_*/_POC_009_Insert_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_009", "/", "");storage.registerRequest(2, "/ns0:POC_009/Customer", "/ns0:POC_009", "");storage.registerRequest(3, "/ns0:POC_009/Customer/CustomerID", "/ns0:POC_009/Customer", "");storage.registerRequest(4, "/ns0:POC_009/Customer/FirstName", "/ns0:POC_009/Customer", "");storage.registerRequest(5, "/ns0:POC_009/Customer/LastName", "/ns0:POC_009/Customer", "");storage.registerRequest(6, "/ns0:POC_009/Customer/Email", "/ns0:POC_009/Customer", "");storage.registerRequest(7, "/ns0:POC_009/Customer/CustomerID", "/ns0:POC_009/Customer", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_009]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_009_Insert",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/009\"",1); root=(StructureNode)a$1; 
//Src[/ns0:POC_009/Customer]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "Insert",a$,1,-1,null,1); a$1.addChildElement(a$2); a$3=AStructureNode.createNode(1, "Customers",new DummyIterator(this),1,1,null,4); a$2.addChildElement(a$3); 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "UPDATE_INSERT");
 a$4=AStructureNode.createNode(3, "action",a$,0,1,null,0); a$3.addChildElement(a$4); 
//= const 
ms$5=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "dbo.POC009");
 a$4=AStructureNode.createNode(1, "table",a$,0,1,null,0); a$3.addChildElement(a$4); a$4=AStructureNode.createNode(1, "access",new DummyIterator(this),1,1,null,4); a$3.addChildElement(a$4); 
//Src[/ns0:POC_009/Customer/CustomerID]
 
 a$ = new NodeArgWrapper(3, storage); a$6=AStructureNode.createNode(1, "CustomerID",a$,0,1,null,0); a$4.addChildElement(a$6); 
//Src[/ns0:POC_009/Customer/FirstName]
 
 a$ = new NodeArgWrapper(4, storage); a$6=AStructureNode.createNode(1, "FirstName",a$,0,1,null,0); a$4.addChildElement(a$6); 
//Src[/ns0:POC_009/Customer/LastName]
 
 a$ = new NodeArgWrapper(5, storage); a$6=AStructureNode.createNode(1, "LastName",a$,0,1,null,0); a$4.addChildElement(a$6); 
//Src[/ns0:POC_009/Customer/Email]
 
 a$ = new NodeArgWrapper(6, storage); a$6=AStructureNode.createNode(1, "Email",a$,0,1,null,0); a$4.addChildElement(a$6); a$6=AStructureNode.createNode(1, "key",new DummyIterator(this),1,1,null,1); a$3.addChildElement(a$6); 
//Src[/ns0:POC_009/Customer/CustomerID]
 
 a$ = new NodeArgWrapper(7, storage); a$4=AStructureNode.createNode(1, "CustomerID",a$,0,1,null,0); a$6.addChildElement(a$4);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/009","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_009_Insert_ st = new /*!_$ClNRep_*/_POC_009_Insert_(); st.testExecute(); }
}
