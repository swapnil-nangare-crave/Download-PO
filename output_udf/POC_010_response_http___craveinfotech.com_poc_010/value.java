package com.sap.xi.tf;
// beginning of import 93473a7344419b15c4219cc2b6c64c6f
import com.sap.aii.mapping.api.*;
import com.sap.aii.mapping.lookup.*;
import com.sap.aii.mappingtool.tf7.rt.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

// end of import 93473a7344419b15c4219cc2b6c64c6f

import java.text.SimpleDateFormat;
import com.sap.aii.ib.bom.flib.types.CalendarPropertiesValue;
import com.sap.aii.mappingtool.tfapi.*;
import com.sap.aii.mappingtool.tf7.*;
import com.sap.aii.mappingtool.flib7.*;



 public class /*!_$ClNRep_*/_POC_010_response_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
MethodSignature  ms$;
MethodSignature  ms$2;
IResIterator a$3;
MethodSignature  ms$4;
FunctionWrapper a$5;
AStructureNode a$6;

   public /*!_$ClNRep_*/_POC_010_response_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_010", "/", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_010]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_010_response",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/010\"",1); root=(StructureNode)a$1; 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "Success!");
 
//= currentDate 
ms$2=new MethodSignature(new Class[]{SimpleDateFormat.class, CalendarPropertiesValue.class}, new String[]{"oform", "calend"}); 
a$3 = new com.sap.aii.mappingtool.flib7.CurDate(this); 
a$3.setParameter("oform", new SimpleDateFormat("MM-dd-yyyy | HH:mm:ss"));
 
a$3.setParameter("calend", new CalendarPropertiesValue(1, 1, true));
 
//= concat 
ms$4=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, "delimeter"}); 
a$5 = new FunctionWrapper(ms$4, this);mt$prepareFunc(a$5,"com.sap.aii.mappingtool.flib7.TextFunctions", "concat", ms$4); a$5.setArgument(0,a$);//<html><body><font color=#808000><b>const</b></font>(value=Success!);
 a$5.setArgument(1,a$3);//<html><body><font color=#808000><b>currentDate</b></font>(oform=MM-dd-yyyy | HH:mm:ss, calend=CalendarProperties{firstWeekDay=1, minDaysInFirstWeek=1, lenient=true});
 
a$5.setParameter("delimeter", " ");
 a$6=AStructureNode.createNode(1, "Message",a$5,0,1,null,0); a$1.addChildElement(a$6);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/010","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_010_response_ st = new /*!_$ClNRep_*/_POC_010_response_(); st.testExecute(); }
}
