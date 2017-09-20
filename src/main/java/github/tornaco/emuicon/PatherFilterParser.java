package github.tornaco.emuicon;

import java.util.List;

public interface PatherFilterParser {
    List<AppFilterItem> parseXML(String xmlPath);
}
