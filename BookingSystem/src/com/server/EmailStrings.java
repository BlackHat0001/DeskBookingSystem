package com.server;

public class EmailStrings {
	
	public static String booking(String type, String officeName, String seats, String hour, String min, String additional1, String hourend, String minend, String additional2, String notes, String output) {
		if(type.equals("simple")) {
			return "Thank you for your booking. Your details are below: \n" + 
		    		"        Office: "+officeName+"\n" + 
		    		"        Date: "+seats+"\n" + 
		    		"        Number of Seats: "+seats+"\n" + 
		    		"        Time: "+hour+":"+min+""+additional1+" - "+hourend+":"+minend+""+additional2+"\n" + 
		    		"        Reason for office visit: "+notes+"\n" + 
		    		"        \n" + 
		    		"        "+output+"\n";
		} 
		return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><!--[if IE]><html xmlns=\"http://www.w3.org/1999/xhtml\" class=\"ie\"><![endif]--><!--[if !IE]><!--><html style=\"margin: 0;padding: 0;\" xmlns=\"http://www.w3.org/1999/xhtml\"><!--<![endif]--><head>\r\n" + 
	    		"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
	    		"    <title></title>\r\n" + 
	    		"    <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /><!--<![endif]-->\r\n" + 
	    		"    <meta name=\"viewport\" content=\"width=device-width\" /><style type=\"text/css\">\r\n" + 
	    		"@media only screen and (min-width: 620px){.wrapper{min-width:600px !important}.wrapper h1{}.wrapper h1{font-size:64px !important;line-height:63px !important}.wrapper h2{}.wrapper h2{font-size:30px !important;line-height:38px !important}.wrapper h3{}.wrapper h3{font-size:22px !important;line-height:31px !important}.column{}.wrapper .size-8{font-size:8px !important;line-height:14px !important}.wrapper .size-9{font-size:9px !important;line-height:16px !important}.wrapper .size-10{font-size:10px !important;line-height:18px !important}.wrapper .size-11{font-size:11px !important;line-height:19px !important}.wrapper .size-12{font-size:12px !important;line-height:19px !important}.wrapper .size-13{font-size:13px !important;line-height:21px !important}.wrapper .size-14{font-size:14px !important;line-height:21px !important}.wrapper .size-15{font-size:15px !important;line-height:23px \r\n" + 
	    		"!important}.wrapper .size-16{font-size:16px !important;line-height:24px !important}.wrapper .size-17{font-size:17px !important;line-height:26px !important}.wrapper .size-18{font-size:18px !important;line-height:26px !important}.wrapper .size-20{font-size:20px !important;line-height:28px !important}.wrapper .size-22{font-size:22px !important;line-height:31px !important}.wrapper .size-24{font-size:24px !important;line-height:32px !important}.wrapper .size-26{font-size:26px !important;line-height:34px !important}.wrapper .size-28{font-size:28px !important;line-height:36px !important}.wrapper .size-30{font-size:30px !important;line-height:38px !important}.wrapper .size-32{font-size:32px !important;line-height:40px !important}.wrapper .size-34{font-size:34px !important;line-height:43px !important}.wrapper .size-36{font-size:36px !important;line-height:43px !important}.wrapper \r\n" + 
	    		".size-40{font-size:40px !important;line-height:47px !important}.wrapper .size-44{font-size:44px !important;line-height:50px !important}.wrapper .size-48{font-size:48px !important;line-height:54px !important}.wrapper .size-56{font-size:56px !important;line-height:60px !important}.wrapper .size-64{font-size:64px !important;line-height:63px !important}}\r\n" + 
	    		"</style>\r\n" + 
	    		"    <meta name=\"x-apple-disable-message-reformatting\" />\r\n" + 
	    		"    <style type=\"text/css\">\r\n" + 
	    		"body {\r\n" + 
	    		"  margin: 0;\r\n" + 
	    		"  padding: 0;\r\n" + 
	    		"}\r\n" + 
	    		"table {\r\n" + 
	    		"  border-collapse: collapse;\r\n" + 
	    		"  table-layout: fixed;\r\n" + 
	    		"}\r\n" + 
	    		"* {\r\n" + 
	    		"  line-height: inherit;\r\n" + 
	    		"}\r\n" + 
	    		"[x-apple-data-detectors] {\r\n" + 
	    		"  color: inherit !important;\r\n" + 
	    		"  text-decoration: none !important;\r\n" + 
	    		"}\r\n" + 
	    		".wrapper .footer__share-button a:hover,\r\n" + 
	    		".wrapper .footer__share-button a:focus {\r\n" + 
	    		"  color: #ffffff !important;\r\n" + 
	    		"}\r\n" + 
	    		".btn a:hover,\r\n" + 
	    		".btn a:focus,\r\n" + 
	    		".footer__share-button a:hover,\r\n" + 
	    		".footer__share-button a:focus,\r\n" + 
	    		".email-footer__links a:hover,\r\n" + 
	    		".email-footer__links a:focus {\r\n" + 
	    		"  opacity: 0.8;\r\n" + 
	    		"}\r\n" + 
	    		".preheader,\r\n" + 
	    		".header,\r\n" + 
	    		".layout,\r\n" + 
	    		".column {\r\n" + 
	    		"  transition: width 0.25s ease-in-out, max-width 0.25s ease-in-out;\r\n" + 
	    		"}\r\n" + 
	    		".preheader td {\r\n" + 
	    		"  padding-bottom: 8px;\r\n" + 
	    		"}\r\n" + 
	    		".layout,\r\n" + 
	    		"div.header {\r\n" + 
	    		"  max-width: 400px !important;\r\n" + 
	    		"  -fallback-width: 95% !important;\r\n" + 
	    		"  width: calc(100% - 20px) !important;\r\n" + 
	    		"}\r\n" + 
	    		"div.preheader {\r\n" + 
	    		"  max-width: 360px !important;\r\n" + 
	    		"  -fallback-width: 90% !important;\r\n" + 
	    		"  width: calc(100% - 60px) !important;\r\n" + 
	    		"}\r\n" + 
	    		".snippet,\r\n" + 
	    		".webversion {\r\n" + 
	    		"  Float: none !important;\r\n" + 
	    		"}\r\n" + 
	    		".stack .column {\r\n" + 
	    		"  max-width: 400px !important;\r\n" + 
	    		"  width: 100% !important;\r\n" + 
	    		"}\r\n" + 
	    		".fixed-width.has-border {\r\n" + 
	    		"  max-width: 402px !important;\r\n" + 
	    		"}\r\n" + 
	    		".fixed-width.has-border .layout__inner {\r\n" + 
	    		"  box-sizing: border-box;\r\n" + 
	    		"}\r\n" + 
	    		".snippet,\r\n" + 
	    		".webversion {\r\n" + 
	    		"  width: 50% !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .btn {\r\n" + 
	    		"  width: 100%;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack .column,\r\n" + 
	    		".ie .stack .gutter {\r\n" + 
	    		"  display: table-cell;\r\n" + 
	    		"  float: none !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie div.preheader,\r\n" + 
	    		".ie .email-footer {\r\n" + 
	    		"  max-width: 560px !important;\r\n" + 
	    		"  width: 560px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .snippet,\r\n" + 
	    		".ie .webversion {\r\n" + 
	    		"  width: 280px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie div.header,\r\n" + 
	    		".ie .layout {\r\n" + 
	    		"  max-width: 600px !important;\r\n" + 
	    		"  width: 600px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .two-col .column {\r\n" + 
	    		"  max-width: 300px !important;\r\n" + 
	    		"  width: 300px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .three-col .column,\r\n" + 
	    		".ie .narrow {\r\n" + 
	    		"  max-width: 200px !important;\r\n" + 
	    		"  width: 200px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .wide {\r\n" + 
	    		"  width: 400px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack.fixed-width.has-border,\r\n" + 
	    		".ie .stack.has-gutter.has-border {\r\n" + 
	    		"  max-width: 602px !important;\r\n" + 
	    		"  width: 602px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack.two-col.has-gutter .column {\r\n" + 
	    		"  max-width: 290px !important;\r\n" + 
	    		"  width: 290px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack.three-col.has-gutter .column,\r\n" + 
	    		".ie .stack.has-gutter .narrow {\r\n" + 
	    		"  max-width: 188px !important;\r\n" + 
	    		"  width: 188px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack.has-gutter .wide {\r\n" + 
	    		"  max-width: 394px !important;\r\n" + 
	    		"  width: 394px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack.two-col.has-gutter.has-border .column {\r\n" + 
	    		"  max-width: 292px !important;\r\n" + 
	    		"  width: 292px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack.three-col.has-gutter.has-border .column,\r\n" + 
	    		".ie .stack.has-gutter.has-border .narrow {\r\n" + 
	    		"  max-width: 190px !important;\r\n" + 
	    		"  width: 190px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .stack.has-gutter.has-border .wide {\r\n" + 
	    		"  max-width: 396px !important;\r\n" + 
	    		"  width: 396px !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .fixed-width .layout__inner {\r\n" + 
	    		"  border-left: 0 none white !important;\r\n" + 
	    		"  border-right: 0 none white !important;\r\n" + 
	    		"}\r\n" + 
	    		".ie .layout__edges {\r\n" + 
	    		"  display: none;\r\n" + 
	    		"}\r\n" + 
	    		".mso .layout__edges {\r\n" + 
	    		"  font-size: 0;\r\n" + 
	    		"}\r\n" + 
	    		".layout-fixed-width,\r\n" + 
	    		".mso .layout-full-width {\r\n" + 
	    		"  background-color: #ffffff;\r\n" + 
	    		"}\r\n" + 
	    		"@media only screen and (min-width: 620px) {\r\n" + 
	    		"  .column,\r\n" + 
	    		"  .gutter {\r\n" + 
	    		"    display: table-cell;\r\n" + 
	    		"    Float: none !important;\r\n" + 
	    		"    vertical-align: top;\r\n" + 
	    		"  }\r\n" + 
	    		"  div.preheader,\r\n" + 
	    		"  .email-footer {\r\n" + 
	    		"    max-width: 560px !important;\r\n" + 
	    		"    width: 560px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .snippet,\r\n" + 
	    		"  .webversion {\r\n" + 
	    		"    width: 280px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  div.header,\r\n" + 
	    		"  .layout,\r\n" + 
	    		"  .one-col .column {\r\n" + 
	    		"    max-width: 600px !important;\r\n" + 
	    		"    width: 600px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .fixed-width.has-border,\r\n" + 
	    		"  .fixed-width.x_has-border,\r\n" + 
	    		"  .has-gutter.has-border,\r\n" + 
	    		"  .has-gutter.x_has-border {\r\n" + 
	    		"    max-width: 602px !important;\r\n" + 
	    		"    width: 602px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .two-col .column {\r\n" + 
	    		"    max-width: 300px !important;\r\n" + 
	    		"    width: 300px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .three-col .column,\r\n" + 
	    		"  .column.narrow,\r\n" + 
	    		"  .column.x_narrow {\r\n" + 
	    		"    max-width: 200px !important;\r\n" + 
	    		"    width: 200px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .column.wide,\r\n" + 
	    		"  .column.x_wide {\r\n" + 
	    		"    width: 400px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .two-col.has-gutter .column,\r\n" + 
	    		"  .two-col.x_has-gutter .column {\r\n" + 
	    		"    max-width: 290px !important;\r\n" + 
	    		"    width: 290px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .three-col.has-gutter .column,\r\n" + 
	    		"  .three-col.x_has-gutter .column,\r\n" + 
	    		"  .has-gutter .narrow {\r\n" + 
	    		"    max-width: 188px !important;\r\n" + 
	    		"    width: 188px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .has-gutter .wide {\r\n" + 
	    		"    max-width: 394px !important;\r\n" + 
	    		"    width: 394px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .two-col.has-gutter.has-border .column,\r\n" + 
	    		"  .two-col.x_has-gutter.x_has-border .column {\r\n" + 
	    		"    max-width: 292px !important;\r\n" + 
	    		"    width: 292px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .three-col.has-gutter.has-border .column,\r\n" + 
	    		"  .three-col.x_has-gutter.x_has-border .column,\r\n" + 
	    		"  .has-gutter.has-border .narrow,\r\n" + 
	    		"  .has-gutter.x_has-border .narrow {\r\n" + 
	    		"    max-width: 190px !important;\r\n" + 
	    		"    width: 190px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .has-gutter.has-border .wide,\r\n" + 
	    		"  .has-gutter.x_has-border .wide {\r\n" + 
	    		"    max-width: 396px !important;\r\n" + 
	    		"    width: 396px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"}\r\n" + 
	    		"@supports (display: flex) {\r\n" + 
	    		"  @media only screen and (min-width: 620px) {\r\n" + 
	    		"    .fixed-width.has-border .layout__inner {\r\n" + 
	    		"      display: flex !important;\r\n" + 
	    		"    }\r\n" + 
	    		"  }\r\n" + 
	    		"}\r\n" + 
	    		"@media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min--moz-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min-device-pixel-ratio: 2), only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx) {\r\n" + 
	    		"  .fblike {\r\n" + 
	    		"    background-image: url(https://i7.createsend1.com/static/eb/master/13-the-blueprint-3/images/fblike@2x.png) !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .tweet {\r\n" + 
	    		"    background-image: url(https://i8.createsend1.com/static/eb/master/13-the-blueprint-3/images/tweet@2x.png) !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .linkedinshare {\r\n" + 
	    		"    background-image: url(https://i9.createsend1.com/static/eb/master/13-the-blueprint-3/images/lishare@2x.png) !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .forwardtoafriend {\r\n" + 
	    		"    background-image: url(https://i10.createsend1.com/static/eb/master/13-the-blueprint-3/images/forward@2x.png) !important;\r\n" + 
	    		"  }\r\n" + 
	    		"}\r\n" + 
	    		"@media (max-width: 321px) {\r\n" + 
	    		"  .fixed-width.has-border .layout__inner {\r\n" + 
	    		"    border-width: 1px 0 !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .layout,\r\n" + 
	    		"  .stack .column {\r\n" + 
	    		"    min-width: 320px !important;\r\n" + 
	    		"    width: 320px !important;\r\n" + 
	    		"  }\r\n" + 
	    		"  .border {\r\n" + 
	    		"    display: none;\r\n" + 
	    		"  }\r\n" + 
	    		"  .has-gutter .border {\r\n" + 
	    		"    display: table-cell;\r\n" + 
	    		"  }\r\n" + 
	    		"}\r\n" + 
	    		".mso div {\r\n" + 
	    		"  border: 0 none white !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .w560 .divider {\r\n" + 
	    		"  Margin-left: 260px !important;\r\n" + 
	    		"  Margin-right: 260px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .w360 .divider {\r\n" + 
	    		"  Margin-left: 160px !important;\r\n" + 
	    		"  Margin-right: 160px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .w260 .divider {\r\n" + 
	    		"  Margin-left: 110px !important;\r\n" + 
	    		"  Margin-right: 110px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .w160 .divider {\r\n" + 
	    		"  Margin-left: 60px !important;\r\n" + 
	    		"  Margin-right: 60px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .w354 .divider {\r\n" + 
	    		"  Margin-left: 157px !important;\r\n" + 
	    		"  Margin-right: 157px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .w250 .divider {\r\n" + 
	    		"  Margin-left: 105px !important;\r\n" + 
	    		"  Margin-right: 105px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .w148 .divider {\r\n" + 
	    		"  Margin-left: 54px !important;\r\n" + 
	    		"  Margin-right: 54px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-8,\r\n" + 
	    		".ie .size-8 {\r\n" + 
	    		"  font-size: 8px !important;\r\n" + 
	    		"  line-height: 14px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-9,\r\n" + 
	    		".ie .size-9 {\r\n" + 
	    		"  font-size: 9px !important;\r\n" + 
	    		"  line-height: 16px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-10,\r\n" + 
	    		".ie .size-10 {\r\n" + 
	    		"  font-size: 10px !important;\r\n" + 
	    		"  line-height: 18px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-11,\r\n" + 
	    		".ie .size-11 {\r\n" + 
	    		"  font-size: 11px !important;\r\n" + 
	    		"  line-height: 19px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-12,\r\n" + 
	    		".ie .size-12 {\r\n" + 
	    		"  font-size: 12px !important;\r\n" + 
	    		"  line-height: 19px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-13,\r\n" + 
	    		".ie .size-13 {\r\n" + 
	    		"  font-size: 13px !important;\r\n" + 
	    		"  line-height: 21px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-14,\r\n" + 
	    		".ie .size-14 {\r\n" + 
	    		"  font-size: 14px !important;\r\n" + 
	    		"  line-height: 21px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-15,\r\n" + 
	    		".ie .size-15 {\r\n" + 
	    		"  font-size: 15px !important;\r\n" + 
	    		"  line-height: 23px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-16,\r\n" + 
	    		".ie .size-16 {\r\n" + 
	    		"  font-size: 16px !important;\r\n" + 
	    		"  line-height: 24px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-17,\r\n" + 
	    		".ie .size-17 {\r\n" + 
	    		"  font-size: 17px !important;\r\n" + 
	    		"  line-height: 26px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-18,\r\n" + 
	    		".ie .size-18 {\r\n" + 
	    		"  font-size: 18px !important;\r\n" + 
	    		"  line-height: 26px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-20,\r\n" + 
	    		".ie .size-20 {\r\n" + 
	    		"  font-size: 20px !important;\r\n" + 
	    		"  line-height: 28px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-22,\r\n" + 
	    		".ie .size-22 {\r\n" + 
	    		"  font-size: 22px !important;\r\n" + 
	    		"  line-height: 31px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-24,\r\n" + 
	    		".ie .size-24 {\r\n" + 
	    		"  font-size: 24px !important;\r\n" + 
	    		"  line-height: 32px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-26,\r\n" + 
	    		".ie .size-26 {\r\n" + 
	    		"  font-size: 26px !important;\r\n" + 
	    		"  line-height: 34px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-28,\r\n" + 
	    		".ie .size-28 {\r\n" + 
	    		"  font-size: 28px !important;\r\n" + 
	    		"  line-height: 36px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-30,\r\n" + 
	    		".ie .size-30 {\r\n" + 
	    		"  font-size: 30px !important;\r\n" + 
	    		"  line-height: 38px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-32,\r\n" + 
	    		".ie .size-32 {\r\n" + 
	    		"  font-size: 32px !important;\r\n" + 
	    		"  line-height: 40px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-34,\r\n" + 
	    		".ie .size-34 {\r\n" + 
	    		"  font-size: 34px !important;\r\n" + 
	    		"  line-height: 43px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-36,\r\n" + 
	    		".ie .size-36 {\r\n" + 
	    		"  font-size: 36px !important;\r\n" + 
	    		"  line-height: 43px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-40,\r\n" + 
	    		".ie .size-40 {\r\n" + 
	    		"  font-size: 40px !important;\r\n" + 
	    		"  line-height: 47px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-44,\r\n" + 
	    		".ie .size-44 {\r\n" + 
	    		"  font-size: 44px !important;\r\n" + 
	    		"  line-height: 50px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-48,\r\n" + 
	    		".ie .size-48 {\r\n" + 
	    		"  font-size: 48px !important;\r\n" + 
	    		"  line-height: 54px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-56,\r\n" + 
	    		".ie .size-56 {\r\n" + 
	    		"  font-size: 56px !important;\r\n" + 
	    		"  line-height: 60px !important;\r\n" + 
	    		"}\r\n" + 
	    		".mso .size-64,\r\n" + 
	    		".ie .size-64 {\r\n" + 
	    		"  font-size: 64px !important;\r\n" + 
	    		"  line-height: 63px !important;\r\n" + 
	    		"}\r\n" + 
	    		"</style>\r\n" + 
	    		"    \r\n" + 
	    		"  <style type=\"text/css\">\r\n" + 
	    		"body{background-color:#fff}.logo a:hover,.logo a:focus{color:#859bb1 !important}.mso .layout-has-border{border-top:1px solid #ccc;border-bottom:1px solid #ccc}.mso .layout-has-bottom-border{border-bottom:1px solid #ccc}.mso .border,.ie .border{background-color:#ccc}.mso h1,.ie h1{}.mso h1,.ie h1{font-size:64px !important;line-height:63px !important}.mso h2,.ie h2{}.mso h2,.ie h2{font-size:30px !important;line-height:38px !important}.mso h3,.ie h3{}.mso h3,.ie h3{font-size:22px !important;line-height:31px !important}.mso .layout__inner,.ie .layout__inner{}.mso .footer__share-button p{}.mso .footer__share-button p{font-family:sans-serif}\r\n" + 
	    		"</style><meta name=\"robots\" content=\"noindex,nofollow\" />\r\n" + 
	    		"<meta property=\"og:title\" content=\"Confirmation email\" />\r\n" + 
	    		"</head>\r\n" + 
	    		"<!--[if mso]>\r\n" + 
	    		"  <body class=\"mso\">\r\n" + 
	    		"<![endif]-->\r\n" + 
	    		"<!--[if !mso]><!-->\r\n" + 
	    		"  <body class=\"no-padding\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;\">\r\n" + 
	    		"<!--<![endif]-->\r\n" + 
	    		"    <table class=\"wrapper\" style=\"border-collapse: collapse;table-layout: fixed;min-width: 320px;width: 100%;background-color: #fff;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tbody><tr><td>\r\n" + 
	    		"      <div role=\"banner\">\r\n" + 
	    		"        <div class=\"preheader\" style=\"Margin: 0 auto;max-width: 560px;min-width: 280px; width: 280px;width: calc(28000% - 167440px);\">\r\n" + 
	    		"          <div style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
	    		"          <!--[if (mso)|(IE)]><table align=\"center\" class=\"preheader\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n" + 
	    		"            <div class=\"snippet\" style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 140px; width: 140px;width: calc(14000% - 78120px);padding: 10px 0 5px 0;color: #adb3b9;font-family: sans-serif;\">\r\n" + 
	    		"              \r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n" + 
	    		"            <div class=\"webversion\" style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 139px; width: 139px;width: calc(14100% - 78680px);padding: 10px 0 5px 0;text-align: right;color: #adb3b9;font-family: sans-serif;\">\r\n" + 
	    		"              \r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
	    		"          </div>\r\n" + 
	    		"        </div>\r\n" + 
	    		"        <div class=\"header\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);\" id=\"emb-email-header-container\">\r\n" + 
	    		"        <!--[if (mso)|(IE)]><table align=\"center\" class=\"header\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 600px\"><![endif]-->\r\n" + 
	    		"          <div class=\"logo emb-logo-margin-box\" style=\"font-size: 26px;line-height: 32px;Margin-top: 6px;Margin-bottom: 20px;color: #c3ced9;font-family: Roboto,Tahoma,sans-serif;Margin-left: 20px;Margin-right: 20px;\" align=\"center\">\r\n" + 
	    		"            <div class=\"logo-center\" align=\"center\" id=\"emb-email-header\"><img style=\"display: block;height: auto;width: 100%;border: 0;max-width: 252px;\" src=\"https://i.ibb.co/Bc3MTdF/bookingindex-jpg.png\" alt=\"\" width=\"252\" /></div>\r\n" + 
	    		"          </div>\r\n" + 
	    		"        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
	    		"        </div>\r\n" + 
	    		"      </div>\r\n" + 
	    		"      <div>\r\n" + 
	    		"      <div style=\"background-color: #e31212;\">\r\n" + 
	    		"        <div class=\"layout three-col stack\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
	    		"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
	    		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #e31212;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
	    		"            <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);Float: left;\">\r\n" + 
	    		"            \r\n" + 
	    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
	    		"      <div style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">&nbsp;</div>\r\n" + 
	    		"    </div>\r\n" + 
	    		"            \r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
	    		"            <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);Float: left;\">\r\n" + 
	    		"            \r\n" + 
	    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
	    		"      <div style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">&nbsp;</div>\r\n" + 
	    		"    </div>\r\n" + 
	    		"            \r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
	    		"            <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);Float: left;\">\r\n" + 
	    		"            \r\n" + 
	    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
	    		"      <div style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">&nbsp;</div>\r\n" + 
	    		"    </div>\r\n" + 
	    		"            \r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n" + 
	    		"          </div>\r\n" + 
	    		"        </div>\r\n" + 
	    		"      </div>\r\n" + 
	    		"  \r\n" + 
	    		"      <div class=\"layout one-col fixed-width stack\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
	    		"        <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;background-color: #ffffff;\">\r\n" + 
	    		"        <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-fixed-width\" style=\"background-color: #ffffff;\"><td style=\"width: 600px\" class=\"w560\"><![endif]-->\r\n" + 
	    		"          <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;\">\r\n" + 
	    		"        \r\n" + 
	    		"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
	    		"      <div style=\"mso-line-height-rule: exactly;line-height: 50px;font-size: 1px;\">&nbsp;</div>\r\n" + 
	    		"    </div>\r\n" + 
	    		"        \r\n" + 
	    		"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
	    		"      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
	    		"        <h2 style=\"Margin-top: 0;Margin-bottom: 16px;font-style: normal;font-weight: normal;color: #e31212;font-size: 26px;line-height: 34px;font-family: Avenir,sans-serif;text-align: center;\"><strong>Your Booking Is Complete</strong></h2>\r\n" + 
	    		"      </div>\r\n" + 
	    		"    </div>\r\n" + 
	    		"        \r\n" + 
	    		"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
	    		"      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
	    		"        <p style=\"Margin-top: 0;Margin-bottom: 0;\">Thank you for your booking. Your details are below: </p>\r\n" + 
	    		"        <br>\r\n" + 
	    		"        <h3>Office: "+officeName+"</h3>\r\n" + 
	    		"        <h3>Date: "+seats+"</h3>\r\n" + 
	    		"        <h3>Number of Seats: "+seats+"</h3>\r\n" + 
	    		"        <h3>Time: "+hour+":"+min+""+additional1+" - "+hourend+":"+minend+""+additional2+"</h3>\r\n" + 
	    		"        <h4>Reason for office visit: "+notes+" </h4>\r\n" + 
	    		"        <hr/>\r\n" + 
	    		"        "+output+"\r\n" + 
	    		"      </div>\r\n" + 
	    		"    </div>\r\n" + 
	    		"        \r\n" + 
	    		"          </div>\r\n" + 
	    		"        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
	    		"        </div>\r\n" + 
	    		"      </div>\r\n" + 
	    		"  \r\n" + 
	    		"      <div style=\"mso-line-height-rule: exactly;line-height: 20px;font-size: 20px;\">&nbsp;</div>\r\n" + 
	    		"  \r\n" + 
	    		"      \r\n" + 
	    		"      <div role=\"contentinfo\">\r\n" + 
	    		"        <div class=\"layout email-footer stack\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
	    		"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
	    		"          <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 400px;\" valign=\"top\" class=\"w360\"><![endif]-->\r\n" + 
	    		"            <div class=\"column wide\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #adb3b9;font-family: sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\r\n" + 
	    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
	    		"                \r\n" + 
	    		"                <div style=\"font-size: 12px;line-height: 19px;\">\r\n" + 
	    		"                  <div>LSH Desk Booking System</div>\r\n" + 
	    		"                </div>\r\n" + 
	    		"                <div style=\"font-size: 12px;line-height: 19px;Margin-top: 18px;\">\r\n" + 
	    		"                  <div>Had a problem? Report it here: https://forms.gle/RvESA2e3rY2mhtf37</div>\r\n" + 
	    		"                </div>\r\n" + 
	    		"                <!--[if mso]>&nbsp;<![endif]-->\r\n" + 
	    		"              </div>\r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 200px;\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
	    		"            <div class=\"column narrow\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #adb3b9;font-family: sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\r\n" + 
	    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
	    		"                \r\n" + 
	    		"              </div>\r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
	    		"          </div>\r\n" + 
	    		"        </div>\r\n" + 
	    		"        <div class=\"layout one-col email-footer\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
	    		"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
	    		"          <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 600px;\" class=\"w560\"><![endif]-->\r\n" + 
	    		"            <div class=\"column\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #adb3b9;font-family: sans-serif;\">\r\n" + 
	    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
	    		"                <div style=\"font-size: 12px;line-height: 19px;\">\r\n" + 
	    		"                </div>\r\n" + 
	    		"              </div>\r\n" + 
	    		"            </div>\r\n" + 
	    		"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
	    		"          </div>\r\n" + 
	    		"        </div>\r\n" + 
	    		"      </div>\r\n" + 
	    		"      <div style=\"line-height:40px;font-size:40px;\">&nbsp;</div>\r\n" + 
	    		"    </div></td></tr></tbody></table>\r\n" + 
	    		"  \r\n" + 
	    		"</body></html>\r\n";
		}
	
		public static String adminData(String type, String officeName, String displayTime, String bookingDate) {
			if(type.equals("simple")) {
				return "";
			}
			return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><!--[if IE]><html xmlns=\"http://www.w3.org/1999/xhtml\" class=\"ie\"><![endif]--><!--[if !IE]><!--><html style=\"margin: 0;padding: 0;\" xmlns=\"http://www.w3.org/1999/xhtml\"><!--<![endif]--><head>\r\n" + 
    		"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n" + 
    		"    <title></title>\r\n" + 
    		"    <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" /><!--<![endif]-->\r\n" + 
    		"    <meta name=\"viewport\" content=\"width=device-width\" /><style type=\"text/css\">\r\n" + 
    		"@media only screen and (min-width: 620px){.wrapper{min-width:600px !important}.wrapper h1{}.wrapper h1{font-size:64px !important;line-height:63px !important}.wrapper h2{}.wrapper h2{font-size:30px !important;line-height:38px !important}.wrapper h3{}.wrapper h3{font-size:22px !important;line-height:31px !important}.column{}.wrapper .size-8{font-size:8px !important;line-height:14px !important}.wrapper .size-9{font-size:9px !important;line-height:16px !important}.wrapper .size-10{font-size:10px !important;line-height:18px !important}.wrapper .size-11{font-size:11px !important;line-height:19px !important}.wrapper .size-12{font-size:12px !important;line-height:19px !important}.wrapper .size-13{font-size:13px !important;line-height:21px !important}.wrapper .size-14{font-size:14px !important;line-height:21px !important}.wrapper .size-15{font-size:15px !important;line-height:23px \r\n" + 
    		"!important}.wrapper .size-16{font-size:16px !important;line-height:24px !important}.wrapper .size-17{font-size:17px !important;line-height:26px !important}.wrapper .size-18{font-size:18px !important;line-height:26px !important}.wrapper .size-20{font-size:20px !important;line-height:28px !important}.wrapper .size-22{font-size:22px !important;line-height:31px !important}.wrapper .size-24{font-size:24px !important;line-height:32px !important}.wrapper .size-26{font-size:26px !important;line-height:34px !important}.wrapper .size-28{font-size:28px !important;line-height:36px !important}.wrapper .size-30{font-size:30px !important;line-height:38px !important}.wrapper .size-32{font-size:32px !important;line-height:40px !important}.wrapper .size-34{font-size:34px !important;line-height:43px !important}.wrapper .size-36{font-size:36px !important;line-height:43px !important}.wrapper \r\n" + 
    		".size-40{font-size:40px !important;line-height:47px !important}.wrapper .size-44{font-size:44px !important;line-height:50px !important}.wrapper .size-48{font-size:48px !important;line-height:54px !important}.wrapper .size-56{font-size:56px !important;line-height:60px !important}.wrapper .size-64{font-size:64px !important;line-height:63px !important}}\r\n" + 
    		"</style>\r\n" + 
    		"    <meta name=\"x-apple-disable-message-reformatting\" />\r\n" + 
    		"    <style type=\"text/css\">\r\n" + 
    		"body {\r\n" + 
    		"  margin: 0;\r\n" + 
    		"  padding: 0;\r\n" + 
    		"}\r\n" + 
    		"table {\r\n" + 
    		"  border-collapse: collapse;\r\n" + 
    		"  table-layout: fixed;\r\n" + 
    		"}\r\n" + 
    		"* {\r\n" + 
    		"  line-height: inherit;\r\n" + 
    		"}\r\n" + 
    		"[x-apple-data-detectors] {\r\n" + 
    		"  color: inherit !important;\r\n" + 
    		"  text-decoration: none !important;\r\n" + 
    		"}\r\n" + 
    		".wrapper .footer__share-button a:hover,\r\n" + 
    		".wrapper .footer__share-button a:focus {\r\n" + 
    		"  color: #ffffff !important;\r\n" + 
    		"}\r\n" + 
    		".btn a:hover,\r\n" + 
    		".btn a:focus,\r\n" + 
    		".footer__share-button a:hover,\r\n" + 
    		".footer__share-button a:focus,\r\n" + 
    		".email-footer__links a:hover,\r\n" + 
    		".email-footer__links a:focus {\r\n" + 
    		"  opacity: 0.8;\r\n" + 
    		"}\r\n" + 
    		".preheader,\r\n" + 
    		".header,\r\n" + 
    		".layout,\r\n" + 
    		".column {\r\n" + 
    		"  transition: width 0.25s ease-in-out, max-width 0.25s ease-in-out;\r\n" + 
    		"}\r\n" + 
    		".preheader td {\r\n" + 
    		"  padding-bottom: 8px;\r\n" + 
    		"}\r\n" + 
    		".layout,\r\n" + 
    		"div.header {\r\n" + 
    		"  max-width: 400px !important;\r\n" + 
    		"  -fallback-width: 95% !important;\r\n" + 
    		"  width: calc(100% - 20px) !important;\r\n" + 
    		"}\r\n" + 
    		"div.preheader {\r\n" + 
    		"  max-width: 360px !important;\r\n" + 
    		"  -fallback-width: 90% !important;\r\n" + 
    		"  width: calc(100% - 60px) !important;\r\n" + 
    		"}\r\n" + 
    		".snippet,\r\n" + 
    		".webversion {\r\n" + 
    		"  Float: none !important;\r\n" + 
    		"}\r\n" + 
    		".stack .column {\r\n" + 
    		"  max-width: 400px !important;\r\n" + 
    		"  width: 100% !important;\r\n" + 
    		"}\r\n" + 
    		".fixed-width.has-border {\r\n" + 
    		"  max-width: 402px !important;\r\n" + 
    		"}\r\n" + 
    		".fixed-width.has-border .layout__inner {\r\n" + 
    		"  box-sizing: border-box;\r\n" + 
    		"}\r\n" + 
    		".snippet,\r\n" + 
    		".webversion {\r\n" + 
    		"  width: 50% !important;\r\n" + 
    		"}\r\n" + 
    		".ie .btn {\r\n" + 
    		"  width: 100%;\r\n" + 
    		"}\r\n" + 
    		".ie .stack .column,\r\n" + 
    		".ie .stack .gutter {\r\n" + 
    		"  display: table-cell;\r\n" + 
    		"  float: none !important;\r\n" + 
    		"}\r\n" + 
    		".ie div.preheader,\r\n" + 
    		".ie .email-footer {\r\n" + 
    		"  max-width: 560px !important;\r\n" + 
    		"  width: 560px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .snippet,\r\n" + 
    		".ie .webversion {\r\n" + 
    		"  width: 280px !important;\r\n" + 
    		"}\r\n" + 
    		".ie div.header,\r\n" + 
    		".ie .layout {\r\n" + 
    		"  max-width: 600px !important;\r\n" + 
    		"  width: 600px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .two-col .column {\r\n" + 
    		"  max-width: 300px !important;\r\n" + 
    		"  width: 300px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .three-col .column,\r\n" + 
    		".ie .narrow {\r\n" + 
    		"  max-width: 200px !important;\r\n" + 
    		"  width: 200px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .wide {\r\n" + 
    		"  width: 400px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .stack.fixed-width.has-border,\r\n" + 
    		".ie .stack.has-gutter.has-border {\r\n" + 
    		"  max-width: 602px !important;\r\n" + 
    		"  width: 602px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .stack.two-col.has-gutter .column {\r\n" + 
    		"  max-width: 290px !important;\r\n" + 
    		"  width: 290px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .stack.three-col.has-gutter .column,\r\n" + 
    		".ie .stack.has-gutter .narrow {\r\n" + 
    		"  max-width: 188px !important;\r\n" + 
    		"  width: 188px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .stack.has-gutter .wide {\r\n" + 
    		"  max-width: 394px !important;\r\n" + 
    		"  width: 394px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .stack.two-col.has-gutter.has-border .column {\r\n" + 
    		"  max-width: 292px !important;\r\n" + 
    		"  width: 292px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .stack.three-col.has-gutter.has-border .column,\r\n" + 
    		".ie .stack.has-gutter.has-border .narrow {\r\n" + 
    		"  max-width: 190px !important;\r\n" + 
    		"  width: 190px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .stack.has-gutter.has-border .wide {\r\n" + 
    		"  max-width: 396px !important;\r\n" + 
    		"  width: 396px !important;\r\n" + 
    		"}\r\n" + 
    		".ie .fixed-width .layout__inner {\r\n" + 
    		"  border-left: 0 none white !important;\r\n" + 
    		"  border-right: 0 none white !important;\r\n" + 
    		"}\r\n" + 
    		".ie .layout__edges {\r\n" + 
    		"  display: none;\r\n" + 
    		"}\r\n" + 
    		".mso .layout__edges {\r\n" + 
    		"  font-size: 0;\r\n" + 
    		"}\r\n" + 
    		".layout-fixed-width,\r\n" + 
    		".mso .layout-full-width {\r\n" + 
    		"  background-color: #ffffff;\r\n" + 
    		"}\r\n" + 
    		"@media only screen and (min-width: 620px) {\r\n" + 
    		"  .column,\r\n" + 
    		"  .gutter {\r\n" + 
    		"    display: table-cell;\r\n" + 
    		"    Float: none !important;\r\n" + 
    		"    vertical-align: top;\r\n" + 
    		"  }\r\n" + 
    		"  div.preheader,\r\n" + 
    		"  .email-footer {\r\n" + 
    		"    max-width: 560px !important;\r\n" + 
    		"    width: 560px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .snippet,\r\n" + 
    		"  .webversion {\r\n" + 
    		"    width: 280px !important;\r\n" + 
    		"  }\r\n" + 
    		"  div.header,\r\n" + 
    		"  .layout,\r\n" + 
    		"  .one-col .column {\r\n" + 
    		"    max-width: 600px !important;\r\n" + 
    		"    width: 600px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .fixed-width.has-border,\r\n" + 
    		"  .fixed-width.x_has-border,\r\n" + 
    		"  .has-gutter.has-border,\r\n" + 
    		"  .has-gutter.x_has-border {\r\n" + 
    		"    max-width: 602px !important;\r\n" + 
    		"    width: 602px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .two-col .column {\r\n" + 
    		"    max-width: 300px !important;\r\n" + 
    		"    width: 300px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .three-col .column,\r\n" + 
    		"  .column.narrow,\r\n" + 
    		"  .column.x_narrow {\r\n" + 
    		"    max-width: 200px !important;\r\n" + 
    		"    width: 200px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .column.wide,\r\n" + 
    		"  .column.x_wide {\r\n" + 
    		"    width: 400px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .two-col.has-gutter .column,\r\n" + 
    		"  .two-col.x_has-gutter .column {\r\n" + 
    		"    max-width: 290px !important;\r\n" + 
    		"    width: 290px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .three-col.has-gutter .column,\r\n" + 
    		"  .three-col.x_has-gutter .column,\r\n" + 
    		"  .has-gutter .narrow {\r\n" + 
    		"    max-width: 188px !important;\r\n" + 
    		"    width: 188px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .has-gutter .wide {\r\n" + 
    		"    max-width: 394px !important;\r\n" + 
    		"    width: 394px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .two-col.has-gutter.has-border .column,\r\n" + 
    		"  .two-col.x_has-gutter.x_has-border .column {\r\n" + 
    		"    max-width: 292px !important;\r\n" + 
    		"    width: 292px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .three-col.has-gutter.has-border .column,\r\n" + 
    		"  .three-col.x_has-gutter.x_has-border .column,\r\n" + 
    		"  .has-gutter.has-border .narrow,\r\n" + 
    		"  .has-gutter.x_has-border .narrow {\r\n" + 
    		"    max-width: 190px !important;\r\n" + 
    		"    width: 190px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .has-gutter.has-border .wide,\r\n" + 
    		"  .has-gutter.x_has-border .wide {\r\n" + 
    		"    max-width: 396px !important;\r\n" + 
    		"    width: 396px !important;\r\n" + 
    		"  }\r\n" + 
    		"}\r\n" + 
    		"@supports (display: flex) {\r\n" + 
    		"  @media only screen and (min-width: 620px) {\r\n" + 
    		"    .fixed-width.has-border .layout__inner {\r\n" + 
    		"      display: flex !important;\r\n" + 
    		"    }\r\n" + 
    		"  }\r\n" + 
    		"}\r\n" + 
    		"@media only screen and (-webkit-min-device-pixel-ratio: 2), only screen and (min--moz-device-pixel-ratio: 2), only screen and (-o-min-device-pixel-ratio: 2/1), only screen and (min-device-pixel-ratio: 2), only screen and (min-resolution: 192dpi), only screen and (min-resolution: 2dppx) {\r\n" + 
    		"  .fblike {\r\n" + 
    		"    background-image: url(https://i7.createsend1.com/static/eb/master/13-the-blueprint-3/images/fblike@2x.png) !important;\r\n" + 
    		"  }\r\n" + 
    		"  .tweet {\r\n" + 
    		"    background-image: url(https://i8.createsend1.com/static/eb/master/13-the-blueprint-3/images/tweet@2x.png) !important;\r\n" + 
    		"  }\r\n" + 
    		"  .linkedinshare {\r\n" + 
    		"    background-image: url(https://i9.createsend1.com/static/eb/master/13-the-blueprint-3/images/lishare@2x.png) !important;\r\n" + 
    		"  }\r\n" + 
    		"  .forwardtoafriend {\r\n" + 
    		"    background-image: url(https://i10.createsend1.com/static/eb/master/13-the-blueprint-3/images/forward@2x.png) !important;\r\n" + 
    		"  }\r\n" + 
    		"}\r\n" + 
    		"@media (max-width: 321px) {\r\n" + 
    		"  .fixed-width.has-border .layout__inner {\r\n" + 
    		"    border-width: 1px 0 !important;\r\n" + 
    		"  }\r\n" + 
    		"  .layout,\r\n" + 
    		"  .stack .column {\r\n" + 
    		"    min-width: 320px !important;\r\n" + 
    		"    width: 320px !important;\r\n" + 
    		"  }\r\n" + 
    		"  .border {\r\n" + 
    		"    display: none;\r\n" + 
    		"  }\r\n" + 
    		"  .has-gutter .border {\r\n" + 
    		"    display: table-cell;\r\n" + 
    		"  }\r\n" + 
    		"}\r\n" + 
    		".mso div {\r\n" + 
    		"  border: 0 none white !important;\r\n" + 
    		"}\r\n" + 
    		".mso .w560 .divider {\r\n" + 
    		"  Margin-left: 260px !important;\r\n" + 
    		"  Margin-right: 260px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .w360 .divider {\r\n" + 
    		"  Margin-left: 160px !important;\r\n" + 
    		"  Margin-right: 160px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .w260 .divider {\r\n" + 
    		"  Margin-left: 110px !important;\r\n" + 
    		"  Margin-right: 110px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .w160 .divider {\r\n" + 
    		"  Margin-left: 60px !important;\r\n" + 
    		"  Margin-right: 60px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .w354 .divider {\r\n" + 
    		"  Margin-left: 157px !important;\r\n" + 
    		"  Margin-right: 157px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .w250 .divider {\r\n" + 
    		"  Margin-left: 105px !important;\r\n" + 
    		"  Margin-right: 105px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .w148 .divider {\r\n" + 
    		"  Margin-left: 54px !important;\r\n" + 
    		"  Margin-right: 54px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-8,\r\n" + 
    		".ie .size-8 {\r\n" + 
    		"  font-size: 8px !important;\r\n" + 
    		"  line-height: 14px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-9,\r\n" + 
    		".ie .size-9 {\r\n" + 
    		"  font-size: 9px !important;\r\n" + 
    		"  line-height: 16px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-10,\r\n" + 
    		".ie .size-10 {\r\n" + 
    		"  font-size: 10px !important;\r\n" + 
    		"  line-height: 18px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-11,\r\n" + 
    		".ie .size-11 {\r\n" + 
    		"  font-size: 11px !important;\r\n" + 
    		"  line-height: 19px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-12,\r\n" + 
    		".ie .size-12 {\r\n" + 
    		"  font-size: 12px !important;\r\n" + 
    		"  line-height: 19px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-13,\r\n" + 
    		".ie .size-13 {\r\n" + 
    		"  font-size: 13px !important;\r\n" + 
    		"  line-height: 21px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-14,\r\n" + 
    		".ie .size-14 {\r\n" + 
    		"  font-size: 14px !important;\r\n" + 
    		"  line-height: 21px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-15,\r\n" + 
    		".ie .size-15 {\r\n" + 
    		"  font-size: 15px !important;\r\n" + 
    		"  line-height: 23px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-16,\r\n" + 
    		".ie .size-16 {\r\n" + 
    		"  font-size: 16px !important;\r\n" + 
    		"  line-height: 24px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-17,\r\n" + 
    		".ie .size-17 {\r\n" + 
    		"  font-size: 17px !important;\r\n" + 
    		"  line-height: 26px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-18,\r\n" + 
    		".ie .size-18 {\r\n" + 
    		"  font-size: 18px !important;\r\n" + 
    		"  line-height: 26px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-20,\r\n" + 
    		".ie .size-20 {\r\n" + 
    		"  font-size: 20px !important;\r\n" + 
    		"  line-height: 28px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-22,\r\n" + 
    		".ie .size-22 {\r\n" + 
    		"  font-size: 22px !important;\r\n" + 
    		"  line-height: 31px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-24,\r\n" + 
    		".ie .size-24 {\r\n" + 
    		"  font-size: 24px !important;\r\n" + 
    		"  line-height: 32px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-26,\r\n" + 
    		".ie .size-26 {\r\n" + 
    		"  font-size: 26px !important;\r\n" + 
    		"  line-height: 34px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-28,\r\n" + 
    		".ie .size-28 {\r\n" + 
    		"  font-size: 28px !important;\r\n" + 
    		"  line-height: 36px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-30,\r\n" + 
    		".ie .size-30 {\r\n" + 
    		"  font-size: 30px !important;\r\n" + 
    		"  line-height: 38px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-32,\r\n" + 
    		".ie .size-32 {\r\n" + 
    		"  font-size: 32px !important;\r\n" + 
    		"  line-height: 40px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-34,\r\n" + 
    		".ie .size-34 {\r\n" + 
    		"  font-size: 34px !important;\r\n" + 
    		"  line-height: 43px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-36,\r\n" + 
    		".ie .size-36 {\r\n" + 
    		"  font-size: 36px !important;\r\n" + 
    		"  line-height: 43px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-40,\r\n" + 
    		".ie .size-40 {\r\n" + 
    		"  font-size: 40px !important;\r\n" + 
    		"  line-height: 47px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-44,\r\n" + 
    		".ie .size-44 {\r\n" + 
    		"  font-size: 44px !important;\r\n" + 
    		"  line-height: 50px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-48,\r\n" + 
    		".ie .size-48 {\r\n" + 
    		"  font-size: 48px !important;\r\n" + 
    		"  line-height: 54px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-56,\r\n" + 
    		".ie .size-56 {\r\n" + 
    		"  font-size: 56px !important;\r\n" + 
    		"  line-height: 60px !important;\r\n" + 
    		"}\r\n" + 
    		".mso .size-64,\r\n" + 
    		".ie .size-64 {\r\n" + 
    		"  font-size: 64px !important;\r\n" + 
    		"  line-height: 63px !important;\r\n" + 
    		"}\r\n" + 
    		"</style>\r\n" + 
    		"    \r\n" + 
    		"  <style type=\"text/css\">\r\n" + 
    		"body{background-color:#fff}.logo a:hover,.logo a:focus{color:#859bb1 !important}.mso .layout-has-border{border-top:1px solid #ccc;border-bottom:1px solid #ccc}.mso .layout-has-bottom-border{border-bottom:1px solid #ccc}.mso .border,.ie .border{background-color:#ccc}.mso h1,.ie h1{}.mso h1,.ie h1{font-size:64px !important;line-height:63px !important}.mso h2,.ie h2{}.mso h2,.ie h2{font-size:30px !important;line-height:38px !important}.mso h3,.ie h3{}.mso h3,.ie h3{font-size:22px !important;line-height:31px !important}.mso .layout__inner,.ie .layout__inner{}.mso .footer__share-button p{}.mso .footer__share-button p{font-family:sans-serif}\r\n" + 
    		"</style><meta name=\"robots\" content=\"noindex,nofollow\" />\r\n" + 
    		"<meta property=\"og:title\" content=\"Confirmation email\" />\r\n" + 
    		"</head>\r\n" + 
    		"<!--[if mso]>\r\n" + 
    		"  <body class=\"mso\">\r\n" + 
    		"<![endif]-->\r\n" + 
    		"<!--[if !mso]><!-->\r\n" + 
    		"  <body class=\"no-padding\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;\">\r\n" + 
    		"<!--<![endif]-->\r\n" + 
    		"    <table class=\"wrapper\" style=\"border-collapse: collapse;table-layout: fixed;min-width: 320px;width: 100%;background-color: #fff;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tbody><tr><td>\r\n" + 
    		"      <div role=\"banner\">\r\n" + 
    		"        <div class=\"preheader\" style=\"Margin: 0 auto;max-width: 560px;min-width: 280px; width: 280px;width: calc(28000% - 167440px);\">\r\n" + 
    		"          <div style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
    		"          <!--[if (mso)|(IE)]><table align=\"center\" class=\"preheader\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n" + 
    		"            <div class=\"snippet\" style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 140px; width: 140px;width: calc(14000% - 78120px);padding: 10px 0 5px 0;color: #adb3b9;font-family: sans-serif;\">\r\n" + 
    		"              \r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 280px\" valign=\"top\"><![endif]-->\r\n" + 
    		"            <div class=\"webversion\" style=\"display: table-cell;Float: left;font-size: 12px;line-height: 19px;max-width: 280px;min-width: 139px; width: 139px;width: calc(14100% - 78680px);padding: 10px 0 5px 0;text-align: right;color: #adb3b9;font-family: sans-serif;\">\r\n" + 
    		"              \r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
    		"          </div>\r\n" + 
    		"        </div>\r\n" + 
    		"        <div class=\"header\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);\" id=\"emb-email-header-container\">\r\n" + 
    		"        <!--[if (mso)|(IE)]><table align=\"center\" class=\"header\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr><td style=\"width: 600px\"><![endif]-->\r\n" + 
    		"          <div class=\"logo emb-logo-margin-box\" style=\"font-size: 26px;line-height: 32px;Margin-top: 6px;Margin-bottom: 20px;color: #c3ced9;font-family: Roboto,Tahoma,sans-serif;Margin-left: 20px;Margin-right: 20px;\" align=\"center\">\r\n" + 
    		"            <div class=\"logo-center\" align=\"center\" id=\"emb-email-header\"><img style=\"display: block;height: auto;width: 100%;border: 0;max-width: 252px;\" src=\"https://i.ibb.co/1RXGk5p/bookingindex.jpg\" alt=\"\" width=\"252\" /></div>\r\n" + 
    		"          </div>\r\n" + 
    		"        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
    		"        </div>\r\n" + 
    		"      </div>\r\n" + 
    		"      <div>\r\n" + 
    		"      <div style=\"background-color: #e31212;\">\r\n" + 
    		"        <div class=\"layout three-col stack\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
    		"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
    		"          <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-full-width\" style=\"background-color: #e31212;\"><td class=\"layout__edges\">&nbsp;</td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
    		"            <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);Float: left;\">\r\n" + 
    		"            \r\n" + 
    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
    		"      <div style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">&nbsp;</div>\r\n" + 
    		"    </div>\r\n" + 
    		"            \r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
    		"            <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);Float: left;\">\r\n" + 
    		"            \r\n" + 
    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
    		"      <div style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">&nbsp;</div>\r\n" + 
    		"    </div>\r\n" + 
    		"            \r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 200px\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
    		"            <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);Float: left;\">\r\n" + 
    		"            \r\n" + 
    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
    		"      <div style=\"mso-line-height-rule: exactly;line-height: 10px;font-size: 1px;\">&nbsp;</div>\r\n" + 
    		"    </div>\r\n" + 
    		"            \r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td><td class=\"layout__edges\">&nbsp;</td></tr></table><![endif]-->\r\n" + 
    		"          </div>\r\n" + 
    		"        </div>\r\n" + 
    		"      </div>\r\n" + 
    		"  \r\n" + 
    		"      <div class=\"layout one-col fixed-width stack\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
    		"        <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;background-color: #ffffff;\">\r\n" + 
    		"        <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-fixed-width\" style=\"background-color: #ffffff;\"><td style=\"width: 600px\" class=\"w560\"><![endif]-->\r\n" + 
    		"          <div class=\"column\" style=\"text-align: left;color: #8e959c;font-size: 14px;line-height: 21px;font-family: sans-serif;\">\r\n" + 
    		"        \r\n" + 
    		"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
    		"      <div style=\"mso-line-height-rule: exactly;line-height: 50px;font-size: 1px;\">&nbsp;</div>\r\n" + 
    		"    </div>\r\n" + 
    		"        \r\n" + 
    		"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
    		"      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
    		"        <h2 style=\"Margin-top: 0;Margin-bottom: 16px;font-style: normal;font-weight: normal;color: #e31212;font-size: 26px;line-height: 34px;font-family: Avenir,sans-serif;text-align: center;\"><strong>Your Booking was Denied / Deleted</strong></h2>\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"        \r\n" + 
    		"            <div style=\"Margin-left: 20px;Margin-right: 20px;\">\r\n" + 
    		"      <div style=\"mso-line-height-rule: exactly;mso-text-raise: 11px;vertical-align: middle;\">\r\n" + 
    		"        <h3 style=\"Margin-top: 0;Margin-bottom: 0;\">Your booking was denied by the systems administrator</h3>\r\n" + 
  	    	"        <h3 style=\"Margin-top: 0;Margin-bottom: 0;\">Office: " + officeName + "</h3>\r\n" + 
  	    	"        <h3 style=\"Margin-top: 0;Margin-bottom: 0;\">Time: " + displayTime + "</h3>\r\n" + 
  	    	"        <h3 style=\"Margin-top: 0;Margin-bottom: 0;\">Date: " + bookingDate + "</h3>\r\n" + 
    		"        <br>\r\n" + 
    		"        <p>You can submit another booking via the system</p>\r\n" + 
    		"      </div>\r\n" + 
    		"    </div>\r\n" + 
    		"        \r\n" + 
    		"          </div>\r\n" + 
    		"        <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
    		"        </div>\r\n" + 
    		"      </div>\r\n" + 
    		"  \r\n" + 
    		"      <div style=\"mso-line-height-rule: exactly;line-height: 20px;font-size: 20px;\">&nbsp;</div>\r\n" + 
    		"  \r\n" + 
    		"      \r\n" + 
    		"      <div role=\"contentinfo\">\r\n" + 
    		"        <div class=\"layout email-footer stack\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
    		"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
    		"          <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 400px;\" valign=\"top\" class=\"w360\"><![endif]-->\r\n" + 
    		"            <div class=\"column wide\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #adb3b9;font-family: sans-serif;Float: left;max-width: 400px;min-width: 320px; width: 320px;width: calc(8000% - 47600px);\">\r\n" + 
    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
    		"                \r\n" + 
    		"                <div style=\"font-size: 12px;line-height: 19px;\">\r\n" + 
    		"                  <div>LSH Desk Booking System</div>\r\n" + 
    		"                </div>\r\n" + 
    		"                <div style=\"font-size: 12px;line-height: 19px;Margin-top: 18px;\">\r\n" + 
    		"                  <div>Had a problem? Report it here: https://forms.gle/RvESA2e3rY2mhtf37</div>\r\n" + 
    		"                </div>\r\n" + 
    		"                <!--[if mso]>&nbsp;<![endif]-->\r\n" + 
    		"              </div>\r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td><td style=\"width: 200px;\" valign=\"top\" class=\"w160\"><![endif]-->\r\n" + 
    		"            <div class=\"column narrow\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #adb3b9;font-family: sans-serif;Float: left;max-width: 320px;min-width: 200px; width: 320px;width: calc(72200px - 12000%);\">\r\n" + 
    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
    		"                \r\n" + 
    		"              </div>\r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
    		"          </div>\r\n" + 
    		"        </div>\r\n" + 
    		"        <div class=\"layout one-col email-footer\" style=\"Margin: 0 auto;max-width: 600px;min-width: 320px; width: 320px;width: calc(28000% - 167400px);overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;\">\r\n" + 
    		"          <div class=\"layout__inner\" style=\"border-collapse: collapse;display: table;width: 100%;\">\r\n" + 
    		"          <!--[if (mso)|(IE)]><table align=\"center\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\"><tr class=\"layout-email-footer\"><td style=\"width: 600px;\" class=\"w560\"><![endif]-->\r\n" + 
    		"            <div class=\"column\" style=\"text-align: left;font-size: 12px;line-height: 19px;color: #adb3b9;font-family: sans-serif;\">\r\n" + 
    		"              <div style=\"Margin-left: 20px;Margin-right: 20px;Margin-top: 10px;Margin-bottom: 10px;\">\r\n" + 
    		"                <div style=\"font-size: 12px;line-height: 19px;\">\r\n" + 
    		"                </div>\r\n" + 
    		"              </div>\r\n" + 
    		"            </div>\r\n" + 
    		"          <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\r\n" + 
    		"          </div>\r\n" + 
    		"        </div>\r\n" + 
    		"      </div>\r\n" + 
    		"      <div style=\"line-height:40px;font-size:40px;\">&nbsp;</div>\r\n" + 
    		"    </div></td></tr></tbody></table>\r\n" + 
    		"  \r\n" + 
    		"</body></html>\r\n";
	}
	
	
}
