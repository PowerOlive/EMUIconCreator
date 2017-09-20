package github.tornaco.emuicon;

import github.tornaco.emuicon.imp.IconTransferImpl;
import github.tornaco.emuicon.imp.PathFilterParserImpl;

import java.io.File;
import java.util.List;

public class EmuiIconCreator {

    public static final String ICON_RES_DIR = "D:\\Android\\Workspace\\tmp\\drawable-nodpi-v4";
    public static final String ICON_DES_DIR = "D:\\Android\\Workspace\\tmp\\icons";
    public static final String XML_PARH = "D:\\Android\\Workspace\\tmp\\appfilter.xml";

    public static void main(String... args) {
        PatherFilterParser patherFilterParser = new PathFilterParserImpl();
        List<AppFilterItem> items = patherFilterParser.parseXML(XML_PARH);
        IconTransfer iconTransfer = new IconTransferImpl();
        for (AppFilterItem item : items) {
            boolean success = iconTransfer.transfer(new File(ICON_RES_DIR), new File(ICON_DES_DIR), item);
            System.out.println(success);
        }
    }
}
