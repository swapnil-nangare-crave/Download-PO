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



 public class /*!_$ClNRep_*/_POC_015_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;

   public /*!_$ClNRep_*/_POC_015_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_015_JDBC", "/", "");storage.registerRequest(2, "/ns0:POC_015_JDBC/row", "/ns0:POC_015_JDBC", "");storage.registerRequest(3, "/ns0:POC_015_JDBC/row/CustomerID", "/ns0:POC_015_JDBC/row", "");storage.registerRequest(4, "/ns0:POC_015_JDBC/row/Email", "/ns0:POC_015_JDBC/row", "");storage.registerRequest(5, "/ns0:POC_015_JDBC/row/EmpName", "/ns0:POC_015_JDBC/row", "");storage.registerRequest(6, "/ns0:POC_015_JDBC/row/Country", "/ns0:POC_015_JDBC/row", "");storage.registerRequest(7, "/ns0:POC_015_JDBC/row/Salary", "/ns0:POC_015_JDBC/row", "");storage.registerRequest(8, "/ns0:POC_015_JDBC/row/State", "/ns0:POC_015_JDBC/row", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_015_JDBC]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_015_FTP",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/015\"",1); root=(StructureNode)a$1; 
//Src[/ns0:POC_015_JDBC/row]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "Record",a$,0,-1,null,6); a$1.addChildElement(a$2); 
//Src[/ns0:POC_015_JDBC/row/CustomerID]
 
 a$ = new NodeArgWrapper(3, storage); a$3=AStructureNode.createNode(1, "ID",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_015_JDBC/row/Email]
 
 a$ = new NodeArgWrapper(4, storage); a$3=AStructureNode.createNode(1, "EmailAddress",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_015_JDBC/row/EmpName]
 
 a$ = new NodeArgWrapper(5, storage); a$3=AStructureNode.createNode(1, "Name",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_015_JDBC/row/Country]
 
 a$ = new NodeArgWrapper(6, storage); a$3=AStructureNode.createNode(1, "Country",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_015_JDBC/row/Salary]
 
 a$ = new NodeArgWrapper(7, storage); a$3=AStructureNode.createNode(1, "Salary",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_015_JDBC/row/State]
 
 a$ = new NodeArgWrapper(8, storage); a$3=AStructureNode.createNode(1, "State",a$,0,1,null,0); a$2.addChildElement(a$3);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/015","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_015_ st = new /*!_$ClNRep_*/_POC_015_(); st.testExecute(); }
}
