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
import java.text.SimpleDateFormat;
import com.sap.aii.ib.bom.flib.types.CalendarPropertiesValue;
import com.sap.aii.mappingtool.tfapi.*;
import com.sap.aii.mappingtool.tf7.*;
import com.sap.aii.mappingtool.flib7.*;



 public class /*!_$ClNRep_*/_POC_011_2_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
MethodSignature  ms$;
IResIterator a$3;
MethodSignature  ms$4;
FunctionWrapper a$5;
AStructureNode a$6;
MethodSignature  ms$7;
MethodSignature  ms$8;
C2CFunctionWrapper a$9;
MethodSignature  ms$10;
Q2QFunctionWrapper a$11;

   public /*!_$ClNRep_*/_POC_011_2_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_011", "/", "");storage.registerRequest(2, "/ns0:POC_011/row", "/ns0:POC_011", "");storage.registerRequest(3, "/ns0:POC_011/row/Address", "/ns0:POC_011/row", "");storage.registerRequest(4, "/ns0:POC_011/row/Email", "/ns0:POC_011/row", "");storage.registerRequest(5, "/ns0:POC_011/row/Name", "/ns0:POC_011/row", "");storage.registerRequest(6, "/ns0:POC_011/row/Name", "/ns0:POC_011", "");storage.registerRequest(7, "/ns0:POC_011/row/Name", "/ns0:POC_011/row", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_011]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_011",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/011\"",1); root=(StructureNode)a$1; 
//Src[/ns0:POC_011/row]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "row",a$,0,-1,null,3); a$1.addChildElement(a$2); 
//Src[/ns0:POC_011/row/Address]
 
 a$ = new NodeArgWrapper(3, storage); 
//= currentDate 
ms$=new MethodSignature(new Class[]{SimpleDateFormat.class, CalendarPropertiesValue.class}, new String[]{"oform", "calend"}); 
a$3 = new com.sap.aii.mappingtool.flib7.CurDate(this); 
a$3.setParameter("oform", new SimpleDateFormat("MM/dd/yyyy"));
 
a$3.setParameter("calend", new CalendarPropertiesValue(1, 1, true));
 
//= concat 
ms$4=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, "delimeter"}); 
a$5 = new FunctionWrapper(ms$4, this);mt$prepareFunc(a$5,"com.sap.aii.mappingtool.flib7.TextFunctions", "concat", ms$4); a$5.setArgument(0,a$);//<html><body><font color=gray>/ns0:POC_011/row/<font color=green><b>Address</b><font color=black>;
 a$5.setArgument(1,a$3);//<html><body><font color=#808000><b>currentDate</b></font>(oform=MM/dd/yyyy, calend=CalendarProperties{firstWeekDay=1, minDaysInFirstWeek=1, lenient=true});
 
a$5.setParameter("delimeter", "");
 a$6=AStructureNode.createNode(1, "Name",a$5,0,1,null,0); a$2.addChildElement(a$6); 
//Src[/ns0:POC_011/row/Email]
 
 a$ = new NodeArgWrapper(4, storage); a$6=AStructureNode.createNode(1, "Address",a$,0,1,null,0); a$2.addChildElement(a$6); 
//Src[/ns0:POC_011/row/Name]
 
 a$3 = new NodeArgWrapper(5, storage); 
//= removeContexts 
ms$7=new MethodSignature(new Class[]{String.class}, new String[]{null}); 
a$ = new com.sap.aii.mappingtool.flib7.Plainer(this); a$.setArgument(0,a$3);//<html><body><font color=gray>/ns0:POC_011/row/<font color=green><b>Name</b><font color=black>;
 
//= Calculate 
ms$8=new MethodSignature(new Class[]{String[].class, ResultList.class}, new String[]{null, null}); 
a$9 = new C2CFunctionWrapper(ms$8, this);mt$prepareFunc(a$9,libs.POC_011, "Calculate", ms$8); a$9.setArgument(0,a$);//<html><body><font color=#808000><b>removeContexts</b></font>(<html><body><font color=gray>/ns0:POC_011/row/<font color=green><b>Name</b><font color=black>);
 
//Src[/ns0:POC_011/row/Name]
 
 a$3 = new NodeArgWrapper(6, storage); 
//Src[/ns0:POC_011/row/Name]
 
 a$ = new NodeArgWrapper(7, storage); 
//= useOneAsMany 
ms$10=new MethodSignature(new Class[]{String[].class, String[].class, String[].class, ResultList.class}, new String[]{null, null, null, null}); 
a$11 = new Q2QFunctionWrapper(ms$10, this);mt$prepareFunc(a$11,"com.sap.aii.mappingtool.flib7.NodeFunctions", "useOneAsMany", ms$10); a$11.setArgument(0,a$9);//<html><body><font color=#808000><b>Calculate</b></font>(<html><body><font color=#808000><b>removeContexts</b></font>(<html><body><font color=gray>/ns0:POC_011/row/<font color=green><b>Name</b><font color=black>), result);
 a$11.setArgument(1,a$3);//<html><body><font color=gray>/<font color=maroon><b>ns0:POC_011</b><font color=gray>/row/<font color=green><b>Name</b><font color=black>;
 a$11.setArgument(2,a$);//<html><body><font color=gray>/ns0:POC_011/row/<font color=green><b>Name</b><font color=black>;
 a$6=AStructureNode.createNode(1, "Email",a$11,0,1,null,0); a$2.addChildElement(a$6);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/011","ns0");
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
         private com.craveinfotech.poc._11.Library POC_011 = new com.craveinfotech.poc._11.Library();

      private MT$InnerLibsList(){
        
      }
      private void libsinit() throws StreamTransformationException {
        init(getGlobalContainer());
POC_011.init(getGlobalContainer());

      }
      private void libscleanup() throws StreamTransformationException {
        cleanUp(getGlobalContainer());
POC_011.cleanUp(getGlobalContainer());

      }
  }
  private class MT$InnerParamsList{
      
      private MT$InnerParamsList(){
      }
      private void assignVars(){
       
      }
  }
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_011_2_ st = new /*!_$ClNRep_*/_POC_011_2_(); st.testExecute(); }
}
