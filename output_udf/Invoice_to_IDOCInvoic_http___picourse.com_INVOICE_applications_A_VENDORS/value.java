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



 public class /*!_$ClNRep_*/_Invoice_to_IDOCInvoic_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   AStructureNode a$;
AStructureNode a$1;
MethodSignature  ms$;
IResIterator a$2;
AStructureNode a$3;
MethodSignature  ms$4;
AStructureNode a$5;
MethodSignature  ms$6;
MethodSignature  ms$7;
MethodSignature  ms$8;
MethodSignature  ms$9;
MethodSignature  ms$10;
MethodSignature  ms$11;
MethodSignature  ms$12;
MethodSignature  ms$13;
AStructureNode a$14;
MethodSignature  ms$15;
MethodSignature  ms$16;
AStructureNode a$17;
MethodSignature  ms$18;
MethodSignature  ms$19;
C2CFunctionWrapper a$20;

   public /*!_$ClNRep_*/_Invoice_to_IDOCInvoic_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:Invoice/Date", "/ns0:Invoice", "");storage.registerRequest(2, "/ns0:Invoice/CustomerParty", "/ns0:Invoice", "");storage.registerRequest(3, "/ns0:Invoice/CustomerParty/Id", "/ns0:Invoice/CustomerParty", "");storage.registerRequest(4, "/ns0:Invoice/CustomerParty/Name", "/ns0:Invoice/CustomerParty", "");storage.registerRequest(5, "/ns0:Invoice/SellerParty/Id", "/ns0:Invoice/SellerParty", "");storage.registerRequest(6, "/ns0:Invoice/SellerParty/Name", "/ns0:Invoice/SellerParty", "");storage.registerRequest(7, "/ns0:Invoice/Line", "/ns0:Invoice", "");storage.registerRequest(8, "/ns0:Invoice/Line/No", "/ns0:Invoice/Line", "");storage.registerRequest(9, "/ns0:Invoice/Line/Quantity", "/ns0:Invoice/Line", "");storage.registerRequest(10, "/ns0:Invoice/Line/Quantity/@unit", "/ns0:Invoice/Line/Quantity", "");storage.registerRequest(11, "/ns0:Invoice/Line/Price", "/ns0:Invoice/Line", "");storage.registerRequest(12, "/ns0:Invoice/Line/Price", "/ns0:Invoice", "");storage.registerRequest(13, "/ns0:Invoice/Total/VAT", "/ns0:Invoice/Total", "");storage.registerRequest(14, "/ns0:Invoice/Line/Price/@currency", "/ns0:Invoice/Line/Price", "");}
   protected void __CreateStructures(){ a$=AStructureNode.createNode(1, "INVOIC02",new DummyIterator(this),1,1,null,1); root=(StructureNode)a$; a$1=AStructureNode.createNode(1, "IDOC",new DummyIterator(this),1,1,null,7); a$.addChildElement(a$1); 
//= const 
ms$=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "1");
 a$3=AStructureNode.createNode(3, "BEGIN",a$2,1,1,null,0); a$1.addChildElement(a$3); a$3=AStructureNode.createNode(1, "E1EDK01",new DummyIterator(this),1,1,null,3); a$1.addChildElement(a$3); 
//= const 
ms$4=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "1");
 a$5=AStructureNode.createNode(3, "SEGMENT",a$2,1,1,null,0); a$3.addChildElement(a$5); 
//= const 
ms$6=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "Missing");
 a$5=AStructureNode.createNode(1, "BELNR",a$2,1,1,null,0); a$3.addChildElement(a$5); 
//Src[/ns0:Invoice/Date]
 
 a$2 = new NodeArgWrapper(1, storage); a$5=AStructureNode.createNode(1, "DATUM",a$2,1,1,null,0); a$3.addChildElement(a$5); a$5=AStructureNode.createNode(1, "E1EDK03",new DummyIterator(this),1,1,null,3); a$1.addChildElement(a$5); 
//= const 
ms$7=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "1");
 a$3=AStructureNode.createNode(3, "SEGMENT",a$2,1,1,null,0); a$5.addChildElement(a$3); 
//= const 
ms$8=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "001");
 a$3=AStructureNode.createNode(1, "QUALI",a$2,1,1,null,0); a$5.addChildElement(a$3); 
//= currentDate 
ms$9=new MethodSignature(new Class[]{SimpleDateFormat.class, CalendarPropertiesValue.class}, new String[]{"oform", "calend"}); 
a$2 = new com.sap.aii.mappingtool.flib7.CurDate(this); 
a$2.setParameter("oform", new SimpleDateFormat("yyyyMMdd"));
 
a$2.setParameter("calend", new CalendarPropertiesValue(1, 1, true));
 a$3=AStructureNode.createNode(1, "DATUM",a$2,1,1,null,0); a$5.addChildElement(a$3); 
//Src[/ns0:Invoice/CustomerParty]
 
 a$2 = new NodeArgWrapper(2, storage); a$3=AStructureNode.createNode(1, "E1EDKA1",a$2,1,-1,null,4); a$1.addChildElement(a$3); 
