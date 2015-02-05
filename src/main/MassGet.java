package Main;

public class MassGet extends Thread {
	
	  public void GetFile() {
	        System.out.println("*** FileGet Running ***");
	        
	        //ASE Exchange
	        GetFile.GetFileMakeFolder(ExchangeList.aseURL, "ase");
			//NCM Exchange
			GetFile.GetFileMakeFolder(ExchangeList.ncmURL1, "ncm1");
			GetFile.GetFileMakeFolder(ExchangeList.ncmURL2, "ncm2");
			GetFile.GetFileMakeFolder(ExchangeList.ncmURL3, "ncm3");
			//NGM Exchange
			GetFile.GetFileMakeFolder(ExchangeList.ngmURL1, "ngm1");
			GetFile.GetFileMakeFolder(ExchangeList.ngmURL2, "ngm2");
			GetFile.GetFileMakeFolder(ExchangeList.ngmURL3, "ngm3");
			//NMS Exchange
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL1, "nms1");
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL2, "nms2");
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL3, "nms3");
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL4, "nms4");
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL5, "nms5");
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL6, "nms6");
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL7, "nms7");
			GetFile.GetFileMakeFolder(ExchangeList.nmsURL8, "nms8");
			//NYQ Exchange
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL1, "nyq1");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL2, "nyq2");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL3, "nyq3");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL4, "nyq4");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL5, "nyq5");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL6, "nyq6");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL7, "nyq7");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL8, "nyq8");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL9, "nyq9");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL10, "nyq10");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL11, "nyq11");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL12, "nyq12");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL13, "nyq13");
			GetFile.GetFileMakeFolder(ExchangeList.nyqURL14, "nyq14");
			//OBB Exchange
			GetFile.GetFileMakeFolder(ExchangeList.obbURL1, "obb1");
			GetFile.GetFileMakeFolder(ExchangeList.obbURL2, "obb2");
			//PCX Exchange
			GetFile.GetFileMakeFolder(ExchangeList.pcxURL1, "pcx");
			//PNK Exchange
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL1, "pnk1");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL2, "pnk2");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL3, "pnk3");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL4, "pnk4");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL5, "pnk5");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL6, "pnk6");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL7, "pnk7");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL8, "pnk8");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL9, "pnk9");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL10, "pnk10");
			GetFile.GetFileMakeFolder(ExchangeList.pnkURL11, "pnk11");
			System.out.println("*** FileGet Ended ***");
	    }

}
