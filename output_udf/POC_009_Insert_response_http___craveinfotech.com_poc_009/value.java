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



 public class /*!_$ClNRep_*/_POC_009_Insert_response_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
MethodSignature  ms$;
IResIterator a$2;
MethodSignature  ms$3;
C2CFunctionWrapper a$4;
AStructureNode a$5;
MethodSignature  ms$6;
MethodSignature  ms$7;

   public /*!_$ClNRep_*/_POC_009_Insert_response_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_009_Insert_response/Insert_response", "/ns0:POC_009_Insert_response", "");storage.registerRequest(2, "/ns0:POC_009_Insert_response/Insert_response/insert_count", "/ns0:POC_009_Insert_response/Insert_response", "");storage.registerRequest(3, "/ns0:POC_009_Insert_response/Insert_response/update_count", "/ns0:POC_009_Insert_response/Insert_response", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_009_Insert_response/Insert_response]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_009_response",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/009\"",2); root=(StructureNode)a$1; 
//Src[/ns0:POC_009_Insert_response/Insert_response/insert_count]
 
 a$ = new NodeArgWrapper(2, storage); 
//= removeContexts 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{null}); 
a$2 = new com.sap.aii.mappingtool.flib7.Plainer(this); a$2.setArgument(0,a$);//<html><body><font color=gray>/ns0:POC_009_Insert_response/Insert_response/<font color=green><b>insert_count</b><font color=black>;
 
//= calculate 
ms$3=new MethodSignature(new Class[]{String[].class, ResultList.class}, new String[]{null, null}); 
a$4 = new C2CFunctionWrapper(ms$3, this);mt$prepareFunc(a$4,(String)this.getClass().getName(), "calculate", ms$3); a$4.setArgument(0,a$2);//<html><body><font color=#808000><b>removeContexts</b></font>(<html><body><font color=gray>/ns0:POC_009_Insert_response/Insert_response/<font color=green><b>insert_count</b><font color=black>);
 a$5=AStructureNode.createNode(1, "InsertCount",a$4,0,1,null,0); a$1.addChildElement(a$5); 
//Src[/ns0:POC_009_Insert_response/Insert_response/update_count]
 
 a$ = new NodeArgWrapper(3, storage); 
//= removeContexts 
ms$6=new MethodSignature(new Class[]{String.class}, new String[]{null}); 
a$2 = new com.sap.aii.mappingtool.flib7.Plainer(this); a$2.setArgument(0,a$);//<html><body><font color=gray>/ns0:POC_009_Insert_response/Insert_response/<font color=green><b>update_count</b><font color=black>;
 
//= calculate 
ms$7=new MethodSignature(new Class[]{String[].class, ResultList.class}, new String[]{null, null}); 
a$4 = new C2CFunctionWrapper(ms$7, this);mt$prepareFunc(a$4,(String)this.getClass().getName(), "calculate", ms$7); a$4.setArgument(0,a$2);//<html><body><font color=#808000><b>removeContexts</b></font>(<html><body><font color=gray>/ns0:POC_009_Insert_response/Insert_response/<font color=green><b>update_count</b><font color=black>);
 a$5=AStructureNode.createNode(1, "UpdateCount",a$4,0,1,null,0); a$1.addChildElement(a$5);}
   
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


  public String setFilename(String po, String date, Container container) throws StreamTransformationException{
  // beginning of setFilename 32e6c78701049681c7fd7d472d438623
DynamicConfiguration conf = (DynamicConfiguration) container.getTransformationParameters().get(StreamTransformationConstants.DYNAMIC_CONFIGURATION);
DynamicConfigurationKey key = DynamicConfigurationKey.create("http://sap.com/xi/XI/System/File","FileName");

String strFileName = "";
strFileName = "OC_" + po + "_" + date + ".xml";
conf.put(key, strFileName); //Set the Key-Value

DynamicConfigurationKey key2 = DynamicConfigurationKey.create("http://sap.com/xi/XI/System/File","Directory");

String strDir = "";
strDir = "/transfer/02160";
conf.put(key2, strDir); //Set the Key-Value

return "";
  // end of setFilename 32e6c78701049681c7fd7d472d438623
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_009_Insert_response_ st = new /*!_$ClNRep_*/_POC_009_Insert_response_(); st.testExecute(); }
}
