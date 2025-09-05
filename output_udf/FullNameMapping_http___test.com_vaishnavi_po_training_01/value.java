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
   IResIterator a$;
AStructureNode a$1;
IResIterator a$2;
MethodSignature  ms$;
FunctionWrapper a$3;
AStructureNode a$4;

   public /*!_$ClNRep_*/_FullNameMapping_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:InputXML", "/", "");storage.registerRequest(2, "/ns0:InputXML/root/name", "/ns0:InputXML/root", "");storage.registerRequest(3, "/ns0:InputXML/root/lastname", "/ns0:InputXML/root", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:InputXML]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:OutputXML",a$,1,1," xmlns:ns0=\"http://test.com/vaishnavi_po_training_01\"",1); root=(StructureNode)a$1; 
//Src[/ns0:InputXML/root/name]
 
 a$ = new NodeArgWrapper(2, storage); 
//Src[/ns0:InputXML/root/lastname]
 
 a$2 = new NodeArgWrapper(3, storage); 
//= concat 
ms$=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, "delimeter"}); 
a$3 = new FunctionWrapper(ms$, this);mt$prepareFunc(a$3,"com.sap.aii.mappingtool.flib7.TextFunctions", "concat", ms$); a$3.setArgument(0,a$);//<html><body><font color=gray>/ns0:InputXML/root/<font color=green><b>name</b><font color=black>;
 a$3.setArgument(1,a$2);//<html><body><font color=gray>/ns0:InputXML/root/<font color=green><b>lastname</b><font color=black>;
 
a$3.setParameter("delimeter", "    ");
 a$4=AStructureNode.createNode(1, "fullName",a$3,1,1,null,0); a$1.addChildElement(a$4);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://test.com/vaishnavi_po_training_01","ns0");
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
