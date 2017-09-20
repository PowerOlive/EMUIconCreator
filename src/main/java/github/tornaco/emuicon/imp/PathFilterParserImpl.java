package github.tornaco.emuicon.imp;

import com.google.common.base.Preconditions;
import github.tornaco.emuicon.AppFilterItem;
import github.tornaco.emuicon.PatherFilterParser;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class PathFilterParserImpl implements PatherFilterParser {

    public List<AppFilterItem> parseXML(String xmlPath) {
        Preconditions.checkArgument(new File(xmlPath).exists());

        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File(xmlPath));
            Element rootElement = document.getRootElement();
            Iterator<Element> rootIt = rootElement.elementIterator();

            List<AppFilterItem> appFilterItemList = new ArrayList<AppFilterItem>();

            while (rootIt.hasNext()) {
                Element element = rootIt.next();
                String compInfo = element.attributeValue("component");
                String drawable = element.attributeValue("drawable");
                AppFilterItem appFilterItem = new AppFilterItem(compInfo, drawable);
                appFilterItemList.add(appFilterItem);
            }

            return appFilterItemList;

        } catch (DocumentException e) {
            onError(e);
        }
        return null;
    }

    private void onError(Exception e) {
        throw new RuntimeException(e);
    }
}
