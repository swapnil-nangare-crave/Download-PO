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



 public class /*!_$ClNRep_*/_POC_020_response_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;
AStructureNode a$4;

   public /*!_$ClNRep_*/_POC_020_response_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ns0:POC_020_API_response", "/", "");storage.registerRequest(2, "/ns0:POC_020_API_response/d", "/ns0:POC_020_API_response", "");storage.registerRequest(3, "/ns0:POC_020_API_response/d/PurchaseOrder", "/ns0:POC_020_API_response/d", "");storage.registerRequest(4, "/ns0:POC_020_API_response/d/CompanyCode", "/ns0:POC_020_API_response/d", "");storage.registerRequest(5, "/ns0:POC_020_API_response/d/PurchaseOrderType", "/ns0:POC_020_API_response/d", "");storage.registerRequest(6, "/ns0:POC_020_API_response/d/PurchasingDocumentDeletionCode", "/ns0:POC_020_API_response/d", "");storage.registerRequest(7, "/ns0:POC_020_API_response/d/PurchasingProcessingStatus", "/ns0:POC_020_API_response/d", "");storage.registerRequest(8, "/ns0:POC_020_API_response/d/Supplier", "/ns0:POC_020_API_response/d", "");storage.registerRequest(9, "/ns0:POC_020_API_response/d/PaymentTerms", "/ns0:POC_020_API_response/d", "");storage.registerRequest(10, "/ns0:POC_020_API_response/d/CashDiscount1Days", "/ns0:POC_020_API_response/d", "");storage.registerRequest(11, "/ns0:POC_020_API_response/d/CashDiscount2Days", "/ns0:POC_020_API_response/d", "");storage.registerRequest(12, "/ns0:POC_020_API_response/d/NetPaymentDays", "/ns0:POC_020_API_response/d", "");storage.registerRequest(13, "/ns0:POC_020_API_response/d/CashDiscount1Percent", "/ns0:POC_020_API_response/d", "");storage.registerRequest(14, "/ns0:POC_020_API_response/d/CashDiscount2Percent", "/ns0:POC_020_API_response/d", "");storage.registerRequest(15, "/ns0:POC_020_API_response/d/PurchasingOrganization", "/ns0:POC_020_API_response/d", "");storage.registerRequest(16, "/ns0:POC_020_API_response/d/PurchasingDocumentOrigin", "/ns0:POC_020_API_response/d", "");storage.registerRequest(17, "/ns0:POC_020_API_response/d/PurchasingGroup", "/ns0:POC_020_API_response/d", "");storage.registerRequest(18, "/ns0:POC_020_API_response/d/PurchaseOrderDate", "/ns0:POC_020_API_response/d", "");storage.registerRequest(19, "/ns0:POC_020_API_response/d/DocumentCurrency", "/ns0:POC_020_API_response/d", "");storage.registerRequest(20, "/ns0:POC_020_API_response/d/IncotermsClassification", "/ns0:POC_020_API_response/d", "");storage.registerRequest(21, "/ns0:POC_020_API_response/d/InvoicingParty", "/ns0:POC_020_API_response/d", "");storage.registerRequest(22, "/ns0:POC_020_API_response/d/AddressCityName", "/ns0:POC_020_API_response/d", "");storage.registerRequest(23, "/ns0:POC_020_API_response/d/AddressHouseNumber", "/ns0:POC_020_API_response/d", "");storage.registerRequest(24, "/ns0:POC_020_API_response/d/AddressPostalCode", "/ns0:POC_020_API_response/d", "");storage.registerRequest(25, "/ns0:POC_020_API_response/d/AddressStreetName", "/ns0:POC_020_API_response/d", "");storage.registerRequest(26, "/ns0:POC_020_API_response/d/AddressPhoneNumber", "/ns0:POC_020_API_response/d", "");storage.registerRequest(27, "/ns0:POC_020_API_response/d/AddressRegion", "/ns0:POC_020_API_response/d", "");storage.registerRequest(28, "/ns0:POC_020_API_response/d/AddressCountry", "/ns0:POC_020_API_response/d", "");storage.registerRequest(29, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem", "");storage.registerRequest(30, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PurchaseOrderItem", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(31, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PurchaseOrderItemText", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(32, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/Plant", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(33, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/OrderQuantity", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(34, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PurchaseOrderQuantityUnit", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(35, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/OrderPriceUnit", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(36, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DocumentCurrency", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(37, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/NetPriceAmount", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(38, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/NetPriceQuantity", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(39, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PriceIsToBePrinted", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(40, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/GoodsReceiptIsExpected", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(41, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/InvoiceIsExpected", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(42, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/InvoiceIsGoodsReceiptBased", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(43, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/ItemNetWeight", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(44, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/ItemWeightUnit", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(45, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/Material", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(46, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/ReferenceDeliveryAddressID", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(47, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressName", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(48, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressCityName", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(49, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressPostalCode", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(50, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressRegion", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(51, "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressCountry", "/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results", "");storage.registerRequest(52, "/ns0:POC_020_API_response/Error", "/ns0:POC_020_API_response", "");}
   protected void __CreateStructures(){ 
//Src[/ns0:POC_020_API_response]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:POC_020_response",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/020\"",2); root=(StructureNode)a$1; 
//Src[/ns0:POC_020_API_response/d]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "PurchaseOrder",a$,0,1,null,27); a$1.addChildElement(a$2); 
//Src[/ns0:POC_020_API_response/d/PurchaseOrder]
 
 a$ = new NodeArgWrapper(3, storage); a$3=AStructureNode.createNode(1, "PurchaseOrder",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/CompanyCode]
 
 a$ = new NodeArgWrapper(4, storage); a$3=AStructureNode.createNode(1, "CompanyCode",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PurchaseOrderType]
 
 a$ = new NodeArgWrapper(5, storage); a$3=AStructureNode.createNode(1, "PurchaseOrderType",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PurchasingDocumentDeletionCode]
 
 a$ = new NodeArgWrapper(6, storage); a$3=AStructureNode.createNode(1, "PurchasingDocumentDeletionCode",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PurchasingProcessingStatus]
 
 a$ = new NodeArgWrapper(7, storage); a$3=AStructureNode.createNode(1, "PurchasingProcessingStatus",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/Supplier]
 
 a$ = new NodeArgWrapper(8, storage); a$3=AStructureNode.createNode(1, "Supplier",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PaymentTerms]
 
 a$ = new NodeArgWrapper(9, storage); a$3=AStructureNode.createNode(1, "PaymentTerms",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/CashDiscount1Days]
 
 a$ = new NodeArgWrapper(10, storage); a$3=AStructureNode.createNode(1, "CashDiscount1Days",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/CashDiscount2Days]
 
 a$ = new NodeArgWrapper(11, storage); a$3=AStructureNode.createNode(1, "CashDiscount2Days",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/NetPaymentDays]
 
 a$ = new NodeArgWrapper(12, storage); a$3=AStructureNode.createNode(1, "NetPaymentDays",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/CashDiscount1Percent]
 
 a$ = new NodeArgWrapper(13, storage); a$3=AStructureNode.createNode(1, "CashDiscount1Percent",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/CashDiscount2Percent]
 
 a$ = new NodeArgWrapper(14, storage); a$3=AStructureNode.createNode(1, "CashDiscount2Percent",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PurchasingOrganization]
 
 a$ = new NodeArgWrapper(15, storage); a$3=AStructureNode.createNode(1, "PurchasingOrganization",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PurchasingDocumentOrigin]
 
 a$ = new NodeArgWrapper(16, storage); a$3=AStructureNode.createNode(1, "PurchasingDocumentOrigin",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PurchasingGroup]
 
 a$ = new NodeArgWrapper(17, storage); a$3=AStructureNode.createNode(1, "PurchasingGroup",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/PurchaseOrderDate]
 
 a$ = new NodeArgWrapper(18, storage); a$3=AStructureNode.createNode(1, "PurchaseOrderDate",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/DocumentCurrency]
 
 a$ = new NodeArgWrapper(19, storage); a$3=AStructureNode.createNode(1, "DocumentCurrency",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/IncotermsClassification]
 
 a$ = new NodeArgWrapper(20, storage); a$3=AStructureNode.createNode(1, "IncotermsClassification",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/InvoicingParty]
 
 a$ = new NodeArgWrapper(21, storage); a$3=AStructureNode.createNode(1, "InvoicingParty",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/AddressCityName]
 
 a$ = new NodeArgWrapper(22, storage); a$3=AStructureNode.createNode(1, "AddressCityName",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/AddressHouseNumber]
 
 a$ = new NodeArgWrapper(23, storage); a$3=AStructureNode.createNode(1, "AddressHouseNumber",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/AddressPostalCode]
 
 a$ = new NodeArgWrapper(24, storage); a$3=AStructureNode.createNode(1, "AddressPostalCode",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/AddressStreetName]
 
 a$ = new NodeArgWrapper(25, storage); a$3=AStructureNode.createNode(1, "AddressStreetName",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/AddressPhoneNumber]
 
 a$ = new NodeArgWrapper(26, storage); a$3=AStructureNode.createNode(1, "AddressPhoneNumber",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/AddressRegion]
 
 a$ = new NodeArgWrapper(27, storage); a$3=AStructureNode.createNode(1, "AddressRegion",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/AddressCountry]
 
 a$ = new NodeArgWrapper(28, storage); a$3=AStructureNode.createNode(1, "AddressCountry",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results]
 
 a$ = new NodeArgWrapper(29, storage); a$3=AStructureNode.createNode(1, "Items",a$,0,-1,null,22); a$2.addChildElement(a$3); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PurchaseOrderItem]
 
 a$ = new NodeArgWrapper(30, storage); a$4=AStructureNode.createNode(1, "PurchaseOrderItem",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PurchaseOrderItemText]
 
 a$ = new NodeArgWrapper(31, storage); a$4=AStructureNode.createNode(1, "PurchaseOrderItemText",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/Plant]
 
 a$ = new NodeArgWrapper(32, storage); a$4=AStructureNode.createNode(1, "Plant",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/OrderQuantity]
 
 a$ = new NodeArgWrapper(33, storage); a$4=AStructureNode.createNode(1, "OrderQuantity",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PurchaseOrderQuantityUnit]
 
 a$ = new NodeArgWrapper(34, storage); a$4=AStructureNode.createNode(1, "PurchaseOrderQuantityUnit",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/OrderPriceUnit]
 
 a$ = new NodeArgWrapper(35, storage); a$4=AStructureNode.createNode(1, "OrderPriceUnit",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DocumentCurrency]
 
 a$ = new NodeArgWrapper(36, storage); a$4=AStructureNode.createNode(1, "DocumentCurrency",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/NetPriceAmount]
 
 a$ = new NodeArgWrapper(37, storage); a$4=AStructureNode.createNode(1, "NetPriceAmount",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/NetPriceQuantity]
 
 a$ = new NodeArgWrapper(38, storage); a$4=AStructureNode.createNode(1, "NetPriceQuantity",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/PriceIsToBePrinted]
 
 a$ = new NodeArgWrapper(39, storage); a$4=AStructureNode.createNode(1, "PriceIsToBePrinted",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/GoodsReceiptIsExpected]
 
 a$ = new NodeArgWrapper(40, storage); a$4=AStructureNode.createNode(1, "GoodsReceiptIsExpected",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/InvoiceIsExpected]
 
 a$ = new NodeArgWrapper(41, storage); a$4=AStructureNode.createNode(1, "InvoiceIsExpected",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/InvoiceIsGoodsReceiptBased]
 
 a$ = new NodeArgWrapper(42, storage); a$4=AStructureNode.createNode(1, "InvoiceIsGoodsReceiptBased",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/ItemNetWeight]
 
 a$ = new NodeArgWrapper(43, storage); a$4=AStructureNode.createNode(1, "ItemNetWeight",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/ItemWeightUnit]
 
 a$ = new NodeArgWrapper(44, storage); a$4=AStructureNode.createNode(1, "ItemWeightUnit",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/Material]
 
 a$ = new NodeArgWrapper(45, storage); a$4=AStructureNode.createNode(1, "Material",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/ReferenceDeliveryAddressID]
 
 a$ = new NodeArgWrapper(46, storage); a$4=AStructureNode.createNode(1, "ReferenceDeliveryAddressID",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressName]
 
 a$ = new NodeArgWrapper(47, storage); a$4=AStructureNode.createNode(1, "DeliveryAddressName",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressCityName]
 
 a$ = new NodeArgWrapper(48, storage); a$4=AStructureNode.createNode(1, "DeliveryAddressCityName",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressPostalCode]
 
 a$ = new NodeArgWrapper(49, storage); a$4=AStructureNode.createNode(1, "DeliveryAddressPostalCode",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressRegion]
 
 a$ = new NodeArgWrapper(50, storage); a$4=AStructureNode.createNode(1, "DeliveryAddressRegion",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/d/to_PurchaseOrderItem/results/DeliveryAddressCountry]
 
 a$ = new NodeArgWrapper(51, storage); a$4=AStructureNode.createNode(1, "DeliveryAddressCountry",a$,0,1,null,0); a$3.addChildElement(a$4); 
//Src[/ns0:POC_020_API_response/Error]
 
 a$ = new NodeArgWrapper(52, storage); a$4=AStructureNode.createNode(1, "Error",a$,0,1,null,0); a$1.addChildElement(a$4);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    uris.put("http://craveinfotech.com/poc/020","ns0");
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_POC_020_response_ st = new /*!_$ClNRep_*/_POC_020_response_(); st.testExecute(); }
}
