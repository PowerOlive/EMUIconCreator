package github.tornaco.emuicon;

import java.io.File;

public interface IconTransfer {
    boolean transfer(File resDir, File destDir, AppFilterItem item);
}
