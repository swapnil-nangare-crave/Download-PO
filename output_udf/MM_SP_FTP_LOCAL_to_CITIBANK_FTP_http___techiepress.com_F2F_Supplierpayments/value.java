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



 public class /*!_$ClNRep_*/_MM_SP_FTP_LOCAL_to_CITIBANK_FTP_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;
AStructureNode a$4;
IResIterator a$5;
MethodSignature  ms$;
FunctionWrapper a$6;
MethodSignature  ms$7;
MethodSignature  ms$8;

   public /*!_$ClNRep_*/_MM_SP_FTP_LOCAL_to_CITIBANK_FTP_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:MT_F2F_SOURCE", "/", "");storage.registerRequest(2, "/ns0:MT_F2F_SOURCE/Records", "/ns0:MT_F2F_SOURCE", "");storage.registerRequest(3, "/ns0:MT_F2F_SOURCE/Records/row", "/ns0:MT_F2F_SOURCE/Records", "");storage.registerRequest(4, "/ns0:MT_F2F_SOURCE/Records/row/ID", "/ns0:MT_F2F_SOURCE/Records/row", "");storage.registerRequest(5, "/ns0:MT_F2F_SOURCE/Records/row/CODE", "/ns0:MT_F2F_SOURCE/Records/row", "");storage.registerRequest(6, "/ns0:MT_F2F_SOURCE/Records/row/FIRSTNAME", "/ns0:MT_F2F_SOURCE/Records/row", "");storage.registerRequest(7, "/ns0:MT_F2F_SOURCE/Records/row/LASTNAME", "/ns0:MT_F2F_SOURCE/Records/row", "");storage.registerRequest(8, "/ns0:MT_F2F_SOURCE/Records/row/AMOUNT", "/ns0:MT_F2F_SOURCE/Records/row", "");storage.registerRequest(9, "/ns0:MT_F2F_SOURCE/Records/row/REMARKS", "/ns0:MT_F2F_SOURCE/Records/row", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:MT_F2F_SOURCE]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:MT_F2F_TARGET",a$,1,1," xmlns:ns0=\"http://techiepress.com/F2F/Supplierpayments\"",1); root=(StructureNode)a$1; 
//Src[/ns0:MT_F2F_SOURCE/Records]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "Records",a$,1,-1,null,1); a$1.addChildElement(a$2); 
//Src[/ns0:MT_F2F_SOURCE/Records/row]
 
 a$ = new NodeArgWrapper(3, storage); a$3=AStructureNode.createNode(1, "row",a$,1,-1,null,7); a$2.addChildElement(a$3); 
//Src[/ns0:MT_F2F_SOURCE/Records/row/ID]
 
 a$ = new NodeArgWrapper(4, storage); a$4=AStructureNode.createNode(1, "ID",a$,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:MT_F2F_SOURCE/Records/row/CODE]
 
 a$ = new NodeArgWrapper(5, storage); a$4=AStructureNode.createNode(1, "CODE",a$,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:MT_F2F_SOURCE/Records/row/FIRSTNAME]
 
 a$ = new NodeArgWrapper(6, storage); 
//Src[/ns0:MT_F2F_SOURCE/Records/row/LASTNAME]
 
 a$5 = new NodeArgWrapper(7, storage); 
//= concat 
ms$=new MethodSignature(new Class[]{String.class, String.class, String.class}, new String[]{null, null, "delimeter"}); 
a$6 = new FunctionWrapper(ms$, this);mt$prepareFunc(a$6,"com.sap.aii.mappingtool.flib7.TextFunctions", "concat", ms$); a$6.setArgument(0,a$);//<html><body><font color=gray>/ns0:MT_F2F_SOURCE/Records/row/<font color=green><b>FIRSTNAME</b><font color=black>;
 a$6.setArgument(1,a$5);//<html><body><font color=gray>/ns0:MT_F2F_SOURCE/Records/row/<font color=green><b>LASTNAME</b><font color=black>;
 
a$6.setParameter("delimeter", "");
 a$4=AStructureNode.createNode(1, "NAME",a$6,1,1,null,0); a$3.addChildElement(a$4); 
//= getMessageID 
ms$7=new MethodSignature(new Class[]{}, new String[]{}); 
a$6 = new FunctionWrapper(ms$7, this);mt$prepareFunc(a$6,(String)this.getClass().getName(), "getMessageID", ms$7); a$4=AStructureNode.createNode(1, "REFERENCE",a$6,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:MT_F2F_SOURCE/Records/row/AMOUNT]
 
 a$ = new NodeArgWrapper(8, storage); a$4=AStructureNode.createNode(1, "AMOUNT",a$,1,1,null,0); a$3.addChildElement(a$4); 
//= currentDate 
ms$8=new MethodSignature(new Class[]{SimpleDateFormat.class, CalendarPropertiesValue.class}, new String[]{"oform", "calend"}); 
a$5 = new com.sap.aii.mappingtool.flib7.CurDate(this); 
a$5.setParameter("oform", new SimpleDateFormat("yyyy/MM/dd"));
 
a$5.setParameter("calend", new CalendarPropertiesValue(1, 1, true));
 a$4=AStructureNode.createNode(1, "DATE",a$5,1,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:MT_F2F_SOURCE/Records/row/REMARKS]
 
 a$ = new NodeArgWrapper(9, storage); a$4=AStructureNode.createNode(1, "REMARKS",a$,1,1,null,0); a$3.addChildElement(a$4);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://techiepress.com/F2F/Supplierpayments","ns0");
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
  

  public String getMessageID(Container container) throws StreamTransformationException{
  // beginning of getMessageID 2eddc0440c864c111c4db8e70ae0b29f
String MessageID;
java.util.Map param = container.getTransformationParameters();
MessageID = (String) param.get(StreamTransformationConstants.MESSAGE_ID);
return MessageID;
  // end of getMessageID 2eddc0440c864c111c4db8e70ae0b29f
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_MM_SP_FTP_LOCAL_to_CITIBANK_FTP_ st = new /*!_$ClNRep_*/_MM_SP_FTP_LOCAL_to_CITIBANK_FTP_(); st.testExecute(); }
}
