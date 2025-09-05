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



 public class /*!_$ClNRep_*/_POC_004_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   AStructureNode a$;
AStructureNode a$1;
IResIterator a$2;
AStructureNode a$3;
AStructureNode a$4;
AStructureNode a$5;
AStructureNode a$6;
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

   public /*!_$ClNRep_*/_POC_004_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ORDERS05/IDOC/E1EDK14", "/ORDERS05/IDOC", "");storage.registerRequest(2, "/ORDERS05/IDOC/E1EDK14/@SEGMENT", "/ORDERS05/IDOC/E1EDK14", "");storage.registerRequest(3, "/ORDERS05/IDOC/E1EDK14/QUALF", "/ORDERS05/IDOC/E1EDK14", "");storage.registerRequest(4, "/ORDERS05/IDOC/E1EDK14/ORGID", "/ORDERS05/IDOC/E1EDK14", "");storage.registerRequest(5, "/ORDERS05/IDOC/E1EDK04", "/ORDERS05/IDOC", "");storage.registerRequest(6, "/ORDERS05/IDOC/E1EDK04/@SEGMENT", "/ORDERS05/IDOC/E1EDK04", "");storage.registerRequest(7, "/ORDERS05/IDOC/E1EDK04/MWSKZ", "/ORDERS05/IDOC/E1EDK04", "");storage.registerRequest(8, "/ORDERS05/IDOC/E1EDK04/MSATZ", "/ORDERS05/IDOC/E1EDK04", "");storage.registerRequest(9, "/ORDERS05/IDOC/E1EDK04/MWSBT", "/ORDERS05/IDOC/E1EDK04", "");storage.registerRequest(10, "/ORDERS05/IDOC/E1EDK04/TXJCD", "/ORDERS05/IDOC/E1EDK04", "");storage.registerRequest(11, "/ORDERS05/IDOC/E1EDK04/KTEXT", "/ORDERS05/IDOC/E1EDK04", "");}
   protected void __CreateStructures(){ a$=AStructureNode.createNode(1, "ORDERS05",new DummyIterator(this),1,1,null,1); root=(StructureNode)a$; a$1=AStructureNode.createNode(1, "IDOC",new DummyIterator(this),1,1,null,19); a$.addChildElement(a$1); 
//Src[/ORDERS05/IDOC/E1EDK14]
 
 a$2 = new NodeArgWrapper(1, storage); a$3=AStructureNode.createNode(1, "E1EDK14",a$2,0,12,null,3); a$1.addChildElement(a$3); 
//Src[/ORDERS05/IDOC/E1EDK14/@SEGMENT]
 
 a$2 = new NodeArgWrapper(2, storage); a$4=AStructureNode.createNode(3, "SEGMENT",a$2,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/ORDERS05/IDOC/E1EDK14/QUALF]
 
 a$2 = new NodeArgWrapper(3, storage); a$4=AStructureNode.createNode(1, "QUALF",a$2,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ORDERS05/IDOC/E1EDK14/ORGID]
 
 a$2 = new NodeArgWrapper(4, storage); a$4=AStructureNode.createNode(1, "ORGID",a$2,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ORDERS05/IDOC/E1EDK04]
 
 a$2 = new NodeArgWrapper(5, storage); a$3=AStructureNode.createNode(1, "E1EDK04",a$2,0,10,null,6); a$1.addChildElement(a$3); 
//Src[/ORDERS05/IDOC/E1EDK04/@SEGMENT]
 
 a$2 = new NodeArgWrapper(6, storage); a$5=AStructureNode.createNode(3, "SEGMENT",a$2,1,1,null,0); a$3.addChildElement(a$5); 
//Src[/ORDERS05/IDOC/E1EDK04/MWSKZ]
 
 a$2 = new NodeArgWrapper(7, storage); a$5=AStructureNode.createNode(1, "MWSKZ",a$2,0,1,null,0); a$3.addChildElement(a$5); 
//Src[/ORDERS05/IDOC/E1EDK04/MSATZ]
 
 a$2 = new NodeArgWrapper(8, storage); a$5=AStructureNode.createNode(1, "MSATZ",a$2,0,1,null,0); a$3.addChildElement(a$5); 
//Src[/ORDERS05/IDOC/E1EDK04/MWSBT]
 
 a$2 = new NodeArgWrapper(9, storage); a$5=AStructureNode.createNode(1, "MWSBT",a$2,0,1,null,0); a$3.addChildElement(a$5); 
//Src[/ORDERS05/IDOC/E1EDK04/TXJCD]
 
 a$2 = new NodeArgWrapper(10, storage); a$5=AStructureNode.createNode(1, "TXJCD",a$2,0,1,null,0); a$3.addChildElement(a$5); 
//Src[/ORDERS05/IDOC/E1EDK04/KTEXT]
 
 a$2 = new NodeArgWrapper(11, storage); a$5=AStructureNode.createNode(1, "KTEXT",a$2,0,1,null,0); a$3.addChildElement(a$5);}
   
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_004_ st = new /*!_$ClNRep_*/_POC_004_(); st.testExecute(); }
}
