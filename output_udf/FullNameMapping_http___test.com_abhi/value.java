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



 public class /*!_$ClNRep_*/_FullNameMapping_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   AStructureNode a$;
IResIterator a$1;
IResIterator a$2;
MethodSignature  ms$;
FunctionWrapper a$3;
AStructureNode a$4;

   public /*!_$ClNRep_*/_FullNameMapping_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:inputXML/root/name", "/ns0:inputXML/root", "");storage.registerRequest(2, "/ns0:inputXML/root/lastName", "/ns0:inputXML/root", "");}
   protected void __CreateStructures(){ a$=AStructureNode.createNode(1, "ns0:outputXML",new DummyIterator(this),1,1," xmlns:ns0=\"http://test.com/abhi\"",1); root=(StructureNode)a$; 
//Src[/ns0:inputXML/root/name]
 
 a$1 = new NodeArgWrapper(1, storage); 
//Src[/ns0:inputXML/root/lastName]
 
 a$2 = new NodeArgWrapper(2, storage); 
//= concat 
ms$=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, "delimeter"}); 
a$3 = new FunctionWrapper(ms$, this);mt$prepareFunc(a$3,"com.sap.aii.mappingtool.flib7.TextFunctions", "concat", ms$); a$3.setArgument(0,a$1);//<html><body><font color=gray>/ns0:inputXML/root/<font color=green><b>name</b><font color=black>;
 a$3.setArgument(1,a$2);//<html><body><font color=gray>/ns0:inputXML/root/<font color=green><b>lastName</b><font color=black>;
 
a$3.setParameter("delimeter", " ");
 a$4=AStructureNode.createNode(1, "fullName",a$3,1,1,null,0); a$.addChildElement(a$4);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://test.com/abhi","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_FullNameMapping_ st = new /*!_$ClNRep_*/_FullNameMapping_(); st.testExecute(); }
}
