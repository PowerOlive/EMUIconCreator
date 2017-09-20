package github.tornaco.emuicon.imp;

import com.google.common.base.Preconditions;
import com.google.common.io.Files;
import github.tornaco.emuicon.AppFilterItem;
import github.tornaco.emuicon.IconTransfer;

import java.io.File;
import java.io.IOException;

public class IconTransferImpl implements IconTransfer {

    @Override
    public boolean transfer(File resDir, File destDir, AppFilterItem item) {
        if (item.getPackageNameSafety() == null || item.getPackageNameSafety().length() == 0) {
            return false;
        }
        Preconditions.checkArgument(resDir.exists());

        String destPath = destDir.getPath() + File.separator + item.getPackageNameSafety() + ".png";
        String sourcePath = resDir.getPath() + File.separator + item.getDrawable() + ".png";
        if (!new File(sourcePath).exists()) {
            System.err.println("sourcePath not exists:" + sourcePath);
            return false;
        }
        try {
            Files.createParentDirs(new File(destPath));
            Files.touch(new File(destPath));
            Files.asByteSink(new File(destPath)).writeFrom(Files.asByteSource(new File(sourcePath)).openStream());
            System.out.println("New icon: " + destPath);
        } catch (IOException e) {
            System.err.println("Write out fail, IOException-" + e.getLocalizedMessage());
            return false;
        }
        return true;
    }
}
