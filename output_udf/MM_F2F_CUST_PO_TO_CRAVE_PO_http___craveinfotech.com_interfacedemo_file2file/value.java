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



 public class /*!_$ClNRep_*/_MM_F2F_CUST_PO_TO_CRAVE_PO_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
MethodSignature  ms$;
MethodSignature  ms$3;
AStructureNode a$4;

   public /*!_$ClNRep_*/_MM_F2F_CUST_PO_TO_CRAVE_PO_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:MT_F2F_CUST_PO_CREATE", "/", "");storage.registerRequest(2, "/ns0:MT_F2F_CUST_PO_CREATE/PONumber", "/ns0:MT_F2F_CUST_PO_CREATE", "");storage.registerRequest(3, "/ns0:MT_F2F_CUST_PO_CREATE/PODate", "/ns0:MT_F2F_CUST_PO_CREATE", "");storage.registerRequest(4, "/ns0:MT_F2F_CUST_PO_CREATE/CustomerName", "/ns0:MT_F2F_CUST_PO_CREATE", "");storage.registerRequest(5, "/ns0:MT_F2F_CUST_PO_CREATE/Items", "/ns0:MT_F2F_CUST_PO_CREATE", "");storage.registerRequest(6, "/ns0:MT_F2F_CUST_PO_CREATE/Items/ItemNo", "/ns0:MT_F2F_CUST_PO_CREATE/Items", "");storage.registerRequest(7, "/ns0:MT_F2F_CUST_PO_CREATE/Items/ItemName", "/ns0:MT_F2F_CUST_PO_CREATE/Items", "");storage.registerRequest(8, "/ns0:MT_F2F_CUST_PO_CREATE/Items/Qty", "/ns0:MT_F2F_CUST_PO_CREATE/Items", "");storage.registerRequest(9, "/ns0:MT_F2F_CUST_PO_CREATE/Items/Price", "/ns0:MT_F2F_CUST_PO_CREATE/Items", "");storage.registerRequest(10, "/ns0:MT_F2F_CUST_PO_CREATE/POAmount", "/ns0:MT_F2F_CUST_PO_CREATE", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:MT_F2F_CUST_PO_CREATE]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:MT_F2F_CRAVE_PO_CREATE",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/interfacedemo/file2file\"",7); root=(StructureNode)a$1; 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/PONumber]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "PONumber",a$,0,1,null,0); a$1.addChildElement(a$2); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/PODate]
 
 a$ = new NodeArgWrapper(3, storage); a$2=AStructureNode.createNode(1, "PODate",a$,0,1,null,0); a$1.addChildElement(a$2); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/CustomerName]
 
 a$ = new NodeArgWrapper(4, storage); a$2=AStructureNode.createNode(1, "CustomerName",a$,0,1,null,0); a$1.addChildElement(a$2); 
//= currentDate 
ms$=new MethodSignature(new Class[]{SimpleDateFormat.class, CalendarPropertiesValue.class}, new String[]{"oform", "calend"}); 
a$ = new com.sap.aii.mappingtool.flib7.CurDate(this); 
a$.setParameter("oform", new SimpleDateFormat("yyyy/MM/dd"));
 
a$.setParameter("calend", new CalendarPropertiesValue(1, 1, true));
 a$2=AStructureNode.createNode(1, "CreatonDate",a$,0,1,null,0); a$1.addChildElement(a$2); 
//= const 
ms$3=new MethodSignature(new Class[]{String.class}, new String[]{"value"}); 
a$ = new com.sap.aii.mappingtool.flib7.Constant(this); 
a$.setParameter("value", "Crave Infotech");
 a$2=AStructureNode.createNode(1, "FullFilledBy",a$,0,1,null,0); a$1.addChildElement(a$2); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/Items]
 
 a$ = new NodeArgWrapper(5, storage); a$2=AStructureNode.createNode(1, "Items",a$,0,1,null,4); a$1.addChildElement(a$2); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/Items/ItemNo]
 
 a$ = new NodeArgWrapper(6, storage); a$4=AStructureNode.createNode(1, "ItemNo",a$,0,1,null,0); a$2.addChildElement(a$4); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/Items/ItemName]
 
 a$ = new NodeArgWrapper(7, storage); a$4=AStructureNode.createNode(1, "ItemName",a$,0,1,null,0); a$2.addChildElement(a$4); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/Items/Qty]
 
 a$ = new NodeArgWrapper(8, storage); a$4=AStructureNode.createNode(1, "Qty",a$,0,1,null,0); a$2.addChildElement(a$4); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/Items/Price]
 
 a$ = new NodeArgWrapper(9, storage); a$4=AStructureNode.createNode(1, "Price",a$,0,1,null,0); a$2.addChildElement(a$4); 
//Src[/ns0:MT_F2F_CUST_PO_CREATE/POAmount]
 
 a$ = new NodeArgWrapper(10, storage); a$4=AStructureNode.createNode(1, "POAmount",a$,0,1,null,0); a$1.addChildElement(a$4);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/interfacedemo/file2file","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_MM_F2F_CUST_PO_TO_CRAVE_PO_ st = new /*!_$ClNRep_*/_MM_F2F_CUST_PO_TO_CRAVE_PO_(); st.testExecute(); }
}
