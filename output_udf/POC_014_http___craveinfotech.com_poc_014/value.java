package com.sap.xi.tf;
// beginning of import 93473a7344419b15c4219cc2b6c64c6f
import com.sap.aii.mapping.api.*;
import com.sap.aii.mapping.lookup.*;
import com.sap.aii.mappingtool.tf7.rt.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

// end of import 93473a7344419b15c4219cc2b6c64c6f

import com.sap.aii.mappingtool.tf7.rt.ResultList;
import com.sap.aii.mappingtool.tfapi.*;
import com.sap.aii.mappingtool.tf7.*;
import com.sap.aii.mappingtool.flib7.*;



 public class /*!_$ClNRep_*/_POC_014_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;
MethodSignature  ms$;
IResIterator a$4;
MethodSignature  ms$5;
C2CFunctionWrapper a$6;
MethodSignature  ms$7;
Q2QFunctionWrapper a$8;

   public /*!_$ClNRep_*/_POC_014_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_014_Proxy", "/", "");storage.registerRequest(2, "/ns0:POC_014_Proxy/row", "/ns0:POC_014_Proxy", "");storage.registerRequest(3, "/ns0:POC_014_Proxy/row/Name", "/ns0:POC_014_Proxy/row", "");storage.registerRequest(4, "/ns0:POC_014_Proxy/row/Address", "/ns0:POC_014_Proxy/row", "");storage.registerRequest(5, "/ns0:POC_014_Proxy/row/Email", "/ns0:POC_014_Proxy/row", "");storage.registerRequest(6, "/ns0:POC_014_Proxy/row/Email", "/ns0:POC_014_Proxy", "");storage.registerRequest(7, "/ns0:POC_014_Proxy/row/Email", "/ns0:POC_014_Proxy/row", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_014_Proxy]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_014_FTP",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/014\"",1); root=(StructureNode)a$1; 
//Src[/ns0:POC_014_Proxy/row]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "row",a$,0,-1,null,3); a$1.addChildElement(a$2); 
//Src[/ns0:POC_014_Proxy/row/Name]
 
 a$ = new NodeArgWrapper(3, storage); a$3=AStructureNode.createNode(1, "Name",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_014_Proxy/row/Address]
 
 a$ = new NodeArgWrapper(4, storage); a$3=AStructureNode.createNode(1, "Address",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_014_Proxy/row/Email]
 
 a$ = new NodeArgWrapper(5, storage); 
//= removeContexts 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{null}); 
a$4 = new com.sap.aii.mappingtool.flib7.Plainer(this); a$4.setArgument(0,a$);//<html><body><font color=gray>/ns0:POC_014_Proxy/row/<font color=green><b>Email</b><font color=black>;
 
//= calculate 
ms$5=new MethodSignature(new Class[]{String[].class, ResultList.class}, new String[]{null, null}); 
a$6 = new C2CFunctionWrapper(ms$5, this);mt$prepareFunc(a$6,(String)this.getClass().getName(), "calculate", ms$5); a$6.setArgument(0,a$4);//<html><body><font color=#808000><b>removeContexts</b></font>(<html><body><font color=gray>/ns0:POC_014_Proxy/row/<font color=green><b>Email</b><font color=black>);
 
//Src[/ns0:POC_014_Proxy/row/Email]
 
 a$ = new NodeArgWrapper(6, storage); 
//Src[/ns0:POC_014_Proxy/row/Email]
 
 a$4 = new NodeArgWrapper(7, storage); 
//= useOneAsMany 
ms$7=new MethodSignature(new Class[]{String[].class, String[].class, String[].class, ResultList.class}, new String[]{null, null, null, null}); 
a$8 = new Q2QFunctionWrapper(ms$7, this);mt$prepareFunc(a$8,"com.sap.aii.mappingtool.flib7.NodeFunctions", "useOneAsMany", ms$7); a$8.setArgument(0,a$6);//<html><body><font color=#808000><b>calculate</b></font>(<html><body><font color=#808000><b>removeContexts</b></font>(<html><body><font color=gray>/ns0:POC_014_Proxy/row/<font color=green><b>Email</b><font color=black>), result);
 a$8.setArgument(1,a$);//<html><body><font color=gray>/<font color=maroon><b>ns0:POC_014_Proxy</b><font color=gray>/row/<font color=green><b>Email</b><font color=black>;
 a$8.setArgument(2,a$4);//<html><body><font color=gray>/ns0:POC_014_Proxy/row/<font color=green><b>Email</b><font color=black>;
 a$3=AStructureNode.createNode(1, "Email",a$8,0,1,null,0); a$2.addChildElement(a$3);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/014","ns0");
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
  

  public void calculate(String[] a, ResultList result, Container container) throws StreamTransformationException{
  // beginning of calculate e606c64557ecf4a46cee78281c5940ca
int j = 0;
for (String element : a) {
    if (element != null) {
        int k = Integer.parseInt(element);
        j += k;
    }
}
result.addValue(j);
  // end of calculate e606c64557ecf4a46cee78281c5940ca
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_014_ st = new /*!_$ClNRep_*/_POC_014_(); st.testExecute(); }
}
