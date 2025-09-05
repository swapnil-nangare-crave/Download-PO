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



 public class /*!_$ClNRep_*/_ExchangeRates_response_ extends AMappingProgram{
   private MT$InnerLibsList libs=new MT$InnerLibsList();
   private MT$InnerParamsList params = new MT$InnerParamsList();
   IResIterator a$;
AStructureNode a$1;
AStructureNode a$2;
AStructureNode a$3;

   public /*!_$ClNRep_*/_ExchangeRates_response_(){}
   public void registerNeededValues(){storage.registerRequest(1, "/ExchangeRatesAPI_response", "/", "");storage.registerRequest(2, "/ExchangeRatesAPI_response/disclaimer", "/ExchangeRatesAPI_response", "");storage.registerRequest(3, "/ExchangeRatesAPI_response/license", "/ExchangeRatesAPI_response", "");storage.registerRequest(4, "/ExchangeRatesAPI_response/timestamp", "/ExchangeRatesAPI_response", "");storage.registerRequest(5, "/ExchangeRatesAPI_response/base", "/ExchangeRatesAPI_response", "");storage.registerRequest(6, "/ExchangeRatesAPI_response/rates", "/ExchangeRatesAPI_response", "");storage.registerRequest(7, "/ExchangeRatesAPI_response/rates/AED", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(8, "/ExchangeRatesAPI_response/rates/AFN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(9, "/ExchangeRatesAPI_response/rates/ALL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(10, "/ExchangeRatesAPI_response/rates/AMD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(11, "/ExchangeRatesAPI_response/rates/ANG", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(12, "/ExchangeRatesAPI_response/rates/AOA", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(13, "/ExchangeRatesAPI_response/rates/ARS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(14, "/ExchangeRatesAPI_response/rates/AUD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(15, "/ExchangeRatesAPI_response/rates/AWG", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(16, "/ExchangeRatesAPI_response/rates/AZN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(17, "/ExchangeRatesAPI_response/rates/BAM", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(18, "/ExchangeRatesAPI_response/rates/BBD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(19, "/ExchangeRatesAPI_response/rates/BDT", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(20, "/ExchangeRatesAPI_response/rates/BGN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(21, "/ExchangeRatesAPI_response/rates/BHD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(22, "/ExchangeRatesAPI_response/rates/BIF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(23, "/ExchangeRatesAPI_response/rates/BMD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(24, "/ExchangeRatesAPI_response/rates/BND", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(25, "/ExchangeRatesAPI_response/rates/BOB", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(26, "/ExchangeRatesAPI_response/rates/BRL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(27, "/ExchangeRatesAPI_response/rates/BSD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(28, "/ExchangeRatesAPI_response/rates/BTC", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(29, "/ExchangeRatesAPI_response/rates/BTN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(30, "/ExchangeRatesAPI_response/rates/BWP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(31, "/ExchangeRatesAPI_response/rates/BYN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(32, "/ExchangeRatesAPI_response/rates/BZD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(33, "/ExchangeRatesAPI_response/rates/CAD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(34, "/ExchangeRatesAPI_response/rates/CDF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(35, "/ExchangeRatesAPI_response/rates/CHF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(36, "/ExchangeRatesAPI_response/rates/CLF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(37, "/ExchangeRatesAPI_response/rates/CLP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(38, "/ExchangeRatesAPI_response/rates/CNH", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(39, "/ExchangeRatesAPI_response/rates/CNY", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(40, "/ExchangeRatesAPI_response/rates/COP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(41, "/ExchangeRatesAPI_response/rates/CRC", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(42, "/ExchangeRatesAPI_response/rates/CUC", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(43, "/ExchangeRatesAPI_response/rates/CUP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(44, "/ExchangeRatesAPI_response/rates/CVE", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(45, "/ExchangeRatesAPI_response/rates/CZK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(46, "/ExchangeRatesAPI_response/rates/DJF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(47, "/ExchangeRatesAPI_response/rates/DKK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(48, "/ExchangeRatesAPI_response/rates/DOP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(49, "/ExchangeRatesAPI_response/rates/DZD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(50, "/ExchangeRatesAPI_response/rates/EGP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(51, "/ExchangeRatesAPI_response/rates/ERN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(52, "/ExchangeRatesAPI_response/rates/ETB", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(53, "/ExchangeRatesAPI_response/rates/EUR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(54, "/ExchangeRatesAPI_response/rates/FJD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(55, "/ExchangeRatesAPI_response/rates/FKP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(56, "/ExchangeRatesAPI_response/rates/GBP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(57, "/ExchangeRatesAPI_response/rates/GEL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(58, "/ExchangeRatesAPI_response/rates/GGP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(59, "/ExchangeRatesAPI_response/rates/GHS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(60, "/ExchangeRatesAPI_response/rates/GIP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(61, "/ExchangeRatesAPI_response/rates/GMD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(62, "/ExchangeRatesAPI_response/rates/GNF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(63, "/ExchangeRatesAPI_response/rates/GTQ", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(64, "/ExchangeRatesAPI_response/rates/GYD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(65, "/ExchangeRatesAPI_response/rates/HKD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(66, "/ExchangeRatesAPI_response/rates/HNL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(67, "/ExchangeRatesAPI_response/rates/HRK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(68, "/ExchangeRatesAPI_response/rates/HTG", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(69, "/ExchangeRatesAPI_response/rates/HUF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(70, "/ExchangeRatesAPI_response/rates/IDR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(71, "/ExchangeRatesAPI_response/rates/ILS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(72, "/ExchangeRatesAPI_response/rates/IMP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(73, "/ExchangeRatesAPI_response/rates/INR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(74, "/ExchangeRatesAPI_response/rates/IQD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(75, "/ExchangeRatesAPI_response/rates/IRR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(76, "/ExchangeRatesAPI_response/rates/ISK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(77, "/ExchangeRatesAPI_response/rates/JEP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(78, "/ExchangeRatesAPI_response/rates/JMD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(79, "/ExchangeRatesAPI_response/rates/JOD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(80, "/ExchangeRatesAPI_response/rates/JPY", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(81, "/ExchangeRatesAPI_response/rates/KES", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(82, "/ExchangeRatesAPI_response/rates/KGS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(83, "/ExchangeRatesAPI_response/rates/KHR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(84, "/ExchangeRatesAPI_response/rates/KMF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(85, "/ExchangeRatesAPI_response/rates/KPW", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(86, "/ExchangeRatesAPI_response/rates/KRW", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(87, "/ExchangeRatesAPI_response/rates/KWD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(88, "/ExchangeRatesAPI_response/rates/KYD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(89, "/ExchangeRatesAPI_response/rates/KZT", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(90, "/ExchangeRatesAPI_response/rates/LAK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(91, "/ExchangeRatesAPI_response/rates/LBP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(92, "/ExchangeRatesAPI_response/rates/LKR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(93, "/ExchangeRatesAPI_response/rates/LRD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(94, "/ExchangeRatesAPI_response/rates/LSL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(95, "/ExchangeRatesAPI_response/rates/LYD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(96, "/ExchangeRatesAPI_response/rates/MAD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(97, "/ExchangeRatesAPI_response/rates/MDL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(98, "/ExchangeRatesAPI_response/rates/MGA", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(99, "/ExchangeRatesAPI_response/rates/MKD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(100, "/ExchangeRatesAPI_response/rates/MMK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(101, "/ExchangeRatesAPI_response/rates/MNT", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(102, "/ExchangeRatesAPI_response/rates/MOP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(103, "/ExchangeRatesAPI_response/rates/MRU", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(104, "/ExchangeRatesAPI_response/rates/MUR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(105, "/ExchangeRatesAPI_response/rates/MVR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(106, "/ExchangeRatesAPI_response/rates/MWK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(107, "/ExchangeRatesAPI_response/rates/MXN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(108, "/ExchangeRatesAPI_response/rates/MYR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(109, "/ExchangeRatesAPI_response/rates/MZN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(110, "/ExchangeRatesAPI_response/rates/NAD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(111, "/ExchangeRatesAPI_response/rates/NGN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(112, "/ExchangeRatesAPI_response/rates/NIO", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(113, "/ExchangeRatesAPI_response/rates/NOK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(114, "/ExchangeRatesAPI_response/rates/NPR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(115, "/ExchangeRatesAPI_response/rates/NZD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(116, "/ExchangeRatesAPI_response/rates/OMR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(117, "/ExchangeRatesAPI_response/rates/PAB", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(118, "/ExchangeRatesAPI_response/rates/PEN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(119, "/ExchangeRatesAPI_response/rates/PGK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(120, "/ExchangeRatesAPI_response/rates/PHP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(121, "/ExchangeRatesAPI_response/rates/PKR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(122, "/ExchangeRatesAPI_response/rates/PLN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(123, "/ExchangeRatesAPI_response/rates/PYG", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(124, "/ExchangeRatesAPI_response/rates/QAR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(125, "/ExchangeRatesAPI_response/rates/RON", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(126, "/ExchangeRatesAPI_response/rates/RSD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(127, "/ExchangeRatesAPI_response/rates/RUB", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(128, "/ExchangeRatesAPI_response/rates/RWF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(129, "/ExchangeRatesAPI_response/rates/SAR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(130, "/ExchangeRatesAPI_response/rates/SBD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(131, "/ExchangeRatesAPI_response/rates/SCR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(132, "/ExchangeRatesAPI_response/rates/SDG", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(133, "/ExchangeRatesAPI_response/rates/SEK", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(134, "/ExchangeRatesAPI_response/rates/SGD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(135, "/ExchangeRatesAPI_response/rates/SHP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(136, "/ExchangeRatesAPI_response/rates/SLL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(137, "/ExchangeRatesAPI_response/rates/SOS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(138, "/ExchangeRatesAPI_response/rates/SRD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(139, "/ExchangeRatesAPI_response/rates/SSP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(140, "/ExchangeRatesAPI_response/rates/STD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(141, "/ExchangeRatesAPI_response/rates/STN", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(142, "/ExchangeRatesAPI_response/rates/SVC", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(143, "/ExchangeRatesAPI_response/rates/SYP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(144, "/ExchangeRatesAPI_response/rates/SZL", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(145, "/ExchangeRatesAPI_response/rates/THB", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(146, "/ExchangeRatesAPI_response/rates/TJS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(147, "/ExchangeRatesAPI_response/rates/TMT", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(148, "/ExchangeRatesAPI_response/rates/TND", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(149, "/ExchangeRatesAPI_response/rates/TOP", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(150, "/ExchangeRatesAPI_response/rates/TRY", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(151, "/ExchangeRatesAPI_response/rates/TTD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(152, "/ExchangeRatesAPI_response/rates/TWD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(153, "/ExchangeRatesAPI_response/rates/TZS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(154, "/ExchangeRatesAPI_response/rates/UAH", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(155, "/ExchangeRatesAPI_response/rates/UGX", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(156, "/ExchangeRatesAPI_response/rates/USD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(157, "/ExchangeRatesAPI_response/rates/UYU", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(158, "/ExchangeRatesAPI_response/rates/UZS", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(159, "/ExchangeRatesAPI_response/rates/VES", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(160, "/ExchangeRatesAPI_response/rates/VND", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(161, "/ExchangeRatesAPI_response/rates/VUV", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(162, "/ExchangeRatesAPI_response/rates/WST", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(163, "/ExchangeRatesAPI_response/rates/XAF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(164, "/ExchangeRatesAPI_response/rates/XAG", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(165, "/ExchangeRatesAPI_response/rates/XAU", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(166, "/ExchangeRatesAPI_response/rates/XCD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(167, "/ExchangeRatesAPI_response/rates/XDR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(168, "/ExchangeRatesAPI_response/rates/XOF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(169, "/ExchangeRatesAPI_response/rates/XPD", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(170, "/ExchangeRatesAPI_response/rates/XPF", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(171, "/ExchangeRatesAPI_response/rates/XPT", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(172, "/ExchangeRatesAPI_response/rates/YER", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(173, "/ExchangeRatesAPI_response/rates/ZAR", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(174, "/ExchangeRatesAPI_response/rates/ZMW", "/ExchangeRatesAPI_response/rates", "");storage.registerRequest(175, "/ExchangeRatesAPI_response/rates/ZWL", "/ExchangeRatesAPI_response/rates", "");}
   protected void __CreateStructures(){ 
//Src[/ExchangeRatesAPI_response]
 
 a$ = new NodeArgWrapper(1, storage); a$1=AStructureNode.createNode(1, "ns0:ExchangeRates_response",a$,1,1," xmlns:ns0=\"http://craveinfotech.com/poc/019\"",5); root=(StructureNode)a$1; 
//Src[/ExchangeRatesAPI_response/disclaimer]
 
 a$ = new NodeArgWrapper(2, storage); a$2=AStructureNode.createNode(1, "disclaimer",a$,0,1,null,0); a$1.addChildElement(a$2); 
//Src[/ExchangeRatesAPI_response/license]
 
 a$ = new NodeArgWrapper(3, storage); a$2=AStructureNode.createNode(1, "license",a$,0,1,null,0); a$1.addChildElement(a$2); 
//Src[/ExchangeRatesAPI_response/timestamp]
 
 a$ = new NodeArgWrapper(4, storage); a$2=AStructureNode.createNode(1, "timestamp",a$,0,1,null,0); a$1.addChildElement(a$2); 
//Src[/ExchangeRatesAPI_response/base]
 
 a$ = new NodeArgWrapper(5, storage); a$2=AStructureNode.createNode(1, "base",a$,0,1,null,0); a$1.addChildElement(a$2); 
//Src[/ExchangeRatesAPI_response/rates]
 
 a$ = new NodeArgWrapper(6, storage); a$2=AStructureNode.createNode(1, "rates",a$,0,1,null,169); a$1.addChildElement(a$2); 
//Src[/ExchangeRatesAPI_response/rates/AED]
 
 a$ = new NodeArgWrapper(7, storage); a$3=AStructureNode.createNode(1, "AED",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/AFN]
 
 a$ = new NodeArgWrapper(8, storage); a$3=AStructureNode.createNode(1, "AFN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ALL]
 
 a$ = new NodeArgWrapper(9, storage); a$3=AStructureNode.createNode(1, "ALL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/AMD]
 
 a$ = new NodeArgWrapper(10, storage); a$3=AStructureNode.createNode(1, "AMD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ANG]
 
 a$ = new NodeArgWrapper(11, storage); a$3=AStructureNode.createNode(1, "ANG",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/AOA]
 
 a$ = new NodeArgWrapper(12, storage); a$3=AStructureNode.createNode(1, "AOA",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ARS]
 
 a$ = new NodeArgWrapper(13, storage); a$3=AStructureNode.createNode(1, "ARS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/AUD]
 
 a$ = new NodeArgWrapper(14, storage); a$3=AStructureNode.createNode(1, "AUD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/AWG]
 
 a$ = new NodeArgWrapper(15, storage); a$3=AStructureNode.createNode(1, "AWG",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/AZN]
 
 a$ = new NodeArgWrapper(16, storage); a$3=AStructureNode.createNode(1, "AZN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BAM]
 
 a$ = new NodeArgWrapper(17, storage); a$3=AStructureNode.createNode(1, "BAM",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BBD]
 
 a$ = new NodeArgWrapper(18, storage); a$3=AStructureNode.createNode(1, "BBD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BDT]
 
 a$ = new NodeArgWrapper(19, storage); a$3=AStructureNode.createNode(1, "BDT",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BGN]
 
 a$ = new NodeArgWrapper(20, storage); a$3=AStructureNode.createNode(1, "BGN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BHD]
 
 a$ = new NodeArgWrapper(21, storage); a$3=AStructureNode.createNode(1, "BHD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BIF]
 
 a$ = new NodeArgWrapper(22, storage); a$3=AStructureNode.createNode(1, "BIF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BMD]
 
 a$ = new NodeArgWrapper(23, storage); a$3=AStructureNode.createNode(1, "BMD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BND]
 
 a$ = new NodeArgWrapper(24, storage); a$3=AStructureNode.createNode(1, "BND",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BOB]
 
 a$ = new NodeArgWrapper(25, storage); a$3=AStructureNode.createNode(1, "BOB",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BRL]
 
 a$ = new NodeArgWrapper(26, storage); a$3=AStructureNode.createNode(1, "BRL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BSD]
 
 a$ = new NodeArgWrapper(27, storage); a$3=AStructureNode.createNode(1, "BSD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BTC]
 
 a$ = new NodeArgWrapper(28, storage); a$3=AStructureNode.createNode(1, "BTC",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BTN]
 
 a$ = new NodeArgWrapper(29, storage); a$3=AStructureNode.createNode(1, "BTN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BWP]
 
 a$ = new NodeArgWrapper(30, storage); a$3=AStructureNode.createNode(1, "BWP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BYN]
 
 a$ = new NodeArgWrapper(31, storage); a$3=AStructureNode.createNode(1, "BYN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/BZD]
 
 a$ = new NodeArgWrapper(32, storage); a$3=AStructureNode.createNode(1, "BZD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CAD]
 
 a$ = new NodeArgWrapper(33, storage); a$3=AStructureNode.createNode(1, "CAD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CDF]
 
 a$ = new NodeArgWrapper(34, storage); a$3=AStructureNode.createNode(1, "CDF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CHF]
 
 a$ = new NodeArgWrapper(35, storage); a$3=AStructureNode.createNode(1, "CHF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CLF]
 
 a$ = new NodeArgWrapper(36, storage); a$3=AStructureNode.createNode(1, "CLF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CLP]
 
 a$ = new NodeArgWrapper(37, storage); a$3=AStructureNode.createNode(1, "CLP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CNH]
 
 a$ = new NodeArgWrapper(38, storage); a$3=AStructureNode.createNode(1, "CNH",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CNY]
 
 a$ = new NodeArgWrapper(39, storage); a$3=AStructureNode.createNode(1, "CNY",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/COP]
 
 a$ = new NodeArgWrapper(40, storage); a$3=AStructureNode.createNode(1, "COP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CRC]
 
 a$ = new NodeArgWrapper(41, storage); a$3=AStructureNode.createNode(1, "CRC",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CUC]
 
 a$ = new NodeArgWrapper(42, storage); a$3=AStructureNode.createNode(1, "CUC",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CUP]
 
 a$ = new NodeArgWrapper(43, storage); a$3=AStructureNode.createNode(1, "CUP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CVE]
 
 a$ = new NodeArgWrapper(44, storage); a$3=AStructureNode.createNode(1, "CVE",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/CZK]
 
 a$ = new NodeArgWrapper(45, storage); a$3=AStructureNode.createNode(1, "CZK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/DJF]
 
 a$ = new NodeArgWrapper(46, storage); a$3=AStructureNode.createNode(1, "DJF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/DKK]
 
 a$ = new NodeArgWrapper(47, storage); a$3=AStructureNode.createNode(1, "DKK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/DOP]
 
 a$ = new NodeArgWrapper(48, storage); a$3=AStructureNode.createNode(1, "DOP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/DZD]
 
 a$ = new NodeArgWrapper(49, storage); a$3=AStructureNode.createNode(1, "DZD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/EGP]
 
 a$ = new NodeArgWrapper(50, storage); a$3=AStructureNode.createNode(1, "EGP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ERN]
 
 a$ = new NodeArgWrapper(51, storage); a$3=AStructureNode.createNode(1, "ERN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ETB]
 
 a$ = new NodeArgWrapper(52, storage); a$3=AStructureNode.createNode(1, "ETB",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/EUR]
 
 a$ = new NodeArgWrapper(53, storage); a$3=AStructureNode.createNode(1, "EUR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/FJD]
 
 a$ = new NodeArgWrapper(54, storage); a$3=AStructureNode.createNode(1, "FJD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/FKP]
 
 a$ = new NodeArgWrapper(55, storage); a$3=AStructureNode.createNode(1, "FKP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GBP]
 
 a$ = new NodeArgWrapper(56, storage); a$3=AStructureNode.createNode(1, "GBP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GEL]
 
 a$ = new NodeArgWrapper(57, storage); a$3=AStructureNode.createNode(1, "GEL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GGP]
 
 a$ = new NodeArgWrapper(58, storage); a$3=AStructureNode.createNode(1, "GGP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GHS]
 
 a$ = new NodeArgWrapper(59, storage); a$3=AStructureNode.createNode(1, "GHS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GIP]
 
 a$ = new NodeArgWrapper(60, storage); a$3=AStructureNode.createNode(1, "GIP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GMD]
 
 a$ = new NodeArgWrapper(61, storage); a$3=AStructureNode.createNode(1, "GMD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GNF]
 
 a$ = new NodeArgWrapper(62, storage); a$3=AStructureNode.createNode(1, "GNF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GTQ]
 
 a$ = new NodeArgWrapper(63, storage); a$3=AStructureNode.createNode(1, "GTQ",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/GYD]
 
 a$ = new NodeArgWrapper(64, storage); a$3=AStructureNode.createNode(1, "GYD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/HKD]
 
 a$ = new NodeArgWrapper(65, storage); a$3=AStructureNode.createNode(1, "HKD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/HNL]
 
 a$ = new NodeArgWrapper(66, storage); a$3=AStructureNode.createNode(1, "HNL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/HRK]
 
 a$ = new NodeArgWrapper(67, storage); a$3=AStructureNode.createNode(1, "HRK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/HTG]
 
 a$ = new NodeArgWrapper(68, storage); a$3=AStructureNode.createNode(1, "HTG",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/HUF]
 
 a$ = new NodeArgWrapper(69, storage); a$3=AStructureNode.createNode(1, "HUF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/IDR]
 
 a$ = new NodeArgWrapper(70, storage); a$3=AStructureNode.createNode(1, "IDR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ILS]
 
 a$ = new NodeArgWrapper(71, storage); a$3=AStructureNode.createNode(1, "ILS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/IMP]
 
 a$ = new NodeArgWrapper(72, storage); a$3=AStructureNode.createNode(1, "IMP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/INR]
 
 a$ = new NodeArgWrapper(73, storage); a$3=AStructureNode.createNode(1, "INR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/IQD]
 
 a$ = new NodeArgWrapper(74, storage); a$3=AStructureNode.createNode(1, "IQD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/IRR]
 
 a$ = new NodeArgWrapper(75, storage); a$3=AStructureNode.createNode(1, "IRR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ISK]
 
 a$ = new NodeArgWrapper(76, storage); a$3=AStructureNode.createNode(1, "ISK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/JEP]
 
 a$ = new NodeArgWrapper(77, storage); a$3=AStructureNode.createNode(1, "JEP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/JMD]
 
 a$ = new NodeArgWrapper(78, storage); a$3=AStructureNode.createNode(1, "JMD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/JOD]
 
 a$ = new NodeArgWrapper(79, storage); a$3=AStructureNode.createNode(1, "JOD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/JPY]
 
 a$ = new NodeArgWrapper(80, storage); a$3=AStructureNode.createNode(1, "JPY",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KES]
 
 a$ = new NodeArgWrapper(81, storage); a$3=AStructureNode.createNode(1, "KES",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KGS]
 
 a$ = new NodeArgWrapper(82, storage); a$3=AStructureNode.createNode(1, "KGS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KHR]
 
 a$ = new NodeArgWrapper(83, storage); a$3=AStructureNode.createNode(1, "KHR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KMF]
 
 a$ = new NodeArgWrapper(84, storage); a$3=AStructureNode.createNode(1, "KMF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KPW]
 
 a$ = new NodeArgWrapper(85, storage); a$3=AStructureNode.createNode(1, "KPW",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KRW]
 
 a$ = new NodeArgWrapper(86, storage); a$3=AStructureNode.createNode(1, "KRW",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KWD]
 
 a$ = new NodeArgWrapper(87, storage); a$3=AStructureNode.createNode(1, "KWD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KYD]
 
 a$ = new NodeArgWrapper(88, storage); a$3=AStructureNode.createNode(1, "KYD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/KZT]
 
 a$ = new NodeArgWrapper(89, storage); a$3=AStructureNode.createNode(1, "KZT",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/LAK]
 
 a$ = new NodeArgWrapper(90, storage); a$3=AStructureNode.createNode(1, "LAK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/LBP]
 
 a$ = new NodeArgWrapper(91, storage); a$3=AStructureNode.createNode(1, "LBP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/LKR]
 
 a$ = new NodeArgWrapper(92, storage); a$3=AStructureNode.createNode(1, "LKR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/LRD]
 
 a$ = new NodeArgWrapper(93, storage); a$3=AStructureNode.createNode(1, "LRD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/LSL]
 
 a$ = new NodeArgWrapper(94, storage); a$3=AStructureNode.createNode(1, "LSL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/LYD]
 
 a$ = new NodeArgWrapper(95, storage); a$3=AStructureNode.createNode(1, "LYD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MAD]
 
 a$ = new NodeArgWrapper(96, storage); a$3=AStructureNode.createNode(1, "MAD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MDL]
 
 a$ = new NodeArgWrapper(97, storage); a$3=AStructureNode.createNode(1, "MDL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MGA]
 
 a$ = new NodeArgWrapper(98, storage); a$3=AStructureNode.createNode(1, "MGA",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MKD]
 
 a$ = new NodeArgWrapper(99, storage); a$3=AStructureNode.createNode(1, "MKD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MMK]
 
 a$ = new NodeArgWrapper(100, storage); a$3=AStructureNode.createNode(1, "MMK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MNT]
 
 a$ = new NodeArgWrapper(101, storage); a$3=AStructureNode.createNode(1, "MNT",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MOP]
 
 a$ = new NodeArgWrapper(102, storage); a$3=AStructureNode.createNode(1, "MOP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MRU]
 
 a$ = new NodeArgWrapper(103, storage); a$3=AStructureNode.createNode(1, "MRU",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MUR]
 
 a$ = new NodeArgWrapper(104, storage); a$3=AStructureNode.createNode(1, "MUR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MVR]
 
 a$ = new NodeArgWrapper(105, storage); a$3=AStructureNode.createNode(1, "MVR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MWK]
 
 a$ = new NodeArgWrapper(106, storage); a$3=AStructureNode.createNode(1, "MWK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MXN]
 
 a$ = new NodeArgWrapper(107, storage); a$3=AStructureNode.createNode(1, "MXN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MYR]
 
 a$ = new NodeArgWrapper(108, storage); a$3=AStructureNode.createNode(1, "MYR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/MZN]
 
 a$ = new NodeArgWrapper(109, storage); a$3=AStructureNode.createNode(1, "MZN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/NAD]
 
 a$ = new NodeArgWrapper(110, storage); a$3=AStructureNode.createNode(1, "NAD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/NGN]
 
 a$ = new NodeArgWrapper(111, storage); a$3=AStructureNode.createNode(1, "NGN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/NIO]
 
 a$ = new NodeArgWrapper(112, storage); a$3=AStructureNode.createNode(1, "NIO",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/NOK]

  __CreateStructures0();}
  private void __CreateStructures0(){  
 a$ = new NodeArgWrapper(113, storage); a$3=AStructureNode.createNode(1, "NOK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/NPR]
 
 a$ = new NodeArgWrapper(114, storage); a$3=AStructureNode.createNode(1, "NPR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/NZD]
 
 a$ = new NodeArgWrapper(115, storage); a$3=AStructureNode.createNode(1, "NZD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/OMR]
 
 a$ = new NodeArgWrapper(116, storage); a$3=AStructureNode.createNode(1, "OMR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/PAB]
 
 a$ = new NodeArgWrapper(117, storage); a$3=AStructureNode.createNode(1, "PAB",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/PEN]
 
 a$ = new NodeArgWrapper(118, storage); a$3=AStructureNode.createNode(1, "PEN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/PGK]
 
 a$ = new NodeArgWrapper(119, storage); a$3=AStructureNode.createNode(1, "PGK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/PHP]
 
 a$ = new NodeArgWrapper(120, storage); a$3=AStructureNode.createNode(1, "PHP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/PKR]
 
 a$ = new NodeArgWrapper(121, storage); a$3=AStructureNode.createNode(1, "PKR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/PLN]
 
 a$ = new NodeArgWrapper(122, storage); a$3=AStructureNode.createNode(1, "PLN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/PYG]
 
 a$ = new NodeArgWrapper(123, storage); a$3=AStructureNode.createNode(1, "PYG",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/QAR]
 
 a$ = new NodeArgWrapper(124, storage); a$3=AStructureNode.createNode(1, "QAR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/RON]
 
 a$ = new NodeArgWrapper(125, storage); a$3=AStructureNode.createNode(1, "RON",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/RSD]
 
 a$ = new NodeArgWrapper(126, storage); a$3=AStructureNode.createNode(1, "RSD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/RUB]
 
 a$ = new NodeArgWrapper(127, storage); a$3=AStructureNode.createNode(1, "RUB",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/RWF]
 
 a$ = new NodeArgWrapper(128, storage); a$3=AStructureNode.createNode(1, "RWF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SAR]
 
 a$ = new NodeArgWrapper(129, storage); a$3=AStructureNode.createNode(1, "SAR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SBD]
 
 a$ = new NodeArgWrapper(130, storage); a$3=AStructureNode.createNode(1, "SBD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SCR]
 
 a$ = new NodeArgWrapper(131, storage); a$3=AStructureNode.createNode(1, "SCR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SDG]
 
 a$ = new NodeArgWrapper(132, storage); a$3=AStructureNode.createNode(1, "SDG",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SEK]
 
 a$ = new NodeArgWrapper(133, storage); a$3=AStructureNode.createNode(1, "SEK",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SGD]
 
 a$ = new NodeArgWrapper(134, storage); a$3=AStructureNode.createNode(1, "SGD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SHP]
 
 a$ = new NodeArgWrapper(135, storage); a$3=AStructureNode.createNode(1, "SHP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SLL]
 
 a$ = new NodeArgWrapper(136, storage); a$3=AStructureNode.createNode(1, "SLL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SOS]
 
 a$ = new NodeArgWrapper(137, storage); a$3=AStructureNode.createNode(1, "SOS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SRD]
 
 a$ = new NodeArgWrapper(138, storage); a$3=AStructureNode.createNode(1, "SRD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SSP]
 
 a$ = new NodeArgWrapper(139, storage); a$3=AStructureNode.createNode(1, "SSP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/STD]
 
 a$ = new NodeArgWrapper(140, storage); a$3=AStructureNode.createNode(1, "STD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/STN]
 
 a$ = new NodeArgWrapper(141, storage); a$3=AStructureNode.createNode(1, "STN",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SVC]
 
 a$ = new NodeArgWrapper(142, storage); a$3=AStructureNode.createNode(1, "SVC",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SYP]
 
 a$ = new NodeArgWrapper(143, storage); a$3=AStructureNode.createNode(1, "SYP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/SZL]
 
 a$ = new NodeArgWrapper(144, storage); a$3=AStructureNode.createNode(1, "SZL",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/THB]
 
 a$ = new NodeArgWrapper(145, storage); a$3=AStructureNode.createNode(1, "THB",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TJS]
 
 a$ = new NodeArgWrapper(146, storage); a$3=AStructureNode.createNode(1, "TJS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TMT]
 
 a$ = new NodeArgWrapper(147, storage); a$3=AStructureNode.createNode(1, "TMT",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TND]
 
 a$ = new NodeArgWrapper(148, storage); a$3=AStructureNode.createNode(1, "TND",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TOP]
 
 a$ = new NodeArgWrapper(149, storage); a$3=AStructureNode.createNode(1, "TOP",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TRY]
 
 a$ = new NodeArgWrapper(150, storage); a$3=AStructureNode.createNode(1, "TRY",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TTD]
 
 a$ = new NodeArgWrapper(151, storage); a$3=AStructureNode.createNode(1, "TTD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TWD]
 
 a$ = new NodeArgWrapper(152, storage); a$3=AStructureNode.createNode(1, "TWD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/TZS]
 
 a$ = new NodeArgWrapper(153, storage); a$3=AStructureNode.createNode(1, "TZS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/UAH]
 
 a$ = new NodeArgWrapper(154, storage); a$3=AStructureNode.createNode(1, "UAH",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/UGX]
 
 a$ = new NodeArgWrapper(155, storage); a$3=AStructureNode.createNode(1, "UGX",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/USD]
 
 a$ = new NodeArgWrapper(156, storage); a$3=AStructureNode.createNode(1, "USD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/UYU]
 
 a$ = new NodeArgWrapper(157, storage); a$3=AStructureNode.createNode(1, "UYU",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/UZS]
 
 a$ = new NodeArgWrapper(158, storage); a$3=AStructureNode.createNode(1, "UZS",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/VES]
 
 a$ = new NodeArgWrapper(159, storage); a$3=AStructureNode.createNode(1, "VES",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/VND]
 
 a$ = new NodeArgWrapper(160, storage); a$3=AStructureNode.createNode(1, "VND",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/VUV]
 
 a$ = new NodeArgWrapper(161, storage); a$3=AStructureNode.createNode(1, "VUV",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/WST]
 
 a$ = new NodeArgWrapper(162, storage); a$3=AStructureNode.createNode(1, "WST",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XAF]
 
 a$ = new NodeArgWrapper(163, storage); a$3=AStructureNode.createNode(1, "XAF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XAG]
 
 a$ = new NodeArgWrapper(164, storage); a$3=AStructureNode.createNode(1, "XAG",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XAU]
 
 a$ = new NodeArgWrapper(165, storage); a$3=AStructureNode.createNode(1, "XAU",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XCD]
 
 a$ = new NodeArgWrapper(166, storage); a$3=AStructureNode.createNode(1, "XCD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XDR]
 
 a$ = new NodeArgWrapper(167, storage); a$3=AStructureNode.createNode(1, "XDR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XOF]
 
 a$ = new NodeArgWrapper(168, storage); a$3=AStructureNode.createNode(1, "XOF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XPD]
 
 a$ = new NodeArgWrapper(169, storage); a$3=AStructureNode.createNode(1, "XPD",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XPF]
 
 a$ = new NodeArgWrapper(170, storage); a$3=AStructureNode.createNode(1, "XPF",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/XPT]
 
 a$ = new NodeArgWrapper(171, storage); a$3=AStructureNode.createNode(1, "XPT",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/YER]
 
 a$ = new NodeArgWrapper(172, storage); a$3=AStructureNode.createNode(1, "YER",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ZAR]
 
 a$ = new NodeArgWrapper(173, storage); a$3=AStructureNode.createNode(1, "ZAR",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ZMW]
 
 a$ = new NodeArgWrapper(174, storage); a$3=AStructureNode.createNode(1, "ZMW",a$,0,1,null,0); a$2.addChildElement(a$3); 
//Src[/ExchangeRatesAPI_response/rates/ZWL]
 
 a$ = new NodeArgWrapper(175, storage); a$3=AStructureNode.createNode(1, "ZWL",a$,0,1,null,0); a$2.addChildElement(a$3);}
   
   public Map getUriMappings(){
     Map uris=new HashMap();
    
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
  public static void main(String[] args) throws Exception{/*!_$ClNRep_*/_ExchangeRates_response_ st = new /*!_$ClNRep_*/_ExchangeRates_response_(); st.testExecute(); }
}