//= const 
ms$10=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "1");
 a$5=AStructureNode.createNode(3, "SEGMENT",a$2,1,1,null,0); a$3.addChildElement(a$5); 
//= const 
ms$11=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "AG");
 a$5=AStructureNode.createNode(1, "PARAW",a$2,1,1,null,0); a$3.addChildElement(a$5); 
//Src[/ns0:Invoice/CustomerParty/Id]
 
 a$2 = new NodeArgWrapper(3, storage); a$5=AStructureNode.createNode(1, "PARTNER",a$2,1,1,null,0); a$3.addChildElement(a$5); 
//Src[/ns0:Invoice/CustomerParty/Name]
 
 a$2 = new NodeArgWrapper(4, storage); a$5=AStructureNode.createNode(1, "NAME1",a$2,1,1,null,0); a$3.addChildElement(a$5); 
//= const 
ms$12=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "Constant");
 a$5=AStructureNode.createNode(1, "E1EDKA1",a$2,1,-1,null,4); a$1.addChildElement(a$5); 
//= const 
ms$13=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "1");
 a$14=AStructureNode.createNode(3, "SEGMENT",a$2,1,1,null,0); a$5.addChildElement(a$14); 
//= const 
ms$15=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "LF");
 a$14=AStructureNode.createNode(1, "PARAW",a$2,1,1,null,0); a$5.addChildElement(a$14); 
//Src[/ns0:Invoice/SellerParty/Id]
 
 a$2 = new NodeArgWrapper(5, storage); a$14=AStructureNode.createNode(1, "PARTNER",a$2,1,1,null,0); a$5.addChildElement(a$14); 
//Src[/ns0:Invoice/SellerParty/Name]
 
 a$2 = new NodeArgWrapper(6, storage); a$14=AStructureNode.createNode(1, "NAME1",a$2,1,1,null,0); a$5.addChildElement(a$14); a$3.setNextDuplicated(a$5); 
//Src[/ns0:Invoice/Line]
 
 a$2 = new NodeArgWrapper(7, storage); a$14=AStructureNode.createNode(1, "E1EDP01",a$2,1,-1,null,6); a$1.addChildElement(a$14); 
//= const 
ms$16=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "1");
 a$17=AStructureNode.createNode(3, "SEGMENT",a$2,1,1,null,0); a$14.addChildElement(a$17); 
//Src[/ns0:Invoice/Line/No]
 
 a$2 = new NodeArgWrapper(8, storage); a$17=AStructureNode.createNode(1, "POSEX",a$2,1,1,null,0); a$14.addChildElement(a$17); 
//Src[/ns0:Invoice/Line/Quantity]
 
 a$2 = new NodeArgWrapper(9, storage); a$17=AStructureNode.createNode(1, "MENGE",a$2,1,1,null,0); a$14.addChildElement(a$17); 
//Src[/ns0:Invoice/Line/Quantity/@unit]
 
 a$2 = new NodeArgWrapper(10, storage); a$17=AStructureNode.createNode(1, "UNIT",a$2,1,1,null,0); a$14.addChildElement(a$17); 
//Src[/ns0:Invoice/Line/Price]
 
 a$2 = new NodeArgWrapper(11, storage); a$17=AStructureNode.createNode(1, "VPREI",a$2,1,1,null,0); a$14.addChildElement(a$17); 
//= const 
ms$18=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$2 = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$2.setParameter("value", "Constant");
 a$17=AStructureNode.createNode(1, "E1EDS01",a$2,1,-1,null,3); a$1.addChildElement(a$17); 
//Src[/ns0:Invoice/Line/Price]
 
 a$2 = new NodeArgWrapper(12, storage); 
//= sum 
ms$19=new MethodSignature(new Class[]{String[].class, ResultList.class}, new String[]{null, null}); 
a$20 = new C2CFunctionWrapper(ms$19, this);mt$prepareFunc(a$20,"com.sap.aii.mappingtool.flib7.Stat", "sum", ms$19); a$20.setArgument(0,a$2);//<html><body><font color=gray>/<font color=maroon><b>ns0:Invoice</b><font color=gray>/Line/<font color=green><b>Price</b><font color=black>;
 a$14=AStructureNode.createNode(1, "SUMME",a$20,1,1,null,0); a$17.addChildElement(a$14); 
//Src[/ns0:Invoice/Total/VAT]
 
 a$2 = new NodeArgWrapper(13, storage); a$14=AStructureNode.createNode(1, "SUMIT",a$2,1,1,null,0); a$17.addChildElement(a$14); 
//Src[/ns0:Invoice/Line/Price/@currency]
 
 a$2 = new NodeArgWrapper(14, storage); a$14=AStructureNode.createNode(1, "CURENCY",a$2,1,1,null,0); a$17.addChildElement(a$14);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://picourse.com/module1","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_Invoice_to_IDOCInvoic_ st = new /*!_$ClNRep_*/_Invoice_to_IDOCInvoic_(); st.testExecute(); }
}
