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



 public class /*Copy*//*!_$ClNRep_*/_POC_005_response_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   AStructureNode a$;
IResIterator a$1;
AStructureNode a$2;
AStructureNode a$3;

   public /*Copy*//*!_$ClNRep_*/_POC_005_response_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:BAPI_PO_GETDETAIL.Response", "/", "");storage.registerXmlRequest(2, "/ns0:BAPI_PO_GETDETAIL.Response/PO_HEADER", "/ns0:BAPI_PO_GETDETAIL.Response", "");storage.registerXmlRequest(3, "/ns0:BAPI_PO_GETDETAIL.Response/PO_ITEMS/item", "/ns0:BAPI_PO_GETDETAIL.Response/PO_ITEMS", "");}
   protected void __CreateStructures(){ a$=AStructureNode.createNode(1, "ns1:POC_005_response",new DummyIterator(this),1,1," xmlns:ns1=\"http://craveinfotech.com/poc/005\"",1); root=(StructureNode)a$; 
//Src[/ns0:BAPI_PO_GETDETAIL.Response]
 
 a$1 = new NodeArgWrapper(1, storage); a$2=AStructureNode.createNode(1, "Response",a$1,0,1,null,2); a$.addChildElement(a$2); 
//Src[/ns0:BAPI_PO_GETDETAIL.Response/PO_HEADER]
 
 a$1 = new NodeArgWrapper(2, storage); a$3=AStructureNode.createNode(1, "Header",a$1,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:BAPI_PO_GETDETAIL.Response/PO_ITEMS/item]
 
 a$1 = new NodeArgWrapper(3, storage); a$3=AStructureNode.createNode(1, "Items",a$1,0,-1,null,0); a$2.addChildElement(a$3);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("urn:sap-com:document:sap:rfc:functions","ns0");
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
  public static void main(String[] args) throws Exception{/*Copy*//*!_$ClNRep_*/_POC_005_response_ st = new /*Copy*//*!_$ClNRep_*/_POC_005_response_(); st.testExecute(); }
}
