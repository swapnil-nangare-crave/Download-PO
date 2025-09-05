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



 public class /*!_$ClNRep_*/_POC_009_Select_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   AStructureNode a$;
AStructureNode a$1;
AStructureNode a$2;
MethodSignature  ms$;
IResIterator a$3;
AStructureNode a$4;
MethodSignature  ms$5;

   public /*!_$ClNRep_*/_POC_009_Select_(){}
   public void registerNeededValues(){}
   protected void __CreateStructures(){ a$=AStructureNode.createNode(1, "ns0:POC_009_Select",new DummyIterator(this),1,1," xmlns:ns0=\"http://craveinfotech.com/poc/009\"",1); root=(StructureNode)a$; a$1=AStructureNode.createNode(1, "Select",new DummyIterator(this),1,1,null,1); a$.addChildElement(a$1); a$2=AStructureNode.createNode(1, "Customers",new DummyIterator(this),1,1,null,2); a$1.addChildElement(a$2); 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$3 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$3.setParameter("value", "SQL_QUERY");
 a$4=AStructureNode.createNode(3, "action",a$3,1,1,null,0); a$2.addChildElement(a$4); 
//= const 
ms$5=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$3 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$3.setParameter("value", "SELECT * FROM dbo.POC009");
 a$4=AStructureNode.createNode(1, "access",a$3,1,1,null,0); a$2.addChildElement(a$4);}
   
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_009_Select_ st = new /*!_$ClNRep_*/_POC_009_Select_(); st.testExecute(); }
}
