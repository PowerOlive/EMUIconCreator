package github.tornaco.emuicon;

public class AppFilterItem {

    public AppFilterItem() {
    }

    public AppFilterItem(String component, String drawable) {
        this.component = component;
        this.drawable = drawable;
    }

    private String component, drawable;

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getDrawable() {
        return drawable;
    }

    public void setDrawable(String drawable) {
        this.drawable = drawable;
    }

    // ComponentInfo{com.qihoo.vpnmaster/com.qihoo.vpnmaster.FlashActivity}
    public String getPackageNameSafety() {
        int first = component.indexOf("{");
        int last = component.indexOf("/");
        try {
            return component.substring(first + 1, last);
        } catch (Throwable ignored) {

        }
        return "";
    }

    @Override
    public String toString() {
        return "AppFilterItem{" +
                "component='" + component + '\'' +
                ", drawable='" + drawable + '\'' +
                ", package=" + getPackageNameSafety() +
                '}';
    }
}
