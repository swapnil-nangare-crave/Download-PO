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



 public class /*!_$ClNRep_*/_POC_006_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   MethodSignature  ms$;
IResIterator a$;
AStructureNode a$1;
MethodSignature  ms$2;
AStructureNode a$3;
MethodSignature  ms$4;
AStructureNode a$5;
MethodSignature  ms$6;
MethodSignature  ms$7;
AStructureNode a$8;
MethodSignature  ms$9;
AStructureNode a$10;
AStructureNode a$11;
AStructureNode a$12;
MethodSignature  ms$13;
AStructureNode a$14;
AStructureNode a$15;
AStructureNode a$16;
MethodSignature  ms$17;
AStructureNode a$18;
MethodSignature  ms$19;
AStructureNode a$20;
AStructureNode a$21;
AStructureNode a$22;
AStructureNode a$23;
AStructureNode a$24;
MethodSignature  ms$25;
AStructureNode a$26;
MethodSignature  ms$27;
MethodSignature  ms$28;
AStructureNode a$29;
AStructureNode a$30;
MethodSignature  ms$31;
AStructureNode a$32;
MethodSignature  ms$33;
MethodSignature  ms$34;
AStructureNode a$35;
AStructureNode a$36;
AStructureNode a$37;
AStructureNode a$38;
AStructureNode a$39;
AStructureNode a$40;
AStructureNode a$41;
AStructureNode a$42;
AStructureNode a$43;
MethodSignature  ms$44;
MethodSignature  ms$45;
AStructureNode a$46;
MethodSignature  ms$47;
MethodSignature  ms$48;
AStructureNode a$49;
AStructureNode a$50;
AStructureNode a$51;
AStructureNode a$52;
AStructureNode a$53;
AStructureNode a$54;
AStructureNode a$55;
AStructureNode a$56;
AStructureNode a$57;
AStructureNode a$58;
AStructureNode a$59;
AStructureNode a$60;
AStructureNode a$61;
AStructureNode a$62;
AStructureNode a$63;
AStructureNode a$64;
AStructureNode a$65;
AStructureNode a$66;
AStructureNode a$67;
AStructureNode a$68;
AStructureNode a$69;
AStructureNode a$70;
AStructureNode a$71;
AStructureNode a$72;
AStructureNode a$73;
AStructureNode a$74;
AStructureNode a$75;
MethodSignature  ms$76;
AStructureNode a$77;
MethodSignature  ms$78;
AStructureNode a$79;

   public /*!_$ClNRep_*/_POC_006_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_006/Record/DeliveryNo", "/ns0:POC_006/Record", "");storage.registerRequest(2, "/ns0:POC_006/Record/DeliveryNo", "/ns0:POC_006/Record", "");storage.registerRequest(3, "/ns0:POC_006/Record", "/ns0:POC_006", "");storage.registerRequest(4, "/ns0:POC_006/Record/OrderNo", "/ns0:POC_006/Record", "");storage.registerRequest(5, "/ns0:POC_006/Record/airway", "/ns0:POC_006/Record", "");storage.registerRequest(6, "/ns0:POC_006/Record/Url", "/ns0:POC_006/Record", "");}
   protected void __CreateStructures(){ 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "");
 a$1=AStructureNode.createNode(1, "SHP_OBDLV_CHANGE02",a$,1,1,null,1); root=(StructureNode)a$1; 
//= const 
ms$2=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "");
 a$3=AStructureNode.createNode(1, "IDOC",a$,1,1,null,4); a$1.addChildElement(a$3); 
//= const 
ms$4=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "1");
 a$5=AStructureNode.createNode(3, "BEGIN",a$,1,1,null,0); a$3.addChildElement(a$5); 
//= const 
ms$6=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "");
 a$5=AStructureNode.createNode(1, "EDI_DC40",a$,1,1,null,37); a$3.addChildElement(a$5); 
//= const 
ms$7=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "1");
 a$8=AStructureNode.createNode(3, "SEGMENT",a$,1,1,null,0); a$5.addChildElement(a$8); 
//= const 
ms$9=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "EDI_DC40");
 a$8=AStructureNode.createNode(1, "TABNAM",a$,1,1,null,0); a$5.addChildElement(a$8); 
