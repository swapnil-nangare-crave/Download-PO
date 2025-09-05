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



 public class /*!_$ClNRep_*/_POC_016_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
MethodSignature  ms$;
AStructureNode a$3;
MethodSignature  ms$4;
AStructureNode a$5;
MethodSignature  ms$6;
AStructureNode a$7;
MethodSignature  ms$8;
MethodSignature  ms$9;

   public /*!_$ClNRep_*/_POC_016_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_016_FTP", "/", "");storage.registerRequest(2, "/ns0:POC_016_FTP/Record", "/ns0:POC_016_FTP", "");storage.registerRequest(3, "/ns0:POC_016_FTP/Record", "/ns0:POC_016_FTP", "");storage.registerRequest(4, "/ns0:POC_016_FTP/Record/ID", "/ns0:POC_016_FTP/Record", "");storage.registerRequest(5, "/ns0:POC_016_FTP/Record/EmailAddress", "/ns0:POC_016_FTP/Record", "");storage.registerRequest(6, "/ns0:POC_016_FTP/Record/Name", "/ns0:POC_016_FTP/Record", "");storage.registerRequest(7, "/ns0:POC_016_FTP/Record/Country", "/ns0:POC_016_FTP/Record", "");storage.registerRequest(8, "/ns0:POC_016_FTP/Record/State", "/ns0:POC_016_FTP/Record", "");storage.registerRequest(9, "/ns0:POC_016_FTP/Record/Salary", "/ns0:POC_016_FTP/Record", "");storage.registerRequest(10, "/ns0:POC_016_FTP/Record/ID", "/ns0:POC_016_FTP/Record", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_016_FTP]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_016_JDBC",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/016\"",1); root=(StructureNode)a$1; 
//Src[/ns0:POC_016_FTP/Record]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "Statement",a$,0,1,null,1); a$1.addChildElement(a$2); 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "");
 a$3=AStructureNode.createNode(1, "Employee",a$,1,1,null,4); a$2.addChildElement(a$3); 
//= const 
ms$4=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "UPDATE_INSERT");
 a$5=AStructureNode.createNode(3, "action",a$,0,1,null,0); a$3.addChildElement(a$5); 
//= const 
ms$6=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "dbo.Customers");
 a$5=AStructureNode.createNode(1, "table",a$,0,1,null,0); a$3.addChildElement(a$5); 
//Src[/ns0:POC_016_FTP/Record]
 
 a$ = new NodeArgWrapper(3, storage); a$5=AStructureNode.createNode(1, "access",a$,0,-1,null,7); a$3.addChildElement(a$5); 
//Src[/ns0:POC_016_FTP/Record/ID]
 
 a$ = new NodeArgWrapper(4, storage); a$7=AStructureNode.createNode(1, "CustomerID",a$,0,1,null,0); a$5.addChildElement(a$7); 
//Src[/ns0:POC_016_FTP/Record/EmailAddress]
 
 a$ = new NodeArgWrapper(5, storage); a$7=AStructureNode.createNode(1, "Email",a$,0,1,null,0); a$5.addChildElement(a$7); 
//Src[/ns0:POC_016_FTP/Record/Name]
 
 a$ = new NodeArgWrapper(6, storage); a$7=AStructureNode.createNode(1, "EmpName",a$,0,1,null,0); a$5.addChildElement(a$7); 
//Src[/ns0:POC_016_FTP/Record/Country]
 
 a$ = new NodeArgWrapper(7, storage); a$7=AStructureNode.createNode(1, "Country",a$,0,1,null,0); a$5.addChildElement(a$7); 
//Src[/ns0:POC_016_FTP/Record/State]
 
 a$ = new NodeArgWrapper(8, storage); a$7=AStructureNode.createNode(1, "State",a$,0,1,null,0); a$5.addChildElement(a$7); 
//Src[/ns0:POC_016_FTP/Record/Salary]
 
 a$ = new NodeArgWrapper(9, storage); a$7=AStructureNode.createNode(1, "Salary",a$,0,1,null,0); a$5.addChildElement(a$7); 
//= const 
ms$8=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "Y");
 a$7=AStructureNode.createNode(1, "Status",a$,0,1,null,0); a$5.addChildElement(a$7); 
//= const 
ms$9=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "");
 a$7=AStructureNode.createNode(1, "Key",a$,0,1,null,1); a$3.addChildElement(a$7); 
//Src[/ns0:POC_016_FTP/Record/ID]
 
 a$ = new NodeArgWrapper(10, storage); a$5=AStructureNode.createNode(1, "CustomerID",a$,0,1,null,0); a$7.addChildElement(a$5);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/016","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_016_ st = new /*!_$ClNRep_*/_POC_016_(); st.testExecute(); }
}