//= const 
ms$13=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "2");
 a$14=AStructureNode.createNode(1, "DIRECT",a$,1,1,null,0); a$5.addChildElement(a$14); 
//= const 
ms$17=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "SHP_OBDLV_CHANGE02");
 a$18=AStructureNode.createNode(1, "IDOCTYP",a$,1,1,null,0); a$5.addChildElement(a$18); 
//= const 
ms$19=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "SHP_OBDLV_CHANGE");
 a$20=AStructureNode.createNode(1, "MESTYP",a$,1,1,null,0); a$5.addChildElement(a$20); 
//= const 
ms$25=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "A000000016");
 a$26=AStructureNode.createNode(1, "SNDPOR",a$,1,1,null,0); a$5.addChildElement(a$26); 
//= const 
ms$27=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "LS");
 a$26=AStructureNode.createNode(1, "SNDPRT",a$,1,1,null,0); a$5.addChildElement(a$26); 
//= const 
ms$28=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "SPOCLNT300");
 a$29=AStructureNode.createNode(1, "SNDPRN",a$,1,1,null,0); a$5.addChildElement(a$29); 
//= const 
ms$31=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "SAPCS4");
 a$32=AStructureNode.createNode(1, "RCVPOR",a$,1,1,null,0); a$5.addChildElement(a$32); 
//= const 
ms$33=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "LS");
 a$32=AStructureNode.createNode(1, "RCVPRT",a$,0,1,null,0); a$5.addChildElement(a$32); 
//= const 
ms$34=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "CS4CLNT300");
 a$35=AStructureNode.createNode(1, "RCVPRN",a$,1,1,null,0); a$5.addChildElement(a$35); 
//= const 
ms$44=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "");
 a$5=AStructureNode.createNode(1, "E1SHP_OBDLV_CHANGE",a$,0,1,null,16); a$3.addChildElement(a$5); 
//= const 
ms$45=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "1");
 a$46=AStructureNode.createNode(3, "SEGMENT",a$,1,1,null,0); a$5.addChildElement(a$46); 
//Src[/ns0:POC_006/Record/DeliveryNo]
 
 a$ = new NodeArgWrapper(1, storage); a$46=AStructureNode.createNode(1, "DELIVERY",a$,0,1,null,0); a$5.addChildElement(a$46); 
//= const 
ms$47=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "");
 a$46=AStructureNode.createNode(1, "E1BPOBDLVHDRCHG",a$,0,1,null,20); a$5.addChildElement(a$46); 
//= const 
ms$48=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "1");
 a$49=AStructureNode.createNode(3, "SEGMENT",a$,1,1,null,0); a$46.addChildElement(a$49); 
//Src[/ns0:POC_006/Record/DeliveryNo]
 
 a$ = new NodeArgWrapper(2, storage); a$49=AStructureNode.createNode(1, "DELIV_NUMB",a$,0,1,null,0); a$46.addChildElement(a$49); 
//Src[/ns0:POC_006/Record]
 
 a$ = new NodeArgWrapper(3, storage); a$75=AStructureNode.createNode(1, "E1BPEXTC",a$,0,999999999,null,5); a$5.addChildElement(a$75); 
//= const 
ms$76=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "1");
 a$77=AStructureNode.createNode(3, "SEGMENT",a$,1,1,null,0); a$75.addChildElement(a$77); 
//Src[/ns0:POC_006/Record/OrderNo]
 
 a$ = new NodeArgWrapper(4, storage); a$77=AStructureNode.createNode(1, "FIELD1",a$,0,1,null,0); a$75.addChildElement(a$77); 
//Src[/ns0:POC_006/Record/airway]
 
 a$ = new NodeArgWrapper(5, storage); a$77=AStructureNode.createNode(1, "FIELD2",a$,0,1,null,0); a$75.addChildElement(a$77); 
//Src[/ns0:POC_006/Record/Url]
 
 a$ = new NodeArgWrapper(6, storage); a$77=AStructureNode.createNode(1, "FIELD3",a$,0,1,null,0); a$75.addChildElement(a$77); 
//= const 
ms$78=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "123");
 a$77=AStructureNode.createNode(1, "FIELD4",a$,0,1,null,0); a$75.addChildElement(a$77);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/006","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_006_ st = new /*!_$ClNRep_*/_POC_006_(); st.testExecute(); }
}
